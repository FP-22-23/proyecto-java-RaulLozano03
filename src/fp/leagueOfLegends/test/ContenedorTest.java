package fp.leagueOfLegends.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import fp.common.PositionEnum;
import fp.leagueOfLegends.Champions;
import fp.leagueOfLegends.Contenedor;
import fp.leagueOfLegends.Factoria;

public class ContenedorTest {

	public static void main(String[] args) {
		
		//Contenedor del fichero
		Contenedor con = new Contenedor(Factoria.leeCampeones("./data/champions.csv"));
		
		//Contenedor vacio para prueba
		Contenedor conVacio = new Contenedor();
		
		//Numero Campeones
		Integer tamano = con.getSizeCampeones();
		System.out.println("Hay este numero de campeones: " + tamano);
		
		//Añadir un campeon
		
		conVacio.addCampeon(Factoria.leeCampeon("Juan;13;646.93;81;true;11/25/2020;flowers;TOP;64.1;2;834"));
		
		System.out.println("Contenedor con campeon añadido: " + conVacio);

		
		//Añadir una collecion
		List<Champions> listaAuxiliar = new ArrayList<>();
		listaAuxiliar.add(Factoria.leeCampeon("Pedro;13;646.93;81;true;11/25/2020;flowers;TOP;64.1;2;834"));
		listaAuxiliar.add(Factoria.leeCampeon("Andres;13;646.93;81;true;11/25/2020;flowers;TOP;64.1;2;834"));
		conVacio.addColleccion(listaAuxiliar);
		System.out.println("Contenedor con campeon añadido: " + conVacio);
		
		//Eliminar campeon
		
		conVacio.eliminarCampeon(Factoria.leeCampeon("Juan;13;646.93;81;true;11/25/2020;flowers;TOP;64.1;2;834"));
		System.out.println("Contenedor eliminando un campeon: " + conVacio);
		
		//Existe campeon con ataque dado
		
		Boolean existe = con.existeCampeonPorAtaque(57);
		System.out.println("¿Hay algún campeon con 57 de ataque? " + existe);
		
		//Contador de una posicion dada
		
		Integer campeonesPosicion = con.campeonesPorPosicion(PositionEnum.TOP);
		System.out.println("¿Cuantos campeones en la posicion top hay? " + campeonesPosicion);
		
		//Campeones que usan mana
		
		List<String> listaMana = con.campeonesUsanMana();
		System.out.println("¿Cuantos campeones usan mana? " + listaMana);
		
		//Map clave positionEnum, valores name
		
		 Map<PositionEnum, Set<String>> pruebaMapUno = con.mapPropiedadBaseValorColeccion();
		System.out.println("Map con el conjunto de campeones que juegan en cada posicion: " + pruebaMapUno);
		 
		//Map clave positionEnum, valores suma attackDamage
		
		Map<PositionEnum, Integer> pruebaMapDos = con.mapPropiedadBaseValorSuma();
		
		 
		System.out.println("Map con la suma de attack damage de cada posicion: " + pruebaMapDos);
	}

}
