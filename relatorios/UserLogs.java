package relatorios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import javax.swing.RowFilter.Entry;

public class UserLogs {
    private BattleLog[] Logs;
    private String Nickname;

    public UserLogs(BattleLog[] logs, String nickname){
        Logs = logs;
        Nickname = nickname;
    }

    public String getNickname(){
        return Nickname;
    }

    public String getHeroiMaisJogado(){
        Map<String, Integer> herois = new HashMap<String, Integer>();
        forEachLog((log)->{
            String h = log.getHeroi();

            if( herois.containsKey(h) )
                herois.put(h, herois.get(h)+1);
            else
                herois.put(h, 1);
        });

        String nome = "";
        int value = 0;
        
        for( var k : herois.keySet()){
            if(herois.get(k) > value){
                value = herois.get(k);
                nome = k;
            }
        }
        return nome + "   (" + value + "x)";
    }

    public String getMostroMaisEnfrentado(){
        Map<String, Integer> herois = new HashMap<String, Integer>();
        forEachLog((log)->{
            String h = log.getMonstro();

            if( herois.containsKey(h) )
                herois.put(h, herois.get(h)+1);
            else
                herois.put(h, 1);
        });

        String nome = "";
        int value = 0;
        
        for( var k : herois.keySet()){
            if(herois.get(k) > value){
                value = herois.get(k);
                nome = k;
            }
        }
        return nome + "   (" + value + "x)";
    }

    public String getPontosTotais(){
        int pontos = 0;
        for (BattleLog battleLog : Logs) {
            pontos += Pontos(battleLog);
        }

/*      // O FATO DISSO NÃO FUNCIONAR É HORROROZO        
        forEachLog((log)->{
            pontos += Pontos(log);
        });
*/
        return pontos + "pts";
    }

    public String getIndiceDeVitoria(){
        ArrayList<Integer> vitorias = new ArrayList<>();
        forEachLog((log)->{
            if(log.isGanhou())
                vitorias.add(0);
        });

        return "Vitorias: " + vitorias.size() + "   / Derrotas: " + Logs.length;
    }

    public String getDiaMaisJogado(){
        Map<LocalDate, Integer> herois = new HashMap<LocalDate, Integer>();
        forEachLog((log)->{
            LocalDate dt = log.getDataDaPartida();

            if( herois.containsKey(dt) )
                herois.put(dt, herois.get(dt)+1);
            else
                herois.put(dt, 1);
        });

        LocalDate nome = LocalDate.MIN;
        int value = 0;
        
        for( var k : herois.keySet()){
            if(herois.get(k) > value){
                value = herois.get(k);
                nome = k;
            }
        }
        return nome + "   ( " + value + " partidas )";
    }

    public String getPontosPorHeroi( String heroi ){
        int pontos = 0;
        for (BattleLog battleLog : Logs) {
            if(battleLog.getHeroi() == heroi){
                pontos += Pontos(battleLog);
            }
        }

        return pontos + "pts";
    }

    public String getIndiceDeVitoriaPorHeroi( String heroi ){
        ArrayList<Integer> vitorias = new ArrayList<>();
        forEachHeroi(heroi,  (log) ->{
            if(log.isGanhou())
                vitorias.add(0);
        });

        return "Vitorias: " + vitorias.size() + "   / Derrotas: " + Logs.length;
    }

    private void forEachLog(Consumer<BattleLog> c){
        for (BattleLog battleLog : Logs) {
            c.accept(battleLog);
        }
    }

    private void forEachHeroi(String Heroi, Consumer<BattleLog>c){
        for (BattleLog battleLog : Logs) {
            if(battleLog.getHeroi() == Heroi){
                c.accept(battleLog);
            }
        }
    }

    private int Pontos(BattleLog b){
        return 100-b.getRodadas();
    }
}
