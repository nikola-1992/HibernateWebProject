package validacija;

public class Validacija {

	public static boolean proveriDaLiSuIstiPasswordi(String password, String repeatPassword) {
		if(password.equals(repeatPassword)) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
	
}
