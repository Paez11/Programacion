package MisEmpleados;

import java.util.InputMismatchException;
import java.util.Scanner;

import Controladores.ControlMenu;
import Utils.Lee;
import vistas.Menus;


public class UsaEmpleado {

	public static void main(String[] args) {
		
		Empleado e1= new Empleado("Pedro","Programaci�n",29,1500);
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
		ControlMenu.menuPrincipal(e1);
	}

}
