package leetcode.problem.easy;

import org.junit.Test;

public class NimGame {

    public boolean canWinNim(int n) {
        int player = getWinnerNim(n, 1);
        return player == 1;
    }

    private int getWinnerNim(int n, int i) {
        if (n <= 3) return i;


        int take = 1;
        int next = i * - 1;
        boolean bound = false;
        while (take<=3 && n > 1 && !bound) {
            n -= take;
            if (n==1){
                next = Math.max(next, getWinnerNim(n, i*-1));
            } else {
                next = Math.min(next, getWinnerNim(n, i*-1));
            }
            if (i * next == 1) {
                bound=true;
            } else {
                n += take;
            }
            take++;
        }
        return next;
    }

    @Test
    public void sampleTest() {
        System.out.println(canWinNim(5));
    }


}
