class Count
{
	int count;
	int index;
	int occurenceCount;

}
public class FirstNonRepeatedCharacter {
	String str="payalp ";
	Count countArray[]=new Count[256];
	
	FirstNonRepeatedCharacter()
	{
		int i;
		for(i=0;i < 256;i++)
		{   this.countArray[i] = new Count();
			this.countArray[i].count= 0;
			this.countArray[i].index = -1;
			this.countArray[i].occurenceCount=-1;
		}
	}
	
	void fill()
	//Traverse the array once and fill the count array
	{  
		int i;
		for(i=0;i < str.length();i++)
		{
			this.countArray[str.charAt(i)].count++;
			this.countArray[str.charAt(i)].index = i;
			this.countArray[str.charAt(i)].occurenceCount = i;
		}
	}

	
	
	int find()
	{
		int i,min;
		min = Integer.MAX_VALUE;
		for(i=0;i<256;i++)
		{
			if((this.countArray[i].count==1) && this.countArray[i].occurenceCount < min)
				min = this.countArray[i].occurenceCount;
			
		}
		for(i=0;i<256;i++)
		{
			if((this.countArray[i].count==1) && min == this.countArray[i].occurenceCount)
				return countArray[i].index;
			
		}
		return -1;
	}
	
	public static void main(String args[])
	{
		FirstNonRepeatedCharacter ob = new FirstNonRepeatedCharacter();
		ob.fill();
		System.out.println("Index = "+ ob.find());
	}
}
