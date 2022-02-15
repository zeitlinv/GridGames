import info.gridworld.actor.Actor;

abstract class Pet extends Actor {
    protected String name;
    protected int maxHP;
    protected int maxAtk;
    protected int maxDef;
    
    protected int atk;
    protected int def;
    protected int hp;
    protected boolean isKO;
    /*
    Side effect- varaible changes (in memory) in the middle of the code 
    Functional programming- no side effects - only work w constants 
    const b  = new Bee(5); always 5 hp
        FN: Haskell, ML, Lisp- useful for data analysis
        Python, Scala, Javascript
        OOP: Java, C++
        Imperative: C
    */
    
    public Pet(int a, int d, int h, String n){
        maxAtk = a;
        maxHP = h;
        maxDef = d;
        name = n;

        atk = a;
        hp = h;
        def = d;
        isKO = false;
    }
    
    public void setHealth(int newHP){
        hp = newHP;
    }
    public void setAtk(int newAtk){
        atk = newAtk;
    }
    public void setDef(int newDef){
        def = newDef;
    }


    abstract public void executeSkl();

    public int calcDmg(Pet opp){
        return atk;
    }
    public void changeHP(int dHP){
        int newHP = hp + dHP;
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
    public void checkKO(){
        if(hp <= 0){
            isKO = true;
        }
        else{
            isKO = false;
        }
    }

    public void battle(Pet opp){
        opp.changeHP(calcDmg(opp));
    }

    public String toString(){
        return String.format("%s: %d, %d", name, hp, atk);
    }
}
