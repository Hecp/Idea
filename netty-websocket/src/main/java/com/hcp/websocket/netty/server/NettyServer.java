package com.hcp.websocket.netty.server;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.hcp.websocket.netty.handler.MyChannelHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.*;

/**
 * Created by hcp on 2018/12/26.
 */
@Component
public class NettyServer {
    private static final Logger LOGGER =  LoggerFactory.getLogger(NettyServer.class);

    private static final int port = 5566;

    @PostConstruct
    public void init() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("netty-server").build();
        ExecutorService singlePool = new ThreadPoolExecutor(1, 1, 0L,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(16), threadFactory);
        singlePool.execute(this::startServer);
        singlePool.shutdown();
    }

    private void startServer() {
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup work = new NioEventLoopGroup();

        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(boss, work).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast("http-codec", new HttpServerCodec())
                        .addLast("aggregator", new HttpObjectAggregator(65536))
                        .addLast("http-chunked", new ChunkedWriteHandler())
                        .addLast(new IdleStateHandler(60, 30, 60 * 30, TimeUnit.SECONDS))
                        .addLast(new MyChannelHandler());

            }
        }).option(ChannelOption.SO_BACKLOG, 1024).childOption(ChannelOption.SO_KEEPALIVE, true);
        LOGGER.info("服务器启动成功，启动端口：{}", port);
        try {
            Channel channel = bootstrap.bind(port).sync().channel();
            channel.closeFuture().sync();
        } catch (InterruptedException e) {
            LOGGER.error("通道获取失败", e);
        } finally {
            boss.shutdownGracefully();
            work.shutdownGracefully();
        }
    }

}
