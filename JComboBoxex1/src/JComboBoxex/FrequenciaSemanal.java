package JComboBoxex;

public enum FrequenciaSemanal {
	DUASVEZESPORSEMANA(0), TRESVEZESPORSEMANA(0.20), CINCOVEZESPORSEMANA(0.50);

	
	public double valorF;
	
	private FrequenciaSemanal(double valorF) {
		this.valorF = valorF;
	}
}