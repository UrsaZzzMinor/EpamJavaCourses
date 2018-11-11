package com.epam.training.services;

import org.apache.log4j.Logger;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class IOService {
    private static Logger logger = Logger.getLogger(IOService.class);
    private static final String FILENAME = ".\\src\\main\\resources\\text.txt";

    public String readFromFile(){
        String text = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            StringBuilder sb = new StringBuilder();
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                sb.append(currentLine).append("\n");
            }
            return text = sb.toString();
        } catch (FileNotFoundException e){
            logger.error("\"Sorry, You've got FileNotFoundException...\"");
        } catch (IOException e) {
            logger.error("\"Sorry, You've got IOException...\"");
        }
        return text;
    }


}
