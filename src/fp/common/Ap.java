package fp.common;


public record Ap(Integer apMin,Integer apMax) {
	public static Ap of(String[] s) {
		return new Ap(Integer.valueOf(s[0]),Integer.valueOf(s[1]));
		
	}
}
