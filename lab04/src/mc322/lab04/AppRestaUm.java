package mc322.lab04;

public class AppRestaUm {
	
	
	public static String executaJogo (String s ){
		//String s="f4:d4";
		
		//declaro meu jogo aberto 
		Tabuleiro Tabuleiro1 = new Tabuleiro();
		
		Tabuleiro1.movePeca("f4", "d4");
		Tabuleiro1.movePeca("e6", "e4");
		Tabuleiro1.movePeca("c6", "e6");
		Tabuleiro1.movePeca("c4", "c6");
		
		

		return ("vetor de Strings contendo o estado do tabuleiro");
		
	}
	
    public static void main(String[] args) { 
    	
    	 executaJogo(""); 
    	
    }

}
