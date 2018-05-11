package com.hcp.activemqdemo;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 自定义消息监听类
 * Created by Administrator on 2016/5/20.
 */
public class ConsumerMessageListener implements MessageListener{
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            System.out.println("ConsumerMessageListener收到了文本消息：\t" + textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
