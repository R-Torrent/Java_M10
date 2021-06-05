/** Back-end Java
*** M10 - Milestone 1 - Fase 1
*** Roger Torrent */

package M10_Milestone1;

import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class M10_Milestone1Fase1 {
	
	public static List<String> noms_propis = List.of("Ana", "abe", "Andr�s", "carla", "Cornelia",
			"Bob", "Albert", "Alb", "Ona", "arminio");
	
	public static List<Integer> nombres = List.of(3, 44, 17, -0, 0, -23, -8);
	
	public static List<String> mesos = Arrays.asList("gener", "febrer", "mar�" ,"abril",
			"maig", "juny", "juliol", "agost", "setembre", "octubre", "novembre", "desembre");
	
	public static void main(String args[]) {
		System.out.println(apartado1(noms_propis)); // Resoluci�n Apartado 1
		System.out.println(apartado2(nombres));     // Resoluci�n Apartado 2
		System.out.println(apartado3(noms_propis)); // Resoluci�n Apartado 3
		System.out.println(apartado4(noms_propis)); // Resoluci�n Apartado 4
		System.out.println(mesos.stream().collect(Collectors.joining(" "))); // Resoluci�n Apartado 5
		// Resoluci�n Apartado 6 (Referencia a un m�todo est�tico + Referencia a un m�todo instanciado v�a el tipo del objeto)  
		System.out.println(mesos.stream().map(M10_Milestone1Fase1::apartado6).reduce("", String::concat));
		// NOTA: Ser�a m�s sencillo imprimir cada mes en una l�nea distinta
		//       mesos.forEach(System.out::println);
	}
	
	public static List<String> apartado1(List<String> noms) {
		return noms.stream().filter(n -> n.length() == 3 && n.charAt(0) == 'A').collect(Collectors.toList());
	}
	
	public static String apartado2(List<Integer> numeros) {
		return nombres.stream().map(n -> (n  % 2 == 0 ? "e" : "o") + n).collect(Collectors.joining(", "));
	}
	
	public static List<String> apartado3(List<String> llista_strings) {
		return llista_strings.stream().filter(s -> s.contains("o")).collect(Collectors.toList());
	}
	
	public static List<String> apartado4(List<String> llista_strings) {
		return Stream.concat(
				apartado3(llista_strings).stream(),
				llista_strings.stream().filter(n -> n.length() > 5))
			.distinct().collect(Collectors.toList());
	}
	
	public static String apartado6(String m) {
		return m + " ";
	}
	
}
