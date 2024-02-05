public class Player {
    //Attribut de la classe
    public static int NbPlayers = 0;

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

    // Constructeur avec paramètres
    public Player(String id, char positionPlayer, String name, String team, String status, int age, double ftps, 
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

    //Les Getters

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

    public double getFtpsPerGame() {
        return this.ftpsPerGp;
    }

    public int getGamePlayed() {
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

    // Retourne en format de String le contenu d'un objet Player
    public String toString(){
        return this.name+"\t"+this.team+"\t"+this.status+"\t"+this.ftps+"\t"+this.ftpsPerGp+"\t\t"+this.gp+"\t"+this.goals+"\t"+this.assists+"\t"+this.hits;
        }
}