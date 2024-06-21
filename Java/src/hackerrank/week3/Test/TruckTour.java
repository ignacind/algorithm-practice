package hackerrank.week3.Test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TruckTour {
    public static int truckTour(List<List<Integer>> petrolpumps) {
        int tank = 0;
        int origin = 0;
        for (int i = 0; i < petrolpumps.size(); i++) {
            int petrolStop = petrolpumps.get(i).get(0);
            int distanceNextPetrol = petrolpumps.get(i).get(1);

            tank += (petrolStop-distanceNextPetrol);
            if (tank < 0) {
                origin = i + 1;
                tank = 0;
            }
        }
        return origin;
    }

    @Test
    public void sampleTest() {
        List<List<Integer>> petrolPumps = new ArrayList<>();
        petrolPumps.add(new ArrayList<>(Arrays.asList(1, 5)));
        petrolPumps.add(new ArrayList<>(Arrays.asList(10, 3)));
        petrolPumps.add(new ArrayList<>(Arrays.asList(3, 4)));

        System.out.println(truckTour(petrolPumps));
    }
}
