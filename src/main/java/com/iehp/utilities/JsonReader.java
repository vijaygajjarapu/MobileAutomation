package com.iehp.utilities;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonReader {

    public static HashMap<String, String> ReadJSONFile(String filepath) {
        HashMap<String, String> map = new HashMap<String, String>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            // Read JSON from a file
            map = mapper.readValue(new File(filepath),
                    new TypeReference<Map<String, String>>() {
                    });
        } catch (JsonGenerationException e) {

        } catch (JsonMappingException e) {

        } catch (IOException e) {

        }
        return map;
    }
}