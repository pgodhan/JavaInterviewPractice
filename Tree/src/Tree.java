
public class Tree extends Node{

	Node root;

	Tree()
	{
		this.root=null;
	}

	//Insert node in a tree
	void insertTree(Node root,Node ob)
	{
		if(root == null)
		{
	    root = ob;
		ob.parent = null;
		this.root =ob;
		}
		else
		{
			if(root.left == null && ob.item < root.item)
			{	ob.parent = root;
				root.left = ob; }
			else if(root.right == null && ob.item > root.item)
			{	 ob.parent = root;
				 root.right =ob; }       		
			else
			{
				if(ob.item < root.item)
					insertTree(root.left,ob);
				else
					insertTree(root.right,ob);
			}
		}

	} //End of insert tree

	//Recursive traversals
	void preorder(Node root)
	{
		if(root == null)
			return;
		System.out.println(" "+root.item);
		preorder(root.left);
		preorder(root.right);
	}

	void postorder(Node root)
	{
		if(root == null)
			return;
		postorder(root.left);
		postorder(root.right);
		System.out.println(" "+root.item);
	}
	
	void inorder(Node root)
	{
		if(root == null)
			return;
		inorder(root.left);
		if(root.parent != null)
		System.out.println(" "+root.item + "parent =" + root.parent.item);
		else
			System.out.println(" "+root.item );
		inorder(root.right);
		
	}
	
	//Delete a tree in java
	void delete(Node root)
	{
		if(root == null)
			return;
		delete(root.left);
		delete(root.right);
		System.out.println("Deleted item: "+root.item);
		if(root.item == this.root.item)
			this.root=null;
		root=null;
	}
	
	int height(Node root,int height)
	{
		if(root == null)
			return height;
		else
			return 1 + Math.max(height(root.left,height),height(root.right,height));
		
	}
	
	void findInorderSuccessor(Node root)
	{
		Node temp,copy;
		copy=root;
		
		if(root.right != null)
		{
			root=root.right;
			temp = leftmostchild(root);
			System.out.println("Inorder successor of "+ copy.item+"is"+ temp.item);
		}
		else
		{
			if(root.parent != null)
			{ 
				while(root.parent != root.parent.parent.left || root.parent== null)
				{
					root=root.parent;
				}
				root = root.parent.parent;
				System.out.println("Inorder successor: "+ root.item);
			}
			else
			  System.out.println("Inorder successor "+ root.item);
		}
		
	}
	
	//Find the left most child 
	Node leftmostchild(Node root)
	{
	 if(root.left != null)
		 return leftmostchild(root.left);
		
		return root;
	}
	
	
	public static void main(String args[])
	{
		Node ob= new Node (60);
		Node ob1=new Node(50);
		Node ob2=new Node(100);
		Node ob3 =new Node(90);
		Node ob4= new Node (110);
		Node ob5=new Node(98);
		Node ob6=new Node(97);
		Node ob7 =new Node(105);
		Node ob8= new Node (99);
		Node ob9=new Node(55);
		Node ob10=new Node(40);
		Node ob11 =new Node(45);
		Tree obj=new Tree();
		obj.insertTree(obj.root, ob);
		obj.insertTree(obj.root, ob1);
		obj.insertTree(obj.root, ob2);
		obj.insertTree(obj.root, ob3);
		obj.insertTree(obj.root, ob4);
		obj.insertTree(obj.root, ob5);
		obj.insertTree(obj.root, ob6);
		obj.insertTree(obj.root, ob7);
		obj.insertTree(obj.root, ob8);
		obj.insertTree(obj.root, ob9);
		obj.insertTree(obj.root, ob10);
		obj.insertTree(obj.root, ob11);
		System.out.println("Pre order Traversal :");
		obj.preorder(obj.root);
		System.out.println("Post order Traversal :");
		obj.postorder(obj.root);
		System.out.println("In order Traversal :");
		obj.inorder(obj.root);
		System.out.println("Height of tree: "+ obj.height(obj.root,0));
		obj.findInorderSuccessor(ob9);
		obj.delete(obj.root);
		System.out.println("\nTree root:"+obj.root);
		
		//Displaying root

	}

}

/*  
 
 *                              60
 *					50              		100
 *			40		   55                90      110
 *            45          56                98
 * 										 97	   99
 *
 *
 */

