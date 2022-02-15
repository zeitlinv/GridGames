public class Snail extends Pet{
    public Snail(){
        super(2, 2, 3, "Snail");
    }
    public void battle(Pet opp){
        opp.changeHP(calcDmg(opp));
        changeHP(2);
    }
    public void executeSkl(){}
}
