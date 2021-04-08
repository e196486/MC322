package mc322.lab03;

public class AppLab03 {

    public static void main(String[] args) { 
    	
    	String Sequencia="080403MCMVMC";   // ##@@@O## 
    	
    	int TamanhoAquario  = Integer.parseInt(Sequencia.substring(0,2));  
    	int TamanhoLombriga = Integer.parseInt(Sequencia.substring(2,4));  
    	int PosicaoLombriga = Integer.parseInt(Sequencia.substring(4,6)); 
    
    	
        System.out.println("Tamanho da lombriga: " + TamanhoLombriga);
        System.out.println("Tamanho do Aquario: " + TamanhoAquario);
        System.out.println("Posição da Lombriga " + PosicaoLombriga ); 
    	
    	AquarioLombriga aquario1 = new AquarioLombriga(TamanhoAquario, TamanhoLombriga, PosicaoLombriga); 
    	
    	new Animacao(Sequencia.substring(6), aquario1);
    	
    }
}
