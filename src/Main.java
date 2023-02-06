import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public Main() {

    }

    public static void main(String[] args) throws SQLException, IOException {
        boolean loop = true;
        boolean loop2 = true;
        Scanner scanner = new Scanner(System.in);
        String userName;
        String password;
        String skoVal;
        int skoID = 0;
        int kundID = 0;
        int beställningsID = 0;
        SearchInterface kundNamnSök = (k, s) -> k.getNamn().equalsIgnoreCase(s);
        SearchInterface kundLösenordSök = (k, s) -> k.getLösenord().equals(s);
        SearchInterfaceSkor skorSökInterface = (sko, s) -> sko.getNamn().equalsIgnoreCase(s);

        Main m = new Main();
        Repository r = new Repository();
        List<Kund> kundLista = r.getKunder();
        List<Skor> skoLista = r.getSkor();
        List<Beställningar> beställningsLista = r.getBeställningar();
        kundLista.forEach(k -> System.out.println(k.getNamn() + ", lösenord: " + k.getLösenord()));  //LAMBA

//TODO gör loop till en metod!
        while (loop) {
            System.out.println("Skriv in ditt användarnamn: ");
            userName = scanner.nextLine();
            for (Kund kund : kundLista){
                //kund.getNamn().equalsIgnoreCase(userName)
                if (kundNamnSök.search(kund, userName)) {
                    System.out.println(userName + " Fanns i databasen");
                    kundID = kund.getKundID();
                    beställningsID = kund.getKundID();
                    System.out.println("Skriv in ditt lösenord: ");
                    password = scanner.nextLine();
                    {
                        if (kundLösenordSök.search(kund, password)) {
                            System.out.println("Korrekt lösenord, Välkommen: " + userName);
                            loop = false;
                            break;
                        } else {
                            System.out.println("fel lösenord, var vänlig försök igen");
                        }

                    }

                }


            }
            System.out.println(userName + " fanns inte i databasen, försök igen");


        }
        System.out.println("\nHär är alla skor som finns i lager: ");
        skoLista.forEach(s -> System.out.println(s.getNamn() + " -> finns i storlek " + s.getSkoStorlek()));   //LAMBA
       while (true) {
           System.out.println("\nVilken sko vill du ha?, skriv en");
           skoVal = scanner.nextLine();
           for (Skor sko : skoLista) {
                if (skorSökInterface.search(sko, skoVal)) {
                    skoID = sko.getSkoID();
                    r.callAddToCart(kundID, beställningsID, skoID);
                    System.out.println(skoVal + " lades till i din beställning!");
                    break;
                }
            }

        }
    }
}











