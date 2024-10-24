package techsolve;

import java.util.Scanner;

/** Considerei como 19 por estar com numero repetido.
 * 18 - Cálculo do Salário Líquido com Descontos
 * @author thiago
 */
public class EX19 {
    public static void main(String[] args) {
        int horasMes;
        double salHr, salLiq, salBruto, inss, sindicato, ir;
        final double TX_INSS = 0.08;
        final double TX_IR = 0.11;
        final double TX_SINDICATO = 0.05;
        
        Scanner in;
        
        System.out.print("Digite o valor recebido por hora: R$ ");
        in = new Scanner(System.in);
        salHr = in.nextDouble();
        
        System.out.print("Digite quantas horas de trabalho por mes: ");
        in = new Scanner(System.in);
        horasMes = in.nextInt();
        
        salBruto = salHr * horasMes;
        ir = salBruto * TX_IR;
        inss = salBruto * TX_INSS;
        sindicato = salBruto * TX_SINDICATO;
        salLiq = salBruto - ir - inss - sindicato;
        
        System.out.printf("""
            + Salário Bruto: R$ %1.2f
            - Imposto de Renda (%d%%): R$ %1.2f
            - INSS (%d%%): R$ %1.2f
            - Sindicato (%d%%): R$ %1.2f
            = Salário Líquido: R$ %1.2f
                          """, salBruto, (int)(TX_IR * 100), ir, (int)(TX_INSS * 100), inss, (int)(TX_SINDICATO * 100), sindicato, salLiq);
    }
}
