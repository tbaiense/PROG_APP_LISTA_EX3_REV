package techsolve;

import java.util.Scanner;

public class EX12 {
    public static void main(String[] args) {
        System.out.print("Escolha um inteiro para verificar se e primo: ");
        Scanner in = new Scanner(System.in);
        System.out.print("Numero escolhido " + (((isPrime( in.nextDouble())) ? "e primo." : "nao e primo")));
    }
    
    public static boolean isPrime(double n) {
        if (n < 2) {
            return false;
        } else {
            for (double d = n-1; d > 1; d--) { // Divide n por divisor d
                if (n % d == 0) {
                    System.out.printf("Divisor encontrado: %1.0f\n",d);
                    return false;
                }
            }
            return true;
        }
    }
}
