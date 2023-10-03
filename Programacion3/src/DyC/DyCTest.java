package DyC;

import DyC.DyC;
import org.junit.jupiter.api.Test;
import tda.VectorTDA;
import tda.impl.Vector;

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

}