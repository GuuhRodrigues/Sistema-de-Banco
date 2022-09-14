import java.util.Scanner;

public class AlgBanco {
	public static void main (String [] args){
		Scanner s = new Scanner (System.in);
		double saldoTT, saldoCC, saldoCP, valor;
		int op, opAux, cc, cp, ag;
		String nome;

		System.out.println ("BEM VINDO AO BANCO GHM!");
		do {
			System.out.println ("Entre com o seu nome: ");
			nome = s.next();
			System.out.println ("Entre com sua agência, com 4 digitos: ");
			ag = s.nextInt ();
			System.out.println ("Entre com sua Conta Corrente, com 6 digitos: ");
			cc = s.nextInt ();
			System.out.println ("Entre com sua Conta Poupança, com 7 digitos: ");
			cp = s.nextInt ();
			System.out.println ("Entre com o saldo incial da sua conta corrente: ");
			saldoCC = s.nextDouble ();
			System.out.println ("Entre com o saldo incial da sua conta poupança: ");
			saldoCP = s.nextDouble ();
			saldoTT = saldoCP+saldoCC;
			System.out.println ("Confirme seus dados!");
			System.out.println ("Nome: "+nome);
			System.out.println ("Sua Agência: "+ag);
			System.out.println ("Sua Conta Corrente: "+cc);
			System.out.printf ("O salado em sua CC é de: R$ %.2f \n",saldoCC);
			System.out.println ("Sua Conta Poupança: "+cp);
			System.out.printf ("O Saldo em sua CP é de: R$ %.2f \n",saldoCP);
			System.out.println ("");
			System.out.println ("Digite 1 (um) para Confirma ou Digite 2 (dois) para Corrigir.");
			System.out.print ("Opção -> ");
			opAux = s.nextInt ();
			if (opAux<1 || opAux>2){
				System.out.println ("Opção Invalida.");
			}
		} while (opAux!=1);
		do{
			System.out.println ("---------------------------------------");
			System.out.println (nome+" Selecione uma Opção!");
			System.out.println ("  Opção 1 ===== Creditaar");
			System.out.println ("  Opção 2 ===== Debitar");
			System.out.println ("  Opção 3 ===== Transferir");
			System.out.println ("  Opção 4 ===== Consultar Saldo");
			System.out.println ("  Opção 5 ===== Sair");
			System.out.print ("  Opção -> ");
			op = s.nextInt ();

			if (op==1){
				System.out.println ("Em qual conta deseja Creditar?");
				System.out.println ("  Opção 1 ===== Corrente");
				System.out.println ("  Opção 2 ===== Poupança");
				System.out.print ("  Opção -> ");
				opAux = s.nextInt ();
				switch (opAux){
					case 1:
						System.out.println ("Qual valor deseja Creditar?");
						System.out.print ("R$ ");
						valor = s.nextDouble ();
						saldoCC+=valor;
						saldoTT=saldoCC+saldoCP;
						System.out.printf ("O saldo em sua conta corrente é de R$ %.2f \n",saldoCC);
						System.out.println ("Operação Realizada com Sucesso!");
						break;
					case 2:
						System.out.println ("Qual valor deseja Creditar?");
						System.out.print ("R$ ");
						valor = s.nextDouble ();
						saldoCP+=valor;
						System.out.printf ("O saldo em sua conta poupança é de R$ %.2f \n",saldoCP);
						System.out.println ("Operação Realizada com Sucesso!");
						break;
					default:
						System.out.println ("Digite somente 1 ou 2");
				}
			}
			else if (op==2){
				System.out.println ("Em qual conta deseja Debitar/Sacar?");
				System.out.println ("  Opção 1 ===== Corrente");
				System.out.println ("  Opção 2 ===== Poupança");
				System.out.print ("  Opção -> ");
				opAux = s.nextInt ();
				switch (opAux){
					case 1:
						System.out.println ("Qual valor deseja Debitar?");
						System.out.print ("R$ ");
						valor = s.nextDouble ();
						saldoCC-=valor;
						System.out.printf ("O saldo em sua conta corrente é de R$ %.2f \n",saldoCC);
						System.out.println ("Operação Realizada com Sucesso!");
						break;
					case 2:
						System.out.println ("Qual valor deseja Debitar?");
						System.out.print ("R$ ");
						valor = s.nextDouble ();
						saldoCP-=valor;
						if (saldoCP<0){
							System.out.println ("Você não tem saldo suficiente para essa operação, tente um novo valor");
							saldoCP+=valor;
							System.out.printf ("O seu saldo é de R$ %.2f \n",saldoCP);
						}
						else {
							System.out.printf ("O seu saldo é de R$ %.2f \n",saldoCP);
							System.out.println ("Operação Realizada com Sucesso!");
						}
						break;
					default:
						System.out.println ("Digite somente 1 ou 2");
				}
			}
			else if (op==3){
				System.out.println ("Qual tipo de transferência deseja fazer?");
				System.out.println ("  Opção 1 ===== Corrente para Poupança");
				System.out.println ("  Opção 2 ===== Poupança para Corrente");
				System.out.print ("  Opção -> ");
				opAux = s.nextInt ();
				switch (opAux) {
					case 1:
						System.out.println ("Qual valor você deseja transferir da conta "+cc+" para a conta "+cp+"?");
						System.out.print ("R$ ");
						valor = s.nextDouble ();
						saldoCC-=valor;
						saldoCP+=valor;
						System.out.printf ("O saldo em sua conta corrente é de R$ %.2f \n",saldoCC);
						System.out.printf ("O saldo em sua conta poupança é de R$ %.2f \n",saldoCP);
						System.out.println ("Operação Realizada com Sucesso!");
						break;
					case 2:
						System.out.println ("Qual valor você deseja transferir da conta "+cp+" para a conta "+cc+"?");
						System.out.print ("R$ ");
						valor = s.nextDouble ();
						saldoCP-=valor;
						if (saldoCP<0){
							System.out.println ("Você não tem saldo suficiente para essa operação, tente um novo valor");
							saldoCP+=valor;
							System.out.printf ("O seu saldo é de R$ %.2f \n",saldoCP);
						}
						else {
							saldoCC+=valor;
							System.out.printf ("O saldo em sua conta corrente é de R$ %.2f \n",saldoCC);
							System.out.printf ("O saldo em sua conta poupança é de R$ %.2f \n",saldoCP);
							System.out.println ("Operação Realizada com Sucesso!");
						}
						break;
				}
			}
			else if (op==4){
				System.out.println("");
				System.out.printf ("O saldo em sua conta corrente é de R$ %.2f \n",saldoCC);
				System.out.printf ("O saldo em sua conta poupança é de R$ %.2f \n",saldoCP);
				System.out.println("");
				System.out.println ("Operação Realizada com Sucesso!");
			}
			else if (op==5) {
				System.out.println ("Obrigado por escolher trabalhar com o Banco GHM");
			}
			else {
				System.out.println ("Opção Inválida!");
			}
		} while (op!=5);
	}
}