package mc322.lab03;

public class AquarioLombriga2 {
	
    int TamanhoLombriga;
    int TamanhoAquario;
    int PosicaoLombriga;
    boolean Lado; // Lado Direito = true, Lado Esquerdo = false;
    String Lombriga="";
    
    public AquarioLombriga2 (int TamanhoAquario, int TamanhoLombriga, int PosicaoLombriga) { //construtor
    	
    	if(TamanhoAquario<TamanhoLombriga)
    		TamanhoLombriga=TamanhoAquario;
    	
    	if(PosicaoLombriga+TamanhoLombriga>TamanhoAquario)
    		PosicaoLombriga = 1;

    	this.TamanhoAquario  =  TamanhoAquario;  
    	this.TamanhoLombriga =  TamanhoLombriga;  
    	this.PosicaoLombriga =  PosicaoLombriga;
    	this.Lado = true; 
       
    	this.Apresenta();
    }
    public void Crescer(){ //se tem espaço, cresce na direção oposta a cabeça
        if (TamanhoLombriga<TamanhoAquario) {
        	this.TamanhoLombriga++;
        	this.PosicaoLombriga--;
        }
    	this.Apresenta();
    }
    
    public void  Mover() { //Vai para o lado da cabeça se tiver espaço 
    	if(this.Lado && (PosicaoLombriga+TamanhoLombriga) <= TamanhoAquario ) {
    		PosicaoLombriga ++;
    		
    	}else if (!this.Lado && PosicaoLombriga>1) {
    		PosicaoLombriga --;
    	}
    	
    	this.Apresenta();
    }
    
    public void  Virar() { //Vira de lado
    	if(this.Lado) {
    		this.Lado = false;
    	}else {
    		this.Lado = true;
    	}
    	this.Apresenta();
    }
    
    public void Apresenta() { // retorna uma String contendo a apresentação da lombriga no aquário no estado atual,
    	int i;
    	this.Lombriga ="";
    	
        for(i=1; i<this.PosicaoLombriga ; i++) {
        	this.Lombriga = Lombriga.concat("#");
        } 
        
        if(this.Lado) {
        	
	        for(i=1; i<(this.TamanhoLombriga) ; i++) {
	        	this.Lombriga = Lombriga.concat("@");
	        }
	        this.Lombriga = Lombriga.concat("O"); 
	        
        }else if(!this.Lado) {
        	
        	 this.Lombriga = Lombriga.concat("O");
        	 
        	 for(i=1; i<(this.TamanhoLombriga) ; i++) {
             	this.Lombriga = Lombriga.concat("@");
             }
        	 
        }
        for(i= (this.PosicaoLombriga + this.TamanhoLombriga); i<= this.TamanhoAquario ; i++) {
        	this.Lombriga = Lombriga.concat("#");
        }  
        
        System.out.println(">>A lombriga fica:  < "+ this.Lombriga+" >");   
    	   
    	
    }
    
    
    public static void main(String[] args) {
    	char Comando;
    	String Sequencia="080403MCMVMMMM";   // ##@@@O##
    	int TamanhoSequencia = Sequencia.length();
    	
    	int TamanhoAquario  = Integer.parseInt(Sequencia.substring(0,2));  
    	int TamanhoLombriga = Integer.parseInt(Sequencia.substring(2,4));  
    	int PosicaoLombriga = Integer.parseInt(Sequencia.substring(4,6)); 
    
    	
        System.out.println("Tamanho da lombriga: " + TamanhoLombriga);
        System.out.println("Tamanho do Aquario: " + TamanhoAquario);
        System.out.println("Posição da Lombriga " + PosicaoLombriga );
        System.out.println("TamanhoSequencia " + TamanhoSequencia );
    	
    	AquarioLombriga2 aquario1 = new AquarioLombriga2(TamanhoAquario, TamanhoLombriga, PosicaoLombriga); 
    	
    	
    	for (int i=6; i<TamanhoSequencia;i++) {
    		Comando = Sequencia.charAt(i); 
    		switch(Comando) {
    			case 'C' : 
    				System.out.print("Cresce ");
    				aquario1.Crescer(); 
    				break;
    			case 'M' :
    				System.out.print("Move   ");
    				aquario1.Mover(); 
    				break;
    			case 'V' :  
    				System.out.print("Vira   ");
    				aquario1.Virar(); 
    				break;
    		
    		}
    	}    	
    }
}
