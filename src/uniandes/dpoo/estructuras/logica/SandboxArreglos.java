package uniandes.dpoo.estructuras.logica;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre arreglos de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos arregloEnteros y arregloCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre arreglos (ie., no haga cosas como construir listas para evitar la manipulación de arreglos).
 */
public class SandboxArreglos
{
    /**
     * Un arreglo de enteros para realizar varias de las siguientes operaciones.
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
	
    private int[] arregloEnteros;

    /**
     * Un arreglo de cadenas para realizar varias de las siguientes operaciones
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    
    private String[] arregloCadenas;

    /**
     * Crea una nueva instancia de la clase con los dos arreglos inicializados pero vacíos (tamaño 0)
     */
    
    public SandboxArreglos( )
    {
        arregloEnteros = new int[]{};
        arregloCadenas = new String[]{};
    }

    /**
     * Retorna una copia del arreglo de enteros, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de enteros
     */
    public int[] getCopiaEnteros( )
    {
    	int numAgregarEntero = getCantidadEnteros();
    	int copiaEntero[] = new int[numAgregarEntero];
    	
    	for ( int i = 0; i<numAgregarEntero; i++)
    		copiaEntero[i]= arregloEnteros[i];
    	
    	return copiaEntero;
    }

    /**
     * Retorna una copia del arreglo de cadenas, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de cadenas
     */
    public String[] getCopiaCadenas( )
    {
    	int numCadenas = getCantidadCadenas();
    	String copiaCadenas[] = new String[numCadenas];
    	
    	for ( int i = 0; i<numCadenas; i++)
    		copiaCadenas[i]= arregloCadenas[i];
    	
    	return copiaCadenas;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de enteros
     * @return
     */
    public int getCantidadEnteros( )
    {
        return arregloEnteros.length;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de cadenas
     * @return
     */
    public int getCantidadCadenas( )
    {
        return arregloCadenas.length;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param entero El valor que se va a agregar.
     */
    public void agregarEntero( int entero )
    {
    	int len = getCantidadEnteros();
    	int[] temp = new int[len + 1];
    	   
    	for (int i = 0; i < len; i++){
          temp[i] = arregloEnteros[i];
   	   }
   	   temp[len] = entero;
   	   arregloEnteros = temp;

    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena( String cadena )
    {
    	int len = getCantidadCadenas();
    	String[] temp = new String[len + 1];
    	   
    	for (int i = 0; i < len; i++){
          temp[i] = arregloCadenas[i];
   	   }
   	   temp[len] = cadena;
   	   arregloCadenas = temp;
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de enteros
     * @param valor El valor que se va eliminar
     */
    public void eliminarEntero( int valor )
    {
    	int len = getCantidadEnteros();
    	int apariciones = contarApariciones(valor);
    	int[] temp = new int[len-apariciones];
    	int num = 0;
    	for (int i = 0; i < len; i++){
   		   if (arregloEnteros[i] != valor) {
   			   temp[num] = arregloEnteros[i];
   			   num = num+1;
   		   }
   		}
       arregloEnteros = temp;
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena )
    {
    	int len = arregloCadenas.length;
    	int apariciones = contarApariciones(cadena);
    	String[] temp = new String[len-apariciones];
    	   int num = 0;
    	   for (int i = 0; i < len; i++){
    		   if (arregloCadenas[i] != cadena) {
    			   temp[num] = arregloCadenas[i];
    			   num = num+1;
    		   }
    	   }
    	   arregloCadenas = temp;
    }

    /**
     * Inserta un nuevo entero en el arreglo de enteros.
     * 
     * @param entero El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor en el arreglo aumentado. Si la posición es menor a 0, se inserta el valor en la primera posición. Si la
     *        posición es mayor que el tamaño del arreglo, se inserta el valor en la última posición.
     */
    public void insertarEntero( int entero, int posicion )
    {
    	int len = arregloEnteros.length;
    	int[] temp = new int[len+1];
    	int num = 0;
    	if (posicion<0) {
    		posicion = 0;
    	} else if (posicion > len) {
    		posicion = len;
    	}
        for (int i = 0; i < len+1; i++){
    	   if (posicion == i) {
   			   temp[i] = entero;
    	   }else {
   			   temp[i] = arregloEnteros[num];
   			   num = num+1;
   			   }
    	   }
        arregloEnteros = temp;
    }

    /**
     * Elimina un valor del arreglo de enteros dada su posición.
     * @param posicion La posición donde está el elemento que debe ser eliminado. Si el parámetro posicion no corresponde a ninguna posición del arreglo de enteros, el método
     *        no debe hacer nada.
     */
    public void eliminarEnteroPorPosicion( int posicion )
    {
    	int len = getCantidadEnteros();
    	int[] temp = new int[len-1];
    	int num = 0;
    	if (posicion<0 || posicion>=len) {
    	}else {
	    	for (int i = 0; i < len; i++){
	    		if (posicion != i) {
	    			temp[num] = arregloEnteros[i];
	    			num = num+1;
	    		   }
    	   }
	    	arregloEnteros = temp;
	    }
    }

    /**
     * Reinicia el arreglo de enteros con los valores contenidos en el arreglo del parámetro 'valores' truncados.
     * 
     * Es decir que si el valor fuera 3.67, en el nuevo arreglo de enteros debería quedar el entero 3.
     * @param valores Un arreglo de valores decimales.
     */
    public void reiniciarArregloEnteros( double[] valores )
    {
    	int num = valores.length;
    	arregloEnteros = new int [num];
    	for (int i = 0; i < num; i++){
    		int valo  = (int)valores[i];
    		arregloEnteros[i] = valo;
    	}
    }

    /**
     * Reinicia el arreglo de cadenas con las representaciones como Strings de los objetos contenidos en el arreglo del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Un arreglo de objetos
     */
    public void reiniciarArregloCadenas( Object[] objetos )
    {
    	int num = objetos.length;
    	arregloCadenas = new String [num];
    	for (int i = 0; i < num; i++){
    		String valo  = String.valueOf(objetos[i]);
    		arregloCadenas[i] = valo;
    	}
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores sean positivos.
     * 
     * Es decir que si en una posición había un valor negativo, después de ejecutar el método debe quedar el mismo valor muliplicado por -1.
     */
    public void volverPositivos( )
    {
    	int len = arregloEnteros.length;
    	for (int i = 0; i < len; i++){
    		if (arregloEnteros[i]<0) {
    			int num = arregloEnteros[i]*(-1);
    			arregloEnteros[i]=num;
    		}
    	}
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores queden organizados de menor a mayor.
     */
    public void organizarEnteros( )
    {
    	Arrays.sort(arregloEnteros);

    }

    /**
     * Modifica el arreglo de cadenas para que todos los valores queden organizados lexicográficamente.
     */
    public void organizarCadenas( )
    {
    	Arrays.sort(arregloCadenas);

    }

    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en el arreglo de enteros
     * @param valor El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones( int valor )
    {
    	int len = arregloEnteros.length;
    	int num = 0;
        for (int i = 0; i < len; i++){
        	if (arregloEnteros[i]==valor) {
        		num = num+1;
        	}
        }
        return num;

    }

    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en el arreglo de cadenas.
     * 
     * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones( String cadena )
    {
    	int len = arregloCadenas.length;
    	String cadenaF = cadena.toLowerCase();
    	int num = 0;
        for (int i = 0; i < len; i++){
        	String cadenaA = arregloCadenas[i];
        	int valor = cadenaA.compareTo(cadenaF);
        	int valor2 = cadenaA.compareTo(cadena);
        	if (valor==0 || valor2==0) {
        		num = num+1;
        	}	}
        return num;
    }
    

    /**
     * Busca en qué posiciones del arreglo de enteros se encuentra el valor que se recibe en el parámetro
     * @param valor El valor que se debe buscar
     * @return Un arreglo con los números de las posiciones del arreglo de enteros en las que se encuentra el valor buscado. Si el valor no se encuentra, el arreglo retornado
     *         es de tamaño 0.
     */
    public int[] buscarEntero( int valor )
    {
    	int len = contarApariciones(valor);
    	int[] aparicionesBuscarEntero = new int[len];
    	int num = 0;
    	for (int i = 0; i < getCantidadEnteros(); i++){
   		   if (arregloEnteros[i] == valor) {
   			   aparicionesBuscarEntero[num] = i;
   			   num = num+1;
   		   }
   		}
        return aparicionesBuscarEntero;
    }

    /**
     * Calcula cuál es el rango de los enteros (el valor mínimo y el máximo).
     * @return Un arreglo con dos posiciones: en la primera posición, debe estar el valor mínimo en el arreglo de enteros; en la segunda posición, debe estar el valor máximo
     *         en el arreglo de enteros. Si el arreglo está vacío, debe retornar un arreglo vacío.
     */
    public int[] calcularRangoEnteros( )
    {
    	organizarEnteros();
    	int [] rangoEnteros = new int [0];
    	int num = arregloEnteros.length;
    	if (num >0) {
    		rangoEnteros = new int [2];
        	rangoEnteros[0]=arregloEnteros[0];
        	rangoEnteros[1]=arregloEnteros[num-1];
    	}
        return rangoEnteros;
    }

    /**
     * Calcula un histograma de los valores del arreglo de enteros y lo devuelve como un mapa donde las llaves son los valores del arreglo y los valores son la cantidad de
     * veces que aparece cada uno en el arreglo de enteros.
     * @return Un mapa con el histograma de valores.
     */
    public HashMap<Integer, Integer> calcularHistograma( )
    {
    	HashMap <Integer, Integer> histogramaEnteros = new HashMap<Integer, Integer>( );
    	for (int i = 0 ; i < getCantidadEnteros(); i++) {
    		if (histogramaEnteros.containsKey(arregloEnteros[i])) {
    			int preNum = histogramaEnteros.get(arregloEnteros[i]);
    			histogramaEnteros.put(arregloEnteros[i], preNum+1);
    		} else {
    			histogramaEnteros.put(arregloEnteros[i], 1);
    		}
    	}
    	
        return histogramaEnteros;
    }

    /**
     * Cuenta cuántos valores dentro del arreglo de enteros están repetidos.
     * @return La cantidad de enteos diferentes que aparecen más de una vez
     */
    public int contarEnterosRepetidos( )
    {
    	int enterosRepetidos = 0;
    	HashMap<Integer, Integer> histogramaEnteros = calcularHistograma();
    	for (Integer i : histogramaEnteros.values()) {
    		  if (i > 1) {
    			  enterosRepetidos = enterosRepetidos+1;
    		  }
    	}
        return enterosRepetidos;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica si son iguales, es decir que contienen los mismos elementos exactamente en el mismo orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los arreglos son idénticos y false de lo contrario
     */
    public boolean compararArregloEnteros( int[] otroArreglo )
    {
    	boolean iguales = true;
    	if (otroArreglo.length != arregloEnteros.length) {
    		iguales = false;
    	} else {
    		for (int i=0 ; i < otroArreglo.length; i++) {
    			if (otroArreglo[i] != arregloEnteros[i]) {
    				iguales = false;
    			}
    		}
    	}
        return iguales;
        
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica que tengan los mismos elementos, aunque podría ser en otro orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos en los dos arreglos son los mismos
     */
    public boolean mismosEnteros( int[] otroArreglo )
    {
    	boolean iguales = true;
	    	for (int i =0 ; i < arregloEnteros.length ; i++) {
	    		int num = arregloEnteros[i];
	    		boolean mid = false;
	    		for (int m = 0 ; m<otroArreglo.length ; m++) {
	    			if (otroArreglo[m]==num) {
	    				mid = true;
	    			}
	    		}
	    		if (mid == false) {
	    			iguales = false;
	    		}}
	    if (arregloEnteros.length==0) {
	    	iguales = false;
	    	if (otroArreglo.length==0) {
	    		iguales = true;
	    	}
	    	
	    }
        return iguales;
    }

    /**
     * Cambia los elementos del arreglo de enteros por una nueva serie de valores generada de forma aleatoria.
     * 
     * Para generar los valores se debe partir de una distribución uniforme usando Math.random().
     * 
     * Los números en el arreglo deben quedar entre el valor mínimo y el máximo.
     * @param cantidad La cantidad de elementos que debe haber en el arreglo
     * @param minimo El valor mínimo para los números generados
     * @param maximo El valor máximo para los números generados
     */
    public void generarEnteros( int cantidad, int minimo, int maximo )
    {
    
    	arregloEnteros = new int [cantidad];
    	for (int i=0;i<cantidad; i++) {
    		int nuevoNum = ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    		arregloEnteros[i]=nuevoNum;
    	}

    }

}
