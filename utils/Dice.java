package utils;

import java.util.Random;

public class Dice {
    private int d;

    public Dice(int max){
        this.d = max;
    }

    public int roll(){
        Random rng = new Random();
        return (rng.nextInt(d)+1);
    }

    public static int roll(int D){
        Random rng = new Random();
        return (rng.nextInt(D)+1);
    }
}
