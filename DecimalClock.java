import acm.graphics.GCanvas;

public class DecimalClock {
	
	private DecimalNumber[] numbers;

	// Construye un reloj que usa tres números decimales para indicar
	//horas, minutos y segundos y lo coloca en la caja indicada por dcBox
	public DecimalClock (Box dcBox) {
		Box[] cajas = dcBox.distributeHorizontally(3);
		numbers = new DecimalNumber[3];
		for(int i = 0; i < cajas.length;i++){
			numbers[i] = new DecimalNumber(2,cajas[i].withPadding(Padding.horizontal(0.1)));
		}
	}

	public void addToGCanvas (GCanvas gCanvas) {
		for(int i=0; i<numbers.length;i++){
			numbers[i].addToGCanvas(gCanvas);
		}
	}

	public void render (int hours, int minutes, int seconds) {
		assert 0 <= hours   &&   hours <= 23;
		assert 0 <= minutes && minutes <= 59;
		assert 0 <= seconds && seconds <= 59;

		numbers[0].render(hours);
		numbers[1].render(minutes);
		numbers[2].render(seconds);
	}

}
