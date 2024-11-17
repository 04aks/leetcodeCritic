package aks;

public class Consts {
    
    // Attempt button
    static final String BUTTON_ATTEMPT_NAME = "Upload your Attempt Image";
    static final String BUTTON_ATTEMPT_COMMAND = "attempt-img";

    // Ideal (ideal Solution) button
    static final String BUTTON_IDEAL_NAME = "Upload the Ideal Image";
    static final String BUTTON_IDEAL_COMMAND = "ideal-img"; 

    // generate button
    static final String BUTTON_GENERATE_NAME = "Generate overview Tweet";
    static final String BUTTON_GENERATE_COMMAND = "generate-tweet"; 

    // Gemini prompt
    public static final String GEMINI_PROMPT = "Analyze the provided JAVA code snippet (read the method name to know which leet code problem is being solved). Identify any logical errors, inefficiencies, or areas for improvement. Assess its correctness and time complexity. Provide a rating from 1 to 3, where 1 indicates a completely incorrect or inefficient solution, 2 indicates a partially correct or inefficient solution, and 3 indicates a correct and efficient solution. send a String in json format response with the keys ranking and feedback, feedback is a short description 3 lines at most, do NOT flag the response as a json meaning the response shouldnt have '```json' at the start, and no spaces between the brackets and the keys, response should be in one line";
}
