package mc322.lab04;

public class Tabuleiro {
	//declaro meu tabuleiro
	Peca pc[][] = new Peca[8][8]; 
	int Xsource;
	int Xtarget;
	int Ysource;
	int Ytarget;
	
	public Tabuleiro() {
		//caso base (sem pe�as) 
		
		for (int i=0; i<8; i++) {
			for (int j=0; j<8; j++) {
				pc[i][j] = new Peca("P"); 
			} 
		}

		
		pc[1][1].P = " "; pc[1][2].P = " ";
		pc[2][1].P = " "; pc[2][2].P = " ";
		
		pc[6][1].P = " "; pc[7][1].P = " ";
		pc[6][2].P = " "; pc[7][2].P = " ";
		
		pc[1][6].P = " "; pc[2][6].P = " ";
		pc[1][7].P = " "; pc[2][7].P = " ";
		
		pc[6][6].P = " "; pc[7][6].P = " ";
		pc[6][7].P = " "; pc[7][7].P = " ";
		
		pc[4][4].P = "-";
		
		System.out.println("Tabuleiro Inicial:");
		for (int i=1; i<8; i++) {
			System.out.print(8-i);
			for (int j=1; j<8; j++) { 

				System.out.print(" "+pc[i][j].P); 
			}
			System.out.println(" ");
		}
		System.out.print("  a b c d e f g \n\n");
			
	}
	
	
	public void desenhaTabuleiro() {
		

		System.out.println("Source: "+(char)(Ysource+96)+Xsource); 
		System.out.println("Target: "+(char)(Ytarget+96)+Xtarget); 
		
		for (int i=7; i>0; i--) {
			System.out.print(8-i);
			for (int j=1; j<8; j++) { 

				System.out.print(" "+pc[i][j].P); 
			}
			System.out.println(" ");
		}
		System.out.print("  a b c d e f g \n\n");
			
	}

	
	public void movePeca(String source, String target) { 
				
		
		this.Xsource = new Coordenada(source).linha;
		this.Ysource = new Coordenada(source).coluna;
		
		this.Xtarget = new Coordenada(target).linha;
		this.Ytarget = new Coordenada(target).coluna;
		
		if (Xsource == Xtarget) { //mesma linha
			if (Ysource > Ytarget) { //foi para esquerda
				if(pc[Xsource][Ysource].P == "P" && pc[Xsource][Ysource-1].P == "P" && pc[Xtarget][Ytarget].P == "-") 
					System.out.println("comi pra esquerda"); 
				pc[Xsource][Ysource].P = "-";
				pc[Xsource][Ysource-1].P = "-";
				pc[Xtarget][Ytarget].P = "P";
				
				
			}else if(Ysource < Ytarget) { // foi para direira 
				
				if(pc[Xsource][Ysource].P == "P" && pc[Xsource][Ysource+1].P == "P" && pc[Xtarget][Ytarget].P == "-") 
					System.out.println("comi pra direita"); 
				pc[Xsource][Ysource].P = "-";
				pc[Xsource][Ysource+1].P = "-";
				pc[Xtarget][Ytarget].P = "P";
				
			} 
			
		}
		if (Ysource == Ytarget) { //mesma coluna
			if (Xsource > Xtarget) { //foi para baixo
				if(pc[Xsource][Ysource].P == "P" && pc[Xsource-1][Ysource].P == "P" && pc[Xtarget][Ytarget].P == "-") { 
					System.out.println("comi pra baixo");
					pc[Xsource][Ysource].P = "-";
					pc[Xsource-1][Ysource].P = "-";
					pc[Xtarget][Ytarget].P = "P";
				}
				
				
				
			}else if(Xsource < Xtarget) { // foi para cima
				if(pc[Xsource][Ysource].P == "P" && pc[Xsource+1][Ysource].P == "P" && pc[Xtarget][Ytarget].P == "-") 
					System.out.println("comi pra cima "); 
				pc[Xsource][Ysource].P = "-";
				pc[Xsource+1][Ysource].P = "-";
				pc[Xtarget][Ytarget].P = "P";
				
			} 
		
		
		
	}
		
		System.out.println("Estado do Jogo:");
		desenhaTabuleiro();
}	
}
