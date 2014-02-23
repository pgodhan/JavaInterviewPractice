
public class Tree extends Node{

	Node root,temp=null;
	int count=0,size=0;
	Tree()
	{
		this.root=null;
	}

	//Calculate size of tree
	int size(Node root)
	{
		if(root == null)
			return 0;
		else
		{
			this.size= this.size+ 1;
			size(root.left);
			size(root.right);
		}
		return this.size;
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

	void mirrorTree(Node root)
	{
		if(root == null)
			return;
		mirrorTree(root.left);
		mirrorTree(root.right);

		Node temp;
		temp = root.left;
		root.left = root.right;
		root.right = temp;
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

	//CONSTRUCT BALANCED MAX HEAP
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
				if(count == 0)
					//Keep toggling between left and right in order to move forward one level
				{maxHeap(node1,root.left);this.count=1;}
				else
				{maxHeap(node1,root.right);this.count=0;}

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


	// CONSTRUCT BALANCED MINHEAP
	void minHeap(Node node1,Node root)
	{
		int item;

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
					if(count == 0)
						//Keep toggling between left and right in order to move forward
					{minHeap(node1,root.left);this.count=1;}
					else
					{minHeap(node1,root.right);this.count=0;}

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

	//To find the last node for replacement
	void getunbalanced(Node root)
	{

		this.size=0;
		int totalLeft = (int)Math.pow((double)2, (double)this.height(root,0)) /2;
		int totalPrevLevel = (int)Math.pow((double)2, (double)this.height(root,0)-1)-1;
		//Mark to decide whether to go left or right
		int  mark = totalLeft + totalPrevLevel; 
		//Size of the tree
		int tempsize = this.size(root);
		//To decide whether to go left or right
		if(tempsize < mark)
		{	//Go to the left
			if(root.left!= null)
			{
				getunbalanced(root.left);
				if(root.right == null)
				{
					if(this.temp==null)
						this.temp=root.left;
				}
				else
				{   if(this.temp==null)
						this.temp=root.right;
				}
			}

		}
		else
		{
			if(root.right != null)
			{	//Go the right
				getunbalanced(root.right);
				if(root.right == null)
				{
					if(this.temp==null)
						this.temp=root.left; 
				}
				else
				{
					if(this.temp==null)
						this.temp=root.right;
				}
			}
		}
		
	}

	//Adjust the heap in order to maintain max-heap property
	void heapify(Node root)
	{int temp;
		if(root == null)
			return;
		else //If left node is the next maximum element in the tree
		if( (root.left!=null) && (root.left.item > root.item) && (root.left.item > root.right.item))
		{
			temp=root.left.item;
			root.left.item=root.item;
			root.item = temp; 
			heapify(root.left);
		} //If right node is the next maximum element in the tree
		else if( (root.right!=null) && (root.right.item > root.item) && (root.right.item > root.left.item))
		{
			temp=root.right.item;
			root.right.item=root.item;
			root.item = temp; 
			heapify(root.right);
		}
		
	}
	
	//Delete the top node from the heap
	void deleteFromHeap(Node root)
	{
		this.getunbalanced(root);
		
		root.item = this.temp.item;
		if(this.temp == this.temp.parent.left)
			this.temp.parent.left = null;
		else
			this.temp.parent.right = null;
		//Call heapify to adjust the heap
		heapify(root);
		
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
		obj.mirrorTree(obj.root);
		obj.inorder(obj.root);
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
		Node t17 = new Node(3);
		testTree.maxHeap(t1, testTree.root);
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
		testTree.maxHeap(t16, testTree.root);
		testTree.maxHeap(t17, testTree.root);
		//NOT A BALANCED MAX HEAP
		testTree.inorder(testTree.root);
		System.out.println("After deleting");
		//Deleting top node
		testTree.deleteFromHeap(testTree.root);
		testTree.deleteFromHeap(testTree.root);
		testTree.inorder(testTree.root);
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

