package fp.leagueOfLegends;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.common.PositionEnum;

public class Contenedor implements Champion {

	// Atributo
	private List<Champions> champions;

	// Constructores
	public Contenedor() {
		champions = new ArrayList<>();
	}

	public Contenedor(Stream<Champions> champions) {
		this.champions = champions.collect(Collectors.toList());
	}

	public Contenedor(Collection<Champions> champions) {
		this.champions = new ArrayList<>(champions);
	}
	// Metodos

	// Numero de campeones
	@Override
	public Integer getSizeCampeones() {
		
		return champions.size();
	}

	// Añade un campeon
	public void addCampeon(Champions campeon) {
		champions.add(campeon);
	}

	// Añadir una colección
	@Override
	public void addColleccion(Collection<Champions> c) {
		this.champions.addAll(c);

	}

	// Eliminar un elemento
	public void eliminarCampeon(Champions champion) {
		if (!champions.contains(champion)) {
			throw new IllegalArgumentException("El campeon no existe");
		} else {
			champions.remove(champion);
		}
	}

	@Override
	public List<Champions> getCampeones() {
		
		return champions;
	}

	@Override
	public String toString() {
		return "Contenedor [champions=" + champions + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(champions);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contenedor other = (Contenedor) obj;
		return Objects.equals(champions, other.champions);
	}

	// Existe
	@Override
	public Boolean existeCampeonPorAtaque(Integer attackDamage) {
		Boolean res = false;
		for (Champions c : this.champions) {
			if (c.getAttackDamage().equals(attackDamage)) {
				res = true;
				break;
			}
		}
		return res;

	}

	// Contador
	@Override
	public Integer campeonesPorPosicion(PositionEnum positionEnum) {
		Integer res = 0;
		for (Champions c : this.champions) {
			if (c.getPositionEnum().equals(positionEnum)) {
				res++;
			}
		}
		return res;
	}

	// Filtrado
	@Override
	public List<String> campeonesUsanMana() {
		List<String> res = new ArrayList<>();
		for (Champions c : this.champions) {
			if (c.getUseMana().equals(true)) {
				res.add(c.getName());
			}
		}
		return res;
	}

	//Map clave positionEnum, valores name
	@Override
	public Map<PositionEnum, Set<String>> mapPropiedadBaseValorColeccion() {
		Map<PositionEnum, Set<String>> res = new HashMap<>();
		for (Champions c : this.champions) {
			if (!res.containsKey(c.getPositionEnum())) {
				Set<String> conjunto = new HashSet<>();
				conjunto.add(c.getName());
				res.put(c.getPositionEnum(), conjunto);

			} else {
				Set<String> copia = res.get(c.getPositionEnum());
				copia.add(c.getName());
				res.put(c.getPositionEnum(), copia);
			}
		}
		return res;
	}
	//Map clave positionEnum, valores suma attackDamage
	@Override
	public Map<PositionEnum, Integer> mapPropiedadBaseValorSuma() {
		
		Map<PositionEnum, Integer> res = new HashMap<>();
		for (Champions c : this.champions) {
			if (!res.containsKey(c.getPositionEnum())) {
				res.put(c.getPositionEnum(), c.getAttackDamage());

			} else {
				Integer variable = res.get(c.getPositionEnum());
				Integer ataque = c.getAttackDamage();
				res.put(c.getPositionEnum(), ataque + variable);
			}
		}
		return res;
	}
}
