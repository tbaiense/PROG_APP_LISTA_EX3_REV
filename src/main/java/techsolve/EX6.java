package techsolve;

import java.util.Scanner;
import java.util.ArrayList;

public class EX6 {
    public static void main(String[] args) {
        ArrayList<Double> notas = new ArrayList<Double>();
        final int QTD_NOTAS = 3;
        double somaNotas=0;
        Scanner in;
        for(int i = 0; i < QTD_NOTAS; i++) {
            System.out.print("Insira a " + (i+1) + ". nota: ");
            in = new Scanner(System.in);
            double nota = in.nextDouble();
            somaNotas += nota;
            notas.add(nota);
        }
        double media = somaNotas / QTD_NOTAS;
        System.out.printf("\nA media das %d notas recebidas foram %1.2f.\n", QTD_NOTAS, media);
    }
}
