package techsolve;

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.io.PrintWriter;

public class EX9 {
    public static void main(String[] args) throws IOException {
        String nomeCliente, recibo;
        int qtdProdutosCliente; // Quantos produtos ele irá inserir no pedido
        int[] qtdProdutoCliente;
        int[] idProdutoCliente;
        double valorPedido = 0;
        
        String[] nomeProdutos = new String[] {
            "Coxinha",
            "Hamburgeer",
            "Sorvete",
            "Refrigerante",
            "Suco"
        };
        
        double[] precoProdutos = new double[] {
            5.25,
            25.0,
            4.80,
            4.5,
            7.99
        };
        
        Scanner in = new Scanner(System.in);
        System.out.print("Nome do cliente: ");
        nomeCliente = in.nextLine();
        
        // Quantidade de produtos no pedido
        while(true) {
            System.out.printf("Quantos produtos deseja pedir? (maximo %d)\n>>> ", nomeProdutos.length);
            in = new Scanner(System.in);
            qtdProdutosCliente = in.nextInt();
            if (qtdProdutosCliente < nomeProdutos.length && qtdProdutosCliente > 0) {
                qtdProdutoCliente = new int[qtdProdutosCliente];
                idProdutoCliente = new int[qtdProdutosCliente];
                break;
            } else {
                System.out.println("Nao e possivel incluir essa quantidade de produtos no pedido. Tente novamente.");
            }
        }
        
        int produtoEscolhido = 1;
        StringBuilder strRecibo = new StringBuilder(String.format("""
            ----- RECIBO DE COMPRA ------
            Cliente: %s
            Produtos:                                 
                                                                  """, nomeCliente));
        
        for (int p = 0; p < qtdProdutosCliente; p++) {
            System.out.println("PRODUTOS DISPONIVEIS ---------------");
            for (int i = 0; i < nomeProdutos.length; i++) {
                System.out.printf("%d -- %s (R$ %2.2f)\n", (i+1), nomeProdutos[i], precoProdutos[i]);
            }
            System.out.print("\nDigite o codigo do produto desejado (ou 0 para sair)\n>>> ");
            in = new Scanner(System.in);
            produtoEscolhido = in.nextInt();
            
            if (produtoEscolhido == 0) {
                produtoEscolhido--; // Decrementa 1 pois produtos começam por 1
                break;
            } else if (produtoEscolhido < 0 | produtoEscolhido > nomeProdutos.length) {
                System.out.println("Produto não encontrado! Tente novamente.");
                p--;
                continue;
            }
            
            idProdutoCliente[p] = produtoEscolhido;
            valorPedido += precoProdutos[produtoEscolhido];
            
            // Validacao de qtd
            while (true) {
                System.out.print("Quantidade do produto: ");
                in = new Scanner(System.in);
                int qtd = in.nextInt();
                
                if (qtd > 0) {
                    qtdProdutoCliente[p] = qtd;
                    System.out.println("");
                    break;
                } else {
                    System.out.println("Quantidade inválida. Tente novamente...");
                }
            }
            
            strRecibo.append(String.format("%2d un.  %s (R$ %2.2f)\n",
                    qtdProdutoCliente[p], 
                    nomeProdutos[produtoEscolhido], 
                    precoProdutos[produtoEscolhido]));
        }
        
        strRecibo.append(String.format("\nPRECO TOTAL: R$ %2.2f", valorPedido));
        recibo = strRecibo.toString();
        JOptionPane.showMessageDialog(null, recibo, "Recibo do pedido", JOptionPane.INFORMATION_MESSAGE);
        FileWriter arquivo = new FileWriter(String.format("C:\\Users\\Public\\EX9-PEDIDO-%s.txt", nomeCliente));
        PrintWriter impressora = new PrintWriter(arquivo);
        impressora.printf(recibo);
        arquivo.close();
    }
}
