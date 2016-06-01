package util;

public class StopWatch {
	private long start;
	
	public StopWatch(){
		start = System.currentTimeMillis();
	}
	
	public double elapsedTime(){
		long now = System.currentTimeMillis();
		double ret = (now - start) / 1000.0;
		start = now;
		return ret;
	}	
}
