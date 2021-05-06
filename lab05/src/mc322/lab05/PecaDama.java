package mc322.lab05;

public class PecaDama extends Peca {

	public PecaDama(int x, int y) {
		super(x, y);
	}

	/*
	 * damas se movem qualquer número de casas na diagonal para frente ou para trás,
	 * contanto que a diagonal esteja desimpedida e seja o seu lance.
	 */

	public Trajetoria TestaPeca(Trajetoria trajeto) {
		char inimigoDama =' ';
		char inimigoPeao =' ';
		int i;
 
		String Direcao = trajeto.Direcao;
		String Caminho = trajeto.Caminho;

		char[] posicao = new char[Caminho.length()];

		for ( i = 0; i < Caminho.length(); i++) {
			posicao[i] = Caminho.charAt(i);
		}
		
		trajeto.TipoPeca = posicao[0];
		
		if (trajeto.TipoPeca =='P') {
			inimigoDama = 'B';
			inimigoPeao = 'b';
		}else if (trajeto.TipoPeca == 'B') {
			inimigoDama = 'P';
			inimigoPeao = 'p';
		}
		
			
				// anda
			trajeto.Possivel = true;
			for (i=1; (i < posicao.length); i++) 
					trajeto.Possivel = (posicao[i] == '-');
			
				// come 
			if (posicao[posicao.length - 1 ] == '-'  && (posicao[posicao.length -2] == inimigoPeao || posicao[posicao.length -2] == inimigoDama) ) {
				trajeto.Possivel = true;
				for (i= (posicao.length - 3) ; i > 1; i-- ) 
					trajeto.Possivel = (posicao[i] == '-');
				
				if (trajeto.Possivel) {
				if (Direcao.compareTo("Sudoeste") == 0) {
					trajeto.PosicaoInimigo[0] = trajeto.cSource;
					trajeto.PosicaoInimigo[0].linha = trajeto.cSource.linha - (posicao.length - 2);
					trajeto.PosicaoInimigo[0].coluna = trajeto.cSource.coluna - (posicao.length - 2);

				} else if (Direcao.compareTo("Sudeste_") == 0) {
					trajeto.PosicaoInimigo[0] = trajeto.cSource;
					trajeto.PosicaoInimigo[0].linha = trajeto.cSource.linha - (posicao.length - 2);
					trajeto.PosicaoInimigo[0].coluna = trajeto.cSource.coluna + (posicao.length - 2);

				}else if (Direcao.compareTo("Nordeste") == 0) {
					trajeto.PosicaoInimigo[0] = trajeto.cSource;
					trajeto.PosicaoInimigo[0].linha = trajeto.cSource.linha + (posicao.length - 2);
					trajeto.PosicaoInimigo[0].coluna = trajeto.cSource.coluna + (posicao.length - 2);

				} else if (Direcao.compareTo("Noroeste") == 0) {
					trajeto.PosicaoInimigo[0] = trajeto.cSource;
					trajeto.PosicaoInimigo[0].linha = trajeto.cSource.linha + (posicao.length - 2);
					trajeto.PosicaoInimigo[0].coluna = trajeto.cSource.coluna - (posicao.length - 2);

				}
			}
				
			}		
			if (!trajeto.Possivel)
				System.out.println("Jogada Impossível: o tabuleiro ou a peça não permite esse movimento.");
		return trajeto;
	}

	public String TipodePeca() {
		return "Dama";
	}
}