package Greedy;

import DyC.DyC;
import tda.ConjuntoTDA;
import tda.VectorTDA;
import tda.impl.Conjunto;
import tda.impl.Vector;
import DyC.metodosOrdenamiento;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Greedy {


    public static VectorTDA<Integer> problemaCambio(VectorTDA<Integer> monedas, int cambio)
    {
        VectorTDA<Integer> solucion = new Vector<>(); solucion.inicializarVector(6);

        int i = 0;
        int suma = 0;
        int indice = 0;
        while (suma!=cambio  && i< monedas.capacidadVector())
        {
            if (suma + monedas.recuperarElemento(i) <= cambio)
            {
                suma += monedas.recuperarElemento(i);
                solucion.agregarElemento(indice, monedas.recuperarElemento(i));
                indice ++;
            }
            else
            {i++;}
        }
        for (int y = 0; y< solucion.capacidadVector(); y++)
        {System.out.println(solucion.recuperarElemento(y));}

        return solucion;
    }
    public static int minTiempoEspera(VectorTDA<Integer> procesos)
    {
        int tEspera = 0;

        metodosOrdenamiento.mergeSort(procesos, 0, procesos.capacidadVector()-1, Comparator.naturalOrder());

        int i = 0;
        int suma = 0;
        while (i<=procesos.capacidadVector()-1)
        {
            tEspera = tEspera + procesos.recuperarElemento(i);
            i+= 1;
        }
        System.out.println(tEspera);
        return tEspera;
    }

    public static int capturasPoliciacas(int[] arr, int k) {
        int cant = 0;
        int p = 0;
        int l = 0;
        int n = arr.length;

        while (p<n && l<n) {
            p = proximoCandidato(arr, p, 1);
            l = proximoCandidato(arr, l, -1);

            if (p == n || l == n) {break;}

            if (Math.abs(p - l) < k) {
                cant++;
                arr[p] = 0;
                arr[l] = 0;

            } else if (p < l) {
                p++;
            } else {
                l++;
            }
        }

        return cant;
    }

    public static int proximoCandidato(int[] arr,int i, int key) {
        while (i < arr.length && arr[i]!=key) {
            i++;
        }
        return i;
    }


    public static int guardarPesos(int[] contenedores, Integer[] o) {
        int i = 0;
        int j = 0;
        int cant = 0;
        int pesoOg = contenedores[0];
        Arrays.sort(o, Collections.reverseOrder());

        while (i < contenedores.length && j < o.length) {
            if (contenedores[i] >= o[j]) {
                contenedores[i] -= o[j];
                j++;
            } else {
                cant++;
                i++;
            }
        }
        if (i < contenedores.length && contenedores[i] != pesoOg) {
            cant++;
        }

        return cant;
    }
}
