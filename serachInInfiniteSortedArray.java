package mediumProblems;

//In an infinte sorted array, we dont have any specific value for high so,
//low = 0 & high =1
//we will keep increasing our low and high until array[high] <= target since its a sorted array
//Apply binary search on that


public class serachInInfiniteSortedArray {
	
	
	public static  int search(int[] array, int target) {
		
		if(array==null || array.length == 0)
			return -1;
		
		int low =0;
		int high=1;
			
		while(array[high] <= target)
		{
			low = high;
			high = high *2;
		}

		return binarySearch(array, low, high, target);
	}
	
	
	public static int binarySearch(int[] array, int low, int high, int target)
	{
		while(low<=high)
		{
			int mid = low+(high-low)/2;
			if(target==array[mid]) return mid;
			if(target < array[mid])
					high = mid-1;
				else
					low = mid+1;
				
		}
		return -1;
	}

	public static void main(String[] args) {
		
		 int arr[] = new int[]{3, 5, 7, 9, 10, 90,  
                 100, 130, 140, 160, 170}; 
		 int ans = search(arr,10); 
		 System.out.println("Target found at: "+ans);

	}

}
