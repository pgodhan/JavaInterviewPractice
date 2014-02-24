
public class palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str=new String("PayyaP");
		
		int length=str.length();
		int i;
		int flag=0;
		for(i=0;i<length/2;i++)
		{
			if(str.charAt(i)!=str.charAt(length-1-i))
			{
				flag=1;
			}
				
		}
		if(flag==0)
			System.out.println("String is palindrome");
		else
			System.out.println("String is not palindrome");
	}

}
