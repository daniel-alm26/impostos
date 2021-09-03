package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Contribuinte;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Contribuinte> list = new ArrayList<>();
	
		/*
		 * A informação colocada aqui nos dará, dependendo se você selecionar 
		 * f (Pessoa Fisica) ou j (Pessoa Juridica), o cálculo do imposto sobre 
		 * os rendimentos anuais de cada tipo de Contribuinte. No final o programa
		 * nos passará quanto foi descontado de imposto de cada Pessoa Fisica e/ou
		 * Jurídica e o Total de todos os impostos somados.
		 */
		System.out.print("Entre com o número de contribuintes: ");
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.println("Dados do Contribuinte #" + i);
			System.out.print("Pessoa Fisica ou Pessoa Jurudica (f/j)? ");
			char ch = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			System.out.print("Renda Anual: ");
			double rendaAnual = sc.nextDouble();
			if (ch == 'f') {
				System.out.print("Gastos com Saúde: ");
				double gastosSaude = sc.nextDouble();
				list.add(new PessoaFisica(nome, rendaAnual, gastosSaude));
			}
			else {
				System.out.print("Número de Funcionários: ");
				int numFunc = sc.nextInt();
				list.add(new PessoaJuridica(nome, rendaAnual, numFunc));
			}
		}
		
		System.out.println();
		System.out.println("IMPOSTOS PAGOS:");
		for (Contribuinte contribuinte : list) {
			System.out.printf("%s: $ %.2f%n", contribuinte.getNome(), contribuinte.taxa());			
		}
		double soma = 0.0;
		System.out.println();
		for (Contribuinte contribuinte : list) {
			soma += contribuinte.taxa();			
		}	
		System.out.printf("TOTAL DE IMPOSTOS: $ %.2f", soma);
		
		sc.close();
	}
}
