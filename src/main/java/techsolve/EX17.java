package techsolve;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

public class EX17 {
    public static void main(String[] args) throws IOException {
        ArrayList<Usuario> uList = new ArrayList<Usuario>();
        Scanner in;
        boolean continuar = true;
        StringBuilder logBuild = new StringBuilder("---- CADASTRO DE USUARIOS ----\nUsuarios:\n");
        
        do {
            String nome = null;
            do {
                System.out.printf("Nome do %s. usuario: ", uList.size() + 1);
                in = new Scanner(System.in);
                String str = in.nextLine().trim();
                if (str.isEmpty()) {
                    System.out.println("Nome nao pode ser vazio. Tente novamente.");
                } else {
                    nome = str;
                    break;
                }
            } while (nome == null);
            
            int idade = -1;
            do {
               System.out.print("Idade: ");
                in = new Scanner(System.in);
                int entrada = in.nextInt();
                if (entrada < 0) {
                    System.out.println("Idade nao pode ser inferior a zero. Tente novamente.");
                } else {
                    idade = entrada;
                    break;
                }
            } while (idade == -1);
            
            String email = null;
            do {
                System.out.print("Email do usuario: ");
                in = new Scanner(System.in);
                String str = in.nextLine().trim();
                if (str.isEmpty()) {
                    System.out.println("Email nao pode ser vazio. Tente novamente.");
                } else {
                    email = str;
                    break;
                }
            } while (email == null);
            
            Usuario novo = new Usuario(idade, nome, email);
            System.out.println("\nUsuário cadastrado!\n");
            logBuild.append("  ")
                    .append(novo)
                    .append("\n");
            uList.add(novo);
            
            char escolha;
            do {
                System.out.print("Deseja continuar a cadastrar usuarios?\nSim ou Nao >>> ");
                in = new Scanner(System.in);
                escolha = Character.toUpperCase(in.next().trim().charAt(0));
                
                if (escolha == 'S') {
                    break;
                } else if (escolha == 'N') {
                    continuar = false;
                    break;
                } else {
                    System.out.println("Escolha invalida. Tente novamente.");
                    escolha = '\0';
                }
            } while (escolha == '\0');
            System.out.println("");
        } while(continuar);
        
        logBuild.append(String.format("Quantidade: %d", uList.size()));
        String log = logBuild.toString();
        System.out.printf("Cadastro finalizado!\n\n%s", log);
        
        FileWriter arquivo = new FileWriter("EX17-CADASTRO-USUARIOS.txt");
        PrintWriter impressora = new PrintWriter(arquivo);
        impressora.printf(log);
        arquivo.close();
    }
}

class Usuario {
    
    int idade;
    String nome, email;
    
    public Usuario(int idade, String nome, String email) {
        this.idade = idade;
        this.nome = nome;
        this.email = email;
    }
    
    @Override
    public String toString() {
        return String.format("%s, %d anos, %s;", this.nome, this.idade, this.email);
    }
}