package util;

import java.util.concurrent.TimeUnit;

public class StopWatch {
	private long start;
	
	public StopWatch(){
		start = System.nanoTime();
	}
	
	public long elapsedTime(TimeConvert timeConvert){
		long now = System.nanoTime();
		long ret = timeConvert.convert(now - start);
		start = now;
		return ret;
	}
	
	public enum TimeConvert{
		SECOND{
			@Override
			public long convert(long nanoTime) {
				return TimeUnit.NANOSECONDS.toSeconds(nanoTime);
			}			
		},NANO{

			@Override
			public long convert(long nanoTime) {
				return nanoTime;
			}
			
		},MINUTE{

			@Override
			public long convert(long nanoTime) {
				return TimeUnit.NANOSECONDS.toMinutes(nanoTime);
			}
		},HOUR{

			@Override
			public long convert(long nanoTime) {
				return TimeUnit.NANOSECONDS.toHours(nanoTime);
			}			
		},DAY{

			@Override
			public long convert(long nanoTime) {
				return TimeUnit.NANOSECONDS.toDays(nanoTime);
			}
		},MILLSECOND{
			@Override
			public long convert(long nanoTime) {
				return TimeUnit.NANOSECONDS.toMillis(nanoTime);
			}
		};
		public abstract long convert(long nanoTime);
	}
}
