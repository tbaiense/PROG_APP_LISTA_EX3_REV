package techsolve;

import java.util.Scanner;

public class EX11 {
    public static void main(String[] args) {
        int QTD_NUM, min, max;
        int[] valores;
        
        Scanner in;
        
        System.out.print("Insira quantos numeros serao digitados: ");
        in = new Scanner(System.in);
        QTD_NUM = in.nextInt();
        
        valores = new int[QTD_NUM];
        for (int i = 0; i < QTD_NUM; i++) {
            System.out.print((i+1) + ". num.: ");
            in = new Scanner(System.in);
            valores[i] = in.nextInt();
        }
        
        min = max = valores[0];
        for (int n : valores) {
            if (n < min) {
                min = n;
            } else if (n > max) {
                max = n;
            }
        }
        
        System.out.print("Maior num: " +  max + "\nMenor num: " + min);
    }
}
