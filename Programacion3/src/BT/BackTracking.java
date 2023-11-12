package BT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTracking {

    public static void subset_Sums(int[] v, int m, int[] solution, int actSum, int stage) {
        if (stage == v.length) {
            if (actSum == m) {

                for (int j=0; j<solution.length; j++) {
                    if (solution[j] != 0) {
                        System.out.println(v[j]);
                    }
                }
            }} else {
        for (int i=0; i<=1; i++) {
            solution[stage] = i;
            actSum += v[stage] * i;

            if (actSum <= m) {
                subset_Sums(v, m, solution, actSum, stage+1);
            }

        }}
    }

    public static boolean equalSum_subSets(int[] v, int arrSum2, int etapa) {
        if (etapa == v.length) {
            int sumaRestante = Arrays.stream(v).sum() - arrSum2;
            return arrSum2 == sumaRestante;
        } else {
            boolean incluirElemento = equalSum_subSets(v, arrSum2 + v[etapa], etapa + 1);
            boolean excluirElemento = equalSum_subSets(v, arrSum2, etapa + 1);
            return incluirElemento || excluirElemento;
        }
    }


    public static void permutations_1234(int[] nums) {



//        if (etapa == nums.length) {
//            permutations.add(new ArrayList<>(comb));
//            return;
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            if (nextNumber_OK(nums, comb, i)) {
//                comb.add(nums[i]);
//                permutations_1234(nums, comb, etapa + 1, permutations);
//                comb.remove(comb.size() - 1);
//            }
//        }
    }

    private static boolean nextNumber_OK(int[] nums, List<Integer> comb, int i) {
        return i == 0 || Math.abs(comb.get(i) - comb.get(i - 1)) <= 2;
    }


}
