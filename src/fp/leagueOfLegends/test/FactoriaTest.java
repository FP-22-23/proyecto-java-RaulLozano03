package fp.leagueOfLegends.test;

import java.util.List;

import fp.leagueOfLegends.Champion;
import fp.leagueOfLegends.Champions;
import fp.leagueOfLegends.Factoria;

public class FactoriaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testLecturaFactoriaFichero("./data/champions.csv");
		testLecturaFactoria("Amumu;104;546.93;80;true;12/25/2020;flowers;TOP;64.1;2;834");
		
	}
	//Lectura del fichero
		private static void testLecturaFactoria(String fichero) {
			System.out.println("Test de un campeon del lol: ");
			Champions champions = Factoria.leeCampeon(fichero);
			System.out.println("##Campeones## "+ champions);
		}
//		Lectura de un campeon
		private static void testLecturaFactoriaFichero(String fichero) {
			System.out.println("Test de los campeones del lol: ");
			List<Champions> champions = Factoria.leeCampeones(fichero);
			System.out.println("##Campeones## " + champions);

		}

}


