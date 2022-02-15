public class Slug extends Pet{
    private int dmgAmt;

    public Slug(){
        super(2, 2, 3, "Slug");
    }

    public void changeHP(int dHP){
        int newHP = hp + dHP;
        if(dHP < 0){
            dmgAmt = dHP;
        }
        if(newHP < 0){
            hp = 0;
        }
        else if (newHP > maxHP){
            hp = maxHP;
        }
        else{
            hp = newHP;
        } 
        
    }

    public void battle(Pet opp){
        opp.changeHP(calcDmg(opp));

    }
    public void executeSkl(){}
}
