package eficiencia;

/**
 * Se dice que un número es primo cuando es mayor que 1 y no tiene más divisores
 * que el 1 y a sí mismo.
 * Esta clase contiene varios métodos con distinta eficiencia que te dicen si un número
 * es primo o no.
 *
 * @author Miguelin
 * @version 2.0
 */
public class Algoritmos {

    /**
     * Método para saber si es primo, el menos eficiente.
     * 
     * @param n Entra como parámetro un número para saber si es primo o no.
     * @return Devuelve un boolean indicando si el número es primo o no.
     */
    public static boolean primo0(int n) {
        int cont = 0;

        if (n <= 1) {
            return false;
        }
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                cont++;
            }
        }
        if (cont == 2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método para saber si es primo, algo más eficiente que primo0.
     * 
     * @param n Entra como parámetro un número para saber si es primo o no.
     * @return Devuelve un boolean indicando si el número es primo o no.
     */
    public static boolean primo1(int n) {
        boolean primo;
        int contador = 0;

        if (n <= 1) {
            primo = false;
        } else {
            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    contador++;
                }
                if (contador == 2) {
                    break;
                }
            }
            if (contador == 1) {
                primo = true;
            } else {
                primo = false;
            }
        }
        return primo;
    }

    /**
     * Método para saber si es primo, algo más eficiente que primo1.
     * 
     * @param n Entra como parámetro un número para saber si es primo o no.
     * @return Devuelve un boolean indicando si el número es primo o no.
     */
    public static boolean primo2(int n) {
        boolean primo;
        int contador = 0;

        if (n <= 1) {
            primo = false;
        } else {
            for (int i = 1; i < (n / 2) + 1; i++) {
                if (n % i == 0) {
                    contador++;
                }
                if (contador == 2) {
                    break;
                }
            }
            if (contador == 1) {
                primo = true;
            } else {
                primo = false;
            }
        }
        return primo;
    }

    /**
     * Método para saber si es primo, hay que intentar mejorar los métodos anteriores.
     * 
     * @param n Entra como parámetro un número para saber si es primo o no.
     * @return Devuelve un boolean indicando si el número es primo o no.
     */
    public static boolean primo3(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        } else if (n % 2 == 0) { //Comprobamos si es múltiplo de 2
            return false;
        }
        //Si no es múltiplo de 2, comprobamos si es divisible por algún número impar
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
