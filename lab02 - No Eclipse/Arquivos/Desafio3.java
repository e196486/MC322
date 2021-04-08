package pack01;

public class Desafio3 {

	public static void main(String[] args) {
		String DNA = "ATTACGCGCAAAC"; 
		int Tamanho= DNA.length() ;
		String RNA = "";

		for (int i=0; i<Tamanho;i++){
		    
		    char DNA_CHAR = DNA.charAt(i);
		    
		    switch (DNA_CHAR) {
		        case 'A' : RNA += 'U'; break;
		        case 'T' : RNA += 'A'; break;
		        case 'G' : RNA += 'C'; break;
		        case 'C' : RNA += 'G'; break; 
		        default: RNA += '?';
		    }
		}

		System.out.println("Codificando a cadeia de RNA temos: "+ RNA);
	}

}
