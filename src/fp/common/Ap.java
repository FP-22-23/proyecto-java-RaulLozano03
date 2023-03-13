package fp.common;

public record Ap(Integer apMin,Integer apMax) implements Comparable<Ap> {
	public static Ap of(String[] s) {
		return new Ap(Integer.valueOf(s[0]),Integer.valueOf(s[1]));
		
	}

	public int compareTo(Ap o) {
		int r;
		if (o == null) {
			throw new NullPointerException();
		}
		r = apMin().compareTo(o.apMin());
		if (r == 0) {
			r = apMax().compareTo(o.apMax());
			
		}
		return r;
	}
} 
	
	

