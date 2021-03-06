package com.epam.training;

import com.epam.training.Models.Text;
import org.testng.annotations.BeforeMethod;
import com.epam.training.services.IOService;
import com.epam.training.services.TextService;

public class BaseTest {
    private Text text;
    private TextService textService;

    public Text getText() {
        return this.text;
    }

    public TextService getTextService() {
        return this.textService;
    }

    public void setTextService(TextService textService) {
        this.textService = textService;
    }

    public void setText(Text text) {
        this.text = text;
    }

    @BeforeMethod
    protected void textInit(){
        setText(new Text(new IOService().readFromFile()));
        setTextService(new TextService());
        getTextService().parseOnElements(getText());
    }


}
