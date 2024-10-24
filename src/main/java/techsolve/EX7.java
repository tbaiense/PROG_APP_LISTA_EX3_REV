package techsolve;

import java.util.Scanner;
import java.util.Arrays;

public class EX7 {
    public static void main(String[] args) {
        final int QTD_COD = (int)(Math.random() * 10) + 1;
        int[] codigos = new int[QTD_COD];
        
        //Preenchimento do vetor de códigos
        for (int i = 0; i < codigos.length; i++) {
            codigos[i] = i+1;
        }
        
        System.out.println("Vetor gerado:\n" + Arrays.toString(codigos));
        
        System.out.print("Digite o codigo do produto que deseja procurar: ");
        Scanner in = new Scanner(System.in);
        int codProcurar = in.nextInt();
        
        boolean encontrado = false;
        for(int c : codigos) {
            if (c == codProcurar) {
                encontrado = true;
                break;
            }
        }
        
        if (encontrado) {
            System.out.println("O produto esta cadastrado na lista.");
        } else {
            System.out.println("O codigo do produto nao foi encontrado.");
        }
    }
}
