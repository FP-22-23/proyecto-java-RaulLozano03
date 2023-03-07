package fp.utiles;
//se crea una clase checker para validar
public class Checkers {

	public static void check(String text, Boolean condition) {
		if (!condition) {
			throw new IllegalArgumentException(text);
		}
	}
	
	
}

