/** Back-end Java
*** M10 - Milestone 1 - Fase 3
*** Roger Torrent */

package M10_Milestone1;

public class M10_Milestone1Fase3 {
	
	public static String prova = "¡Esto es una demostración del método 'reverse()'!";
	
	public static void main(String args[]) {
		PhaseIII phaseiii = s -> new StringBuilder(s).reverse().toString();
		
		System.out.println(prova);
		System.out.println(phaseiii.reverse(prova));
	}
	
	@FunctionalInterface
	public interface PhaseIII {
		
		public String reverse(String s);
		
	}
	
}
