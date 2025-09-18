package com.dimchev.ai.prompt;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dimobank")
public class DimosBankController {
  private final ChatClient chatClient;

    public DimosBankController(ChatClient.Builder chatClientBuilder) {
        // You can also set the default system message per chatClient bean by passing it to the builder.
        this.chatClient = chatClientBuilder.build();
    }

/**
 * This is how to pass so me guardrails context so apis answer only specific questions.
 *
 * For more on the system message, look at:
 * @see com.dimchev.ai.prompt.ArticleController#newArticle(String)
 * **/

    @GetMapping("/info")
    public String info(@RequestParam(required = true) String message){
    var systemInstructions = """
           You are  a customer service asistant for Dimos Bank.
           You can answer questions about:
           - Account balance
           - Account history
           - Account transactions
           - Account details 
           
           If asked about other questions, you respond with: "Sorry, I don't know about that."
            """;


        return chatClient.prompt()
                .user(message)
                .system(systemInstructions)
                .call()
                .content();
    }
}
