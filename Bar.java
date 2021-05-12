import acm.graphics.GCanvas;

class Bar {

	private Led[] leds;

	// Construye una barra en la caja indicada por barBox, formada por
	// size leds del mismo tamaño colocados horizontalmente
	public Bar (int size, Box barBox) {
		assert size > 0;
		
		Box[] cajas = barBox.distributeHorizontally(size);
		this.leds = new Led[cajas.length];
		for(int i = 0; i < cajas.length; i++) {
			this.leds[i] = new Led(cajas[i]);
		}
	}

	// Añade todos los leds que forman la barra al canvas gCanvas
	public void addToGCanvas (GCanvas gCanvas) {
		for(int i = 0; i < leds.length; i++) {
			leds[i].addToGCanvas(gCanvas);
		}
	}

	//Ilumina el led indicado por value en la barra, contando desde 0
	// de izquierda a derecha.
	public void render (int value) {
		for (int i = 0; i < leds.length; i++){
			if(i == value){
				leds[i].on();
			}
			else{
				leds[i].off();
			}
		}
	}

}
