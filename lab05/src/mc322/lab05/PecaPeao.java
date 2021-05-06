package mc322.lab05;

public class PecaPeao extends Peca {

	PecaPeao(int x, int y) {

		super(x, y);
	}

	/*
	 * peças comuns se movem uma casa na diagonal para frente somente se a posição
	 * estiver livre e for o seu lance;
	 */
	public Trajetoria TestaPeca(Trajetoria trajeto) {

		String Direcao = trajeto.Direcao;
		String Caminho = trajeto.Caminho;

		char[] posicao = new char[Caminho.length()];

		for (int i = 0; i < Caminho.length(); i++) {
			posicao[i] = Caminho.charAt(i);
		}
		

		if (posicao[0] == 'p') {
			trajeto.TipoPeca = 'p';
			if (Direcao.compareTo("Nordeste") == 0 || Direcao.compareTo("Noroeste") == 0) {
				// come
				if ((posicao[1] == 'b' || posicao[1] == 'B') && posicao[2] == '-' && posicao.length == 3) {
					trajeto.Possivel = true;

					if (Direcao.compareTo("Nordeste") == 0) {
						trajeto.PosicaoInimigo[0] = trajeto.cSource;
						trajeto.PosicaoInimigo[0].linha = trajeto.cSource.linha + 1;
						trajeto.PosicaoInimigo[0].coluna = trajeto.cSource.coluna + 1;

					} else if (Direcao.compareTo("Noroeste") == 0) {
						trajeto.PosicaoInimigo[0] = trajeto.cSource;
						trajeto.PosicaoInimigo[0].linha = trajeto.cSource.linha + 1;
						trajeto.PosicaoInimigo[0].coluna = trajeto.cSource.coluna - 1;

					}

				}
			}
			if (Direcao.compareTo("Sudoeste") == 0 || Direcao.compareTo("Sudeste_") == 0) {
				// anda
				if (posicao[1] == '-' && posicao.length == 2)
					trajeto.Possivel = true;
				
				// come
				if ((posicao[1] == 'b' || posicao[1] == 'B') && posicao[2] == '-' && posicao.length == 3) {
					trajeto.Possivel = true;

					if (Direcao.compareTo("Sudoeste") == 0) {
						trajeto.PosicaoInimigo[0] = trajeto.cSource;
						trajeto.PosicaoInimigo[0].linha = trajeto.cSource.linha - 1;
						trajeto.PosicaoInimigo[0].coluna = trajeto.cSource.coluna - 1;

					} else if (Direcao.compareTo("Sudeste_") == 0) {
						trajeto.PosicaoInimigo[0] = trajeto.cSource;
						trajeto.PosicaoInimigo[0].linha = trajeto.cSource.linha - 1;
						trajeto.PosicaoInimigo[0].coluna = trajeto.cSource.coluna + 1;

					}
				}
			}
		}else if (posicao[0] == 'b') {
			trajeto.TipoPeca = 'b';
			if (Direcao.compareTo("Sudoeste") == 0 || Direcao.compareTo("Sudeste_") == 0) {
				// come
				if ((posicao[1] == 'p' || posicao[1] == 'P') && posicao[2] == '-' && posicao.length == 3) {
					trajeto.Possivel = true;
					
					if (Direcao.compareTo("Sudoeste") == 0) {
						trajeto.PosicaoInimigo[0] = trajeto.cSource;
						trajeto.PosicaoInimigo[0].linha = trajeto.cSource.linha - 1;
						trajeto.PosicaoInimigo[0].coluna = trajeto.cSource.coluna - 1;

					} else if (Direcao.compareTo("Sudeste_") == 0) {
						trajeto.PosicaoInimigo[0] = trajeto.cSource;
						trajeto.PosicaoInimigo[0].linha = trajeto.cSource.linha - 1;
						trajeto.PosicaoInimigo[0].coluna = trajeto.cSource.coluna + 1;

					}
				
				}
			}
			if (Direcao.compareTo("Nordeste") == 0 || Direcao.compareTo("Noroeste") == 0) {
				// anda
				if (posicao[1] == '-' && posicao.length == 2)
					trajeto.Possivel = true;
				// come
				if ((posicao[1] == 'p' || posicao[1] == 'P') && posicao[2] == '-' && posicao.length == 3) {
					trajeto.Possivel = true;
					
					if (Direcao.compareTo("Nordeste") == 0) {
						trajeto.PosicaoInimigo[0] = trajeto.cSource; 
						trajeto.PosicaoInimigo[0].linha = trajeto.cSource.linha + 1;
						trajeto.PosicaoInimigo[0].coluna = trajeto.cSource.coluna + 1;

					} else if (Direcao.compareTo("Noroeste") == 0) {
						trajeto.PosicaoInimigo[0] = trajeto.cSource;
						trajeto.PosicaoInimigo[0].linha = trajeto.cSource.linha + 1;
						trajeto.PosicaoInimigo[0].coluna = trajeto.cSource.coluna - 1;

					}
				}
				
				
			}
		}else {
			System.out.println("Jogada Impossível : a peça solicitada nao é um tipo de Peao.");
		}
		if (!trajeto.Possivel)
			System.out.println("Jogada Impossível: o tabuleiro ou a peça não permite esse movimento.");
		return trajeto;
	}

	public String TipodePeca() {
		return "Peao";
	}
}