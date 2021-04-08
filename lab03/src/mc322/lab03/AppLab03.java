package mc322.lab03;

public class AppLab03 {

    public static void main(String[] args) { 
    	
    	String Sequencia="080403MCMVM";   //  
    	
    	int AA  = Integer.parseInt(Sequencia.substring(0,2));  
    	int LL = Integer.parseInt(Sequencia.substring(2,4));  
    	int PP = Integer.parseInt(Sequencia.substring(4,6)); 
 
    	AquarioLombriga aquario1 = new AquarioLombriga(AA,LL,PP); 
    	
    	new Animacao(Sequencia, aquario1);
    	
    }
}
