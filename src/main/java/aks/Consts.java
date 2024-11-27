package aks;

public class Consts {
    
    // Attempt button
    static final String BUTTON_ATTEMPT_NAME = "Upload your Attempt Image";
    static final String BUTTON_ATTEMPT_COMMAND = "attempt-img";
    //----
    static final String ATTEMPT_SCREENSHOT = "take Screenshot of your Attempt";
    public static final String ATTEMPT_SCREENSHOT_CMD = "attempt-img-screen";

    // Ideal (ideal Solution) button
    static final String BUTTON_IDEAL_NAME = "Upload the Ideal Image";
    static final String BUTTON_IDEAL_COMMAND = "ideal-img"; 
    //----
    static final String SOLUTION_SCREENSHOT = "take Screenshot of the Solution";
    public static final String SOLUTION_SCREENSHOT_CMD = "solution-img-screen";

    // generate button
    static final String BUTTON_GENERATE_NAME = "Generate overview Tweet";
    static final String BUTTON_GENERATE_COMMAND = "generate-tweet"; 

    // Gemini prompt
    public static final String GEMINI_PROMPT = "Analyze the provided JAVA code snippet (read the method name to know which leet code problem is being solved). Identify any logical errors, inefficiencies, or areas for improvement. Assess its correctness and time complexity. Provide a rating from 1 to 3, where 1 indicates a completely incorrect or inefficient solution, 2 indicates a completely correct solution BUT isn't as efficient as needed, and 3 indicates a correct and efficient solution that is accepted during interviews for companies. send a String in json format response with the keys 'ranking' and 'feedback', 'feedback' is a short description, 3 lines at most, do NOT flag the response as a json meaning the response shouldnt have '```json' at the start, and no spaces between the brackets and the keys, response should be in one line";
}
