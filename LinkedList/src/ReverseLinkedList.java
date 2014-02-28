class Node
{
	int data;
	Node next;
	
	Node(int item)
	{
		this.data=item;
	}
}

public class ReverseLinkedList {

	Node root;
	
	void insert(int item)
	{
		Node newNode=new Node(item);
		if(root == null)
		{
			root=newNode;
			root.next=null;
		}
		else
		{
		newNode.next =root;
		root=newNode;
		}
	}
	
	void print()
	{
		Node temp=this.root;
		
		while(temp!=null)
		{
			System.out.print(temp.data +"->");
			temp=temp.next;
		}
	}
	
	void reverse()
	{
		Node next,prev,current;
		current=root;
		prev=null;
		while(current!=null)
		{
		next=current.next;
		current.next=prev;
		prev=current;
		current=next;
		}
		root = prev;
	}
	
	void detectLoop()
	{
	boolean flag=false;
	Node fast,slow;
	slow=root;
	fast=root.next;
	while(slow!=null && fast!=null)
	{
		if(slow==fast)
			{System.out.println("There is a loop in the linked list");flag=true;
			break;}
		if(fast.next != null)
		fast=fast.next.next;
		else
		break;
		slow=slow.next;
	}
	if(flag==false)
	System.out.println("No LOOP");
	}
	
	public static void main(String args[])
	{
		ReverseLinkedList ob= new ReverseLinkedList();
		ob.insert(10);
		ob.insert(20);
		ob.insert(30);
		ob.insert(40);
		
		ob.print();
		ob.reverse();
		Node last=ob.root;
		ob.print();
		while(last.next!=null)
			last=last.next;
		last.next=ob.root;
		System.out.println("Last node after reversal="+last.data);
		System.out.println("");
		
		System.out.println("");
		ob.detectLoop();
		
	}
	
}
