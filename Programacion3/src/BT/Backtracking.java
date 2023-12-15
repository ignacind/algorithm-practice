package BT;

import java.util.*;

import tda.impl.Musico;
import tda.impl.Par;

public class Backtracking {
    public static boolean n_Damas(List<Integer> s, int e) {
        boolean ok = false;
        s.set(e, 0);
        while (s.get(e) < s.size() && !ok) {
            if (damaOK(s, e)) {
                if (e == s.size() - 1) {
                    ok = true;
                } else {
                    ok = n_Damas(s, e + 1);
                }
            }
            s.set(e, s.get(e) + 1);
        }
        return ok;
    }

    public static boolean damaOK(List<Integer> s, int e) {
        for (int i = 1; i <= e - 1; i++) {
            if (s.get(i) == s.get(e) || Math.abs(s.get(i) - s.get(e)) == Math.abs((i - e))) {
                return false;
            }
        }
        return true;
    }


    public static void subset_Sums(int[] v, int m, int[] solution, int actSum, int stage) {
        if (stage == v.length) {
            if (actSum == m) {

                for (int j = 0; j < solution.length; j++) {
                    if (solution[j] != 0) {
                        System.out.println(v[j]);
                    }
                }
            }
        } else {
            for (int i = 0; i <= 1; i++) {
                solution[stage] = i;
                actSum += v[stage] * i;

                if (actSum <= m) {
                    subset_Sums(v, m, solution, actSum, stage + 1);
                }

            }
        }
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

    // [[2, 4, 1, 3], [3, 1, 4, 2]]

    public static void permutations_1234(int[] nums, List<Integer> perm, List<List<Integer>> permutations) {
        if (perm.size() == nums.length) {
            permutations.add(new ArrayList<>(perm));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!perm.contains(nums[i]) && (perm.size() == 0 || Math.abs(nums[i] - perm.get(perm.size() - 1)) >= 2)) {
                    perm.add(nums[i]);
                    permutations_1234(nums, perm, permutations);
                    perm.remove(perm.size() - 1);
                }
            }
        }
    }

    public static void roomPath_max(int[][] m, int n, List<Integer> path, List<Integer> longestPath) {

        if (path.get(path.size() - 1) == n - 1) {
            if (path.size() > longestPath.size()) {
                longestPath.clear();
                longestPath.addAll(new ArrayList<>(path));
            }
        } else {
            for (int i = 0; i < m.length; i++) {
                int lstNode = path.get(path.size() - 1);
                if (!path.contains(i) && i > lstNode && m[lstNode][i] == 1) {
                    path.add(i);
                    roomPath_max(m, n, path, longestPath);
                    path.remove(path.size() - 1);
                }
            }
        }
    }

    public static void permutations_Orquesta(List<Musico> musicos, List<String> perm, List<List<String>> permutations) {
        if (perm.size() == 4) {
            permutations.add(new ArrayList<>(perm));
        } else {
            for (int i = 0; i < musicos.size(); i++) {
                if (!perm.contains(musicos.get(i).id) && musicoOK(musicos, perm, i)) {
                    perm.add(musicos.get(i).id);
                    permutations_Orquesta(musicos, perm, permutations);
                    perm.remove(perm.size() - 1);
                }
            }
        }
    }

    public static boolean musicoOK(List<Musico> musicos, List<String> perm, int i) {
        String instrument = musicos.get(i).inst;
        int n = perm.size();

        return (n < 2 && instrument == "vln") || (n == 2 && instrument == "vla") || (n == 3 && instrument == "vcl");
    }


    public static int chorchosGame(int e, int p) {

        if (e == 0) {
            return p;
        } else {
            int play = 1;
            int val = p * -1;
            boolean poda = false;
            while ((play <= e) && (play <= 3) && !poda) {
                e -= play;
                if (p == 1) {
                    val = Math.max(val, chorchosGame(e, p * -1));
                } else {
                    val = Math.min(val, chorchosGame(e, p * -1));
                }

                if (val * p == 1) {
                    poda = true;
                } else {
                    e += play;
                }
                play += 1;
            }
            return val;
        }
    }

    public static void permutations_parcial2(int[] a, List<Integer> perm, List<List<Integer>> permutations) {
        if (perm.size() == 4) {
            permutations.add(new ArrayList<>(perm));
        } else {
//            for (int i = 0; i < a.length; i++)
            for (int i = a.length - 1; i > -1; i--) // CASO C, estrictamente decreciente
            {
                if (!perm.contains(a[i])) {  // CASO B, el caso A es con repeticiones.
                    perm.add(a[i]);
                    permutations_parcial2(a, perm, permutations);
                    perm.remove(perm.size() - 1);
                }
            }
        }
    }


    public static void conjunto_potencia(int index, List<Integer> list, Set<Integer> subset, Set<Set<Integer>> conjuntoPotencia) {
        conjuntoPotencia.add(new HashSet<>(subset));

        for (int i = index; i < list.size(); i++) {
            subset.add(list.get(i));
            conjunto_potencia(i + 1, list, subset, conjuntoPotencia);
            subset.remove(list.get(i));
        }
    }

    public static void redoCuartetoCuerdas(List<Musico> m, List<List<String>> cuartetos, List<String> temp) {
        if (temp.size() == 4) {
            cuartetos.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < m.size(); i++) {
                if (musicianOK(temp, m, i)) {
                    temp.add(m.get(i).id);
                    redoCuartetoCuerdas(m, cuartetos, temp);
                    temp.remove(temp.size()-1);
                }
            }
        }
    }


    public static boolean musicianOK(List<String> temp, List<Musico> m, int i) {
        String instrumento = m.get(i).inst;
        int n = temp.size();
        return  (!temp.contains(m.get(i).id))
                && ((n < 2 && instrumento == "vln")
                || (n == 2 && instrumento == "vla")
                || (n == 3 && instrumento == "vcl"));
    }






}






