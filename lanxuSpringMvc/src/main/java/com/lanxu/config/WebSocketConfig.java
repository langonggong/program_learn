package com.lanxu.config;

import com.lanxu.handler.SystemWebSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年09月11 22:45
 **/
@Configuration
@EnableWebMvc
@EnableWebSocket
public class WebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {

  public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
    registry.addHandler(systemWebSocketHandler(), "/webSocketServer");
    registry.addHandler(systemWebSocketHandler(), "/webSocketServer/sockjs").setAllowedOrigins("*").withSockJS();
    //registry.addHandler(systemWebSocketHandler(),"/webSocketServer").addInterceptors(new WebSocketHandshakeInterceptor());
    //registry.addHandler(systemWebSocketHandler(), "/sockjs/webSocketServer").addInterceptors(new WebSocketHandshakeInterceptor()).withSockJS();
    //registry.addHandler(systemWebSocketHandler(), "/webSocketServer/sockjs").withSockJS();
         /*registry.addHandler(systemWebSocketHandler(),"/ws").addInterceptors(new WebSocketHandshakeInterceptor());
            registry.addHandler(systemWebSocketHandler(), "/ws/sockjs").addInterceptors(new WebSocketHandshakeInterceptor())
                    .withSockJS();*/
  }

  @Bean
  public WebSocketHandler systemWebSocketHandler() {
    return new SystemWebSocketHandler();
  }
}
