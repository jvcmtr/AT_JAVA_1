package utils;
import java.util.Scanner;

import combat.Program;
import combat.builds.BaseClass;
import combat.Character;

public class AltProgram {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Console out = new  Console(90);
        String nick = Program.EscolherNickname(scan, out);

        while(true){
            BaseClass b = Program.EscolherClasse(nick, scan, out);
            Character c = new Character(nick, b);

            for (int i = 0; i < 10; i++) {
                Program.AddToLog(Program.runRandomBattle(c), c);
            }
        }


    }
}
