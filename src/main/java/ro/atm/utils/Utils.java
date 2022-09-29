package ro.atm.utils;

import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class Utils {
    private static final Random rnd = new Random();

    public static @NotNull String getRandomNumber(int digCount) {
        StringBuilder sb = new StringBuilder(digCount);
        for (int i = 0; i < digCount; i++)
            sb.append((char) ('0' + rnd.nextInt(10)));
        return sb.toString();
    }
}
