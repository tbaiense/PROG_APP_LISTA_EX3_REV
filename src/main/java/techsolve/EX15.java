package techsolve;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.IOException;

public class EX15 {
    public static void main(String[] args) throws IOException {
        String resultado;
        int qtdOuvintes; // Quantos ouvintes participarão da pesquisa
        int[] qtdFavGenero;
        
        String[] nomeGeneros = new String[] {
            "Rock",
            "Pop",
            "Jazz",
            "Blues",
            "Hip-hop",
            "Classico"
        };
        qtdFavGenero = new int[nomeGeneros.length];
        
        Scanner in = new Scanner(System.in);       
        // Quantidade de ouvintes participantes
        while(true) {
            System.out.print("Quantos ouvintes participarao da pesquisa?\n>>> ");
            in = new Scanner(System.in);
            qtdOuvintes = in.nextInt();
            if (qtdOuvintes > 0) {
                break;
            } else {
                System.out.println("Nao e possivel incluir essa quantidade de ouvintes participantes. Tente novamente.");
            }
        }
        
        int genEscolhido = 1;
        StringBuilder strRecibo = new StringBuilder(String.format("""
            ----- RESULTADOS DA PESQUISA ------
            Ouvintes intrevistados: %d
            Generos favoritos:                                 
                                                                  """, qtdOuvintes));
        // Passa pelos ouvintes e registra genero favorito
        for (int p = 0; p < qtdOuvintes; p++) {
            System.out.println("\nGENEROS DE MUSICA ---------------");
            for (int i = 0; i < nomeGeneros.length; i++) {
                System.out.printf("%d -- %s \n", (i+1), nomeGeneros[i]);
            }
            System.out.print("\nDigite o codigo do genero favorito\n>>> ");
            in = new Scanner(System.in);
            genEscolhido = in.nextInt();
            
            if (genEscolhido < 0 | genEscolhido > nomeGeneros.length) {
                System.out.println("Genero nao encontrado! Tente novamente.");
                p--;
                continue;
            }
            
            qtdFavGenero[genEscolhido]++;
        }
        
        // Contagem de votos em cada gênero de música
        for(int i = 0; i < nomeGeneros.length; i++) {
            strRecibo.append(String.format("%2d favs.  %s\n",
                qtdFavGenero[i], 
                nomeGeneros[i]));
        
        }
        
        resultado = strRecibo.toString();
        JOptionPane.showMessageDialog(null, resultado, "Resultado da pesquisa", JOptionPane.INFORMATION_MESSAGE);
        FileWriter arquivo = new FileWriter("EX15-PESQUISA-MUSICA.txt");
        PrintWriter impressora = new PrintWriter(arquivo);
        impressora.printf(resultado);
        arquivo.close();
    }
}
