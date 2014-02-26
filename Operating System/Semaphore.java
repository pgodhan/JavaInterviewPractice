
public class Semaphore {
 
	//To keep count of the number of processes who has acquired resource
  private int counter=0;
  
  public synchronized void acquire() throws InterruptedException
  {
	  if(counter==0)
		  wait();
	  counter--;
  }
  
  public synchronized void release()
  {
	  this.notify();
	  counter++;
  }
}
