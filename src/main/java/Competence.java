package main.java;

public enum Competence {

    /*Explication de chaque stats :
    Healing : nombre de PV rendus/retirés.
    Damage : nombre de dégâts supplémentaires/réduits infligés.
    Armor : nombre de points d'armure ajoutés/retirés au lanceur.
    Boost : nombre de points d'armure retirés/ajoutés au receveur.
    Turn : durée en tours de l'effet.
    Crit_rate : fixation du taux de coups critiques.
    Crit_damage : fixation du boost de dégâts liés au coups-critiques
    */

    //Compétences du barbare.
    ATTAQUE_RENFORCEE(0,40,0,0,1),
    INTIMIDATION(0,0,0,25,3),
    SOINS_CONTINUS(25,0,0,0,5),
    RENFORCEMENT(0,0,35,35,3),
    BRISE_ARMURE(0,30,0,40,3),
    UPPERCUT(0,150,0,0,1,0.2),
    TOUT_OU_RIEN(0,0,-50,150,10),

    //Compétences du mage.
    ECLAIR(0,35,0,0,1),
    MALEDICTION(0,35,0,0,3),
    SOINS_MAJEURS(60,0,10,0,1),
    EMBRASEMENT(0,65,5,0,3),
    COMETE(0,200,0,0,1),
    BOOST_MAGIQUE(0,0,10,20,4),
    PLUIE_SANGUINE(-60,400,0,0,1),

    //Compétence de l'assassin.
    BACKSTAB(2.0),
    PUISSANCE(0.75, 3),
    SAIGNEMENT(0,45,0,0,5),
    PREMIERS_SECOURS(30,0,0,0,1),
    SANGSUE(45,90,0,0,1),
    IMMOBILISATION(0,25,0,0,3,0.4),
    EXECUTION(25,-30,1,0.05);


    private int healing;
    private int damage;
    private int armor;
    private int boost;
    private int turn;
    private double crit_rate;
    private double crit_damage;
    private boolean special;

    Competence(int healing, int damage, int armor, int boost, int turn) {
        this.healing = healing;
        this.damage = damage;
        this.armor = armor;
        this.boost = boost;
        this.turn = turn;
        this.crit_rate = 0.25;
        this.crit_damage = 1.25;
        
    }

    Competence(double crit_rate, int turn) {
        this.crit_rate = crit_rate;
        this.crit_damage = 1.25;
        this.healing = 0;
        this.damage = 0;
        this.armor = 0;
        this.boost = 0;
        this.turn = turn;
    }

    Competence(double crit_damage) {
        this.healing = 0;
        this.damage = 0;
        this.armor = 0;
        this.boost = 0;
        this.crit_rate = 0.25;
        this.turn = 1;
        this.crit_damage = crit_damage;
    }

    Competence(int healing, int damage, int armor, int boost, int turn, double stunt) {
        this.crit_rate = 0.25;
        this.crit_damage = 1.25;
        this.healing = healing;
        this.damage = damage;
        this.boost = boost;
        this.turn = turn;
        if(Math.random()<stunt) {
            this.armor = 9999;
        } else {
            this.armor = 0;
        }
    }
    
    Competence(int damage, int armor, int turn, double execut_rate) {
        this.healing = 0;
        this.damage = damage;
        this.armor = armor;
        this.boost = 0;
        this.turn = turn;
        this.crit_rate = 0.25;
        this.crit_damage = 1.25;
        if(Math.random()<execut_rate) {
            this.damage = 9999;
        }
    }

    public void turnPast() {
        this.turn--;
    }
}