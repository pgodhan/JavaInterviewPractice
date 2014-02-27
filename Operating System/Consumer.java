
public class Consumer extends Thread implements Runnable {
	
	BufferHolder temp;
	
	Consumer(BufferHolder b)
	{
		this.temp=b;
	}
	public void run() 
	{
		try
		{
		int item;
		for(int i=0;i<10;i++)
		{ item=temp.consume();
		System.out.println("Item consumed="+item);}
		}
		catch(InterruptedException e)
		{System.out.println("Exception thrown");}
	}

}
