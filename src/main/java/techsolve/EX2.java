package techsolve;

import java.util.Scanner;

public class EX2 {
    public static void main(String[] args) {
        int estoque;
        Scanner in = new Scanner(System.in);
        System.out.print("Insira a quantidade de itens no estoque: ");
        estoque = in.nextInt();
        
        String resultado;
        if (estoque % 2 == 0) {
            resultado = "A quantidade é par";
        } else {
            resultado = "A quantidade é impar";
        }
        
        System.out.println(resultado);
    }
}
