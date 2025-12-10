package h1;

public class Bruch {
	int zaehler, nenner;
	
	Bruch(int zaehler, int nenner){
		this.zaehler = zaehler;
		this.nenner = nenner;
	}
	
	private int ggT(int x, int y) {
		int bigger = x <= y ? y : x;
		int smaller = x <= y ? x : y;
		int biggerRest = smaller;
		int smallerRest = bigger%smaller;
		while(smallerRest != 0) {
			int temp = smallerRest;
			smallerRest = biggerRest%smallerRest;
			biggerRest = temp;			
		}
		return biggerRest;
	}
	
	public void shorten() {
		int toDivideBy = ggT(nenner, zaehler);
		nenner = nenner / toDivideBy;
		zaehler = zaehler / toDivideBy;
	}
	
	public boolean hasSameValueAs(Bruch b) {
		this.shorten();
		b.shorten();
		if(this.zaehler == b.zaehler && this.nenner == b.nenner) {
			return true;
		}
		return false;
		
	}
}
