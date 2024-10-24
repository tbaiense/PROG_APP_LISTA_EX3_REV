package techsolve;

import java.util.Scanner;

public class EX5 {
    public static void main(String[] args) {
        int segRestantes;
        Scanner in = new Scanner(System.in);
        
        System.out.print("Insira a quantidade de segundos restantes: ");
        segRestantes = in.nextInt();
        
        System.out.println("TEMPO RESTANTE ----");
        for (int i = segRestantes; i > 0; i--) {
            System.out.println("Restam " + (i) + " segundos...");
        }
        System.out.println("\nPROCESSO FINALIZADO!");
    }
}
