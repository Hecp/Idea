package com.hcp.spring.springmvc.demo;

import com.hcp.spring.springmvc.annotation.MyController;
import com.hcp.spring.springmvc.annotation.MyRequestMapping;
import com.hcp.spring.springmvc.annotation.MyRequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hcp on 2018/8/3.
 */
@MyController
@MyRequestMapping("/test")
public class TestController {
    @MyRequestMapping("/doTest")
    public void test1(HttpServletResponse response, @MyRequestParam("param") String param) {
        System.out.println(param);
        try {
            response.getWriter().write("doTest method success! param = " + param);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
