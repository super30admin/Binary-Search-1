// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode : N/A
// Any problem you faced while coding this : Not able to get the time complexity


// Your code here along with comments explaining your approach



class InfiniteArray{

    public int searchIndex(int[] arr, int target) {
    

    	int low = 0;
    	int high = 1;
    	
    	//As we don't know the length of array , we can not find the bounds to compare it with the target value. Hence the bounds of array are exponentially increased untill the target becomes lesser than the higher bound element in the array. In case accessing the higher bound index intialized in any iteration is not present in the array, it throws an ArrayOutOfBoundExcepetion.
    	while(arr[high]<target) {
    		
    		low = high;
    		high = 2 * low;
    	}
    	
    	
    return binarySearch(arr,low,high,target);
    	
    }

    //Normal Binary search operation with the given lower and higher bounds of the array
    
    int binarySearch(int arr[], int l, int r, int x) 
    { 
      
        int mid = 0;

        while(l<=r){

           mid = ((r-l)/2)+l;   

           if(x == arr[mid])
               return mid;
           else if(x < arr[mid]){
               r = mid - 1;           
           }else{
               l = mid + 1;
           }
        }

        return -1;
    }

    public static void main(String[] args) {
    InfiniteArray obj = new InfiniteArray();
    int[] arr = new int[]{3,5,6,8,11,14,15,19,29,30,44,45,50,66,77,80,93,101,122,134,156,149};
    int target = 50;
    System.out.println(obj.searchIndex(arr,target));
    }
  
}

