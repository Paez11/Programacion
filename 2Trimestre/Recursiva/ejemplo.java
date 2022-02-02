
package Recursiva;
import java.util.Scanner;


public class ejemplo {
    public static void main (String[] arg){
        Scanner teclado = new Scanner (System.in);

        int n=0;
        int n2=0;
        System.out.println("Introduzca un numero");
        n=teclado.nextInt();
        //System.out.println(fibonacci(n));
        System.out.println("Introduzca el exponente");
        n2=teclado.nextInt();
        System.out.println(potencia(n, n2));
        teclado.close();
    }

    static int funcionRecursiva(int n){
        int result=0;

        if(n<=1){
            result=n;
        }else{
            result=n+funcionRecursiva(n-1); //suma(n)=n+suma(n-1) hasta llegar a 1
        }

        return result;
    }
    
    static int factorial(int n){
        int result=0;

        if(n<=1){
            result=n;
        }else{
            result=n*factorial(n-1);
        }
        return result;
    }

    static int fibonacci(int n){
        int result=0;

        if(n<=0){
            result=0;
        }else if(n!=1){
            result=fibonacci(n-1)+fibonacci(n-2);
        }else{
            result=n;
        }

        return result;
    }

    static int potencia(int base, int exp){
        int result=0;

        if(base<=0){
            result=0;
        }else if(exp<0){
            result=0;
        }else if (exp==0){
            result=1;
        }else if (exp==1){
            result=base;
        }
        else{
            result=base*potencia((base),(exp-1));
        }

        return result;
    }
}
