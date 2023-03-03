import java.util.*;

public class PublishingRetailer {
    int ID;
    String name;
    List<IPublishingArtifact> publishingArtifacts;
    List<Countries> countries;

    public PublishingRetailer(int ID, String name) {
        this.ID = ID;
        this.name = name;
        this.publishingArtifacts = new ArrayList<>();
        this.countries = new ArrayList<>();
    }

    @Override
    public String toString(){
        return "**********<PublishingRetailer>**********" + "\n" + "retailerID = " + ID +
                "name = " + name + "\n" + "<tara>" + countries.toString() + "</tara>" + "\n"
                + "<entitate>" + publishingArtifacts.toString() + "</entitate>";
    }
}
