package techsolve;

import java.util.Scanner;

public class EX8 {
    public static void main(String[] args) {
        
        double[] notas;
        double somaNotas=0;
        
        Scanner in;
        System.out.print("Quantas notas o aluno possui: ");
        in = new Scanner(System.in);
        final int QTD_NOTAS = in.nextInt();
        notas = new double[QTD_NOTAS];
                
        for (int i = 0; i < notas.length; i++) {
            System.out.print("Insira a " + (i+1) + ". nota do aluno: ");
            in = new Scanner(System.in);
            somaNotas += in.nextDouble();
        }
        
        double media = somaNotas / QTD_NOTAS;
        
        String resultado = (media >= 6) ? "APROVADO" : "REPROVADO";
        
        System.out.printf("Com a media %1.2f, o aluno esta %s", media, resultado);
    }
}
