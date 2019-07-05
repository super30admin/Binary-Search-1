class Test 
{ 
	//Source is from geeksforgeeks https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
	static int binarySearch(int arr[], int l, int h, int x) 
	{ 
		if (h>=l) 
		{ 
			int mid = l + (h - l)/2; 
			if (arr[mid] == x) 
				return mid; 
			if (arr[mid] > x) 
				return binarySearch(arr, l, mid-1, x); 
			return binarySearch(arr, mid+1, h, x); 
		} 
		return -1; 
	} 
	
	static int findPos(int arr[],int key) 
	{ 
		int low = 0, high = 1; 
		int leastValue = arr[0];  
		while (leastValue < key) 
		{ 
			low = high;
			if(2*high < arr.length-1) 
			high = 2*high;			 
			else
			high = arr.length-1; 
			
			leastValue = arr[high];  
		} 
		
		//Call binary search on the new high
		return binarySearch(arr, low, high, key); 
	} 
 
	public static void main(String[] args) 
	{ 
		int arr[] = new int[]{1,2,2,3,4,5,6,7,8,9,10,11,12,13,13,14,15,15,16}; 
		int ans = findPos(arr, 5); 
		System.out.println("Index = " + ans); 
	} 
} 