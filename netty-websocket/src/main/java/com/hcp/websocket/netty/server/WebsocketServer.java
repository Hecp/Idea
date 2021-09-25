package com.hcp.websocket.netty.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by hcp on 2018/12/26.
 */
@Component
@ServerEndpoint("/websocket")
public class WebsocketServer {
    private static final Logger LOGGER =  LoggerFactory.getLogger(WebsocketServer.class);

    /**
     * 线程安全？
     */
    private static int onlineCount = 0;

    private static CopyOnWriteArraySet<WebsocketServer> serverSet = new CopyOnWriteArraySet<>();

    private Session session;

    public int getOnlineCount() {
        return onlineCount;
    }

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        serverSet.add(this);
        addOnlineCount();
        LOGGER.info("有新连接加入，当前连接数为：{}", getOnlineCount());
        try {
            sendMessage("连接成功！");
        } catch (IOException e) {
            LOGGER.error("send message error", e);
        }
    }

    private void sendMessage(String msg) throws IOException {
        synchronized (this.session) {
            if (this.session.isOpen()) {
                this.session.getBasicRemote().sendText(msg);
            }
        }
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        serverSet.remove(session);
        LOGGER.error(throwable.getMessage(), throwable);
    }

    @OnMessage
    public void onMessage(String msg) {
        LOGGER.info("客户端消息：{}", msg);
        // 群发消息
        for (WebsocketServer server : serverSet) {
            try {
                server.sendMessage(msg);
            } catch (IOException e) {
                LOGGER.error("send message error", e);
            }
        }
    }

    private void addOnlineCount() {
        // ++并非原子性操作，故此处是非线程安全的，应该使用AtomicInteger
        WebsocketServer.onlineCount++;
    }
}
