public class Kund {

    protected int kundID;
    protected String namn;
    protected String lösenord;



    public Kund(){}

    public Kund(String namn, String lösenord) {
        this.namn = namn;
        this.lösenord = lösenord;
    }
    public int getKundID() {
        return kundID;
    }

    public void setKundID(int kundID) {
        this.kundID = kundID;
    }

    public String getNamn() {
        return namn;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    public String getLösenord() {
        return lösenord;
    }

    public void setLösenord(String lösenord) {
        this.lösenord = lösenord;
    }
}
