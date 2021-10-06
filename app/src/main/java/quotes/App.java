/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new App().getGreeting());
//        getRandomQuote ();
        Gson gson = new Gson();
        BufferedReader reader = Files.newBufferedReader(Paths.get("C:\\Users\\dc\\asac\\401\\quotes\\app\\src\\main\\resources\\recentquotes.json"));
        List<Quotes> quote = gson.fromJson(reader, new TypeToken<List<Quotes>>() {}.getType());
        reader.close();

        int min = 0;
        int max = quote.size()-1 ;

      try {
        String url = "http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en";
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(3000);
        connection.setReadTimeout(3000);

         int response = connection.getResponseCode();

         if (response == HttpURLConnection.HTTP_OK){

//             System.out.println(connection);

             InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
             String data = bufferedReader.readLine();

             QuotesAPI quotesAPI = gson.fromJson(data, QuotesAPI.class);
             Quotes quoteFromApi = new Quotes(quotesAPI.getQuoteAuthor(), quotesAPI.getQuoteText());

             // add the API quote to JSON File
             System.out.println( quotesAPI );
//             System.out.println("Quote Text "+ quotesAPI.getQuoteText());
             Writer addToFile = new FileWriter("C:\\Users\\dc\\asac\\401\\quotes\\app\\src\\main\\resources\\recentquotes.json",true);
             gson.toJson(quoteFromApi,addToFile);
             addToFile.close();
             bufferedReader.close();
         }
        } catch (IOException e )
      {
          System.out.println(quote.get((int) (Math.random()*(max- min+1)+ min)).toString());
      }
    }

    }


