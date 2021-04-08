// Erica Yuri Nunes de Oliveira 
// RA 196486 
// MC 322 1S 2021 

package pack01;

public class Emprestimo {
	   double S; //Valor da parcela
	   int P_Atual; //numero da parcela atual
	   int N;    //Numero de parcelas 
	   double J;   // Percentual de juros
	   int Ordem; // numero do emprestimo
	   
	   public Emprestimo(double S,int N,double J,int Ordem) {
		   this.S = S;
		   this.N = N;
		   this.J = J;
		   this.P_Atual = 1;
		   this.Ordem = Ordem;
	   }
	   
	   public void ProximaParcela () {
		  
		   if (P_Atual <= N ) {
			   System.out.printf( "Emprestimo %d : Parcela %d eh R$ %.2f \n",Ordem,P_Atual, S);
			   S = S*(1+(J/100));
			   P_Atual++;
			   } 
	   }
	
	public static void main(String[] args) {
		
		Emprestimo emprestimo1 = new Emprestimo (200,5,1,1);
		Emprestimo emprestimo2 = new Emprestimo (500,7,2,2);
		Emprestimo emprestimo3 = new Emprestimo (800,10,2,3);
		
		do {
		emprestimo1.ProximaParcela();
		emprestimo2.ProximaParcela();
		emprestimo3.ProximaParcela();
		
		}while (emprestimo1.P_Atual <= emprestimo1.N || 
				emprestimo2.P_Atual <= emprestimo2.N || 
				emprestimo3.P_Atual <= emprestimo3.N );
		
	}
}

