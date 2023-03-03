import java.util.*;

public class Book implements IPublishingArtifact {
    int ID;
    String name;
    String subtitle;
    String ISBN;
    int pageCount;
    String keywords;
    int languageID;
    Date createdOn;
    List<Author> authors ;

    public Book(int id, String name, String subtitle, String isbn, int pageCount, String keywords, int languageID, Date createdOn) {
        this.subtitle = subtitle;
        this.ID = id;
        this.name = name;
        this.ISBN = isbn;
        this.pageCount = pageCount;
        this.keywords = keywords;
        this.languageID = languageID;
        this.createdOn = createdOn;
        this.authors = new ArrayList<>();
    }
    @Override
    public String Publish() {
        String xml_subtitle;
        if(this.subtitle != null)
            xml_subtitle = "<subtitle>" + subtitle + "</subtitle>" + "\n";
        else
            xml_subtitle = "";
        return "<xml>" + "\n" + "<title>" + name + "</title>" + "\n" + xml_subtitle +
                "<isbn>" + ISBN + "</isbn>" + "\n" + "<pageCount>" + pageCount + "</pageCount>" + "\n" + "<keywords>" +
                keywords + "</keywords>" + "\n" + "<languageID>" + languageID + "</languageID>" + "\n" + "<createdOn>" +
                createdOn + "</createdOn>" + "\n" + authors.toString() + "</xml>";
      }
      @Override
    public String toString() {
          return "<book>" + "\n" + "id = " + ID + "<title>" + name + "</title>" + "\n" + "<subtitle>" + subtitle + "</subtitle>" + "\n" +
                  "<isbn>" + ISBN + "</isbn>" + "\n" + "<pageCount>" + pageCount + "</pageCount>" + "\n" + "<keywords>" + keywords +
                  "</keywords>" + "\n" + "<languageID>" + languageID + "</languageID>" + "\n" + "<createdOn>" + createdOn +
                  "</createdOn>" + "\n" + authors.toString() + "</book>";
      }
}
