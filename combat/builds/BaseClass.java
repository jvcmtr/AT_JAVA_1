package combat.builds;

import utils.Dice;

public abstract class BaseClass {

    protected String name;
    protected Dice FdD;
    protected int PdV;
    protected int For;
    protected int Def;
    protected int Agi;
    
    public BaseClass() {

    }

    public String getDetails(){
        int j = 10 - name.length();
        String spacing = "";
        for (int i = 0; i < j; i++) 
            spacing += " ";
        
        return spacing + name + "  | Vida: " +  PdV + "  | Força: " + For + "  | Defesa: " + Def+ "  | Agilidade: "+Agi+ "  | Dano: "+FdD.toString();   
    }
    
    public String getName(){
        return this.name;
    }

}