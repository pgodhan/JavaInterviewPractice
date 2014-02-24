
public class Reverse {

	
	public static void main(String[] args) {
		StringBuffer s=new StringBuffer("Layap");
		char arr[]={'a','b','c','d','e'};
		
		int len=s.length();
		int i;
		char temp,temp1;
		//Using a character Array
		for(i=0;i<arr.length/2;i++)
		{
			temp=arr[i];
			arr[i]=arr[arr.length-1-i];
			arr[arr.length-1-i]=temp;
		}
		
		//Using string buffer
		for(i=0;i<len/2;i++)
		{
			temp = s.charAt(i);
			temp1 =s.charAt(len-1-i);
			s.setCharAt(i, temp1);
			s.setCharAt(len-1-i,temp);
		}
		//Converting character array to string 
		System.out.println("Reverse Array="+ String.valueOf(arr));
		System.out.println("Reverse String="+s);
	}

}
