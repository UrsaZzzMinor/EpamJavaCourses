import Models.Text;
import services.IOService;
import services.TextService;

public class Runner {

        public static void main(String[] args){
            TextService textService = new TextService();
            Text text = new Text(new IOService().readFromFile());

            textService.parseOnElements(text);
            textService.findTheMostFrequentWord(text);
            textService.compareGivenText2Assembled(text);
        }
}
