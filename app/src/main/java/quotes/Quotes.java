package quotes;

public class Quotes {
    String author;
    String text;

    public Quotes(String author, String text) {
        this.author = author;
        this.text = text;

    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {

        return  "{ Quote: " + text + ", " + "Author: " + author + " }";
    }
}
