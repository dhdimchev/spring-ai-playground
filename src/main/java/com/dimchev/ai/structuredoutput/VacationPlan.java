package com.dimchev.ai.structuredoutput;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vacation")
public class VacationPlan {

    @Autowired
    private ChatClient chatClient;

    /**
     * This is the way to get structured answers from the LLM API
     * 1. Define the format of the data as an entity
     * @see com.dimchev.ai.structuredoutput.Activity
     * @return
     */
    @GetMapping("structured")
    public Schedule structured(){
        return chatClient.prompt()
                .user("I plan a vacation  to go to Italy in 2027. Give me a list to do.")
                .call()
                .entity(Schedule.class);
    }
}
