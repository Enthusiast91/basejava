package com.enthusiast91.webapp;

import java.util.Random;

public final class RandomName {
    public static String get() {
        final String[] FirstNames = {"Azmodan ", "Andariel ", "Baal ", "Belial ", "Diablo ", "Decard ", "Imperius ", "Maltael ", "Mephisto ", "Tirael "};
        final String[] LastNames = {"Adria", "Aidan", "Cain", "Djared", "Katos", "Lazarus", "Leah", "Leoric", "Magda", "Raven"};
        Random rand = new Random();

        return FirstNames[rand.nextInt(FirstNames.length)] + LastNames[rand.nextInt(LastNames.length)];
    }
}
