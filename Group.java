import acm.graphics.GCanvas;

class Group {
	private Bar[] bar;
	/* Construye un grupo en la caja indicada por groupBox, formada por
	tantas barras como elementos tenga el array sizes. El array sizes
	contiene el número de leds que tienen cada una de las barras.
	Las barras están dispuestas, una encima de la otra, verticalmente.
	El orden de los sizes se corresponde a los tamaños de las barras de
	arriba hacia abajo.
	*/
	public Group (int[] sizes, Box groupBox) {
		Box[] barras = groupBox.distributeVertically(sizes.length);
		this.bar = new Bar[sizes.length];
		for(int i = 0; i < sizes.length; i++){
			this.bar[i] = new Bar(sizes.length, barras[i]);
		}
	}

	public void addToGCanvas (GCanvas gCanvas) {
		for(int i = 0; i < bar.length; i++) {
			bar[i].addToGCanvas(gCanvas);
		}
	}

	public void render (int[] values) {
		throw new UnsupportedOperationException("A implementar en el paso Step3");
	}

}
