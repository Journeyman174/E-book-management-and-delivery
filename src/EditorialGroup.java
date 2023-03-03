import java.util.*;

public class EditorialGroup implements IPublishingArtifact {
    int ID;
    String name;
    List<Book> books;

    public EditorialGroup(int ID, String name) {
        this.ID = ID;
        this.name = name;
        this.books = new ArrayList<>();
    }

    @Override
    public String Publish() {
       return "<xml>" + "\n" + "<editorialGroup>" + "\n" +
               "<ID>" + ID + "</ID>" + "\n" + "<Name>" + name + "</Name>" + "\n" + "</editorialGroup>" + "\n" + "<books>" +
               "\n" + books.toString() + "\n" + "</books>" + "</xml>";
    }

    @Override
    public String toString() {
        return "<xml>" + "\n" + "<editorialGroup>" + "\n" +
                "<ID>" + ID + "</ID>" + "\n" + "<Name>" + name + "</Name>" + "\n" + "</editorialGroup>" + "\n" + "<books>"
                + "\n" + books.toString() + "\n" + "</books>" + "</xml>";
    }
}