package s30Coding;

public class FindElementInInfiniteArray {

	public static void main(String[] args) {
		FindElementInInfiniteArray f = new FindElementInInfiniteArray();
		int[] nums = new int[] {10,20,30,45,50,100};
		System.out.println(f.search(nums,99));
	}
		// TODO Auto-generated method stub
		public int search(int[] nums, int target) {
			
			
			int length = 1;
			
			//calculate the high end for the array search since we don't know the length
			try { while(target > nums[length])
		     {
		    	 length = length+1;
		     }
			}
			catch(ArrayIndexOutOfBoundsException e){
				throw e;
			}
			
		    
	        int result = search(nums, 0, length, target);
	        return result;
	       
	    }
	   
	      static int search(int num[], int low, int high, int target)
	    {
	         
	        if (low > high) 
	            return -1;
	       
	        int mid = (low+high)/2;
	          
	          
	        //if target is equal to num of mid
	        if (num[mid] == target)
	            return mid;
	       
	          //num of low less than equal to mid  (sorted and rotation point found)
	        if (num[low] <= num[mid])
	        {
	          
	            if (target >= num[low] && target <= num[mid])
	               return search(num, low, mid-1, target);
	         
	            return search(num, mid+1, high, target);
	        }
	       
	       // target between mid and high
	        if (target >= num[mid] && target <= num[high])
	            return search(num, mid+1, high, target);
	          
	       //num of low greater than mid (not sorted yet)
	          
	        return search(num, low, mid-1, target);
	    }

}
