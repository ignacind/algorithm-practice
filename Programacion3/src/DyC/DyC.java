package DyC;

import tda.MatrizTDA;
import tda.VectorTDA;
import tda.impl.Vector;

import java.util.Arrays;
import java.util.List;

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
    public static boolean busquedaBinaria(VectorTDA<Integer> v, int x, int left, int right)
    {
        if(v.capacidadVector()==0){return false;}
        if (left >= right)
        {return v.recuperarElemento(left) == x;}
        else
        {
            int medio = (left+right)/2;

            if (x == v.recuperarElemento(medio))
            {return true;}
            else
            // [1,2,3,4,6]   x = 1
            {
                if(x < v.recuperarElemento(medio))
                {return busquedaBinaria(v, x, left, medio);}

                else
                {return busquedaBinaria(v, x, medio+1, right);}
            }
        }
    }
    public static int numeroRepetido(int[] vec, int ini, int fin)
    {
        //Caso base, vector de 1 elemento

        if(ini == fin) {
            return ini; }

        int mitad = (ini + fin)/2;

        if(vec[mitad]==mitad) {//Hago esta comparacion con el indice por que dice que estan acomodados de acuerdo al indice. Ya si lo que tengo en el arreglo no esta en el indice es por que esta repetido.
            //el elemento repetido esta de la izq
            return numeroRepetido(vec,mitad+1,fin);
        }
        //el elemento repetido esta de la derecha
        else {
            return numeroRepetido(vec, ini, mitad);
        }


    }


    public static int huevoRoto(int[] pisos, int k) {
        int left = 0;
        int n = pisos.length;
        int right = n - 1;
        int amount = 0;
        while (left <= right) {
            int mid = (left+right) / 2;
            amount ++;
            if (pisos[mid] < k) {
                if (mid+1 < n && pisos[mid+1] >= k){
                    return amount;}
                left = mid + 1;
            } else {
                right = mid - 1;
                if (mid-1 >= 0 && pisos[mid-1] <= k) {
                    return amount;
                }
            }
        }
        return amount;
    }


    public static int picosAltos(int[] a, int left, int right) {
        if (left == right) {
            return a[left];
        }
        int mid = (left+right) / 2;

        if (mid + 1 < a.length && a[mid+1] > a[mid]) {
            return picosAltos(a, mid+1, right);
        } else {
            return picosAltos(a, left, mid);
        }
    }



    public static int eggs_trials(int[] floors, int k, int left, int right, int amount) {
        if (left >= right) {
            return amount;
        }
        int mid = (left+right) / 2;
        if (mid+1<floors.length && floors[mid] < k && floors[mid+1] > k) {
            return amount+2;
        }
        if (floors[mid] < k) {
            return eggs_trials(floors, k, mid, right, amount+1);
        } else {
            return eggs_trials(floors, k, left, mid-1, amount+1);
        }
    }

    public static int combinationsStudents(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return combinationsStudents(n-1) + (n-1) * combinationsStudents(n - 2);
        }

    }

    public static void order_negs_positives(int left, int right, List<Integer> v) {
        if (left >= right) {
            return;
        } else {
            if (v.get(left) < 0) {
                order_negs_positives(left+1, right, v);
            }
            else if (v.get(right) >= 0) {
                order_negs_positives(left, right-1, v);
            } else {
                int temp = v.get(right);
                v.set(right, v.get(left));
                v.set(left, temp);
                order_negs_positives(left+1, right-1, v);
            }
        }

        //[9, −3, 5, −2, −8, −6, 1, 3]
        // output =  [-6, -3, -8, -2, 5, 9, 1, 3]
        // expected =  [−3, −2, −8, −6, 9, 5, 1, 3].
    }

    public static void merge_negsPositvs(int[] u, int left, int right) {
        int[] w = Arrays.copyOf(u, u.length);
        int mid = (left + right) / 2;
        int k = left;

        // copy negs from left sub
        for (int i = left; i <= mid; i++) {
            if (u[i] < 0) {
                w[k] = u[i];
                k++;
            }
        }

        // copy negative from right sub
        for (int j = mid+1; j <= right; j++) {
            if (u[j] < 0) {
                w[k] = u[j];
                k++;
            }
        }

        for (int i = left; i <= mid; i++) {
            if (u[i] > 0) {
                w[k] = u[i];
                k++;
            }
        }

        for (int j = mid+1; j <= right; j++) {
            if (u[j] > 0) {
                w[k] = u[j];
                k++;
            }
        }

        for (int i = left; i <= right; i++) {
            u[i] = w[i];
        }


    }


}
