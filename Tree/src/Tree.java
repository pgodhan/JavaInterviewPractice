
public class Tree extends Node{

	Node root;

	Tree()
	{
		this.root=null;
	}

	void insertTree(Node root,Node ob)
	{
		if(root == null)
		{root = ob;
		this.root =ob;
		}
		else
		{
			if(root.left == null && ob.item < root.item)
			{	root.left = ob; }
			else if(root.right == null && ob.item > root.item)
			{	root.right =ob; }       		
			else
			{
				if(ob.item < root.item)
					insertTree(root.left,ob);
				else
					insertTree(root.right,ob);

			}


		}

	} //End of insert tree

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
		preorder(root.left);
		preorder(root.right);
		System.out.println(" "+root.item);
	}
	
	void inorder(Node root)
	{
		if(root == null)
			return;
		preorder(root.left);
		System.out.println(" "+root.item);
		preorder(root.right);
		
	}
	
	public static void main(String args[])
	{
		Node ob=new Node (10);
		Node ob1=new Node(20);
		Node ob2=new Node(30);
		Node ob3 =new Node(5);
		Tree obj=new Tree();
		obj.insertTree(obj.root, ob);
		obj.insertTree(obj.root, ob1);
		obj.insertTree(obj.root, ob2);
		obj.insertTree(obj.root, ob3);
		System.out.println("Pre order Traversal :");
		obj.preorder(obj.root);
		System.out.println("Post order Traversal :");
		obj.postorder(obj.root);
		System.out.println("In order Traversal :");
		obj.inorder(obj.root);
		
	

	}

}
