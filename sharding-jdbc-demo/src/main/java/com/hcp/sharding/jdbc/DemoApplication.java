package com.hcp.sharding.jdbc;

import com.hcp.sharding.jdbc.service.impl.OrderServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Created by hcp on 2018/5/19.
 */
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);
        applicationContext.getBean(OrderServiceImpl.class).test();
    }
}
