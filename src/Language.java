public class Language {
    int ID;
    String code;
    String name;

    public Language(int ID, String code, String name) {
        this.ID = ID;
        this.code = code;
        this.name = name;
    }
    public String toString() {
        return "Limba = " + ID + "code = " + code + "nume = " + name + "\n";
    }
}

