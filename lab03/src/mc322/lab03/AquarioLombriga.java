package mc322.lab03;

public class AquarioLombriga {
	
    int TamanhoLombriga;
    int TamanhoAquario;
    int PosicaoLombriga;
    boolean Lado; // Lado Direito = true, Lado Esquerdo = false;
    String Lombriga="";
    
    public AquarioLombriga (int TamanhoAquario, int TamanhoLombriga, int PosicaoLombriga) { //construtor
    	
    	if(TamanhoAquario<TamanhoLombriga)
    		TamanhoAquario=TamanhoLombriga;
    	
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
        	if(this.Lado)
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
}
