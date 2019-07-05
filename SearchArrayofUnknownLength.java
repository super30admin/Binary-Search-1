class Solution
{
	//src:http://www.ardendertat.com/2011/11/21/programming-interview-questions-17-search-unknown-length-array/
   public static int search(int[] nums, int target)
   {
	   int exp =0;
	   int index = 0;
	   
	   while(true)
	   {
		   try {
			   if(target==nums[index])
				   return index;
			   else if(target>nums[index]) //checking in next loop expanding till next chunk
			   {
				   index=(int)Math.pow(2,exp); //e.g if len:14 of arr, the index expands till 16 after which it breaks
				   exp++;
			   }
				else
				{
					break;
					}
		   }
		catch (ArrayIndexOutOfBoundsException   e)
		   {
			break;
		   }
	   }
	   
	   //Binary Search which can have more Array Out of Bounds(between array size 14 and our imaginary index estimate of 16)
	   int left = index/2+1; //Since we have checked target is greater than this
	   int right = index-1;
	  
	   
	   while(left<=right)
	   {
		   int mid = left + (right-left)/2;
		   try {
		   if (target==nums[mid])
			   return mid;
		   else if (target<nums[mid])
			   right = mid-1;
		   else
		   {
			   left = mid+1;
		   }
		   }
		   catch(ArrayIndexOutOfBoundsException e)
		   {
			   right = mid-1; //Keep reducing till we get the right size
		   }
	   }
	   return -1;
   }
    public static void main(String args[])
    {
    	int nums[] = {8,9,12,13,14,15};
    	int index = search(nums,15);
    	System.out.println(index);
    }
}
