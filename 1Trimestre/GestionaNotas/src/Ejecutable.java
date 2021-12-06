import Modelo.Alumno;
import Modelo.Grupo;

public class Ejecutable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Alumno a1 = new Alumno("victor" , 8.67);
		
		System.out.println(a1);
		
		Grupo g1 = new Grupo ("PrimeroSMR", 7);
		System.out.println(g1);
		
		System.out.println();
		
		Grupo g2 = new Grupo ("SegundoSMR", 7);
		System.out.println(g2);
		
		g1.newAlumno(a1);
		
		System.out.println(g1);
		
		
		/*
		g1.mejorNota(g1);
		
		/*
		Alumno a2 = new Alumno("Boxhot", 7.45);
		g1.newAlumno(a2);
		
		Alumno a4 = new Alumno("Pablo", 5.43);
		g1.newAlumno(a4);
		
		System.out.println(g1);
		
		g1.mediaGrupo(g1);
		
		
		/*
		g1.muestraAlumno("Boxhot");
		
		
		g1.modificaNota("Boxhot");
		
		System.out.println(g1);
		
		
		/*
		g1.getAlumno(a2);
		
		
		Alumno a3 = new Alumno("Boxhot", 7.45);
		g1.newAlumno(a3);
		
		System.out.println(g1);
		
		/*
		g1.eliminaAlumno("Boxhot");
		
		System.out.println(g1);
		*/
	}

}
