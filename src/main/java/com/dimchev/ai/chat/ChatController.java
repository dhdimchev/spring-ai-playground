package com.dimchev.ai.chat;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ChatController {
    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

   @GetMapping("/chat")
    public String chat(String message) {
        return chatClient.prompt()
                .user("Tell me something random")
                .call()
                .content();
    }
    @GetMapping("/stream")
    public Flux<String> stream(){
        return chatClient.prompt()
                .user("List top 10 things about open api")
                .stream()
                .content();
    }

    @GetMapping
    public ChatResponse joke(){
        return chatClient.prompt()
                .user("Tell me cool bulgarian Joke.'")
                .call()
                .chatResponse();
    }


}
