public class Beställningar {
    protected int beställningsID;  //samma som kundID
    protected int skoID;

    public Beställningar(){}

    public Beställningar(int beställningsID, int skoID) {
        this.beställningsID = beställningsID;
        this.skoID = skoID;
    }

    public int getBeställningsID() {
        return beställningsID;
    }

    public void setBeställningsID(int beställningsID) {
        this.beställningsID = beställningsID;
    }

    public int getSkoID() {
        return skoID;
    }

    public void setSkoID(int skoID) {
        this.skoID = skoID;
    }
}
