package com.mwtestconsultancy;

import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiChatModelName;
import dev.langchain4j.service.AiServices;

import java.sql.SQLException;
import java.util.Scanner;

public class DataAssistant {

    static interface DataAssistantService {
        String sendPrompt(String userPrompt);
    }

    public static void main(String[] args) throws SQLException {
        OpenAiChatModel model = OpenAiChatModel
                .builder()
                .apiKey(System.getenv("OPENAI_KEY"))
                .modelName(OpenAiChatModelName.GPT_4_O_MINI)
                .build();

        DataAssistantService dataAssistantChat = AiServices.builder(DataAssistantService.class)
                .chatLanguageModel(model)
                .tools(new DataAssistantTools())
                .build();

        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("What do you need?");
            String query = scanner.nextLine();
            String response = dataAssistantChat.sendPrompt(query);
            System.out.println(response);
            scanner.close();
        }
    }

}
