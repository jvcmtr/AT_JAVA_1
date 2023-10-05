package relatorios;

import java.util.Scanner;

import utils.Console;

public class Program {
    public static void main(String[] args){
        
        Scanner scan = new Scanner(System.in);
        Console out = new Console(90);

        UserLogs userLog = getUserLog(out, scan);
        
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

    public static void displayLog(UserLogs log, battleLogs, Console out, Scanner scan){
            out.Clear()
                .printTitle("Bem vindo " + battleLogs[0].nickname)
                .println("")
                .println("")
                .println(" Digite o seu nickname : _ _ _")
                .Close();
    }

    private static BattleLog[] getLog(String nickname) {
        return null;
    }
}
