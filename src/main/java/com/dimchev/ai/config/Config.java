package com.dimchev.ai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
   @Bean
   public ChatClient createChat(ChatClient.Builder builder){
        return builder.build();
    }
}
