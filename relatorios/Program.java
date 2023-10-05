package relatorios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import utils.Console;
import utils.RepositoryHelper;
import utils.Utils;

public class Program {
    public static void main(String[] args){
        
        Scanner scan = new Scanner(System.in);
        Console out = new Console(90);

        UserLogs userLog = getUserLog(out, scan);
        displayLog(userLog, out, scan);
        
    }

    private static UserLogs getUserLog(Console out, Scanner scan){
        BattleLog[] userLog = null;
        String nickname ="";

        String ERRO = "";
        boolean done = false;
        
        while (!done){
            out.Clear()
                .printTitle("Veja seu histtorico de combate ")
                .println("")
                .println("")
                .println(" Digite o seu nickname : _ _ _")
                .println(ERRO)
                .Close();

            
            nickname = scan.nextLine();
            userLog = getLog(nickname);

            if (userLog.length == 0)
                ERRO = "Nao foi encontrado um jogador com o nome " + nickname;
            else
                done = true;
        }
        return new UserLogs(userLog, nickname);
    }

    public static void displayLog(UserLogs log, Console out, Scanner scan){
            out.Clear()
                .printTitle("Bem vindo " + log.getNickname())
                .println("Heroi mais jogado : " + log.getHeroiMaisJogado())
                .println("Monstro mais Enfrentado : " + log.getHeroiMaisJogado())
                .println("")
                .Close();
    }

    private static BattleLog[] getLog(String nickname) {
        String[] lines = RepositoryHelper.Load(nickname);
        ArrayList<BattleLog> logs = new ArrayList<BattleLog>();
        
        for (String line : lines) {
            String[] props = line.split(",");
            BattleLog b = new BattleLog( 
                Utils.dtFromString(props[0]), 
                props[1], 
                (props[2]=="GANHOU"), 
                props[3], 
                Integer.parseInt(props[4]) );
            logs.add(b);
        }

        return logs.toArray(new BattleLog[logs.size()]);
    }
}
