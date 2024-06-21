package hackerrank.week4;

import org.junit.jupiter.api.Test;

import java.util.*;

public class HackerlandTransmitters {

    public static int hackerlandRadioTransmitters(List<Integer> x, int k) {
        ArrayList<Integer> houses = new ArrayList<>(x);
        Collections.sort(houses);
        int transmitters = 1;
        int i = 0;
        int candidateInCenter = houses.get(i) + k;
        int anntenaPos = i;
        while (i < houses.size()) {
            if (houses.get(i) <= candidateInCenter) {
                anntenaPos = houses.get(i);
            } else if (houses.get(i) > anntenaPos+k) {
                transmitters++;
                candidateInCenter = houses.get(i)+k;
            }
            i++;
        }

        return transmitters;
    }

    @Test
    public void sampleTest() {
        List<Integer> arr = List.of(1, 2, 3, 5, 9);
        System.out.println(hackerlandRadioTransmitters(arr, 1));
    }
}
