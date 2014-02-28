
public class Queue {
   int front=0; 
   int rear=0;
   int length=5;
   int count=0;
	
	Node queue[] = new Node[length];

	//To enqueue a node in the queue
	void enqueue(Node ob)
	{ 
		if(count == length)
			System.out.println("Queue is full");
		else
		{
			count++;
			queue[front]=ob;
			front=front%(length-1);
			front++;
		}
	
	}
	
	void printQueue()
	{
		
	}
	//To dequeue a node from the queue
	Node dequeue()
	{
		if(count ==0)
		{
			System.out.println("Empty");
			return null;
		}
		else
		{
			rear=rear%(length-1);
			count--;
			Node ob= queue[rear++];
			return ob;
		}
	}
}
