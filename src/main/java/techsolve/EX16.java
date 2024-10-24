package techsolve;

import java.util.Scanner;
import java.util.Arrays;

public class EX16 {
    public static void main(String[] args) {
        int[] pontuacoes;
        Scanner in;
        
        while (true) {
            System.out.print("Insira quantas pontuações serão registradas: ");
            in = new Scanner(System.in);
            final int QTD = in.nextInt();
            if (QTD > 0) {
                pontuacoes = new int[QTD];
                break;
            }
            
            System.out.println("Quantidade deve ser maior que zero. Tente novamente.");
        }
        
        for (int p = 0; p < pontuacoes.length; p++) {
            System.out.printf("Insira a %da pontuacao: ", p+1);
            in = new Scanner(System.in);
            pontuacoes[p] = in.nextInt();
        }
        System.out.printf("\nCadastro de pontuacoes concluida!\n\nPontuacoes cadastradas:\n%s\n", Arrays.toString(pontuacoes));
        
        System.out.printf("Vetor ordenado crescentemente:\n%s", Arrays.toString(sortBubble(pontuacoes)));
    }
    
    public static int[] sortBubble(int[] a) {
        if (a == null) {
            return null;
        }
        
        a = a.clone();
        
        for (int i = 0; i < a.length-1; i++) { // Repetição de iterações
            for (int posAtual = 0; posAtual < a.length -1; posAtual++) { // Iteração única
                if (a[posAtual] > a[posAtual+1]) {
                    int copia = a[posAtual];
                    a[posAtual] = a[posAtual + 1];
                    a[posAtual+1] = copia;
                }
            }
        }
        
        return a;
    }
}
