package mc322.lab04;

public class Coordenada {

	int coluna, linha; 
	
	public Coordenada (String s) {
		  

	    switch( s.substring(0,1) ){
	      case "a" : coluna = 1; break;
	      case "b" : coluna = 2; break;
	      case "c" : coluna = 3; break;
	      case "d" : coluna = 4; break;
	      case "e" : coluna = 5; break;
	      case "f" : coluna = 6; break;
	      case "g" : coluna = 7; break;
	    }
	    
	    linha = Integer.parseInt(s.substring(1,2));  
	}

}
