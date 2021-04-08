package pack01;

public class Desafio1Parte2 {
		  
	public static double Proxima_Parcela(double S){
	         S *= (1.01);
	         return(S); 
	 }
	     
	public static void main(String[] args) {
		double S = 200.00; 
		
		for (int cont = 1; cont <= 5; cont++){
		    System.out.printf( "O Valor da Parcela %d eh : R$ %.2f \n",cont, S);
		    S = Proxima_Parcela(S);
		}
	}

}
