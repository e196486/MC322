package mc322.lab05;

public class Trajetoria {
	String Direcao = "";
	String Caminho = "";
	char TipoPeca;
	Coordenada PosicaoInimigo[] = new Coordenada[10];
	boolean Possivel = false;
	Coordenada cSource = new Coordenada(null);

	public Trajetoria(Peca peca) {
		this.cSource.linha = peca.coordenada.linha;
		this.cSource.coluna = peca.coordenada.coluna;

		Direcao = "";
		Caminho = "";

		Possivel = false;

	}
}
