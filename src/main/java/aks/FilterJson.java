package aks;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FilterJson {
    
    public String getGeminiKey(String json, String key){
        String ranking = "";

        ObjectMapper om = new ObjectMapper();
        try{
            JsonNode main = om.readTree(json);
            ranking = main.get(key).asText();
        }catch(Exception e){
            e.printStackTrace();
        }

        return ranking;
    }
}
