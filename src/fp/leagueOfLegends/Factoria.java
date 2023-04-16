package fp.leagueOfLegends;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import fp.common.Ap;
import fp.common.PositionEnum;

public class Factoria {
	// LECTURA
	public static List<Champions> leeCampeones(String nomfich) {
		List<Champions> res = null;
		try {
			List<Champions> champions = Files.lines(Paths.get(nomfich)).skip(1).map(Factoria::parseaChampion)
					.collect(Collectors.toList());

			res = champions;
		} catch (IOException e) {
			System.out.println("Fichero no encontrado: " + nomfich);
			e.printStackTrace();
		}
		return res;
	}
	//SEGUNDA LECTURA
	
	public static Champions leeCampeon(String lineaCSV) {
		
		return parseaChampion(lineaCSV);
		
		
	}
	
	//PARSEA UNA LINEA DE TEXTO A MI CLASE
	private static Champions parseaChampion(String linea) {
		String[] trozos = linea.split(";");

		String name = (trozos[0].trim());
		Integer shield = Integer.valueOf(trozos[1].trim());
		Float healthpoint = Float.valueOf(trozos[2].trim());
		Integer attackDamage = Integer.valueOf(trozos[3].trim());
		Boolean usemana = parseaUseMana(trozos[4].trim());
		LocalDate releaseDate = LocalDate.parse(trozos[5].trim(), DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		List<String> skins = Arrays.asList(trozos[6].trim().split("-"));
		PositionEnum positionenum = PositionEnum.valueOf(trozos[7].trim());
		Float speed = Float.valueOf(trozos[8].trim());
		Integer apMin = Integer.valueOf(trozos[9].trim());
		Integer apMax = Integer.valueOf(trozos[10].trim());

		return new Champions(name, shield, healthpoint, attackDamage, usemana, releaseDate, skins, positionenum, speed,
				new Ap(apMin, apMax));
	}
	//PARSEA MI COLUMNA DEL CSV A BOOLEANO
	private static Boolean parseaUseMana(String cadena) {
		Boolean res = null;
		if (cadena.equals("TRUE")) {
			res = true;
		} else {
			res = false;
		}
		return res;
	}

}
