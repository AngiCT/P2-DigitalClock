import acm.graphics.GCanvas;

public class DecimalNumber {

	private DecimalDigit[] digits;

	public DecimalNumber (int numDigits, Box dnBox) {
		assert numDigits > 0;

		Box[] cajas = dnBox.distributeHorizontally(numDigits);
		this.digits = new DecimalDigit[cajas.length];
		for(int i = 0; i < cajas.length; i++) {
			this.digits[i] = new DecimalDigit(cajas[i]);
		}
	}

	public void addToGCanvas (GCanvas gCanvas) {
		for(int i = 0; i < digits.length; i++) {
			digits[i].addToGCanvas(gCanvas);
		}
	}

	public void render (int number) {
		assert number >= 0;
		for (int i = 0; i < digits.length; i++){
				digits[i].render(number);
		}
	}

}
