package fp.leagueOfLegends.test;

import java.time.LocalDate;
import java.util.List;

import fp.common.PositionEnum;
import fp.leagueOfLegends.Champions;

public class ChampionsTest {

	public static void main(String[] args) {

		// Los constructores
		Champions c1 = new Champions();

		Champions c2 = new Champions("Aatrox", 101, 558.02f, 77, true, LocalDate.of(2020, 10, 20) , PositionEnum.JNG, 52.6f);
		
		Champions c3 = new Champions();
		//Algunos SET
		System.out.println(c1);
		c1.setName("Aatrox");
		c1.setShield(101);
		c1.setHealthPoint(558.02f);
		c1.setAttackDamage(77);
		c1.setReleaseDate(LocalDate.of(2020, 10, 20));
		c1.setSpeed(500.0f);
		System.out.println(c1);
		System.out.println(c1.getName() + " " + c1.getShield());
		c2.setName("Ahri");
		c3.setName("Akali");

		// Algunos GET
		System.out.println("Nombre del campeon:" + c1.getName());
		System.out.println("Escudo del Campeon:" + c1.getShield());
		System.out.println("Calle del Campeon:" + c1.getPositionEnum());


		//Propiedad derivada
		System.out.println("\n" + c1.getName() + " es rapido: " + c1.getFast());

		// El equals
		System.out.println("\nEl resultado de  c1.equals(c3)= " + c1.equals(c3));
		System.out.println("El resultado de  c1.equals(c1)= " + c1.equals(c1));

		// El Orden natural
		if (c1.compareTo(c2) > 0) {
			System.out.println("\nEl campeon " + c1.getName() + " es anterior a " + c2.getName());
		} else {
			System.out.println("\nEl campeon " + c1.getName() + " es anterior " + c2.getName());
		}
	}

}