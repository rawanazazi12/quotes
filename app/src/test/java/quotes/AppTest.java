/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }
    @Test
    public void jsonReaderTest() throws IOException {

        BufferedReader reader = Files.newBufferedReader(Paths.get("C:\\Users\\dc\\asac\\401\\quotes\\app\\src\\main\\resources\\recentquotes.json"));
        assertNotNull("testJsonReader should return: ", String.valueOf(reader));
    }

    @Test
    public void quoteConstructorTest(){
        Quotes quote = new Quotes("William James", "Act as if what you do makes a difference, IT DOES.");
        assertEquals("William James", quote.getAuthor());
        assertEquals("Act as if what you do makes a difference, IT DOES.", quote.getText());
    }
    @Test
    public void randomQuoteTest() throws IOException {
        Gson gson = new Gson();
        int idx =0;
        BufferedReader reader = Files.newBufferedReader(Paths.get("C:\\Users\\dc\\asac\\401\\quotes\\app\\src\\main\\resources\\recentquotes.json"));
        List<Quotes> quote = gson.fromJson(reader, new TypeToken<List<Quotes>>() {}.getType());
        int min = 0;
        int max = quote.size()-1 ;
        Quotes quote1 = quote.get((int) (Math.random()*(max- min+1)+ min));
        for(int i = 0; i < quote.size(); i++) {
            if(quote.get(i).getText().equals(quote1.getText())){
                idx = i;
            }
        }
        assertTrue(idx >= 0 && idx < quote.size()-1 , "return true if successfully got a random quote from the json file ");
    }
    @Test
    public void testAPI() throws IOException {
        URL url = new URL("http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        assertEquals(200, connection.getResponseCode(), String.valueOf(true));
    }

}
