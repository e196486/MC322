package mc322.lab05;

public class AppDama{
	public static String[] executaJogo(String entrada, String saida) {
		CSVReader csv = new CSVReader();
		csv.setDataSource(entrada);
		String commands[] = csv.requestCommands();		
		
		Tabuleiro tab = new Tabuleiro();
		tab.setTabuleiro();
		
		String estados[] = new String[commands.length];
		
		System.out.println("Tabuleiro inicial:\n" + tab.imprimirTabuleiro());
		
		for (int k = 0; k < commands.length; k++) {
			tab.solicitaMovimento(commands[k]);
			estados[k] = tab.imprimirTabuleiro();
			System.out.println("Source: " + commands[k].substring(0, 2));
			System.out.println("Target: " + commands[k].substring(3, 5)+"\n");
			System.out.println(tab.imprimirTabuleiro());
		}
		
		tab.exportarArquivo(saida);
		
		return estados;
	}
	
	public static void main(String[] args) {
		executaJogo("C:\\Users\\muril\\Desktop\\lab05\\data\\arq001.csv","C:\\Users\\muril\\Desktop\\lab05\\data\\arq002.csv");
	}
}