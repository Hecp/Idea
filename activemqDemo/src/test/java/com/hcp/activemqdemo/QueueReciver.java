package com.hcp.activemqdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * 消息接收测试类
 * Created by Administrator on 2016/5/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:ApplicationContext.xml"})
public class QueueReciver {
    @Resource
    private JmsTemplate jmsTemplate;

    @Test
    public void receiveMqMessage() {
        Destination destination = jmsTemplate.getDefaultDestination();
        try {
            receive(destination);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    /**
     * 接收消息
     *
     * @param destination
     * @throws JMSException
     */
    private void receive(Destination destination) throws JMSException {
        if (destination == null) {
            throw new IllegalArgumentException("destination must not be null!" + destination);
        }
        TextMessage textMessage = (TextMessage) jmsTemplate.receive(destination);
        if (textMessage == null) {
            System.out.println("队列中暂无消息！");
        } else {
            System.out.println("从队列" + destination.toString() + "收到了消息：" + textMessage.getText());
        }
    }
}
