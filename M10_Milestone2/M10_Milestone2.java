/** Back-end Java
*** M10 - Milestone 2
*** Roger Torrent */

package M10_Milestone2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.Comparator;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class M10_Milestone2 {
	
	public static String text = "The main armament consisted of three electrically powered triple-gun "
			+ "turrets, each with three 54-caliber 305 mm B-50 guns."; // Kronshtadt
	
	public static String[] matriu = text.split("[ ,.]+"); // Matriu per fer el exercici
	
	public static void main(String args[]) {
		Method questio; // Mètode reflexiu d'invocar les matrius
		for(int i = 0; i <= 6; i++) { try {
			questio = M10_Milestone2.class.getMethod("mat" + i, String[].class);             // obtenció del mètode
			Object mat_i = questio.invoke(null, (Object)matriu);                             // invocació del mètode
			System.out.println(Stream.of((String[])mat_i).collect(Collectors.joining(" "))); // impressió de la matriu
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) { e.printStackTrace(); } }
		
		MilestoneII
			suma = (a, b) -> a+b,
			rsta = (a, b) -> a-b,
			mult = (a, b) -> a*b,
			divs = (a, b) -> a/b;
		
		operacions(2.71f, 3.42f, '+', suma);
		operacions(2.71f, 3.42f, '-', rsta);
		operacions(2.71f, 3.42f, '×', mult);
		operacions(2.71f, 3.42f, '÷', divs);
	}
	// Matriu original (referència)
	public static String[] mat0(String[] s) {
		return s;
	}
	
	// Qüestió 1: Ordenada per longitud
	public static String[] mat1(String[] s) {
		return Stream.of(s).sorted(Comparator.comparingInt(String::length)).toArray(String[]::new);
	}
	
	// Qüestió 2: Ordenada per longitud inversa
	public static String[] mat2(String[] s) {
		return Stream.of(s).sorted(Comparator.comparingInt(String::length).reversed()).toArray(String[]::new);
	}
	
	// Qüestió 3: Ordenada alfabèticament pel primer caràcter
	public static String[] mat3(String[] s) {
		return Stream.of(s).sorted(Comparator.comparing(t -> Character.toUpperCase(t.charAt(0)))).toArray(String[]::new);
	}
	
	// Qüestió 4: Ordenada, primer cadenes que contenen "e"
	public static String[] mat4(String[] s) {
		return Stream.of(s).sorted(Comparator.comparing((String t) -> t.contains("e")).reversed()).toArray(String[]::new);
	}
	
	// Qüestió 5: Modificada, "a" -> "4"
	public static String[] mat5(String[] s) {
		return Stream.of(s).map(t -> t.replace('a', '4')).toArray(String[]::new);
	}
	
	// Qüestió 6: Mostra només els elements que siguin 100% numèrics
	public static String[] mat6(String[] s) {
		return Stream.of(s).filter(t -> t.matches("[0-9]+")).toArray(String[]::new);
	}
	
	public static void operacions(float a, float b, char c, MilestoneII m) {
		System.out.println(String.format("%.2f %c %.2f = %.2f", a, c, b, m.operacio(a, b)));
	}
	
	public interface MilestoneII {
		
		public float operacio(float a, float b);
		
	}
	
}
