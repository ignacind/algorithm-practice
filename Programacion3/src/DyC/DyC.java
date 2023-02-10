package DyC;

import tda.MatrizTDA;
import tda.VectorTDA;
import tda.impl.Vector;

public class DyC {

    public static boolean esPalindromo(String palabra, int inicio, int fin) {
        if (inicio >= fin) {
            return true;
        } else {
            if (palabra.charAt(inicio) != palabra.charAt(fin)) {
                return false;
            }

            return esPalindromo(palabra, inicio + 1, fin - 1);
        }
    }

    public static void torresHanoi(int n, char a, char b, char c)
    {
        if (n<1)
        {System.out.println("Primer disco desde " + a + "-->" + c);}
        else
        {
            torresHanoi(n-1, a, c, b);
            System.out.println(" " + n + " Un disco de " + a + "-->" + c);
            torresHanoi(n-1, b, a, c);
        }
    }
    public static boolean busquedaBinaria(VectorTDA<Integer> v, int x, int inicio, int fin)
    {
        if(fin-inicio==0){return false;}
        if (fin - inicio == 1)
        {return v.recuperarElemento(0) == x;}
        else
        {
            int medio = (fin-inicio)/2;
            if (x == v.recuperarElemento(medio))
            {return true;}
            else
            // [1,2,3,4,6]   x = 1
            {
                if(x<v.recuperarElemento(medio))
                {return busquedaBinaria(v, x, inicio, medio);}

                else
                {return busquedaBinaria(v, x, medio+1, fin);}
            }
        }
    }
}