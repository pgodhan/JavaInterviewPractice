
public class Mutex {

	private boolean isLocked = false;
	
	public synchronized void lock() throws InterruptedException 
	{
		try
		{
			//Wait till lock is held by another thread
			while(isLocked == true)
			wait();
			
			isLocked = true;
		}
		finally	
		{
			//To release the lock on exception
			isLocked = false;
		}
	}
	
	public synchronized void unlock()
	{
		//Release the lock and notify the waiting thread
		isLocked=false;
		notify();
	}
	
	
}
