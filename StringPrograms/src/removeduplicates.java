
public class removeduplicates {

	public static void main(String[] args) {
		StringBuffer s1=new StringBuffer("Payal Godhani");
        int length=s1.length();
        int count=0;
        int i,j,flag=0;
        for(i=0;i<length;i++)
        {
         flag=0;
        	for(j=0;j<length ;j++)
        	{
        		if(j!=i && s1.charAt(i)==s1.charAt(j))
        			{
        		     flag=1;break;}
        	}
         if(flag==0)
        	 {s1.setCharAt(count, s1.charAt(i));
             count++;}
        }
        
        s1.delete(count, length);
        System.out.println(s1);
	}

}
