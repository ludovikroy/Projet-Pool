import java.io.BufferedReader;

public class Projet {
    public static void main(String[] args) throws Exception {
        static BufferedReader bufLire;
        private static final int MAX_LIVRES = 100;
        private static boolean donneesChangees = false;

        static Livre tabLivres[] = new Livre[MAX_LIVRES];

        private static void chargerPlayers(){
            String ligne;
            String composants[] = new String[6];
            int i=0;
            try{
                bufLire = new  BufferedReader(new FileReader("./src/Donnees/livres.txt"));
                while((ligne = bufLire.readLine()) != null &&  i < MAX_LIVRES){
                    composants = ligne.split(";");
                    tabLivres[i] = new Livre(Integer.parseInt(composants[0]),  composants[1], Integer.parseInt(composants[4]),Integer.parseInt(composants[3]));
                    i++;
                }
            } catch(Exception e){
                System.out.println("Erreur pour charger les livres"+e.getMessage());
            }
        }




    }
}
