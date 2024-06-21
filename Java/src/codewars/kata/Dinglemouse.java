package codewars.kata;
import java.util.*;



public class Dinglemouse {

    private static int[][] queues;
    private static List<Passenger> elevator;
    private static List<Integer> floorHistory;
    private static int capacity;
    private static boolean peopleInLine;

    public static int[] theLift(final int[][] queues, final int capacity) {
        Dinglemouse.queues = queues;
        Dinglemouse.capacity = capacity;
        elevator = new ArrayList<>();
        floorHistory = new ArrayList<>(); floorHistory.add(0);
        peopleInLine = true;

        while (peopleInLine) {
            peopleInLine = false;
            moveElevator(true);
            moveElevator(false);
        }

        if (floorHistory.get(floorHistory.size()-1) != 0) {
            floorHistory.add(0);
        }

        return floorHistory.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private static void moveElevator(boolean isGoingUp) {
        int index = isGoingUp ? 0 : queues.length - 1;

        for (int floor = index; isGoingUp ? floor < queues.length : floor >= 0; floor+= isGoingUp ? 1 : -1) {
            boolean stopToDeliver = deliverPassengers(floor);
            boolean stopToPickUp = pickUpPassengers(floor, isGoingUp);

            if ((stopToDeliver || stopToPickUp) && floorHistory.get(floorHistory.size()-1) != floor) {
                floorHistory.add(floor);
            }
        }
    }

    private static boolean deliverPassengers(int floor) {
        return elevator.removeIf(passenger -> passenger.objective == floor);
    }

    private static boolean pickUpPassengers(int floor, boolean isGoingUp) {
        boolean stopElevator = false;
        for (int j = 0; j < queues[floor].length; j++) {
            if (queues[floor][j] == -1) {
                continue;
            }
            boolean conditionForEnter = isGoingUp ? queues[floor][j] > floor : queues[floor][j] < floor;
            if (conditionForEnter) {
                stopElevator = true;
                if (capacity > elevator.size()) {
                    elevator.add(new Passenger(queues[floor][j], floor));
                    queues[floor][j] = -1;
                } else {
                    peopleInLine = true;
                }
            }


        }
        return stopElevator;
    }


    private record Passenger(int objective, int origin){};

}











