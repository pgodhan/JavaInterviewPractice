
public class Reader_Writer {

	private int readerCount=0;
	private int writerCount=0;
	private int writeRequest=0;
	
	public synchronized void lockReader() throws InterruptedException
	{
		while(writerCount >0  && writeRequest >0)
			wait();
		readerCount++;
	}
	
	public synchronized void lockWriter() throws InterruptedException
	{
		writeRequest++;
		while(readerCount >0 || writerCount >0)
			wait();
		writerCount++;
	}
	
	
	public synchronized void unlockReader() 
	{
		readerCount--;
		notifyAll();
	}
	
	public synchronized void unlockWriter() 
	{
		 writerCount--;
		 writeRequest--;
		 notifyAll();
	}
}
