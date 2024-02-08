import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Projet {
    private static final int MAX_PLAYERS = 26;
    static Player tabPlayers[] = new Player[MAX_PLAYERS];

    // // ********** Avec Scanner (fonctionne) **********
    // private static void chargerPlayers() {
    // String ligne;
    // int i = 0;
    // BufferedReader bufLire = null;
    // try {
    // bufLire = new BufferedReader(new
    // FileReader("./src/donnees/Stats_Saison.txt"));
    // while ((ligne = bufLire.readLine()) != null && i < MAX_PLAYERS) {
    // Scanner scanner = new Scanner(ligne);
    // scanner.useDelimiter("[*,\"]+");
    // while (scanner.hasNext()) {
    // tabPlayers[i] = new Player(scanner.next(), scanner.next().charAt(0),
    // scanner.next(), scanner.next(),
    // scanner.next().charAt(0), scanner.next(), Integer.parseInt(scanner.next()),
    // Double.parseDouble(scanner.next()),
    // Double.parseDouble(scanner.next()),
    // Integer.parseInt(scanner.next()),
    // Integer.parseInt(scanner.next()),
    // Integer.parseInt(scanner.next()),
    // Integer.parseInt(scanner.next()),
    // Integer.parseInt(scanner.next()),
    // Integer.parseInt(scanner.next()),
    // Integer.parseInt(scanner.next()),
    // Integer.parseInt(scanner.next()),
    // Integer.parseInt(scanner.next()));
    // }
    // i++;
    // scanner.close();
    // }
    // } catch (Exception e) {
    // System.out.println("Erreur pour charger les joueurs" + e.getMessage());
    // } finally {
    // try {
    // bufLire.close();
    // } catch (Exception e) {
    // System.out.println("Erreur pour fermer le bufLire." + e.getMessage());
    // }
    // }
    // }

    // ********** Avec Split (ne fonctionne pas) **********
    // Avec la méthode "replace" pour enlever les ""
    private static void chargerPlayers() {
        String ligne;
        String composants[] = new String[18];
        int i = 0;
        BufferedReader bufLire = null;
        try {
            bufLire = new BufferedReader(new FileReader("./src/donnees/Stats_Saison.txt"));
            while ((ligne = bufLire.readLine()) != null && i < MAX_PLAYERS) {
                ligne = ligne.replace("\"", "");
                composants = ligne.split(",");
                tabPlayers[i] = new Player(composants[0], composants[1].charAt(0), composants[2], composants[3],
                        composants[4].charAt(0), composants[5], Integer.parseInt(composants[6]),
                        Double.parseDouble(composants[7]), Double.parseDouble(composants[8]),
                        Integer.parseInt(composants[9]), Integer.parseInt(composants[10]),
                        Integer.parseInt(composants[11]), Integer.parseInt(composants[12]),
                        Integer.parseInt(composants[13]), Integer.parseInt(composants[14]),
                        Integer.parseInt(composants[15]), Integer.parseInt(composants[16]),
                        Integer.parseInt(composants[17]));
                i++;
            }
        } catch (Exception e) {
            System.out.println("Erreur pour charger les joueurs" + e.getMessage());
        } finally {
            try {
                bufLire.close();
            } catch (Exception e) {
                System.out.println("Erreur pour fermer le bufLire." + e.getMessage());
            }
        }
    }

    private static void listerPlayers() {
        JTextArea jta = new JTextArea();
        jta.append("Nom du joueur\t" + "Équipe\t" + "Status\t" + "Ftps\t" + "Ftps/gp\t" + "Game Played\t" + "Goals\t"
                + "Assists\t" + "Hits\n");
        for (Player aPlayer : tabPlayers) {
            jta.append(aPlayer.toString());
        }
        JOptionPane.showMessageDialog(null, jta, "Statistiques des joueurs", JOptionPane.PLAIN_MESSAGE);
    }

    public static void main(String[] args) throws Exception {
        chargerPlayers();
        listerPlayers();
    }
}