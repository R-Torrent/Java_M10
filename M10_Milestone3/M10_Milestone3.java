/** Back-end Java
*** M10 - Milestone 3
*** Roger Torrent */

package M10_Milestone3;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class M10_Milestone3 {
	
	public static void main(String args[]) {
		List<Alumne> alumnes = List.of(
			new Alumne(   "Alberto", 24,      Cursos.ANGULAR, 8.13f),
			new Alumne(     "Belén", 18, Cursos.DATA_SCIENCE, 6.98f),
			new Alumne(    "Carlos", 30,      Cursos.NODE_JS, 7.20f),
			new Alumne(     "Diana", 20,        Cursos.REACT, 5.90f),
			new Alumne( "Atahualpa", 18,         Cursos.JAVA, 9.06f),
			new Alumne(     "Friné", 17,          Cursos.PHP, 7.45f),
			new Alumne(   "Günther", 14,         Cursos.JAVA, 9.50f),
			new Alumne(    "Hannah", 19,          Cursos.PHP, 3.80f),
			new Alumne(     "Íñigo", 22, Cursos.DATA_SCIENCE, 4.32f),
			new Alumne("Jacqueline", 19,       Cursos.VUE_JS, 7.75f)
		);
		Scanner sc = new Scanner(System.in);
		byte op = 0;
		List<Alumne> solucio = null;
		Stream<Alumne> stream = null;
		do {
			System.out.println("Introduzca # de apartado [1-5] o '0' para salir");
			System.out.print("? ");
			if(sc.hasNextByte()) op = sc.nextByte();
			else { sc.next(); continue; }
			switch(op) {
				case 1: // Apartado 1
					alumnes
						.forEach(a -> System.out.println(String.format("%10s %d", a.nom, a.edat)));
					System.out.println();
					continue;
				case 2: // Apartado 2
					stream = alumnes.stream()
						.filter(a -> Set.of('a', 'A').contains(a.nom.charAt(0)));
					break;
				case 3: case 4: // Apartados 3 y 4
					stream = alumnes.stream()
						.filter(a -> a.nota >= 5.0)
						.filter(op == 4 ? a -> a.curs != Cursos.PHP : a -> true); // Filtro adicional para Aptdo. 4
					break;
				case 5: // Apartado 5
					stream = alumnes.stream()
						.filter(a -> a.curs == Cursos.JAVA)
						.filter(a -> a.edat >= 18);
					break;
				default: continue;
				case 0: // Sortida
					sc.close();
					System.out.println("\nAdéu!");
					System.exit(0);
			}
			solucio = stream.collect(Collectors.toList()); // Nova llista
			solucio.forEach(System.out::println);          // Impressió de llista
			System.out.println();
		} while(true);
	}
	
}

class Alumne {
	
	String nom;
	int edat;
	Cursos curs;
	float nota;
	
	Alumne(String nom, int edat, Cursos curs, float nota) {
		this.nom = nom;
		this.edat = edat;
		this.curs = curs;
		this.nota = nota;
	}
	
	@Override
	public String toString() {
		return String.format("%10s %2d %12s %.2f", nom, edat, curs, nota);
	}
	
}

enum Cursos {
	ANGULAR, DATA_SCIENCE, JAVA, NODE_JS, PHP, REACT, VUE_JS
}
