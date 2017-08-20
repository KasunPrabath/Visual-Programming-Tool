package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {

        //read json file data to String
        byte[] jsonData = Files.readAllBytes(Paths.get("/home/oracle/Desktop/Visual-Programming-Tool-master/Visual Programming Tool/src/com/company/split.txt"));

        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        //convert json string to object
        Structure struct = objectMapper.readValue(jsonData, Structure.class);

        //algorithm to traversing and generate source code
        Algorithm algorithm = new Algorithm(struct);
        algorithm.run(struct);
    }
}