import java.util.*;

public class PublishingBrand implements  IPublishingArtifact {
    int ID;
    String name;
    List<Book> books;

public PublishingBrand(int ID, String name) {
    this.ID = ID;
    this.name = name;
    this.books = new ArrayList<>();
}
    @Override
    public String Publish() {
        return "<xml>" + "\n" + "<publishingBrand>" + "\n" +
                "<ID>" + ID + "</ID>" + "\n" + "<Name>" + name + "</Name>" + "\n" + "</publishingBrand>" + "\n" + "<books>"
                + "\n" + books.toString() + "\n" + "</books>" + "</xml>";
    }
    @Override
    public String toString() {
        return "<xml>" + "\n" + "<publishingBrand>" + "\n" +
                "<ID>" + ID + "</ID>" + "\n" + "<Name>" + name + "</Name>" + "\n" + "</publishingBrand>" + "\n" + "<books>"
                + "\n" + books.toString() + "\n" + "</books>" + "</xml>";
    }
}
