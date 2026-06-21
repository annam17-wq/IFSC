package JComboBoxex;

public enum Duracao {
	MENSAL(0.0), SEMESTRAL(0.10), ANUAL(0.20);
	
	public double valorD;
	
	private Duracao(double valorD) {
		this.valorD = valorD;
	}
}
