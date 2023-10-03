package combat;

import java.util.Random;

import combat.builds.Barbarian;
import combat.builds.BaseClass;
import combat.builds.Fighter;
import combat.builds.Kobold;
import combat.builds.Orc;
import combat.builds.MortoVivo;
import combat.builds.Paladin;

public class CombatHelper {
    public static BaseClass[] availableMonsters(){
        return new BaseClass[]{
            new MortoVivo(),
            new Orc(),
            new Kobold()
        };
    }

    public static BaseClass[] availableClasses(){
        return new BaseClass[]{
            new Barbarian(),
            new Fighter(),
            new Paladin()
        };
    }

    public static BaseClass getRandomMonster(){
        Random r = new Random();
        var m = availableMonsters();
        int i = r.nextInt(m.length);
        return m[i];
    }

    public static BaseClass[] getIniciativa(BaseClass player, BaseClass monstro){
        int pi = player.getIniciativa();
        int mi = monstro.getIniciativa();

        if(pi > mi){
            return new BaseClass[]{
                player, monstro
            };
        }

        
        if(pi < mi){
            return new BaseClass[]{
                monstro, player
            };
        }

        return getIniciativa(player, monstro);
    }
}
