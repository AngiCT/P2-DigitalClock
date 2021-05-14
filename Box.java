public class Box {

	private final double x;
	private final double y;
	private final double width;
	private final double height;

	public Box (double x, double y, double width, double height) {
		assert 0 <= x;
		assert 0 <= y;
		assert 0 <= width;
		assert 0 <= height;

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public Box withPadding (Padding padding) {
		double top    = height * padding.getTop();
		double right  = width  * padding.getRight();
		double bottom = height * padding.getBottom();
		double left   = width  * padding.getLeft();
		return new Box (x + left,
							 y + top,
							 width  - left - right,
							 height - top  - bottom);
	}

	public Box[][] distributeBidimensionally (int numRows, int numCols) {
		assert numRows > 0 && numCols > 0;

		// partitionedRows no es "exactamente" una matriz sino un vector de
		// referencias a vectores (fijaos en que no he indicado el número de
		// columnas al declarar la "matriz".
		// El número de columnas de cada fila de la matriz será el número de
		// elementos del vector que sea referenciado por la fila.
		// En este caso todas las filas tienen el mismo número de columnas.

		Box[][] partitionedRows = new Box[numRows][];
		Box[] rows = distributeVertically(numRows);
		for (int i = 0; i < rows.length; i++) {
			partitionedRows[i] = rows[i].distributeHorizontally(numCols);
		}
		return partitionedRows;
	}

	// Distribuye de forma uniforme el espacio indicado en la caja
	// (Box) del objeto receptor en tantas cajas como indique numColumns.
	// Las cajas resultantes están colocadas horizontalmente de forma
	// contigua.
	// Se devuelve el vector de referencias a esas cajas.
	public Box[] distributeHorizontally (int numColumns) {
		assert numColumns > 0;

		double anchoCajas = this.width/numColumns;

		Box[] distributeHorizontally = new Box[numColumns];
		for(int i = 0; i < numColumns; i++) {
			Box box = new Box(this.x + anchoCajas*i , this.y, anchoCajas, this.height);
			distributeHorizontally[i] = box;
		}

		return distributeHorizontally;
	}
	/* Distribuye de forma uniforme el espacio indicado en la caja
	(Box) del objeto receptor en tantas cajas como indique numRows.
	Las cajas resultantes están colocadas verticalmente de forma
	contigua. Se devuelve el vector de referencias a esas cajas.
	*/

	public Box[] distributeVertically (int numRows) {
		assert numRows > 0;
		double altoCajas = this.height/numRows;
		Box[] distributeVertically = new Box[numRows];
		for(int i = 0; i < numRows; i++) {
			Box box = new Box(this.x, this.y + altoCajas*i, this.width, altoCajas);
			distributeVertically[i] = box;
		}

		return distributeVertically;
	}

	public Box[] splitTopBottom (double ratio) {
		assert 0.0 <= ratio && ratio <= 1.0;

		throw new UnsupportedOperationException("A implementar en el paso ClockProgram");
	}

}
