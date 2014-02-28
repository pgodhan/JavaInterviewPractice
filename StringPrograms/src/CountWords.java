
public class CountWords {
	
	public static void main(String[] args) {
		String str="Payal Godhani and Shrinivas Panchamukhi study in same class";
		int i;
		int wc=0;
		int flag=0; //0 OUT //1 IN
		
		for(i=0;i<str.length();i++)
		{
			if(str.charAt(i)==' ' || str.charAt(i)=='\t' || str.charAt(i)=='\n')
				flag=0;
			else if(flag == 0)
			{
				wc++;
				flag=1;
			}
		}
		System.out.println("Words in the string="+wc);
	}

}
