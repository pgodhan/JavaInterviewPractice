
public class Node {
int item;
Node left,right,parent;

Node()
{
	
}
Node(int item )
{

  this.item=item;
  this.left=null;
  this.right=null;
}


int getItem(Node obj)
{
	return obj.item;
}

void setItem(Node obj,int item)
{
	obj.item = item;
}

}


