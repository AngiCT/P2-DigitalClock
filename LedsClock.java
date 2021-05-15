import acm.graphics.GCanvas;

class LedsClock {
	private Group[] grupos;

	public LedsClock (Box ledBox) {
		Box[] cajas = ledBox.distributeVertically(3);
		grupos = new Group[3];
		grupos[0] = new Group(new int[] {3,10}, cajas[0]);
		grupos[1] = new Group(new int[] {6,10}, cajas[1]);
		grupos[2] = new Group(new int[] {6,10}, cajas[2]);

	}

	public void addToGCanvas (GCanvas gCanvas) {
		for(int i = 0; i < grupos.length;i++){
			grupos[i].addToGCanvas(gCanvas);
		}
		
	}

	public void render (int hours, int minutes, int seconds) {
		assert 0 <= hours   &&   hours <= 23;
		assert 0 <= minutes && minutes <= 59;
		assert 0 <= seconds && seconds <= 59;

		grupos[0].render(new int[] {hours%10, hours/10});
		grupos[1].render(new int[] {minutes%10, minutes/10});
		grupos[2].render(new int[] {seconds%10, seconds/10});
	}

}
