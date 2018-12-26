package com.hcp.websocket.netty.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * Created by hcp on 2018/12/26.
 */
@Configuration
public class WebsocketConfig {

    @Bean
    public ServerEndpointExporter getServerEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
