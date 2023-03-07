package fp.leagueOfLegends;

import java.time.LocalDate;
import java.util.Objects;

import fp.common.PositionEnum;
import fp.utiles.Checkers;

public class Champions implements Comparable<Champions> {
//ATRIBUTOS
	private String name;
	private Integer shield;
	private Float healthPoint;
	private Integer attackDamage;
	private Boolean useMana;
	private LocalDate releaseDate;
	private PositionEnum positionEnum;
	private Float speed;

//CONSTRUCTOR COMPLETO
	public Champions(String name, Integer shield, Float healthPoint, Integer attackDamage, Boolean usemana,
			LocalDate releaseDate, PositionEnum positionenum, Float speed) {
		
		
		Checkers.check("El nombre no puede estar vacío",  //PRIMERA RESTRICCION, NOMBRE NO PUEDE ESTAR VACIO
				!name.equals(""));
		Checkers.check("El valor de healthPoint no puede ser inferior a 400",  //SEGUNDA RESTRICCION NO PUEDE SER MENOR A 400
				healthPoint > 400);
		this.name = name;
		this.shield = shield;
		this.healthPoint = healthPoint;
		this.attackDamage = attackDamage;
		this.useMana = usemana;
		this.releaseDate = releaseDate;
		this.positionEnum = positionEnum;
		this.speed = speed;
		
		
	}

//CONSTRUCTOR VACIO
	public Champions() {

		name = null;
		shield = null;
		healthPoint = null;
		attackDamage = null;
		useMana = null;
		releaseDate = null;
		positionEnum = null;
		speed = null;
	}

//GETTERS Y SETTERS
	public String getName() {
		return name;
	}

	public void setName(String name) {
		
		Checkers.check("El nombre no puede estar vacío",  //MISMA RESTRICCION, NOMBRE NO PUEDE ESTAR VACIO
				!name.equals(""));
		
		this.name = name;
		
		
	}

	public Integer getShield() {
		return shield;
	}

	public void setShield(Integer shield) {
		this.shield = shield;
	}

	public Float getHealthPoint() {
		return healthPoint;
	}

	public void setHealthPoint(Float healthPoint) {
		
		Checkers.check("El valor de healthPoint no puede ser inferior a 400",  //SEGUNDA RESTRICCION NO PUEDE SER MENOR A 400
				healthPoint > 400);
		
		this.healthPoint = healthPoint;
	}

	public Integer getAttackDamage() {
		return attackDamage;
	}

	public void setAttackDamage(Integer attackDamage) {
		this.attackDamage = attackDamage;
	}

	public Boolean getUseMana() {
		return useMana;
	}

	public void setUseMana(Boolean useMana) {
		this.useMana = useMana;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public PositionEnum getPositionEnum() {
		return positionEnum;
	}

	public void setPositionEnum(PositionEnum positionEnum) {
		this.positionEnum = positionEnum;
	}

	public Float getSpeed() {
		return speed;
	}

	public void setSpeed(Float speed) {
		this.speed = speed;
	}

//PROPIEDAD DERIVADA PARA SABER SI EL CAMPEON ES RAPIDO O NO
	public Boolean getFast() {

		Boolean res = true;

		if (getSpeed() < 50.0) {
			res = false;
		}

		return res;

	}

//La representación como cadena, HACER COMO EN LA FOTO DE CLASE
	@Override
	public String toString() {
		return "Champions [name=" + name + ", shield=" + shield + ", healthPoint=" + healthPoint + ", attackDamage="
				+ attackDamage + ", useMana=" + useMana + ", releaseDate=" + releaseDate + ", positionEnum="
				+ positionEnum + ", speed=" + speed + "]";
	}

//El criterio de igualdad
	@Override
	public int hashCode() {
		return Objects.hash(attackDamage, healthPoint, name, positionEnum, releaseDate, shield, speed, useMana);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
			}
		if (obj == null) {
			return false;
			}
		if (getClass() != obj.getClass()) {
			return false;
			}
		Champions other = (Champions) obj;
		return Objects.equals(attackDamage, other.attackDamage) && Objects.equals(healthPoint, other.healthPoint)
				&& Objects.equals(name, other.name) && positionEnum == other.positionEnum
				&& Objects.equals(releaseDate, other.releaseDate) && Objects.equals(shield, other.shield)
				&& Objects.equals(speed, other.speed) && Objects.equals(useMana, other.useMana);
	}

//ORDEN NATURAL, NO PUEDE SER NADA NULO
	@Override
	public int compareTo(Champions o) {
		int r;
		if (o == null) {
			throw new NullPointerException();
		}
		r = getName().compareTo(o.getName());
		if (r == 0) {
			r = getShield().compareTo(o.getShield());
			if (r == 0) {
				r = getHealthPoint().compareTo(o.getHealthPoint());
				if (r == 0) {
					r = getAttackDamage().compareTo(o.getAttackDamage());
					if (r == 0) {
						r = getUseMana().compareTo(o.getUseMana());
						if (r == 0) {
							r = getReleaseDate().compareTo(o.getReleaseDate());
							if (r == 0) {
								r = getPositionEnum().compareTo(o.getPositionEnum());
								if (r == 0) {
									r = getSpeed().compareTo(o.getSpeed());
								}
							}
						}
					}
				}
			}
		}
			
		
		return r;
	}
	
	
	


}

//Preguntar si getters y setters, y to string, y equals se pueden hacer con el generate,
	// y si criterio de igualdad es equal o hashcode y no encuentro utiidad para se puede hacer generando
	// utiles y common,,,,, SOLO TIPO FECHA HACER