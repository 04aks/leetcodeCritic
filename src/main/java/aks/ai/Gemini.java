package aks.ai;

import aks.Consts;
import aks.gemini.GeminiClient;

public class Gemini {
    
    public String geminiAssessment(String base64image){
        GeminiClient geminiClient = new GeminiClient();
        geminiClient.authenticate(System.getenv("GEMINI-KEY"));
        geminiClient.requestGemini(Consts.GEMINI_PROMPT, base64image);

        return geminiClient.responseGemini();
    }
}
