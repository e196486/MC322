package mc322.lab05;

public class Tabuleiro {
	Peca tabuleiro[][] = new Peca[10][10];
	Coordenada Csource;
	Coordenada Ctarget;
	boolean erro = false;

	public void inserePeca(int x, int y, char c) {
		Peca pc = null;
		if (y <= 9 && x < 9) {
			pc = new PecaPeao(x, y);
			tabuleiro[x][y] = pc;
			pc.P = c;
		}
	}

	public void setTabuleiro() {
		for (int i = 0; i < 3; i++) {
			for (int j = 1; j <= 9; j++) {
				if ((j % 2 == 0 && i % 2 == 0) || (j % 2 != 0 && i % 2 != 0)) {
					inserePeca(i + 1, j, '-');
				} else {
					inserePeca(i + 1, j, 'b');
				}
			}
			inserePeca(i + 1, 9, '\n');
		}
		for (int i = 3; i < 5; i++) {
			for (int j = 1; j <= 9; j++) {
				inserePeca(i + 1, j, '-');
			}
			inserePeca(i + 1, 9, '\n');
		}
		for (int i = 6; i <= 8; i++) {
			for (int j = 1; j <= 9; j++) {
				if ((j % 2 == 0 && i % 2 != 0) || (j % 2 != 0 && i % 2 == 0)) {
					inserePeca(i, j, '-');
				} else {
					inserePeca(i, j, 'p');
				}
			}
			inserePeca(i, 9, '\n');
		}
	}

	public void exportarArquivo(String saida) {
		CSVHandling hand = new CSVHandling();
		hand.setDataExport(saida);
		
		String ultimo[] = new String[64];
		String errado[] = new String[1];
		int count = 0;
		
		if (erro == false) {		
			for (int i = 1; i < 9; i++) {
				for (int j = 1; j < 9; j++) {
					ultimo[count] = tabuleiro[j][i].leitura();
					count++;
				}
			}
			hand.exportState(ultimo);
		} else {
			errado[0] = "erro";
			hand.exportState(errado);
		}	
	}

	public String imprimirTabuleiro() {
		String EstadoTabuleiro = "";

		for (int i = 8; i > 0; i--) {
			EstadoTabuleiro += i;
			for (int j = 1; j <= 9; j++) {
				
				EstadoTabuleiro += " " + tabuleiro[i][j].P;
			}

		}
		EstadoTabuleiro += "  a b c d e f g h \n";

		return (EstadoTabuleiro);

	}

	public void CapturaOponente(Coordenada Inimigo[]) {

		for (int i = 0; Inimigo[i] != null; i++) {
			
			tabuleiro[Inimigo[i].linha][Inimigo[i].coluna].P = '-';
		}
		// se meu oponente for inimigo , eu excluo ele.
	}

	public boolean RegraDama(Peca Peca) {
		return ((Peca.P == 'p' && Peca.coordenada.linha == 1) || (Peca.P == 'b' && Peca.coordenada.linha == 8));
	}

	public Peca CriaDama(Peca Peca) {
		char cor = Peca.P;

		Peca pDama = new PecaDama(Peca.coordenada.linha, Peca.coordenada.coluna);

		tabuleiro[Peca.coordenada.linha][Peca.coordenada.coluna] = pDama;

		if (cor == 'p' || cor == 'P')
			pDama.P = 'P';
		if (cor == 'b' || cor == 'B')
			pDama.P = 'B';

		return (pDama);
	}

	public void solicitaMovimento(String Movimento) {

		// separa a String em duas coordenadas

		String Source = Movimento.substring(0, 2);
		String Target = Movimento.substring(3, 5);

		Csource = new Coordenada(Source);
		Ctarget = new Coordenada(Target);

		Peca PecaSource = tabuleiro[Csource.linha][Csource.coluna];
		Peca PecaTarget = tabuleiro[Ctarget.linha][Ctarget.coluna];

		Trajetoria trajeto = new Trajetoria(PecaSource);

		trajeto = TraduzMovimento(PecaSource, Ctarget);

		if (trajeto.Caminho != "" && PecaSource.TestaPeca(trajeto).Possivel) {
			if (trajeto.PosicaoInimigo[0] != null)
				CapturaOponente(trajeto.PosicaoInimigo);

			PecaTarget.P = PecaSource.P;
			PecaSource.P = '-';
		}

		if (RegraDama(PecaTarget))
			PecaTarget = CriaDama(PecaTarget);

		if (PecaSource.TipodePeca() == "Dama" && trajeto.Possivel == true) {
			PecaTarget = CriaDama(PecaTarget);
			inserePeca(PecaSource.coordenada.linha, PecaSource.coordenada.coluna, PecaSource.P);
		}
		if (trajeto.Possivel == false)
			erro = true;
	}

	public Trajetoria TraduzMovimento(Peca peca, Coordenada Ctarget) {
		Trajetoria trajeto = new Trajetoria(peca);
		String Caminho = "";
		Coordenada cAux = new Coordenada(null);

		cAux.linha = peca.coordenada.linha;
		cAux.coluna = peca.coordenada.coluna;

		if ((peca.coordenada.linha < Ctarget.linha) && (peca.coordenada.coluna < Ctarget.coluna)) { // caminho Nordeste
			trajeto.Direcao = "Nordeste";
			while ((cAux.linha <= Ctarget.linha) && (cAux.coluna <= Ctarget.coluna)) {
				Caminho += tabuleiro[cAux.linha][cAux.coluna].P;
				cAux.linha++;
				cAux.coluna++;
			}

		}
		if ((peca.coordenada.linha < Ctarget.linha) && (peca.coordenada.coluna > Ctarget.coluna)) { // caminho Noroeste
			trajeto.Direcao = "Noroeste";
			while ((cAux.linha <= Ctarget.linha) && (cAux.coluna >= Ctarget.coluna)) {
				Caminho += tabuleiro[cAux.linha][cAux.coluna].P;
				cAux.linha++;
				cAux.coluna--;
			}
		}
		if ((peca.coordenada.linha > Ctarget.linha) && (peca.coordenada.coluna < Ctarget.coluna)) { // caminho Sudeste
			trajeto.Direcao = "Sudeste_";
			while ((cAux.linha >= Ctarget.linha) && (cAux.coluna <= Ctarget.coluna)) {
				Caminho += tabuleiro[cAux.linha][cAux.coluna].P;
				cAux.linha--;
				cAux.coluna++;
			}
		}
		if (((peca.coordenada.linha > Ctarget.linha) && (peca.coordenada.coluna > Ctarget.coluna))) { // caminho
																										// Sudoeste
			trajeto.Direcao = "Sudoeste";
			while (((cAux.linha >= Ctarget.linha) && (cAux.coluna >= Ctarget.coluna))) {
				Caminho += tabuleiro[cAux.linha][cAux.coluna].P;
				cAux.linha--;
				cAux.coluna--;
			}
		}
		if (Caminho == "")
			erro = true;
		trajeto.Caminho = Caminho;
		return trajeto;
	}
}