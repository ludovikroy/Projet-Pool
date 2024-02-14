import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Projet {
    private static final int MAX_PLAYERS = 27;
    static Player tabPlayers[] = new Player[MAX_PLAYERS];

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
                ligne = ligne.replace("*", "");
                composants = ligne.split(",");
                tabPlayers[i] = new Player(composants[0], composants[1].charAt(0), composants[2], composants[3],
                        composants[5], Integer.parseInt(composants[6]),
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

    private static void chargerStats14Jours() {
        String ligne;
        String composants[] = new String[18];
        int i = 0;
        BufferedReader bufLire = null;
        try {
            bufLire = new BufferedReader(new FileReader("./src/donnees/Stats_14Jours.txt"));
            while ((ligne = bufLire.readLine()) != null && i < MAX_PLAYERS) {
                ligne = ligne.replace("\"", "");
                ligne = ligne.replace("*", "");
                composants = ligne.split(",");
                tabPlayers[i].setFptsGp14Jours(Double.parseDouble(composants[8]));
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

    private static void chargerStats30Jours() {
        String ligne;
        String composants[] = new String[18];
        int i = 0;
        BufferedReader bufLire = null;
        try {
            bufLire = new BufferedReader(new FileReader("./src/donnees/Stats_30Jours.txt"));
            while ((ligne = bufLire.readLine()) != null && i < MAX_PLAYERS) {
                ligne = ligne.replace("\"", "");
                ligne = ligne.replace("*", "");
                composants = ligne.split(",");
                tabPlayers[i].setFtpsGp30Jours(Double.parseDouble(composants[8]));
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

    public static void chargerNbMatchsAJouer() {
        String ligne;
        String composants[] = new String[18];
        int i = 0;
        BufferedReader bufLire = null;
        try {
            bufLire = new BufferedReader(new FileReader("./src/donnees/Stats_MatchsAJouer.txt"));
            while ((ligne = bufLire.readLine()) != null && i < MAX_PLAYERS) {
                ligne = ligne.replace("\"", "");
                ligne = ligne.replace("*", "");
                composants = ligne.split(",");
                tabPlayers[i].setMatchAJouerCetteSemaine((int) Math.ceil(Double.parseDouble(composants[9])));
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

    public static void calculerFtpsPredictionSemaine() {
        for (Player aPlayer : tabPlayers) {
            double Stats14Jours = aPlayer.getFptsGp14Jours();
            double Stats30Jours = aPlayer.getFtpsGp30Jours();
            double StatsSaison = aPlayer.getFtpsPerGp();
            double MatchsAJouer = aPlayer.getMatchAJouerCetteSemaine();
            double PredictionSemaine = ((0.2 * Stats14Jours) + (0.5 * Stats30Jours) + (0.3 * StatsSaison))
                    * MatchsAJouer;
            aPlayer.setFtpsPrevisionProchaineSemaine(PredictionSemaine);
        }
    }

    public static void ajusterLongueurNomJoueur() {
        for (Player aPlayer : tabPlayers) {
            String name = aPlayer.getName();
            if (name.length() <= 33) {
                aPlayer.setName(name + " ".repeat(33 - name.length()));
            }
        }
    }

    public static void afficherSiBlessure() {
        for (Player aPlayer : tabPlayers) {
            String name = aPlayer.getName();
            if (aPlayer.getStatus().equals("IR")) {
                aPlayer.setName(name + " (IR)");
            }
        }
    }

    private static void ordonnerSelonPredictionSemaine(){
        Arrays.sort(tabPlayers, Comparator.comparing(Player::getFtpsPrevisionProchaineSemaine).thenComparing(Player::getFtpsGp30Jours).reversed());
    }

    private static void listerPlayers() {
        JTextArea jta = new JTextArea();
        jta.append("*****ATTAQUANT*****\n" + "Nom du joueur\t\t" + "Équipe\t" + "Ftps/Semaine\t" + "Gp this week\t"
                + "Ftps/gp(14J)\t"
                + "Ftps/gp(30J)\t" + "Ftps/gp\t" + "Ftps\t" + "Game Played\t" + "Goals\t"
                + "Assists\t" + "Hits");
        for (Player aPlayer : tabPlayers) {
            //int ranking = 0;
                if (aPlayer.getPositionPlayer() == 'F') {
                    jta.append(aPlayer.toString());
                    //ranking++;
                }
        }
        jta.append("\n\n*****DÉFENSEUR*****\n" + "Nom du joueur\t\t" + "Équipe\t" + "Ftps/Semaine\t" + "Gp this week\t"
                + "Ftps/gp(14J)\t"
                + "Ftps/gp(30J)\t" + "Ftps/gp\t" + "Ftps\t" + "Game Played\t" + "Goals\t"
                + "Assists\t" + "Hits");
        for (Player aPlayer : tabPlayers) {
            if (aPlayer.getPositionPlayer() == 'D') {
                jta.append(aPlayer.toString());
            }
        }
        JOptionPane.showMessageDialog(null, jta, "Statistiques des joueurs", JOptionPane.PLAIN_MESSAGE);
    }

    public static void main(String[] args) throws Exception {
        chargerPlayers();
        chargerStats14Jours();
        chargerStats30Jours();
        chargerNbMatchsAJouer();
        calculerFtpsPredictionSemaine();
        afficherSiBlessure();
        ajusterLongueurNomJoueur();
        ordonnerSelonPredictionSemaine();
        listerPlayers();
    }
}