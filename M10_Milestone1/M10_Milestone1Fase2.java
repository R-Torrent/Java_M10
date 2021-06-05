/** Back-end Java
*** M10 - Milestone 1 - Fase 2
*** Roger Torrent */

package M10_Milestone1;

public class M10_Milestone1Fase2 {
	
	public static void main(String args[]) {
/*		
		System.out.println(new PhaseII() { // Clase anónima que implementa la interfaz
			
			@Override                      // Modo "Java" de resolver el enunciado
			public double getPiValue() {
				return 3.1415;
			}
			
		}.getPiValue());
*/		
		PhaseII phaseii = () -> 3.1415;    // Modo "funcional" de resolver el enunciado; función anónima instancia la interfaz
		System.out.println(phaseii.getPiValue());
	}
	
	@FunctionalInterface
	public interface PhaseII {
		
		public double getPiValue();
		
	}
	
}
