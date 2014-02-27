
public class Producer extends Thread implements Runnable{
	BufferHolder temp;
	int item;
    static int count;
	
    Producer(BufferHolder b,int item)
	{
		this.temp=b;
		this.count=item;
	}
	public void run() 
	{
		try
		{
		for(int i=0;i<10;i++)
		{
		temp.produce(count++);
		System.out.println("Item produced ="+count);}
		}
		catch(InterruptedException e)
		{System.out.println("Exception thrown");}
	}
}
