
public class Permutation {

	void swap(StringBuffer str,int i,int j)
	{
		char temp;
		temp = str.charAt(i);
		str.setCharAt(i, str.charAt(j));
		str.setCharAt(j,temp);
	}
	
	//Permutation of the string
	void permute(StringBuffer str,int start,int end)
	{
		int i;
		//When u reach the end print the string
		if(start==end)
			System.out.println(str);
		else
		{
			//Fix one letter and permute other ones gradually
			for(i=start;i<=end;i++)
			{	
				swap(str,start,i);
				permute(str,start+1,end);
				//To preserve the original ordering
				swap(str,start,i);
			}
		}
	}
	public static void main(String[] args) {
		Permutation ob=new Permutation();
		StringBuffer str=new StringBuffer("abc");
		ob.permute(str,0,2);
		//	System.out.println("Str="+str);
	}

}
