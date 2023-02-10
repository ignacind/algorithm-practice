import DyC.DyC;
import tda.ConjuntoTDA;
import tda.VectorTDA;
import tda.impl.Conjunto;
import tda.impl.Vector;
import DyC.metodosOrdenamiento;

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
}
