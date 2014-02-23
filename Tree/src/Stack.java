
public class Stack {
	int topOfStack=0;
	int count; //to keep track of number of items in the stack
	int stack[]=new int[20];
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

//Returns the value at top of the stack without removing the element
int peek()
{   if (this.topOfStack > 0)
	  return this.stack[this.topOfStack-1];
   else
	   return -1; //If stack is empty
}

//Push item onto the stack
void push(int item)
{
	if(this.isFull())
		System.out.println("Stack is full!! OVERFLOW");
	else
	{
		this.stack[this.topOfStack]=item;
		this.topOfStack++;
	}
}

//Pop the item on the stack
int pop()
{
	if(this.isEmpty())
		{System.out.println("Stack is empty!! UNDERFLOW");
		return -1;
		}
	else
	{
		--this.topOfStack;
	    return this.stack[this.topOfStack];
	 }
}

}
