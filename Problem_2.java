//Time COmplexity-o(log n)
//Space COmplexity-o(1)
//dont have a premium leetcode so solved it on myown
//I get time limit exceeded if I try to search for large values which arent present,
//could you help me with it?

class Test {
	static int BinarySearch(int a[], int l, int h, int x)
	{
	    while(l<=h)
	    {
	        int m=l+(h-1)/2;
	        if(a[m]==x)
	        {
	            return m;
	            
	        }
	        if(x<a[m])
	        {
	            h=m-1;
	        }
	        else
	        {
	            l=m+1;
	        }
	    }
	    return -1;
	    
	}
	static int findPosition(int a[],int key)
	{
	    int l=0;
	    int h=1;
	    int val=a[l];
	    while(val<key)
	    {
	        l=h;
	        if(2*h<a.length-1)
	        {
	            h*=2;
	            
	        }
	        else{
	            h=a.length-1;
	        }
	        val=a[h];
	    }
	    return BinarySearch(a,l,h,key);
	}
	public static void main(String args[])
	{
	    int a[]={3,4,7,8,9,11,12,32};
	    int key=6;
	    int ans=findPosition(a,key);
	    if(ans==-1)
	    System.out.println("Not found");
	    else
	    System.out.println("The output is "+ans);
	}
}
	
	
