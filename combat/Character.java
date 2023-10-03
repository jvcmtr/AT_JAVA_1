package combat;

import combat.builds.BaseClass;

public class Character {
    private BaseClass Heroi;
    private String Nickname;

    public Character(String nick, BaseClass heroi){
        this.Heroi = heroi;
        this.Nickname = nick;
    }
}
