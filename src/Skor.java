public class Skor {

    protected int skoID;
    protected String namn;
    protected int skoStorlek;


    public Skor(){}



    public String getNamn() {
        return namn;
    }

    public int getSkoStorlek() {
        return skoStorlek;
    }

    public void setSkoStorlek(int skoStorlek) {
        this.skoStorlek = skoStorlek;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    public Skor(String namn, int skoStorlek, int skoID) {
        this.namn = namn;
        this.skoStorlek = skoStorlek;
        this.skoID = skoID;
    }

    public int getSkoID() {
        return skoID;
    }

    public void setSkoID(int skoID) {
        this.skoID = skoID;
    }
}
