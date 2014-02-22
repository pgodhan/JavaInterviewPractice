
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

	//FIND COMMON ANCESTOR
	Node findLowestCommonAncestor(Node root,Node node1, Node node2)
	{  //GO TO THE LEFT
		if(node1.item > root.item && node2.item > root.item)
			return findLowestCommonAncestor(root.right,node1,node2);
		else //GO TO THE RIGHT
			if(node1.item < root.item && node2.item < root.item)
				return findLowestCommonAncestor(root.left,node1,node2);
			else //ELSE RETURN
				return root;
	}

	//FIND INORDER SUCCESSOR
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
				while(root.parent != root.parent.parent.left || root.parent == null)
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

	//To construct imbalanced binary heap tree
	void maxHeap(Node node1,Node root)
	{ int item;
	
	//For the first node
	if(this.root == null)
	{ 
	root = node1;
	root.left=null;
	root.right = null;
	root.parent=null;
	this.root = node1;
	}
	else
	{

		if(node1.item <= root.item)
		{  

			if(root.left == null )
			{root.left = node1;node1.parent=root;}
			else if(root.right == null)
			{root.right = node1;node1.parent=root;}
			else if(root.left.left == null || root.left.right == null)
				maxHeap(node1,root.left);
			else if (root.right.right==null || root.right.left == null)
				maxHeap(node1,root.right);
			else //TO KEEP MOVING FORWARD
				maxHeap(node1,root.left);

		}	
		else
		{
			item = root.item;
			root.item = node1.item;
			node1.item=item;
			maxHeap(node1,root);

		}
	}
	}
	
	//To construct imbalanced min Heap tree
		void minHeap(Node node1,Node root)
		{ int item;
		
		//For the first node
		if(this.root == null)
		{ 
		root = node1;
		root.left=null;
		root.right = null;
		root.parent=null;
		this.root = node1;
		}
		else
		{

			if(node1.item >= root.item)
			{  

				if(root.left == null )
				{root.left = node1;node1.parent=root;}
				else if(root.right == null)
				{root.right = node1;node1.parent=root;}
				else if(root.left.left == null || root.left.right == null)
					minHeap(node1,root.left);
				else if (root.right.right==null || root.right.left == null)
					minHeap(node1,root.right);
				else //TO KEEP MOVING FORWARD
					minHeap(node1,root.left);

			}	
			else
			{
				item = root.item;
				root.item = node1.item;
				node1.item=item;
				minHeap(node1,root);

			}
		}
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
		Node ob12=new Node(56);
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
		obj.insertTree(obj.root, ob12);
		System.out.println("Pre order Traversal :");
		obj.preorder(obj.root);
		System.out.println("Post order Traversal :");
		obj.postorder(obj.root);
		System.out.println("In order Traversal :");
		obj.inorder(obj.root);
		System.out.println("Height of tree: "+ obj.height(obj.root,0));
		obj.findInorderSuccessor(ob12);
		Node temp = obj.findLowestCommonAncestor(obj.root, ob10,ob12 );
		System.out.println("ANCESTOR = "+ temp.item);
		obj.delete(obj.root);
		System.out.println("\nTree root:"+obj.root);
		System.out.println("===========================================================");

		Tree testTree=new Tree();
		Node t1= new Node(50);
		Node t2=new Node(10);
		Node t3=new Node(60);
		Node t4=new Node(80);
		Node t5=new Node(5);
		Node t6= new Node(9);
		Node t7=new Node(90);
		Node t8 = new Node(55);
		Node t9=new Node(54);
		Node t10 = new Node(34);
		Node t11=new Node(4);
		Node t12 = new Node(30);
		Node t13=new Node(45);
		Node t14 = new Node(33);
		Node t15=new Node(22);
		Node t16 = new Node(99);
	/*	testTree.maxHeap(t1, testTree.root);
		testTree.maxHeap(t2, testTree.root);
		testTree.maxHeap(t3, testTree.root);
		testTree.maxHeap(t4, testTree.root);
		testTree.maxHeap(t5, testTree.root);
		testTree.maxHeap(t6, testTree.root);
		testTree.maxHeap(t7, testTree.root);
		testTree.maxHeap(t8, testTree.root);
		testTree.maxHeap(t9, testTree.root);
		testTree.maxHeap(t10, testTree.root);
		testTree.maxHeap(t11, testTree.root);
		testTree.maxHeap(t12, testTree.root);
		testTree.maxHeap(t13, testTree.root);
		testTree.maxHeap(t14, testTree.root);
		testTree.maxHeap(t15, testTree.root);
		testTree.maxHeap(t16, testTree.root);*/
		//NOT A BALANCED MAX HEAP
		//testTree.inorder(testTree.root);
		testTree.root=null;
		testTree.minHeap(t1, testTree.root);
		testTree.minHeap(t2, testTree.root);
		testTree.minHeap(t3, testTree.root);
		testTree.minHeap(t4, testTree.root);
		testTree.minHeap(t5, testTree.root);
		testTree.minHeap(t6, testTree.root);
		testTree.minHeap(t7, testTree.root);
		testTree.minHeap(t8, testTree.root);
		testTree.minHeap(t9, testTree.root);
		testTree.minHeap(t10, testTree.root);
		testTree.minHeap(t11, testTree.root);
		testTree.minHeap(t12, testTree.root);
		testTree.minHeap(t13, testTree.root);
		testTree.minHeap(t14, testTree.root);
		testTree.minHeap(t15, testTree.root);
		testTree.minHeap(t16, testTree.root);
		testTree.inorder(testTree.root);
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

