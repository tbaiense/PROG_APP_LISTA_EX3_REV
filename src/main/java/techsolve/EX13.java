package techsolve;

import javax.swing.JOptionPane;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EX13 {
    public static String[] nomeProduto;
    public static double[] precoProduto;
    public static int qntProdutos;
    public static int qntCadastrados;
    
    public static void main(String[] args) throws IOException {
        Scanner in;
        
        // Validacao de quantidade
        do {
            System.out.print("Quantos produtos deseja cadastrar: ");
            in = new Scanner(System.in);
            int entrada = in.nextInt();
            
            if (entrada > 0) {
                qntProdutos = entrada;
            } else {
                System.out.println("Quantidade invalida. Tente novamente.");
            }
        } while (qntProdutos == 0);
        
        nomeProduto = new String[qntProdutos];
        precoProduto = new double[qntProdutos];
        
        while (qntCadastrados < qntProdutos) {
            // Definição do nome do produto
            do {
                System.out.printf("Nome do produto num. %d: ", qntCadastrados+1);
                in = new Scanner(System.in);
                String entrada = in.nextLine().trim();
                if (!entrada.isEmpty()) {
                    nomeProduto[qntCadastrados] = entrada;
                } else {
                    System.out.println("Nome nao pode ser vazio. Tente novamente.");
                }
            } while (nomeProduto[qntCadastrados] == null);
            
            do {
                System.out.print("Preco do produto: ");
                in = new Scanner(System.in);
                double entrada = in.nextDouble();
                if (entrada > 0) {
                    precoProduto[qntCadastrados] = entrada;
                } else {
                    System.out.println("Preco do produto deve ser maior que zero. Tente novamente");
                }
            } while (precoProduto[qntCadastrados] == 0);
            qntCadastrados++;
            System.out.println("PRODUTO CADASTRADO!\n");
        }
        
        StringBuilder strProdutos = new StringBuilder(
                String.format("""
                              ---- PRODUTOS CADASTRADOS ----
                              Quantidade: %d
                              Produtos: 
                              """, qntCadastrados));
        
        for (int i = 0; i < qntCadastrados; i++) {
            String strProduto = visualizarProduto(i);
            if (strProduto != null) {
                strProdutos.append(strProduto + "\n");
            }
        }
        String strCadastrados = strProdutos.toString();
        JOptionPane.showMessageDialog(null, strCadastrados, "Produtos cadastrados", JOptionPane.INFORMATION_MESSAGE);
        
        FileWriter arquivo = new FileWriter("EX13-PRODUTOS.txt");
        PrintWriter impressora = new PrintWriter(arquivo);
        impressora.printf(strCadastrados);
        System.out.println("Produtos cadastrados com sucesso!");
        arquivo.close();
    }
    
    public static void cadastrarProduto(String nome, double preco) {
        if (qntCadastrados < qntProdutos) {
            nomeProduto[qntCadastrados] = nome.trim();
            precoProduto[qntCadastrados] = preco;
            qntCadastrados++;
        }
    }
    
    public static String visualizarProduto(int index) {
        if (qntCadastrados > 0 && index >= 0 && index < qntCadastrados) {
            return String.format("  %s (R$ %2.2f)", nomeProduto[index], precoProduto[index]);
        }
        return null;
    }
}
