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
			this.bar[i] = new Bar(sizes[i], barras[i]);
		}
	}
	
	// Añade todos los leds que forman la barra al canvas gCanvas
	public void addToGCanvas (GCanvas gCanvas) {
		for(int i = 0; i < bar.length; i++) {
			bar[i].addToGCanvas(gCanvas);
		}
	}

	/* Muestra, en cada una de las barras del grupo, el valor
	correspondiente del array values.
	El orden de los elementos en el vector values es de abajo hacia
	arriba. De esta manera, si queréis mostrar el valor de un número a
	partir de sus cifras, la cifra correspondiente a las unidades
	estará en la posición 0 del vector values.
	*/
	public void render (int[] values) {
		for (int i = 0; i < bar.length; i++){
			bar[i].render(values[values.length-1-i]);
		}
	}

}
