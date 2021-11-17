package MisEmpleados;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UsaEmpleado {

	public static void main(String[] args) {
		
		Empleado e1= new Empleado("Pedro","Programación",29,1500);
		System.out.println(e1);
		
		/*
		Empleado e2= new Empleado("Ana",31,1600);
		System.out.println(e2);
		
		Empleado e3= new Empleado("Maria",25);
		System.out.println(e3);
		
		Empleado e4= new Empleado();
		System.out.println(e4);
		*/
		System.out.println();
		menu1(e1);
	}
	
	
	
	
	
	public static void muestraMenu() {
		
		System.out.println("1: Modificar parametros");
		System.out.println("2: Aumentar el sueldo con importe fijo");
		System.out.println("3. Aumentar sueldo con porcentaje");
		System.out.println("0: salir");
		
	}
	
	public static void muestraMenu2() {
		
		System.out.println("0: volver al menu");
		System.out.println("1: Modificar nombre");
		System.out.println("2: Modificar departamento");
		System.out.println("3. Modificar edad");
		System.out.println("4: Modificar sueldo");
	
	}
	
	public static void menu1(Empleado e1) {
		int opcion=-1;
		int op2=0;
		int aumento=0;
		//Scanner teclado = new Scanner(System.in);
		
		do {
			
			System.out.println("                 MENU\n");
			
			muestraMenu();
			opcion=leeEntero();
			
			switch(opcion){
				case 1:
					System.out.println("--------------------------------------------------------------------------------------");
					menu2(e1);
					break;
				case 2:
					System.out.println("--------------------------------------------------------------------------------------");
					System.out.print("Introduce el aumento fijo para el empleado: ");
					e1.increaseSalary(leeDouble((double)aumento));
					System.out.println(e1);
					break;
				case 3:
					System.out.println("--------------------------------------------------------------------------------------");
					System.out.print("Introduce el aumento en porcentaje para el empleado: ");
					e1.increaseSalary(aumento=leeEntero());
					System.out.println(e1);
					break;
				case 0:
					break;
			}
	
		}while(opcion>0);
		System.out.println("Hasta luego");
	}
	
	public static void menu2(Empleado e1) {
		String nuevoNombre="";
		int opcion=0;
		int n=0;
		double salario=0;
		
		do {
			
			muestraMenu2();
			opcion=leeEntero();
			
			switch(opcion){
				case 1:
					System.out.println("--------------------------------------------------------------------------------------");
					System.out.print("Introduce el nuevo nombre: ");
					e1.setNombre(leeString(nuevoNombre));
					System.out.println(e1);
					break;
				case 2:
					System.out.println("--------------------------------------------------------------------------------------");
					System.out.print("Introduce el nuevo departamento: ");
					e1.setDpto(leeString(nuevoNombre));
					System.out.println(e1);
					break;
				case 3:
					System.out.println("--------------------------------------------------------------------------------------");
					System.out.print("Introduce la nueva edad: ");
					e1.setAge(n=leeEntero());
					System.out.println(e1);
					break;
				case 4:
					System.out.println("--------------------------------------------------------------------------------------");
					System.out.print("Introduce el nuevo salario base: ");
					e1.setSalary(leeDouble(salario));
					System.out.println(e1);
					break;
				case 0:
					
					break;
			}
	
		}while(opcion>0);
	}
	
	public static int leeEntero() {
		int n=0;
		Scanner teclado = new Scanner (System.in);
		boolean valid=false;
		do {
			try {
				n=teclado.nextInt();
				valid=true;
			}catch(InputMismatchException ex) {
				System.out.println("Error");
				teclado.next();
			}
		}while(!valid || n<0);
		return n;
	}
	
	public static double leeDouble(double n) {
		Scanner teclado = new Scanner (System.in);
		boolean valid=false;
		do {
			try {
				n=teclado.nextDouble();
				valid=true;
			}catch(InputMismatchException ex) {
				System.out.println("Error");
				teclado.next();
			}
		}while(!valid || n<=0);
		return n;
	}
	
	public static String leeString(String n) {
		Scanner teclado = new Scanner (System.in);
		boolean valid=false;
		do {
			try {
				n=teclado.next();
				valid=true;
			}catch(InputMismatchException ex) {
				System.out.println("Error");
				teclado.next();
			}
		}while(!valid);
		return n;
	}
	

}
