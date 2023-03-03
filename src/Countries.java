public class Countries {
    int ID;
    String countryCode;

    public Countries(int ID, String countryCode)
    {
        this.ID = ID;
        this.countryCode = countryCode;
    }
    public String toString() {
        return "Tara = " + ID +  "auto = " + countryCode + "\n";
    }

}
