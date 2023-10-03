package DP;

import tda.impl.Solicitud;

import java.util.ArrayList;
import java.util.Arrays;

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

    public static int planTrabajoPeriodista(ArrayList<Solicitud> s) {
        int plazoMax = 4;
        int [] dp = new int[plazoMax + 1];

        for (int i = 1; i<dp.length; i++) {
            System.out.println((s.get(i-1).plazo <= i)+ " " + s.get(i-1).plazo);
            if (dp[i-1] + s.get(i-1).precio>dp[i] && s.get(i-1).plazo < plazoMax) {

                dp[i] = dp[i-1] + s.get(i-1).precio;
                System.out.println(dp[i] + " " + i);
            }
        }
//        for (int i =0;i<dp.length;i++) {
//            System.out.println(dp[i]);
//        }

        return dp[4];
    }
}
