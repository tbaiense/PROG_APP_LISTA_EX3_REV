package techsolve;

import java.util.Scanner;
import java.util.ArrayList;

public class EX3 {
    public static void main(String[] args) {
        ArrayList<Double> pontuacoes = new ArrayList<Double>();
        final int qtdJogadores = 2;
        
        Scanner in;
        for (int i = 0; i < qtdJogadores; i++) {
            System.out.print("Insira a pontuacao do " + (i+1) + ". jogador: ");
            in = new Scanner(System.in);
            pontuacoes.add(in.nextDouble());
        }
        
        int indexMaior=0;
        double ptMaior = pontuacoes.get(indexMaior);
        boolean empate = false;
        for (int i = 1; i < qtdJogadores; i++) {
            double ptAtual = pontuacoes.get(i);
            if (ptAtual > ptMaior) {
                indexMaior = i;
                ptMaior = pontuacoes.get(indexMaior);
            } else if (ptAtual == ptMaior) {
                empate = true;
            }
        }
        
        if (!empate) {
            System.out.println("O jogador com a maior pontuacaoo foi o " 
                + (indexMaior + 1) + "., com " + pontuacoes.get(indexMaior) + " pontos.");
        } else {
            System.out.print("Ocorreu um empate!");
        }
        
    }
}
