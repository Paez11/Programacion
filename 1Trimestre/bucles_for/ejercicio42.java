/*
Programa que muestre hacia atr�s todos los n�meros pares desde 100 (incluido).
 */

package bucles_for;

public class ejercicio42 {

	public static void main(String[] args) {
		for(int i=100;i>0;i--) {				//for(int i=100;i>0;i-=2)
			if (i%2==0) {
				System.out.println(i);
			}
		}

	}

}
