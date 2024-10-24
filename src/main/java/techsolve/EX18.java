package techsolve;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class EX18 {
    public static String[] nomeFuncionario;
    public static double[] salarioFuncionario;
    public static double[] feriasFuncionario;
    public static int qntFuncionarios;
    public static int qntCadastrados;
    
    public static void main(String[] args) throws IOException {
      Scanner in;
        
        // Validacao de quantidade
        do {
            System.out.print("Quantos funcionarios deseja cadastrar: ");
            in = new Scanner(System.in);
            int entrada = in.nextInt();
            
            if (entrada > 0) {
                qntFuncionarios = entrada;
            } else {
                System.out.println("Quantidade invalida. Tente novamente.");
            }
        } while (qntFuncionarios == 0);
        
        nomeFuncionario = new String[qntFuncionarios];
        salarioFuncionario = new double[qntFuncionarios];
        feriasFuncionario = new double[qntFuncionarios];
        
        while (qntCadastrados < qntFuncionarios) {
            // Definição do nome do funcionário
            do {
                System.out.printf("Nome do funcionario num. %d: ", qntCadastrados+1);
                in = new Scanner(System.in);
                String entrada = in.nextLine().trim();
                if (!entrada.isEmpty()) {
                    nomeFuncionario[qntCadastrados] = entrada;
                } else {
                    System.out.println("Nome nao pode ser vazio. Tente novamente.");
                }
            } while (nomeFuncionario[qntCadastrados] == null);
            // Definicao de salario e ferias
            do {
                System.out.print("Salario do funcionario: ");
                in = new Scanner(System.in);
                double entrada = in.nextDouble();
                if (entrada > 0) {
                    salarioFuncionario[qntCadastrados] = entrada;
                    feriasFuncionario[qntCadastrados] = entrada + (entrada / 3);;
                } else {
                    System.out.println("Salario do funcionario deve ser maior que zero. Tente novamente");
                }
            } while (salarioFuncionario[qntCadastrados] == 0);
            qntCadastrados++;
            System.out.println("FUNCIONARIO CADASTRADO!\n");
        }
        
        // Registro de informações cadastradas
        StringBuilder strInformacoes = new StringBuilder(
                String.format("""
                              ---- FERIAS DOS FUNCIONARIOS ----
                              Quantidade: %d
                              Valor de ferias: 
                              """, qntCadastrados));
        
        for (int i = 0; i < qntCadastrados; i++) {
            String strFuncionario = visualizarFuncionario(i);
            if (strFuncionario != null) {
                strInformacoes.append(strFuncionario + "\n");
            }
        }
        
        String log = strInformacoes.toString();
        JOptionPane.showMessageDialog(null, log, "Informações de férias", JOptionPane.INFORMATION_MESSAGE);
        FileWriter arquivo = new FileWriter("EX18-FERIAS-FUNCIONARIOS.txt");
        PrintWriter impressora = new PrintWriter(arquivo);
        impressora.printf(log);
        
        System.out.println("Ferias calculada com sucesso!");
        arquivo.close();
    }
    
    public static int procurarFuncionario(String nome) {       
        for (int i = 0; i < qntCadastrados; i++) {
            if (nomeFuncionario[i].equalsIgnoreCase(nome)) {
                return i;
            }
        }
        return -1;
    }
    
    public static String visualizarFuncionario(int index) {
        if (qntCadastrados > 0 && index >= 0 && index < qntCadastrados) {
            return String.format("   %s (ferias = R$ %2.2f)", nomeFuncionario[index], feriasFuncionario[index]);
        }
        return null;
    }
}
