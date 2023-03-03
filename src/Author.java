public class Author {
    int ID;
    String firstname;
    String lastname;

    public Author(int ID, String firstname, String lastname) {
        this.ID = ID;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "<author>" + firstname + " " + lastname + "</author>";
    }

}

