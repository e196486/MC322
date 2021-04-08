package pack01;
import java.util.Random;

public class Desafio2 {

	public static void main(String[] args) {
		// gerando números aleatórios
		Random rand = new Random();
		int n_sorteado = rand.nextInt(10000);
		System.out.println("Numero Sorteado: " + n_sorteado); 

		//convertendo para numero binario 
		int numeros[] = new int[50];
		int i,n;

		for(i=0; (n_sorteado)>=2; i++)  { 
		    numeros[i] = n_sorteado%2;
		    n_sorteado *= 0.5;

		    if (n_sorteado<2){
		        numeros[i+1] = n_sorteado;
		    }
		}

		    System.out.print("A conversão para binário é: ");
		for (n = i; n >= 0; n--)
		    System.out.print(numeros[n]);
	}

}
