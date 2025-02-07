package uniandes.dpoo.estructuras.logica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre mapas.
 *
 * Todos los métodos deben operar sobre el atributo mapaCadenas que se declara como un Map.
 * 
 * En este mapa, las llaves serán cadenas y los valores serán también cadenas. La relación entre los dos será que cada llave será igual a la cadena del valor, pero invertida.
 * 
 * El objetivo de usar el tipo Map es que sólo puedan usarse métodos de esa interfaz y no métodos adicionales provistos por la implementación concreta (HashMap).
 * 
 * No pueden agregarse nuevos atributos.
 */
public class SandboxMapas
{
    /**
     * Un mapa de cadenas para realizar varias de las siguientes operaciones.
     * 
     * Las llaves del mapa son cadenas, así como los valores.
     * 
     * Las llaves corresponden a invertir la cadena que aparece asociadaave.
     */
    private Map<String, String> mapaCadenas;

    /**
     * Crea una nueva instancia de la clase con las dos listas inicializadas pero vacías
     */
    public SandboxMapas( )
    {
        mapaCadenas = new HashMap<String, String>( );
    }

    /**
     * Retorna una lista con las cadenas del mapa (los valores) ordenadas lexicográficamente
     * @return Una lista ordenada con las cadenas que conforman los valores del mapa
     */
    public List<String> getValoresComoLista( )
    {
    	List<String> listValoresCadenas = new LinkedList<String>(mapaCadenas.values());
    	Collections.sort(listValoresCadenas);
        return listValoresCadenas;
    }

    /**
     * Retorna una lista con las llaves del mapa ordenadas lexicográficamente de mayor a menor
     * @return Una lista ordenada con las cadenas que conforman las llaves del mapa
     */
    public List<String> getLlavesComoListaInvertida( )
    {
    	
    	List<String> listCadenas = new LinkedList<String>(mapaCadenas.keySet());
    	Collections.sort(listCadenas, Collections.reverseOrder());
        return listCadenas;
    }

    /**
     * Retorna la cadena que sea lexicográficamente menor dentro de las llaves del mapa .
     * 
     * Si el mapa está vacío, debe retornar null.
     * @return
     */
    public String getPrimera( )
    {
    	List<String> listLlavesCadenas = getLlavesComoListaInvertida();
    	String primeraLlave = null;
    	for (String st : listLlavesCadenas) {
    		if (primeraLlave != null) {
    			int positivo = primeraLlave.compareTo(st);
    			if (positivo > 0) {
    				primeraLlave = st;
    			}
    		}
    		else {
    			primeraLlave = st;
    		}
    	}
        return primeraLlave;
    }

    /**
     * Retorna la cadena que sea lexicográficamente mayor dentro de los valores del mapa
     * 
     * Si el conjunto está vacío, debe retornar null.
     * @return
     */
    public String getUltima( )
    {
    	List<String> listLlavesCadenas = getLlavesComoListaInvertida();
    	String ultimaLlave = null;
    	for (String st : listLlavesCadenas) {
    		if (ultimaLlave != null) {
    			int positivo = ultimaLlave.compareTo(st);
    			if (positivo < 0) {
    				ultimaLlave = st;
    			}
    		}
    		else {
    			ultimaLlave = st;
    		}
    	}
        return ultimaLlave;
    }

    /**
     * Retorna una colección con las llaves del mapa, convertidas a mayúsculas.
     * 
     * El orden de las llaves retornadas no importa.
     * @return Una lista de cadenas donde todas las cadenas están en mayúsculas
     */
    public Collection<String> getLlaves( )
    {
    	Collection<String> llaves = new ArrayList<String>();
    	for (String llave: mapaCadenas.keySet()) {
    		String llaveF = llave.toUpperCase();
    		llaves.add(llaveF);
    	}
        return llaves;
    }

    /**
     * Retorna la cantidad de *valores* diferentes en el mapa
     * @return
     */
    public int getCantidadCadenasDiferentes( )
    {
    	List<String> listaCadenasNoRepetidos = new ArrayList<String>( );
    	for (String cd : mapaCadenas.keySet()) {
    		if (listaCadenasNoRepetidos.contains(mapaCadenas.get(cd))) {
    		}else {
    			listaCadenasNoRepetidos.add(mapaCadenas.get(cd));
    		}
    		
    	}
        return listaCadenasNoRepetidos.size();
    }

    /**
     * Agrega un nuevo valor al mapa de cadenas: el valor será el recibido por parámetro, y la llave será la cadena invertida
     * 
     * Este método podría o no aumentar el tamaño del mapa, dependiendo de si ya existía la cadena en el mapa
     * 
     * @param cadena La cadena que se va a agregar al mapa
     */
    public void agregarCadena( String cadena )
    {
    	String llave = new StringBuffer(cadena).reverse().toString();
    	mapaCadenas.put(llave, cadena);
    }

    /**
     * Elimina una cadena del mapa, dada la llave
     * @param cadena La llave para identificar el valor que se debe eliminar
     */
    public void eliminarCadenaConLLave( String llave )
    {
    	mapaCadenas.remove(llave);
    }

    /**
     * Elimina una cadena del mapa, dado el valor
     * @param cadena El valor que se debe eliminar
     */
    public void eliminarCadenaConValor( String valor )
    {
    	String llaveEliminar = null;
    	for (String llave : mapaCadenas.keySet()) {
    		if (valor == mapaCadenas.get(llave)) {
    			llaveEliminar = llave;
    		}
    	}
    	mapaCadenas.remove(llaveEliminar);
    }

    /**
     * Reinicia el mapa de cadenas con las representaciones como Strings de los objetos contenidos en la lista del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Una lista de objetos
     */
    public void reiniciarMapaCadenas( List<Object> objetos )
    {
    	mapaCadenas = new HashMap<String, String>( );
    	for (Object objeto: objetos) {
    		String cadena = String.valueOf(objeto);
    		agregarCadena(cadena);
    	}
    }

    /**
     * Modifica el mapa de cadenas reemplazando las llaves para que ahora todas estén en mayúsculas pero sigan conservando las mismas cadenas asociadas.
     */
    public void volverMayusculas( )
    {
    	Map<String, String> temp = new HashMap<String, String>( );
    	for (String llave : mapaCadenas.keySet()) {
    		String cadena = mapaCadenas.get(llave);
    		String llaveFin = llave.toUpperCase();
    		temp.put(llaveFin, cadena);
    	}
    	mapaCadenas = temp;

    }

    /**
     * Verifica si todos los elementos en el arreglo de cadenas del parámetro hacen parte del mapa de cadenas (de los valores)
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si todos los elementos del arreglo están dentro de los valores del mapa
     */
    public boolean compararValores( String[] otroArreglo )
    {
    	List<String> lista = Arrays.asList(otroArreglo);
    	boolean iguales = true;
    	for (String valor : mapaCadenas.values()) {
    		if (lista.contains(valor)) {
    			
    		}else {
    			iguales = false;
    		}
    	}
        return iguales;
    }

}
