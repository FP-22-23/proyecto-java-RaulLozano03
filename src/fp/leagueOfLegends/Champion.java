package fp.leagueOfLegends;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import fp.common.PositionEnum;

public interface Champion {
	
	List<Champions> getCampeones();

	//	Numero de campeones
	Integer getSizeCampeones();

	//	Anadir un campeon
	void addCampeon(Champions c);

	//	Añadir una colección de campeones.
	void addColleccion(Collection<Champions> p);

	//	Eliminar un campeon.
	void eliminarCampeon(Champions c);
	
	
	//Existe
	
	Boolean existeCampeonPorAtaque(Integer attackDamage);
	
	//Contador
	
	Integer campeonesPorPosicion(PositionEnum positionEnum);
	
	//Filtrado
	
	List<String> campeonesUsanMana();
	
	//Map clave positionEnum, valores name
	
	Map<PositionEnum, Set<String>> mapPropiedadBaseValorColeccion();
	
	//Map clave positionEnum, valores suma attackDamage
	
	Map<PositionEnum, Integer> mapPropiedadBaseValorSuma();


}
