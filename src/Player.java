import java.text.DecimalFormat;

public class Player {
    // Attribut de la classe
    public static int NbPlayers = 0;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    // Attributs des joueurs (instances)
    private String id;
    private char positionPlayer;
    private String name;
    private String team;
    private String status;
    private int age;
    private double ftps;
    private double ftpsPerGp;
    private int gp;
    private int goals;
    private int assists;
    private int penalties;
    private int shotsOnGoal;
    private int shortHandedGoals;
    private int powerPlayPoints;
    private int hatTricks;
    private int hits;
    private double fptsGp14Jours;
    private double ftpsGp30Jours;
    private int matchAJouerCetteSemaine;
    private double ftpsPrevisionProchaineSemaine;

    // Constructeur par défaut
    public Player() {
        NbPlayers++;
    }

    // Constructeur des essentiels
    public Player(String id, char positionPlayer, String name, double fptsGp14Jours,
            double ftpsGp30Jours, double ftpsPerGp, int matchAJouerCetteSemaine,
            double ftpsPrevisionProchaineSemaine) {
        this.id = id;
        this.positionPlayer = positionPlayer;
        this.name = name;
        this.fptsGp14Jours = fptsGp14Jours;
        this.ftpsGp30Jours = ftpsGp30Jours;
        this.ftpsPerGp = ftpsPerGp;
        this.matchAJouerCetteSemaine = matchAJouerCetteSemaine;
        this.ftpsPrevisionProchaineSemaine = ftpsPrevisionProchaineSemaine;
    }

    // Constructeur avec paramètres
    public Player(String id, char positionPlayer, String name, String team, String status, int age,
            double ftps,
            double ftpsPerGp, int gp, int goals, int assists, int penalties, int shotsOnGoal,
            int shortHandedGoals, int powerPlayPoints, int hatTricks, int hits) {
        this.id = id;
        this.positionPlayer = positionPlayer;
        this.name = name;
        this.team = team;
        this.status = status;
        this.age = age;
        this.ftps = ftps;
        this.ftpsPerGp = ftpsPerGp;
        this.gp = gp;
        this.goals = goals;
        this.assists = assists;
        this.penalties = penalties;
        this.shotsOnGoal = shotsOnGoal;
        this.shortHandedGoals = shortHandedGoals;
        this.powerPlayPoints = powerPlayPoints;
        this.hatTricks = hatTricks;
        this.hits = hits;
        ++NbPlayers;
    }

    // Les Getters

    public String getId() {
        return this.id;
    }

    public char getPositionPlayer() {
        return this.positionPlayer;
    }

    public String getName() {
        return this.name;
    }

    public String getTeam() {
        return this.team;
    }

    public String getStatus() {
        return this.status;
    }

    public int getAge() {
        return this.age;
    }

    public double getFtps() {
        return this.ftps;
    }

    public double getFtpsPerGp() {
        return this.ftpsPerGp;
    }

    public int getGp() {
        return this.gp;
    }

    public int getGoals() {
        return this.goals;
    }

    public int getAssists() {
        return this.assists;
    }

    public int getPenalties() {
        return this.penalties;
    }

    public int getShotsOnGoal() {
        return this.shotsOnGoal;
    }

    public int getShortHandedGoals() {
        return this.shortHandedGoals;
    }

    public int getPowerPlayPoints() {
        return this.powerPlayPoints;
    }

    public int getHatTricks() {
        return this.hatTricks;
    }

    public int getHits() {
        return this.hits;
    }

    public double getFptsGp14Jours() {
        return this.fptsGp14Jours;
    }

    public double getFtpsGp30Jours() {
        return this.ftpsGp30Jours;
    }

    public int getMatchAJouerCetteSemaine() {
        return this.matchAJouerCetteSemaine;
    }

    public double getFtpsPrevisionProchaineSemaine() {
        return this.ftpsPrevisionProchaineSemaine;
    }

    // Les Setters

    public void setId(String id) {
        this.id = id;
    }

    public void setPositionPlayer(char positionPlayer) {
        this.positionPlayer = positionPlayer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFtps(double ftps) {
        this.ftps = ftps;
    }

    public void setFtpsPerGp(double ftpsPerGp) {
        this.ftpsPerGp = ftpsPerGp;
    }

    public void setGp(int gp) {
        this.gp = gp;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public void setPenalties(int penalties) {
        this.penalties = penalties;
    }

    public void setShotsOnGoal(int shotsOnGoal) {
        this.shotsOnGoal = shotsOnGoal;
    }

    public void setShortHandedGoals(int shortHandedGoals) {
        this.shortHandedGoals = shortHandedGoals;
    }

    public void setPowerPlayPoints(int powerPlayPoints) {
        this.powerPlayPoints = powerPlayPoints;
    }

    public void setHatTricks(int hatTricks) {
        this.hatTricks = hatTricks;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public void setFptsGp14Jours(double fptsGp14Jours) {
        this.fptsGp14Jours = fptsGp14Jours;
    }

    public void setFtpsGp30Jours(double ftpsGp30Jours) {
        this.ftpsGp30Jours = ftpsGp30Jours;
    }

    public void setMatchAJouerCetteSemaine(int matchAJouerCetteSemaine) {
        this.matchAJouerCetteSemaine = matchAJouerCetteSemaine;
    }

    public void setFtpsPrevisionProchaineSemaine(double ftpsPrevisionProchaineSemaine) {
        this.ftpsPrevisionProchaineSemaine = ftpsPrevisionProchaineSemaine;
    }

    // Méthode afficher joueur complet
    public String afficherPrevision() {
        return this.id + "\t" + this.positionPlayer + "\t" + this.name + "\t" + this.fptsGp14Jours + "\t"
                + this.ftpsGp30Jours + "\t" + this.ftpsPerGp + "\t" + this.matchAJouerCetteSemaine + "\t"
                + this.ftpsPrevisionProchaineSemaine;
    }

    // Retourne en format de String le contenu d'un objet Player
    public String toString() {
        return "\n" + this.name + "\t" + this.team + "\t" + df.format(this.ftpsPrevisionProchaineSemaine) + "\t"
                + this.matchAJouerCetteSemaine + "\t" + this.fptsGp14Jours + "\t" + this.ftpsGp30Jours + "\t"
                + this.ftpsPerGp + "\t" + this.ftps + " pts\t" +
                +gp + " gp\t" + this.goals + " g\t" + this.assists + " a\t" + this.hits + " hits";
    }
}

// Une fonction qui prend le nom de jueur. Si nom inferieur à 120, rajouter des
// espaces jusqu'à obtenir 120
// Rajouter les espaces avec une boule