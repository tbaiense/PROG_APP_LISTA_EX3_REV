package techsolve;

import java.util.Scanner;

public class EX1 {
    public static void main(String[] args) {
        double soma = 0;
        Scanner in;
        for (int i = 0; i < 2; i++) {
            System.out.print("Digite o " + (i+1) + ". numero: ");
            in = new Scanner(System.in);
            soma += in.nextDouble();
        }
        System.out.println("O total somado foi de " + soma);
    }
}
