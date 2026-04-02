package SistemaClinicaOdontologicaPackage;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Sistema sistema = new Sistema();
		Consulta consulta = new Consulta();
		Consulta consultaLista[] = new Consulta[10];
		Agenda agenda = new Agenda();
		
		Scanner input = new Scanner(System.in); //objeto input 
		
		while (1 > 0) {
			//opções da tela principal
			System.out.println("\n\n\n================================================");
			System.out.println("           Opção 1: Marcar Consulta             ");
			System.out.println("           Opção 2: Remarcar Consulta           ");
			System.out.println("           Opção 3: Cancelar Consulta           ");
			System.out.println("           Opção 4: Marcar acompanhamento       ");
			System.out.println("           Opção 5: Remarcar acompanhamento     ");
			System.out.println("           Opção 6: Cancelar acompanhamento     ");
			System.out.println("================================================\n\n");
			//seleção opção usuário
			System.out.println("Digite o número de uma das opções acima: ");
			// fica iterando indefinidamente até um input válido
			while (!input.hasNextInt()) {
			    String inputInvalido = input.next(); // lê e descarta o input inválido
			    System.out.println("\n\n '" + inputInvalido + "' Não é válido. Tente denovo: ");
			}
			int opcao = input.nextInt();
			input.nextLine();
			sistema.interacao(opcao, consulta, sistema, consultaLista, agenda);
		}
	}
}
