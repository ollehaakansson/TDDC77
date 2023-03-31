package Lab5;

public class Word {
	
	String t;
	
	public Word (String text) {
		
		t = text;
	}
	
	public boolean equals (Object obj) {
		
		// detta borde kolla om hashcoden av obj & hashcoden av text är densamma 
		// (aka om det är samma ord)
		// den kollar även om obj är ett ord.
//		Integer var1 = (this.hashCode());
//		Integer var2 = (obj.hashCode());
//		
//		String var3 = var1.toString();
//		String var4 = var2.toString();
//		
//		if((var3.equals(var4)) && obj instanceof Word == true) {
//			return true;
//		}else {
		
		return t.equals(obj.toString())  && (obj instanceof Word);
		}
		
	
	public int hashCode () {
		// Behövs, används indirekt alltid när HashMap används. Då hashMap behöver HasCode  POLIMORPHIsm
		return t.hashCode();
	}

	public String toString () {
		
		return t;
	}

}
