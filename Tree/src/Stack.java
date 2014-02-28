
public class Stack {
	int topOfStack=0;
	int count; //to keep track of number of items in the stack
	Node stack[]=new Node[20];
	int limit =20;
	//Check whether stack is empty
boolean isEmpty()
{
	if(this.topOfStack == 0) 
		return true;
	else
		return false;
}

//Check if the stack is full
boolean isFull()
{
	if(this.topOfStack >= limit )
	 return true;
	else 
	 return false;
	
}

void printStack()
{
	int i;
	for(i=0;i<this.topOfStack;i++)
	{
		System.out.println(" Item "+i+"="+this.stack[i].item);
	}
}
//Returns the value at top of the stack without removing the element
Node peek()
{   if (this.topOfStack > 0)
	  return this.stack[this.topOfStack-1];
   else
	   return null; //If stack is empty
}

//Push item onto the stack
void push(Node ob)
{
	if(this.isFull())
		System.out.println("Stack is full!! OVERFLOW");
	else
	{
		this.stack[this.topOfStack]=ob;
		this.topOfStack++;
	}
}

//Pop the item on the stack
Node pop()
{
	if(this.isEmpty())
		{System.out.println("Stack is empty!! UNDERFLOW");
		return null;
		}
	else
	{
		--this.topOfStack;
	    return this.stack[this.topOfStack];
	 }
}

}
