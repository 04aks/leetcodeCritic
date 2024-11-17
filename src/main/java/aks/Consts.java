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
    public static final String GEMINI_PROMPT = "the code given is a solution to a leetcode problem, rank the attempt from 1 to 3, 1 being a horrible attempt the code will not retur the desired outcome, 2 being a fine attempt it will return the desired outcome but its not memory and time efficient and basically a bad way to go about it, 3 being the correct way to do it, respond with only the number";
}
