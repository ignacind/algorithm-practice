package DyC;

import tda.VectorTDA;
import tda.impl.Vector;

import java.util.Comparator;

public class metodosOrdenamiento {
    public static void mergeSort(int[] s, int inicio, int fin) {
        if (inicio < fin) {
            int medio = (fin + inicio) / 2;
            mergeSort(s, inicio, medio);
            mergeSort(s, medio + 1, fin);
            DyC.merge_negsPositvs(s, inicio, fin);
        }
    }

    private static <T> void merge(int[] s, int inicio, int fin) {
        int[] r = new int[fin - inicio + 1];
        int medio = (fin + inicio) / 2;
        int i = inicio;
        int j = medio + 1;
        for (int k = 0; k <= fin - inicio; k++) {
            if (j > fin || s[i] <= s[j] && i <= medio) {
                r[k] = s[i];
                i++;
            } else {
                r[k] = s[j];
                j++;
            }
        }
        for (int k = 0; k <= fin - inicio; k++) {
            s[inicio + k] =  r[k];
        }
    }

    public static void quickSort(VectorTDA<Integer> s, int inicio, int fin) {
        if (inicio < fin) {
            int p = pivote(s, inicio, fin);
            quickSort(s, inicio, p - 1);
            quickSort(s, p + 1, fin);
        }
    }

    private static int pivote(VectorTDA<Integer> s, int inicio, int fin) {
        int p = s.recuperarElemento(inicio);
        int k = inicio + 1;
        int l = fin;
        while (s.recuperarElemento(k) <= p && k < fin) {
            k++;
        }
        while (s.recuperarElemento(l) > p) {
            l--;
        }
        while (k < l) {
            int aux = s.recuperarElemento(k);
            s.agregarElemento(k, s.recuperarElemento(l));
            s.agregarElemento(l, aux);
            while (s.recuperarElemento(k) <= p) {
                k++;
            }
            while (s.recuperarElemento(l) > p) {
                l--;
            }
        }
        int aux = s.recuperarElemento(inicio);
        s.agregarElemento(inicio, s.recuperarElemento(l));
        s.agregarElemento(l, aux);
        return l;
    }
}