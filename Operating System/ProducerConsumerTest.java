
public class ProducerConsumerTest {

	public static void main(String[] args) {
		BufferHolder buff=new BufferHolder();
		Thread t1=new Thread();
		Producer p=new Producer(buff,10);
		Consumer c=new Consumer(buff);
	    p.start();
	    c.start();
	    

	}

}
