package com.hcp.activemqdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * 消息发送测试类
 * Created by Administrator on 2016/5/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:ApplicationContext.xml"})
public class QueueSender {
    @Resource
    private JmsTemplate jmsTemplate;

    @Test
    public void send(){
        sendMqMessage(null, "spring message listener...");
    }

    /**
     * 说明:发送的时候如果这里没有显示的指定destination.将用spring xml中配置的destination
     *
     * @param destination
     * @param msg
     */
    private void sendMqMessage(Destination destination, final String msg) {
        if (null == destination){
            destination = jmsTemplate.getDefaultDestination();
        }
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        });
        System.out.println("spring send message……");
    }
}
