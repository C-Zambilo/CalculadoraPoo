package programa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import classes.Multiplicacao;
import classes.Soma;
import classes.Subtracao;
import classes.Divisao;


public class ExemploPrograma {	
	
	public static void main(String args[]) {
				
		Integer opc = 0;
		do {
			opc = menu();
			ArrayList<Double> entrada = menuEntradaDados();
			
			switch (opc) {
			case 1:
				Double data_soma[] = new Double[entrada.size()];
				
				for (int i = 0; i < entrada.size(); i++) {
					data_soma[i] = entrada.get(i);
				}
				
				System.out.println(verificaTipoEntrada(data));				
				
				Soma s = new Soma();
				System.out.println(s.calcula(data_soma));
				
				break;
			case 2:
				Double data_sub[] = new Double[entrada.size()];
				
				for (int i = 0; i < entrada.size(); i++) {
					data_sub[i] = entrada.get(i);
				}
				
				System.out.println(verificaTipoEntrada(data_sub));				
				
				Subtracao sub = new Subtracao();
				System.out.println(s.calcula(data_sub));
				break;
			case 3:
				Double data_mul[] = new Double[entrada.size()];
				
				for (int i = 0; i < entrada.size(); i++) {
					data_mul[i] = entrada.get(i);
				}
				
				System.out.println(verificaTipoEntrada(data_mul));				
				
				Multiplicacao m = new Multiplicacao();
				System.out.println(s.calcula(data_mul));
				break;
			case 4:
				Double data_div[] = new Double[entrada.size()];
				
				for (int i = 0; i < entrada.size(); i++) {
					data_div[i] = entrada.get(i);
				}
				
				System.out.println(verificaTipoEntrada(data_div));				
				
				Divisao d = new Divisao();
				System.out.println(s.calcula(data_div));
				break;
			default:
				System.out.println("Finalizando...");
				System.exit(0);
				break;
			}
		} while (opc != 0);
			
		
	}
	
	public static Integer menu() {
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		sb.append(" CALCULADORA POO \n");
		sb.append("Digite 1 para SOMA \n");
		sb.append("Digite 2 para SUBTRAÇÃO \n");
		sb.append("Digite 3 para DIVISÃO \n");
		sb.append("Digite 4 para MULTIPLICAÇÃO \n");
		sb.append("Digite 0 para encerrar \n");
		
		System.out.println(sb.toString());
		Integer opc = scan.nextInt();
		return opc;
	}
	
	public static ArrayList<Double> menuEntradaDados() {
		ArrayList<Double> entrada = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		sb.append("Insercao de Dados\n");
		
		Integer usuarioQuerContinuar = 0;
		do {			
			System.out.println("Digite o número:");
			if (scan.hasNextDouble()) {
				entrada.add(scan.nextDouble());
			}			
			if (entrada.size() >= 2) {
				System.out.println("Você deseja iserir mais número? [0 - SIM | 1 - NÃO]");
				usuarioQuerContinuar = scan.nextInt();
			}
			
		} while (entrada.size() < 2 || usuarioQuerContinuar == 0);
	
		return entrada;
	}
	
	public static String verificaTipoEntrada(Double[] entrada) {

		Integer numeroEntradaInteiros = 0;
		Integer numeroEntradaFloat = 0;
		Integer numeroEntradaDouble = 0;
		for (int i = 0; i < entrada.length; i++) {
			
			double n = entrada[i];
			
			if ((int) n == n) {
				numeroEntradaInteiros++;
			} else if (Double.toString(n).split("\\.")[1].length() < 7) {
				numeroEntradaFloat++;
			} else {
				numeroEntradaDouble++;
			}			
		}
		
		if (numeroEntradaInteiros > 0 && numeroEntradaFloat == 0 && numeroEntradaDouble == 0) {
			return "inteiro";
		}
		
		if ((numeroEntradaInteiros > 0 || numeroEntradaInteiros == 0) && numeroEntradaFloat > 0 && numeroEntradaDouble == 0) {
			return "float";
		}
		
		return "double";
	}
}

