package mc322.lab03;

public class Animacao {
	
	public Animacao(String Sequencia, AquarioLombriga aquario) {
		int TamanhoSequencia = Sequencia.length();
		
		for (int i=1; i<TamanhoSequencia;i++) {
			char Comando = Sequencia.charAt(i); 
			switch(Comando) {
				case 'C' : 
					System.out.print("Cresce ");
					aquario.Crescer(); 
					break;
				case 'M' :
					System.out.print("Move   ");
					aquario.Mover(); 
					break;
				case 'V' :  
					System.out.print("Vira   ");
					aquario.Virar(); 
					break;
			
			}
		} 
	}
}
