package programacion3.DP;

import tda.impl.Solicitud;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DynamicProgramming {


    /*
        Navegación en el río Ctalamochita, de nuevo. Usted planea navegar en
    canoa aguas abajo por el río Ctalamochita entre las ciudades de Morrison
    y Monte Leña. Hay n puestos de canoas a lo largo de este trayecto. Antes
    de comenzar su excursión, usted consigue para cada 1 ≤ i < j ≤ n, el
    precio fi,j para alquilar una canoa desde el puesto i hasta el puesto j.
    Estos precios son arbitrarios. Por ejemplo, es posible que sea f1,3 = 10 y
    f1,4 = 5. Usted comienza en el puesto 1 y debe terminar en el puesto n
    (usando canoas alquiladas). El objetivo es minimizar el costo.
        Aplique un abordaje de programación dinámica para resolver este
    problema. Considere la posibilidad de construir una tabla en la que la
    posición i contenga el costo mínimo para llegar a este puesto desde el
    puesto 1.
    */
    public static int navegationPrice(int[][] prices, int n, int x) {
        int[] v = new int[n];
        int[] pos = new int[n];
        for (int i = 0; i<n; i++) {
            if (i==0){
                v[i] = 0;
            } else {
                v[i] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i+1 == n) {break;}
            for (int j = i+1; j<n; j++) {
                if (i == 0){
                    pos[i]=-1;
                }
                if (prices[i][j] != 0) {
                    if (v[j] > v[i] + prices[i][j]) {
                        v[j] = v[i] + prices[i][j];
                        pos[j] = i;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(v));
        System.out.println(Arrays.toString(pos));
        return v[n-1];
    }

    public static int subsecuenciaStrings(String a, String b) {
        int[][] m = new int[a.length()][b.length()];


        for (int i = 0; i<a.length(); i++) {
            for (int j = 0; j<b.length(); j++) {
                if (i==0 || j==0){m[i][j]=0;}
                else if (a.charAt(i) == b.charAt(j)) {
                    m[i][j] = 1 + m[i-1][j-1];
                } else {
                    m[i][j] = Math.max(m[i-1][j], m[i][j-1]);
                }
            }
        }

        return m[a.length()-1][b.length()-1];
    }


    public static int caminos_laberinto(int[][] lab, int m, int n) {

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (lab[i][j] == -1) {
                    continue;
                } else if (i == 0 || j == 0) {
                    lab[i][j] = 1;
                } else {
                    if (lab[i - 1][j] != -1) {
                        lab[i][j] += lab[i - 1][j] ;
                    } if (lab[i][j - 1] != -1) {
                        lab[i][j] += lab[i][j - 1];
                    }
                }
            }
        }
        for (int i = 0; i < lab.length; i++) {
            for (int j = 0; j < lab[0].length; j++) {
                System.out.print(lab[i][j] + " ");
            }
            System.out.println();
        }
        return lab[m-1][n-1];

    }

    public static int repeteadElements_knapsack(int w, int [] values, int[] weights) {
        int[] dp =  new int[w+1];

        for (int i = 1; i < w+1; i++) {
            for (int j = 0; j < weights.length; j++) {
                if (weights[j] <= i) {
                    dp[i] = Math.max(dp[i], dp[Math.abs(i - weights[j])] + values[j]);
                }
            }
        }
        for(int n : dp) {
            System.out.print(n+" ");
        }
        return dp[w];
    }

    public static int[] catalan_numbers(int n) {
        int[] arr = new int[n+1];
        arr[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] * (2 * (2 * i - 1)) / (i + 1);
        }

        return arr;

    }

    public static boolean subconjunto_booleanMatrix(int[] a, int k) {
        boolean[][] t = new boolean[a.length][k+1];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < k+1; j++) {
                if (i == 0) {
                    t[i][j] =  j==0 || a[i] == j;
                } else {
                    if (j==0) {
                        t[i][j] = true;
                    } else {
                        t[i][j] = (a[i]==j) || (t[i-1][j]) || (a[i]<j && t[i-1][j-a[i]]);
                    }
                }
            }
        }
        return t[a.length-1][k];
    }


    public static int redoMinimumPath(int[][] paths) {
        int minCost = Integer.MAX_VALUE;
        int[] p = new int[paths.length];
        int k = 1;
        for (int i = 0; i < paths.length; i++) {
            if (i+1 >= paths.length) {
                break;
            }
            for (int j = i+1; j < paths[0].length; j++) {
                if (paths[i][j] != 0) {
                    if (p[j] != 0) {
                        p[j] = Math.min(p[j], paths[i][j] + p[i]);
                    } else {
                        p[j] = p[i] + paths[i][j];
                    }
                }
            }
        }


        return p[paths.length-1];
    }

    public static int[] goldRush(int[][] g, int n, int m) {
        int[][] gold = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    gold[i][j] = g[i][j];
                } else if (i == 0) {
                    gold[i][j] = Math.max(gold[i][j-1], gold[i+1][j-1]) + g[i][j];
                }
                else if (i+1 <= n) {
                    gold[i][j] = Math.max(gold[i][j-1], gold[i-1][j-1]) + g[i][j];
                } else {
                    gold[i][j] = Math.max(gold[i][j-1], Math.max(gold[i-1][j-1], gold[i+1][j-1])) + g[i][j];
                }
            }
        }
        int mx = 0;
        int mxIndex = 0;
        for (int i = 0; i < n; i++) {
            for (int j = m-1; j < m; j++) {
                if (mx < gold[i][j]){
                    mx = gold[i][j];
                    mxIndex = i;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println();
            for (int j = 0; j < m; j++) {
                System.out.print(gold[i][j] + "    ");
            }
        }

        int[] path = new int[m];
        path[m-1] = mx;
        int pIndex = m-2;
        for (int i = mxIndex; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--) {
                if (pIndex == -1) {
                    break;
                }
                if (j == 0) {
                    path[pIndex] = g[i][j];
                } else if (i == 0) {
                    path[pIndex] = Math.max(gold[i][j-1], gold[i+1][j-1]);
                }
                else if (i+1 < n) {
                    path[pIndex] = Math.max(gold[i][j-1], Math.max(gold[i-1][j-1], gold[i+1][j-1]));
                } else {
                    path[pIndex] = Math.max(gold[i][j-1], gold[i-1][j-1]);
                }
                pIndex--;

            }

            }

        System.out.println();
        return path;
    }


}
