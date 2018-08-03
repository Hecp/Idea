package com.hcp.spring.springmvc.servlet;

import com.hcp.spring.springmvc.annotation.MyController;
import com.hcp.spring.springmvc.annotation.MyRequestMapping;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

/**
 * Created by hcp on 2018/8/3.
 */
public class MyDispatcherServlet extends HttpServlet {

    private Properties properties = new Properties();

    private Map<String, Method> handlerMapping = new HashMap<>(16);

    private Map<String, Object> controllerMap = new HashMap<>(16);

    private List<String> classNames = new LinkedList<>();

    private Map<String, Object> container = new HashMap<>(16);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doDispatch(req, resp);
        } catch (Exception e) {
            resp.getWriter().write("500, Server Exception.");
        }
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (handlerMapping.isEmpty()) {
            return;
        }
        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        url = url.replace(contextPath, "").replaceAll("/+", "/");
        if (!this.handlerMapping.containsKey(url)) {
            resp.getWriter().write("404 NOT FOUND.");
            return;
        }
        Method method = this.handlerMapping.get(url);
        Class<?>[] parameterTypes = method.getParameterTypes();
        Map<String, String[]> parameterMap = req.getParameterMap();
        Object[] paramValues = new Object[parameterTypes.length];
        String requestParam = null;
        for (int i = 0; i < parameterTypes.length; i++) {
            requestParam = parameterTypes[i].getSimpleName();
            if (requestParam.equals("HttpServletRequest")) {
                paramValues[i] = req;
                continue;
            }
            if (requestParam.equals("HttpServletResponse")) {
                paramValues[i] = resp;
                continue;
            }
            if (requestParam.equals("String")) {
                String value = null;
                for (Map.Entry<String, String[]> param : parameterMap.entrySet()) {
                    value = Arrays.toString(param.getValue()).replaceAll("[|]", "")
                            .replaceAll(",\\s", ",");
                    paramValues[i] = value;
                }
            }

            try {
                method.invoke(this.controllerMap.get(url), paramValues);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        // 加载配置文件
        doLoadConfig(config.getInitParameter("contextConfigLocation"));

        // 初始化所有相关联的类，扫描用户设定包下面的所有类
        doScanner(properties.getProperty("scanPackage"));

        // 拿到扫描到的类，通过反射进行实例化，并且放到IOC容器中
        doInstance();

        // 初始化HandlerMapping
        initHandlerMapping();
    }

    private void initHandlerMapping() {
        if (container.isEmpty()) {
            return;
        }
        Class<? extends Object> clazz = null;
        for (Map.Entry entry : container.entrySet()) {
            clazz = entry.getValue().getClass();
            if (!clazz.isAnnotationPresent(MyController.class)) {
                continue;
            }
            String baseUrl = "";
            if (clazz.isAnnotationPresent(MyRequestMapping.class)) {
                MyRequestMapping requestMapping = clazz.getAnnotation(MyRequestMapping.class);
                baseUrl = requestMapping.value();
            }
            Method[] methods = clazz.getMethods();
            String url = null;
            for (Method method : methods) {
                if (!method.isAnnotationPresent(MyRequestMapping.class)) {
                    continue;
                }
                MyRequestMapping methodRequestMapping = method.getAnnotation(MyRequestMapping.class);
                url = methodRequestMapping.value();
                url = (baseUrl + "/" + url).replaceAll("/+", "/");
                handlerMapping.put(url, method);
                try {
                    controllerMap.put(url, clazz.newInstance());
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    private void doInstance() {
        if (classNames.isEmpty()) {
            return;
        }
        Class<?> clazz = null;
        for (String className : classNames) {
            try {
                clazz = Class.forName(className);
                if (clazz.isAnnotationPresent(MyController.class)) {
                    container.put(toLowerFirstWord(clazz.getSimpleName()), clazz.newInstance());
                }
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    private String toLowerFirstWord(String simpleName) {
        char[] charArray = simpleName.toCharArray();
        charArray[0] += 32;
        return Arrays.toString(charArray);
    }

    private void doScanner(String scanPackage) {
        URL url = this.getClass().getClassLoader().getResource("/" + scanPackage.replaceAll("\\.", "/"));
        if (url != null) {
            File dir = new File(url.getFile());
            for (File file : dir.listFiles()) {
                if (file.isDirectory()) {
                    doScanner(scanPackage + "." + file.getName());
                } else {
                    String className = scanPackage + "." + file.getName().replaceAll(".class", "");
                    classNames.add(className);
                }
            }
        }
    }

    private void doLoadConfig(String contextConfigLocation) {
        InputStream resourceInputStream = this.getClass().getClassLoader().getResourceAsStream(contextConfigLocation);
        try {
            properties.load(resourceInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                resourceInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
