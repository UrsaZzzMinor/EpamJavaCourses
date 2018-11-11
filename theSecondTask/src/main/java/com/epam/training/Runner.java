package com.epam.training;

import com.epam.training.Models.Text;
import com.epam.training.services.IOService;
import com.epam.training.services.TextService;

public class Runner {

        public static void main(String[] args){
            TextService textService = new TextService();
            Text text = new Text(new IOService().readFromFile());

            textService.parseOnElements(text);
            textService.findTheMostFrequentWord(text);
            textService.compareGivenText2Assembled(text);
        }
}
