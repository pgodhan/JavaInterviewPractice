
public class Rotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1=new String("applemango");
		String str2=new String("pleapp");
		
		boolean flag=false;
		String temp;
		int i;
		int len1=str1.length();
		int len2=str2.length();
		int len;
		if(len1<len2)
			len=len1;
		else
			len=len2;
		
		//Concatenating the two strings
		str1=str1+str1;
		
		//Checking if other string is substring of the concatenated string or not
		for(i=0;i<len;i++)
		{
			temp=str1.substring(i,i+str2.length());
			if(temp.equals(str2))
				flag=true;
			
		}
		
		//Base case testing
		if(len1!=len2)
			flag=false;
		
		if(flag==true)
			System.out.println("Rotation=true");
		else
			System.out.println("Rotation=false");
	}

}
