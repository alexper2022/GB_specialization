package Task2.models;

public class Counter {
	private int counter;
	public void addCounter(){
		counter +=1;
	}
	public void reduceCounter(){
		counter -=1;
	}

	public int getCounter(){
		return counter;
	}
}
