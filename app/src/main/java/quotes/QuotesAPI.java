package quotes;

public class QuotesAPI {
    String quoteText;
    String quoteAuthor;

    public QuotesAPI(String quoteText, String quoteAuthor) {
        this.quoteText = quoteText;
        this.quoteAuthor = quoteAuthor;
    }

    public String getQuoteText() {
        return quoteText;
    }

    public String getQuoteAuthor() {
        return quoteAuthor;
    }

    @Override
    public String toString() {
        return "QuotesAPI{" +
                "Quote: " + quoteText + '\'' +
                ", Author: " + quoteAuthor + '\'' +
                '}';
    }
}
