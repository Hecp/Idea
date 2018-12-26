package com.hcp.spring.learning;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by hcp on 2018/9/13.
 */
public class BeanFactoryTest {
    public static void main(String[] args) {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
        MyTestBean bean = (MyTestBean) beanFactory.getBean("myTestBean");
        System.out.println(bean.getTestStr());
    }
}
