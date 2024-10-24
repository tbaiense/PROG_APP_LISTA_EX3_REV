package techsolve;

import java.util.Scanner;

public class EX4 {
    public static void main(String[] args) {
        System.out.print("Insira o numero para exibir a tabuda: ");
        Scanner in = new Scanner(System.in);
        tabuada(in.nextDouble());
    }
    
    public static void tabuada(double n) {
        StringBuilder tbN = new StringBuilder(String.format("TABUADA DE %1.2f -----------\n", n));
        for (int i = 1; i <= 10; i++) {
            tbN.append(String.format("%1.1f x %d = %1.2f\n", n, i, (n*i)));
        }
        System.out.println(tbN.toString());
    }
}
