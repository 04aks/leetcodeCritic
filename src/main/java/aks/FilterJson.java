package aks;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FilterJson {
    
    public String getGeminiKey(String json, String key){
        String ranking = "";

        ObjectMapper om = new ObjectMapper();
        try{
            JsonNode main = om.readTree(json);
            ranking = main.get(key).asText();
        }catch(JsonParseException e){
            System.out.println("Error while parsing the Gemini response as a JSON text: " + json);
        }
        catch(JsonMappingException e){
            System.out.println("mapping");
        }
        catch(JsonProcessingException e){
            System.out.println("processing");
        }

        return ranking;
    }
}
