package pack01;
import java.util.Random;

public class Desafio4 {

	public static void main(String[] args) {
		// gerando salário
		Random rand = new Random();
		int Somador_do_salario;
		double Salario[] = new double[51];
		double media_salarial = 0;
		int Salario_Alto = 0;

		for (int i=1; i<=50; i++){
		    Somador_do_salario = rand.nextInt(12500);
		    Salario[i] = Somador_do_salario + 2500;  
		}

		//calcula média salarial 
		for (int i=1; i<=50; i++){
		    media_salarial += Salario[i];
		}
		media_salarial = media_salarial/(double)50;

		System.out.println("A Média Salarial é: R$ "+ media_salarial);


		//Verifica salarios acima da média 
		for (int i=1; i<=50; i++){
		    if (Salario[i]>media_salarial){
		        Salario_Alto++; 
		    }
		}
		System.out.println(Salario_Alto + " Funcionários ganham acima da média." );
	}

}
