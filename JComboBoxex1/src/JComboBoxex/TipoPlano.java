package JComboBoxex;

public enum TipoPlano {
	BASICO (80.0), INTERMEDIARIO(120.0), PREMIUM(180.0);
	
	
	public double valorT;
	
	private TipoPlano(double valorT) {
		this.valorT = valorT;
	}
}