public class Academia {
	
	public double calcular(String plano, int duracao, String frequencia) {
		
		double valorbase = 0;
		double valorfinal = 0;

		if (plano.equals("B")) {
			valorbase = 80; 
		}
		else if (plano.equals("I")) {
			valorbase = 120;
		}
		else if (plano.equals("P")) {
			valorbase = 180;
		}


		valorfinal = valorbase;


		if (frequencia.equals("S")) {
			valorfinal = valorfinal - (valorfinal * 10 / 100);
		}
		else if (frequencia.equals("A")) {
			valorfinal = valorfinal - (valorfinal * 20 / 100);
		}

	
		if (duracao == 3) {
			valorfinal = valorfinal + (valorfinal * 20 / 100);
		}
		else if (duracao == 5) {
			valorfinal = valorfinal + (valorfinal * 50 / 100);
		}	
		
		return valorfinal;
	}
}
