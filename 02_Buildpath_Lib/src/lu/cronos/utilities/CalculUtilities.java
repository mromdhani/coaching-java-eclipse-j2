package lu.cronos.utilities;

public class CalculUtilities {
	
	public static int additionner(int... nombres) {
		int cumul = 0;
		for (int n : nombres) {
			cumul += n;
		}
		return cumul;
	}

}
