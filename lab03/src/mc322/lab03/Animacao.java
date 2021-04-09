package mc322.lab03;

public class Animacao {
	AquarioLombriga aquario; 
	char Comando;
	
    public Animacao(String Sequencia) {
    	
    	int AA  = Integer.parseInt(Sequencia.substring(0,2));  
    	int LL = Integer.parseInt(Sequencia.substring(2,4));  
    	int PP = Integer.parseInt(Sequencia.substring(4,6)); 
  
        this.aquario = new AquarioLombriga(AA,LL,PP); 
        
        int TamanhoSequencia = Sequencia.length();
        
        for (int i=1; i<TamanhoSequencia;i++) {
        	this.Comando = Sequencia.charAt(i); 
        	this.passo(Comando);
            System.out.println(this.apresenta()); 
        }

    }
    
    public void passo (char Comando) { 
    	
    	switch(Comando) {
    	case 'C' :  
    		this.aquario.crescer(); 
    			break;
    	case 'M' : 
    		this.aquario.mover(); 
    			break;
    	case 'V' :  
    		this.aquario.virar();
    			break;
	            
	            }
	        
    }
    public String apresenta() {
    	this.aquario.Lombriga = this.aquario.apresenta();
    	return(this.aquario.Lombriga);
    }
}
