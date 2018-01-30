package eficiencia;

/**
 * Esta clase hereda de Thread para poder ejecutar en varios hilos.
 * Esta clase sirve para generar procesos que muestran los números primos 
 * de un rango usando la clase Algoritmos.
 * 
 * @author Miguelin
 * @version 2.0
 * @see Thread
 * @see Algoritmos
 */
public class Proceso extends Thread {

    /**
     * Atributo que define el principio del rango de números.
     */
    private int inicio;
    
    /**
     * Atributo que define el final del rango de números.
     */
    private int fin;
    
    /**
     * Atributo que define el algoritmo a usar en la ejecución.
     */
    private int calidad;
    
    /**
     * Atributo que define el número de hilos a usar en la ejecución.
     */
    private int hilos;
    
    /**
     * Constructor de la clase Proceso.
     * 
     * @param inicio Define el principio del rango de los números.
     * @param fin Define el fin del rango de los números.
     * @param calidad Define el algoritmo a usar en la ejecución.
     * @param hilos Define el número de hilos que se usarán en la ejecución.
     */
    public Proceso(int inicio, int fin, int calidad, int hilos) {
        this.inicio = inicio;
        this.fin = fin;
        this.calidad = calidad;
        this.hilos = hilos;
    }
    
    /**
     * Método que muestra los números primos en un rango numérico pudiendo
     * tener distinta eficiencia dependiendo del atributo calidad.
     * 
     * @see Algoritmos
     */
    @Override
    public void run() {
        switch (calidad) {
            case 0:
                for (int i = inicio; i <= fin; i = i + hilos) {
                    if (Algoritmos.primo0(i)) {
                        System.out.println(i);
                    }
                }
                break;
            case 1:
                for (int i = inicio; i <= fin; i = i + hilos) {
                    if (Algoritmos.primo1(i)) {
                        System.out.println(i);
                    }
                }
                break;
            case 2:
                for (int i = inicio; i <= fin; i = i + hilos) {
                    if (Algoritmos.primo2(i)) {
                        System.out.println(i);
                    }
                }
                break;
            case 3:
                for (int i = inicio; i <= fin; i = i + hilos) {
                    if (Algoritmos.primo3(i)) {
                        System.out.println(i);
                    }
                }
                break;
            default:
                break;
        }
    }
}
