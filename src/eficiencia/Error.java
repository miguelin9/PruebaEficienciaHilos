package eficiencia;

/**
 * Esta clase contiene los atributos y métodos necesarios para comprobar si hay
 * errores y informar de ello.
 * Los atributos de esta clase son constantes que se usan para definir los
 * distintos tipos de errores que se pueden dar.
 *
 * @author Miguelin
 * @version 2.0
 * @see Primos
 */
public class Error {

    protected static final int NIVEL_MAX = 3;
    protected static final int MAX_HILOS = 32;
    protected static final int NO_ERROR = 0;
    protected static final int ERROR_SIN_PARAMETROS = 1;
    protected static final int ERROR_NUM_PARAMETROS = 2;
    protected static final int ERROR_NEGATIVO = 3;
    protected static final int ERROR_NIVEL = 4;
    protected static final int ERROR_NUM_HILOS = 5;

    /**
     * Este método recibe la lista de parámetros introducidos por el usuario en
     * la línea de comandos y tras analizarlos, devuelve un código de error
     * pertinente desde 0 (ausencia de error) hasta 5. Cada uno de los códigos
     * está parametrizado como uno de los atributos constantes (final) de esta
     * clase para mejorar la legibilidad.
     *
     * @param args Recive los parámetros introducidos en la linea de comandos.
     * @return Devuelve un entero que define cual es el error o si no lo hay.
     */
    protected static int error(String[] args) {
        int error = NO_ERROR;
        try {
            for (int i = 0; i < args.length; i++) {
                Integer.parseInt(args[i]);
            }
        } catch (NumberFormatException h) {
            return 6;
        }
        if (args.length == 0) {
            error = ERROR_SIN_PARAMETROS;
        }
        if (args.length != 3) {
            error = ERROR_NUM_PARAMETROS;
        } else if (Integer.parseInt(args[0]) < 0) {
            error = ERROR_NEGATIVO;
        } else if (Integer.parseInt(args[1]) < 0 || Integer.parseInt(args[1]) > NIVEL_MAX) {
            error = ERROR_NIVEL;
        } else if (!numHilosPermitidos(Integer.parseInt(args[2]))) {
            error = ERROR_NUM_HILOS;
        }
        return error;
    }

    /**
     * Este método muestra en pantalla el mensaje de error correspondiente al
     * código que recibe.
     *
     * @param error Recibe un entero que indica que error mostrar.
     */
    protected static void manual(int error) {
        switch (error) {
            case 1:
            case 2:
                System.out.println("Error: número de parámetros no es correcto, se necesitan 3 parámetros.");
                System.out.println("El programa mostrará los números primos entre 1 y m, uno por línea, no necesariamente en "
                        + "orden. Se ejecutará desde la línea de comandos de un terminal Linux con la siguiente sintaxis:");
                System.out.println("time java eficiencia.Primos m nivel hilos");
                System.out.println("time: Es un comando Linux que permite averiguar el tiempo de ejecución que emplea un programa.");
                System.out.println("java eficiencia.Primos:  Ejecución de Primos.class del paquete eficiencia.");
                System.out.println("m: Límite superior de los números primos que queremos buscar.");
                System.out.println("nivel: Nivel de eficiencia exigida desde 0 (algoritmo intencionadamente ineficiente) hasta 3 (código más eficiente que seamos capaces de implementar). ");
                System.out.println("hilos: Número de procesos paralelos durante la ejecución del programa. Deberá ser una potencia de 2 entre 1 y 32. Esto permite aprovechar explícitamente las capacidades de equipos multiproceso. Usar más hilos que procesadores no debería aportar ningún beneficio. ");
                break;
            case 3:
                System.out.println("Error: número negativo, debe de ser positivo.");
                break;
            case 4:
                System.out.println("Error: nivel de eficiencia incorrecto, debe estar entre 0-" + NIVEL_MAX + ".");
                break;
            case 5:
                System.out.println("Error: número de hilos incorrecto, debe ser una potencia de 2 entre 1 y 32.");
                break;
            case 6:
                System.out.println("Error: Todos los parámetros deben de ser números.");
                break;
            default:
                break;
        }
    }

    /**
     * Este método privado determina si el número de hilos seleccionado por el
     * usuario es correcto, es decir, si se corresponde con una potencia de 2
     * entre 1 y 32. Será útil para llamarlo desde el método error().
     *
     * @param nHilos Recibe un entero y comprueba si es una potencia de 2 entre
     * 1 y 32.
     * @return Devuelve un boolean indicando si es correcto o no.
     */
    private static boolean numHilosPermitidos(int nHilos) {
        boolean bandera = false;
        int aux = 1;

        while (aux <= MAX_HILOS) {
            if (nHilos == aux) {
                bandera = true;
                break;
            } else {
                bandera = false;
            }
            aux = aux * 2;
        }
        return bandera;
    }

}
