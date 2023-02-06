import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Repository {

    List<Kund> getKunder() throws IOException, SQLException {

            Properties p = new Properties();
            p.load(new FileInputStream("src/Settings.properties.txt"));

            try (Connection con = DriverManager.getConnection(
                    p.getProperty("connectionString"),
                    p.getProperty("name"),
                    p.getProperty("password"));
                 Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery("select id, namn, lösenord from Kund")) {

                List<Kund> kund = new ArrayList<>();

                while (rs.next()) {
                    Kund temp = new Kund();
                    int kundID = rs.getInt("id");
                    temp.setKundID(kundID);
                    String namn = rs.getString("namn");
                    temp.setNamn(namn);
                    String lösenord = rs.getString("lösenord");
                    temp.setLösenord(lösenord);
                    kund.add(temp);


                    //System.out.println(namn+ " " + lösenord+ " ");
                }

                return kund;
            }
        }

    List<Skor> getSkor() throws IOException, SQLException {

        Properties p = new Properties();
        p.load(new FileInputStream("src/Settings.properties.txt"));

        try (Connection con = DriverManager.getConnection(
                p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select id, namn, storlek from Skor")) {

            List<Skor> sko = new ArrayList<>();

            while (rs.next()) {
                Skor temp = new Skor();
                int skoID = rs.getInt("id");
                temp.setSkoID(skoID);
                String namn = rs.getString("namn");
                temp.setNamn(namn);
                int storlek = rs.getInt("storlek");
                temp.setSkoStorlek(storlek);
                sko.add(temp);

            }

            return sko;
        }
    }
    List<Beställningar> getBeställningar() throws IOException, SQLException {

        Properties p = new Properties();
        p.load(new FileInputStream("src/Settings.properties.txt"));

        try (Connection con = DriverManager.getConnection(
                p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select skoID, beställningsID from BeställningMap")) {

            List<Beställningar> beställning = new ArrayList<>();

            while (rs.next()) {
                Beställningar temp = new Beställningar();
                int skoID = rs.getInt("skoID");
                temp.setSkoID(skoID);
                int beställningsID = rs.getInt("beställningsID");
                temp.setBeställningsID(beställningsID);
                beställning.add(temp);
            }

            return beställning;
        }
    }

    //addToCart stored procedure
    void callAddToCart(int kundID, int beställningsID, int produktID) throws IOException, SQLException {

        Properties p = new Properties();
        p.load(new FileInputStream("src/Settings.properties.txt"));

        try (Connection con = DriverManager.getConnection(
                p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
             CallableStatement stmt = con.prepareCall("call addToCart(?, ? , ?)");
             ) {
            stmt.setInt(1, kundID);
            stmt.setInt(2, beställningsID);
            stmt.setInt(3, produktID);
            stmt.executeQuery();

        }
    }


    }

