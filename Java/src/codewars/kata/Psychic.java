package codewars.kata;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class Psychic {

    public static double guess() {
        long seed_ms = System.currentTimeMillis();
        try {
            Field randomNumberGeneratorField = Class.forName("java.lang.Math$RandomNumberGeneratorHolder").getDeclaredField("randomNumberGenerator");
            randomNumberGeneratorField.setAccessible(true);
            Random random = (Random) randomNumberGeneratorField.get(null);
            random.setSeed(seed_ms);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new Random(seed_ms).nextDouble();
    }

    @Test
    public void testRandom() {
        assertEquals(Psychic.guess(), java.lang.Math.random(), 0);
    }
}
