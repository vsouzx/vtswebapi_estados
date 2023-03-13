package br.vtsoliveira.vtswebapi_estados.config.websocket;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final NotificationWebSocket meuWebSocketHandler;
    @Value("${settings.allow-origin}")
    private String origin;

    public WebSocketConfig(NotificationWebSocket meuWebSocketHandler) {
        this.meuWebSocketHandler = meuWebSocketHandler;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(meuWebSocketHandler, "/web-socket").setAllowedOriginPatterns("*");
    }
}
