package com.mwtestconsultancy;

import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiChatModelName;
import dev.langchain4j.service.AiServices;

public class DataAssistant {

    static interface DataAssistantService {
        String sendPrompt(String userPrompt);
    }

    public static void main(String[] args) {
        OpenAiChatModel model = OpenAiChatModel
                .builder()
                .apiKey(System.getenv("OPENAI_KEY"))
                .modelName(OpenAiChatModelName.GPT_3_5_TURBO)
                .build();

        DataAssistantService dataAssistantChat = AiServices.builder(DataAssistantService.class)
                .chatLanguageModel(model)
                .build();

        String response = dataAssistantChat.sendPrompt("Hi, can you introduce yourself?");
        System.out.printf(response);
    }

}
