package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Bouquet;
import org.apache.log4j.Logger;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BouquetService {
    private static Logger logger = Logger.getLogger(BouquetService.class);

    public void writeBouquet2File(Bouquet bouquet){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try(FileWriter writer = new FileWriter(".\\src\\main\\resources\\Init.json")) {
            gson.toJson(bouquet, writer);
        } catch (IOException e) {
            logger.error("Sorry, You've got IOException...", e);
        }
    }

    public Bouquet readBouquetFromFile(){
        Gson gson = new Gson();
        Bouquet bouquet = new Bouquet();

        try(FileReader reader = new FileReader(".\\src\\main\\resources\\Init.json")){
            bouquet = gson.fromJson(reader, Bouquet.class);
        } catch (FileNotFoundException e) {
            logger.error("Sorry, You've got FileNotFoundException...", e);
        } catch (IOException e) {
            logger.error("Sorry, You've got IOException...", e);
        }

        logger.info("The Bouquet has been successfully read from the file...\n");
        return bouquet;
    }

}
