package mc322.lab04;

public class AppRestaUm {

	public static String executaJogo(String s) {
		String EstadoTabuleiro = "";

		CSVReader csv = new CSVReader();
		csv.setDataSource(s);
		String commands[] = csv.requestCommands();

		// declaro meu jogo aberto
		Tabuleiro Tabuleiro1 = new Tabuleiro();

		for (int i = 0; i < commands.length; i++) {
			Tabuleiro1.movePeca(commands[i].substring(1, 3), commands[i].substring(4, 6));
			EstadoTabuleiro = Tabuleiro1.desenhaTabuleiro();
		}

		return (EstadoTabuleiro);

	}

	public static void main(String[] args) {
		String ComandosCSV = "C:\\Users\\muril\\eclipse-workspace\\lab04\\src\\db\\arq001.csv";
		executaJogo(ComandosCSV);

	}

}
