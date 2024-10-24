package techsolve;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class EX10 {
    public static void main(String[] args) throws IOException {
        String nomeCliente, resultado;
        int qtdClientes; // Quantos clientes participarão da pesquisa
        int[] qtdFavGenero;
        
        String[] nomeGeneros = new String[] {
            "Acao",
            "Aventura",
            "Comedia",
            "Romance",
            "Suspence",
            "Terror"
        };
        qtdFavGenero = new int[nomeGeneros.length];
        
        Scanner in = new Scanner(System.in);       
        // Quantidade de clientes participantes
        while(true) {
            System.out.print("Quantos clientes participarao da pesquisa?\n>>> ");
            in = new Scanner(System.in);
            qtdClientes = in.nextInt();
            if (qtdClientes > 0) {
                break;
            } else {
                System.out.println("Nao e possivel incluir essa quantidade de clientes participantes. Tente novamente.");
            }
        }
        
        int genEscolhido = 1;
        StringBuilder strRecibo = new StringBuilder(String.format("""
            ----- RESULTADOS DA PESQUISA ------
            Clientes intrevistados: %d
            Generos favoritos:                                 
                                                                  """, qtdClientes));
        // Passa pelos clientes e registra genero favorito
        for (int p = 0; p < qtdClientes; p++) {
            System.out.println("\nGENEROS DE FILME ---------------");
            for (int i = 0; i < nomeGeneros.length; i++) {
                System.out.printf("%d -- %s \n", (i+1), nomeGeneros[i]);
            }
            System.out.printf("\nCliente n.%d, digite o codigo do genero favorito\n>>> ", p+1);
            in = new Scanner(System.in);
            genEscolhido = in.nextInt() - 1;
            
            if (genEscolhido < 0 | genEscolhido >= nomeGeneros.length) {
                System.out.println("Genero não encontrado! Tente novamente.");
                p--;
                continue;
            }
            
            qtdFavGenero[genEscolhido]++;
        }
        
        for(int i = 0; i < nomeGeneros.length; i++) {
            strRecibo.append(String.format("%2d favs.  %s\n",
                qtdFavGenero[i], 
                nomeGeneros[i]));
        
        }
        
        resultado = strRecibo.toString();
        JOptionPane.showMessageDialog(null, resultado, "Resultado da pesquisa", JOptionPane.INFORMATION_MESSAGE);
        FileWriter arquivo = new FileWriter("EX10-PESQUISA-FILME.txt");
        PrintWriter impressora = new PrintWriter(arquivo);
        impressora.printf(resultado);
        arquivo.close();
    }
}
