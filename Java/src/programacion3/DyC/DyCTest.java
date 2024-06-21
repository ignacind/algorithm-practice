package programacion3.DyC;

import org.junit.jupiter.api.Test;
import tda.VectorTDA;
import tda.impl.Vector;

import javax.sound.midi.Soundbank;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DyCTest {

    @Test
    public void esPalindromoTest() {
        String palabra = "kayak";
        int inicio = 0;
        int fin = palabra.length() - 1;
        assertTrue(DyC.esPalindromo(palabra, inicio, fin));
        palabra = "neuqYen";
        fin = palabra.length() - 1;
        assertFalse(DyC.esPalindromo(palabra, inicio, fin));
    }

    @Test
    public void torresHanoiTest() {
        int n = 5;
        char a = 'a';
        char b = 'b';
        char c = 'c';
        DyC.torresHanoi(n, a, b, c);
    }

    @Test
    public void busquedaBinaria() {
        VectorTDA<Integer> v = new Vector<>();
        v.inicializarVector(5);
        v.agregarElemento(0, 1);
        v.agregarElemento(1, 2);
        v.agregarElemento(2, 3);
        v.agregarElemento(3, 4);
        v.agregarElemento(4, 6);
        int x = 6;
        int inicio = 0;
        int fin = v.capacidadVector() - 1;
        assertTrue(DyC.busquedaBinaria(v, x, inicio, fin));

    }

// [0, 1, 2, 3, 4, 5]
    @Test
    public void numeroRepetido() {
        int[] p = new int[] {0, 1, 2, 3, 4, 5, 5, 6, 7, 8, 9};
        System.out.println(DyC.numeroRepetido(p, 0, p.length));
        assertEquals(6, DyC.numeroRepetido(p, 0, p.length));
    }


    @Test
    public void huevoRoto() {
        int[] pisos = new int[] {1, 3, 6, 10, 15, 21, 28, 36, 45};
        int k = 25;
        assertEquals(2, DyC.huevoRoto(pisos, k));
    }

    @Test
    public void picosAltos() {
        int[] a = new int[] {1, 6, 5, 4, 3, 2, 7};
        int expected = 6;
        assertEquals(expected, DyC.picosAltos(a, 0, a.length-1));

    }


    @Test
    public void eggs_trails() {
        int[] floors = new int[] {1, 3, 5, 6, 7, 9, 12};
        int k = 8;
        System.out.println(DyC.eggs_trials(floors, k, 0, floors.length-1, 0));
    }

    @Test
    public void combinationsStudents() {
        int n = 4;
        System.out.println(DyC.combinationsStudents(n));
    }

    @Test
    public void order_negs_positives() {
        List<Integer> v = new ArrayList<>();
        v.add(9);
        v.add(-3);
        v.add(5);
        v.add(-2);
        v.add(-8);
        v.add(-6);
        v.add(1);
        v.add(3);

        int[] m = new int[]{9, -3, 5, -2, -8, -6, 1, 3};
        DyC.mergeSort(m, 0,v.size()-1);
        for (int n : m) {
            System.out.print(n + " ");
        }
        // input    =  [9, −3, 5, −2, −8, −6, 1, 3]
        // output   =  [-6, -3, -8, -2, 5, 9, 1, 3]
        // expected =  [−3, −2, −8, −6, 9, 5, 1, 3].
    }


    @Test
    public void merge_negsPositvs() {
        int[] order = new int[]{9, -3, 5, -2, -8, -6, 1, 3};
        metodosOrdenamiento.mergeSort(order, 0, order.length-1);

        for (int i = 0; i < order.length; i++) {
            System.out.print(order[i] + " ");

        }
    }

    @Test
    void valleFinal() {
        int[] arr = new int[] {0, 4, 3, 5, 6};
        System.out.println(DyC.valleFinal(arr, 0, arr.length-1));
    }
}