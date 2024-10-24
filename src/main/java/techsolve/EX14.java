package techsolve;

import javax.swing.JOptionPane;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EX14 {
    public static String[] nomeFuncionario;
    public static double[] salarioFuncionario;
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
            
            do {
                System.out.print("Salario do funcionario: ");
                in = new Scanner(System.in);
                double entrada = in.nextDouble();
                if (entrada > 0) {
                    salarioFuncionario[qntCadastrados] = entrada;
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
                              ---- FUNCIONARIO CADASTRADOS ----
                              Quantidade: %d
                              Funcionarios: 
                              """, qntCadastrados));
        
        for (int i = 0; i < qntCadastrados; i++) {
            String strFuncionario = visualizarFuncionario(i);
            if (strFuncionario != null) {
                strInformacoes.append(strFuncionario + "\n");
            }
        }
        
        // Controle de alteração de salários
        boolean alterar;
        while (true) {
            System.out.print("Deseja alterar o salario de algum funcionario?\nSim ou Nao >>> ");
            in = new Scanner(System.in);
            char entrada = Character.toUpperCase(in.next().charAt(0));
            
            if (entrada == 'S') {
                alterar = true;
                break;
            } else if (entrada == 'N') {
                alterar = false;
                break;
            } else {
                System.out.println("Escolha invalida. Tente novamente.");
            }
        }
        if (alterar) {
            strInformacoes.append("Alteracoes:\n");
            boolean continuar = true;
            
            // Definição do funcionário e novo salário
            do {
                System.out.print("Digite o nome do funcionario que deseja alterar o salario\n>>> ");
                in = new Scanner(System.in);
                String strNome = in.nextLine().trim();

                if (strNome.isEmpty()) {
                    System.out.println("Nome nao pode ser vazio. Tente novamente.");
                    continue;
                }
                int indexSalAlterar; // Qual index sofrerá a alteração de salário
                indexSalAlterar = procurarFuncionario(strNome);
                if (indexSalAlterar == -1) {
                    System.out.println("Nao foi encontrado um funcionario com o nome informado. Tente novamente.");
                    continue;
                }

                double novoSalario = 0;
                // Recebimento do novo salário
                do {
                    System.out.printf("Funcionario %s\nDigite o novo salario: ", visualizarFuncionario(indexSalAlterar));
                    in = new Scanner(System.in);
                    novoSalario = in.nextDouble();

                    if (!(novoSalario > 0)) {
                        System.out.println("Novo salario deve ser superior a zero. Tente novamente.");
                    }
                } while (novoSalario <= 0);

                int opcao = JOptionPane.showConfirmDialog(
                        null, 
                        String.format(
                                "Deseja alterar o salario do funcionario %s de %1.2f para %1.2f?", 
                                nomeFuncionario[indexSalAlterar], 
                                salarioFuncionario[indexSalAlterar], 
                                novoSalario), "Alteração de salário",
                        JOptionPane.YES_NO_OPTION);

                if (opcao == JOptionPane.YES_OPTION) {
                    definirSalario(indexSalAlterar, novoSalario);

                    strInformacoes.append(
                            String.format("   %s (de %1.2f para %1.2f)\n",
                                nomeFuncionario[indexSalAlterar], 
                                salarioFuncionario[indexSalAlterar], 
                                novoSalario));

                    System.out.println("Salario alterado com sucesso!");
                } else {
                    System.out.println("Alteracao de salario cancelada.");
                }
                while (true) {
                    System.out.print("Continuar a alteracao de salario?\nSim ou Nao >>> ");
                    in = new Scanner(System.in);
                    char charContinuar = Character.toUpperCase(in.next().charAt(0));
                    if (charContinuar == 'S') {
                        break;
                    } else if (charContinuar == 'N') {
                        continuar = false;
                        break;
                    } else {
                        System.out.println("Opcao invalida. Tente novamente.");
                    }
                }

            } while (continuar);
        }
        
        String log = strInformacoes.toString();
        
        FileWriter arquivo = new FileWriter("EX14-FUNCIONARIOS.txt");
        PrintWriter impressora = new PrintWriter(arquivo);
        impressora.printf(log);
        
        System.out.println("Registro de funcionarios atualizado com sucesso!");
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
    
    public static void definirSalario(int index, double salario) {
        if (index >=0 && index < qntCadastrados && salario > 0) {
            salarioFuncionario[index] = salario;
        }
    }
    
    public static String visualizarFuncionario(int index) {
        if (qntCadastrados > 0 && index >= 0 && index < qntCadastrados) {
            return String.format("   %s (R$ %2.2f)", nomeFuncionario[index], salarioFuncionario[index]);
        }
        return null;
    }
}
