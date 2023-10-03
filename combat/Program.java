package combat;

import java.util.Scanner;

import combat.builds.Barbarian;
import combat.builds.BaseClass;
import combat.builds.Fighter;
import combat.builds.Paladin;
import utils.Console;

public class Program {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        BaseClass[] classes = CombatHelper.availableClasses();
        Console out = new Console(90);
        Character boneco = InitCharacter(classes, scan, out);
                

    }

    public static String runRandomBattle(Character c){
        BaseClass[] criaturas = CombatHelper.getIniciativa(c.getHeroi(), CombatHelper.getRandomMonster());

        while(true){
            if(criaturas[0].getFatorDeAtaque() > criaturas[1].getFatorDeDefesa())
                criaturas[0].attack( criaturas[1] );

            if(criaturas[1].isDead())
                break;

            criaturas = new BaseClass[]{
                criaturas[1], 
                criaturas[0]
            };
        }

        if(criaturas[0] == c.getHeroi()){
            return "";
        }


        return "" ;  
    }

    public static void AddToLog(String s){

    }

    

    public static Character InitCharacter(BaseClass[] classes, Scanner scan, Console out ){
        boolean run = false;
        String nickname = "";
        BaseClass charClass = null;

        while(!run){

            // _____________ NICKNAME ___________________________________________________________________________
            out.Clear()
                .printTitle("bem Vindo ao medieval Battle !")
                .println("")
                .println("")
                .println(" Digite o seu nickname : _ _ _")
                .Close();
            nickname = scan.nextLine();


            // _____________ HEROI ___________________________________________________________________________
            while(charClass == null){
                out.Clear()
                    .printTitle("bem Vindo ao medieval Battle !")
                    .println("")
                    .println("") 
                    .println("+ Digite o seu nickname : " + nickname)
                    .println("")
                    .println( "+ Digite o numero da classe que deseja escolher : ");
                
                for (int i = 0; i < classes.length; i++) {
                    out.println("    [" + i + "] " + classes[i].getDetails());
                }
                out.Close();

                try {
                    int i = scan.nextInt();
                    charClass = classes[i];
                } catch (Exception e) {
                    continue;
                }
            }
        
            
            // _____________ CONFIRMAR ___________________________________________________________________________
            String inp = "";
            while( !inp.equals("y") && !inp.equals("n")){
                out.Clear()
                    .printCentralized("+ Confirme seu personagem :")
                    .println("")
                    .println("    nickname : " + nickname)
                    .println("    classe : ")
                    .println("     "+ charClass.getDetails() )
                    .println("")
                    .printCentralized("[y] OK  /  [n] VOLTAR")
                    .Close();
                
                inp = scan.nextLine();
                for (char c : inp.toCharArray()) {
                    System.out.println(c == 'n');
                }
                System.out.println(inp == "n");
            }
            run = inp.equals("y");
        }

        Character c = new Character(nickname, charClass);
        return c;
    }
}
