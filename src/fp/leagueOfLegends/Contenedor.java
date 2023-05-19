package fp.leagueOfLegends;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.BinaryOperator;
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

	// Map clave positionEnum, valores name
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

	// Map clave positionEnum, valores suma attackDamage
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

	public Boolean existeCampeonPorAtaqueStream(Integer attackDamage) {
		Boolean res = champions.stream().anyMatch(f -> f.getAttackDamage().equals(attackDamage));
		return res;
	}

	public Integer campeonesPorPosicionStream(PositionEnum positionEnum) {
		return (int) champions.stream().filter(c -> c.getPositionEnum().equals(positionEnum)).count();

	}

	public Set<String> campeonesUsanManaStream() {
		Set<String> res = champions.stream().filter(c -> c.getUseMana().equals(true)).map(Champions::getName)
				.collect(Collectors.toSet());
		return res;
	}

	public Champions getUseManaMaxAttackDamageStream(Boolean useMana) {
		Champions res = champions.stream().filter(c -> c.getUseMana().equals(useMana))
				.max(Comparator.comparing(Champions::getAttackDamage)).orElse(null);
		return res;
	}

	public List<Champions> getUseManaOrdenadoShieldStream(Boolean useMana) {
		List<Champions> res = champions.stream().filter(e -> e.getUseMana().equals(useMana))
				.sorted(Comparator.comparing(Champions::getShield)).collect(Collectors.toList());
		return res;
	}

	public Map<PositionEnum, Set<String>> mapPropiedadBaseValorColeccionStream() {
		return this.champions.stream().collect(Collectors.groupingBy(Champions::getPositionEnum,
				Collectors.mapping(Champions::getName, Collectors.toSet())));
	}

	public Set<Integer> obtenerMediaStream() {
		return champions.stream().collect(Collectors.mapping(Champions::getAttackDamage, Collectors.toSet()));

	}

	public Map<String, Integer> mapNombreMaxAttackDamageStream() {

		Map<String, Set<Integer>> res = champions.stream()

				.collect(Collectors.groupingBy(Champions::getName,
						Collectors.mapping(Champions::getAttackDamage, Collectors.toSet())));

		return res.entrySet().stream()

				.collect(Collectors.toMap(

						entry -> entry.getKey(),

						entry -> Collections.max(entry.getValue())));

	}
	public SortedMap<PositionEnum, List<String>> sortedMapPositionEnumMaxNombreStream(Integer number) {
	    TreeMap<PositionEnum, List<String>> collect = champions.stream()
	            .collect(Collectors.groupingBy(Champions::getPositionEnum,
	                    TreeMap::new,
	                    Collectors.collectingAndThen(Collectors.toList(),
	                            c -> sortedAndLimitByName(c, number))
	            ));
	    return new TreeMap<>(collect);

	}

	public List<String> sortedAndLimitByName(List<Champions> l, Integer n) {
	    return
	            l.stream()
	                    .sorted(Comparator.comparing(Champions::getName))
	                    .limit(n)
	                    .map(Champions::getName)
	                    .collect(Collectors.toList());
	}

	public String championsWorstAttack() {
		Map<String, Set<Integer>> aux = champions.stream().collect(Collectors.groupingBy(Champions::getName,
				Collectors.mapping(Champions::getAttackDamage, Collectors.toSet())));
		return aux.entrySet().stream()
				.min(Comparator.comparingInt(entry -> entry.getValue().stream().min(Integer::compareTo).get()))
				.map(Map.Entry::getKey).orElse(null);
	}
}