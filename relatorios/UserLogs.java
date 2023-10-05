package relatorios;

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

}
