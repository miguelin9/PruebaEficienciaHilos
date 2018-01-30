package eficiencia;

/**
 * Esta clase contiene el método principal que le entran 3 parámetros enteros.
 * Primer parámetro: Hasta que número muestra primos.
 * Segundo parámetro: nivel de eficiencia entre 0-3.
 * Tercer parámetro: número de hilos a usar, debe ser una potencia de 2 entre 1 y 32.
 * 
 * @author Miguelin
 * @version 2.0
 * @see Error
 * @see Proceso
 */
public class Primos {

    public static void main(String[] args) {
        //Comprobar si hay errores.
        if (Error.error(args) != 0) {
            Error.manual(Error.error(args));
        } else {

            //Ejecutamos el programa.
            int hasta = Integer.parseInt(args[0]);
            int calidad = Integer.parseInt(args[1]);
            int nHilos = Integer.parseInt(args[2]);

            for (int i = 1; i <= nHilos; i++) {
                Proceso p = new Proceso(i , hasta, calidad, nHilos);
                p.start();
            }
        }

    }
}
