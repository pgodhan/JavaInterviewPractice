import java.util.concurrent.*;

public class BufferHolder {

	private int buffer[]=new int[10];
	private boolean available=false;
	
	int n=10;
	Semaphore full=new Semaphore(0);
	Semaphore empty=new Semaphore(n);
	Semaphore lock =new Semaphore(1);
    int track=0;

	public synchronized void produce(int item) throws InterruptedException
	{
	  empty.acquire();	
	  lock.acquire();
	  buffer[track]=item;
	  track++;
	  lock.release();
	  full.release();
	  
	 	}
	
	public synchronized int consume() throws InterruptedException
	{
		int item;
		full.acquire(); 
		System.out.println("Waiting for producer");//decrement
		lock.acquire();
		track--;
		item=buffer[track];
		
		lock.release();
		empty.release(); //increment
		return item;
	}
	
}
