package Greedy;

import org.junit.jupiter.api.Test;
import tda.VectorTDA;
import tda.impl.Vector;

import static org.junit.jupiter.api.Assertions.*;

class GreedyTest {

    @Test
    void problemaCambioTest() {
        VectorTDA<Integer> monedas = new Vector<>(); monedas.inicializarVector(6); //monedas = [$100, $50, $25, $10, $5, $1]
        monedas.agregarElemento(0, 100);
        monedas.agregarElemento(1, 50);
        monedas.agregarElemento(2, 25);
        monedas.agregarElemento(3, 10);
        monedas.agregarElemento(4, 5);
        monedas.agregarElemento(5, 1);

        int cambio = 177;

        Greedy.problemaCambio(monedas, cambio);
    }


    @Test
    void minTiempoEsperaTest() {
        VectorTDA<Integer> procesos = new Vector<>(); procesos.inicializarVector(3);
        procesos.agregarElemento(0,10);
        procesos.agregarElemento(1, 3);
        procesos.agregarElemento(2,5);

        assertEquals(29,Greedy.minTiempoEspera(procesos));
    }

    @Test
    void capturasPoliciacas() {
        int[] arr = new int[] {1,-1,1,1,-1,-1,1,-1};
        int k = 2;
        assertEquals(3, Greedy.capturasPoliciacas(arr, k));
    }

    @Test
    void guardarPesos() {
        int[] contenedores = {5, 5, 5, 5};
        Integer[] pesos = {4, 3, 2, 1};

        int resultado = Greedy.guardarPesos(contenedores, pesos);

        assertEquals(3, resultado);
    }
}