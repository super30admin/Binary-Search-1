// Time Complexity : O (log n)
    	// Space Complexity : O(n)
    	// Did this code successfully run on Leetcode : I had some issues on leet code, 
	//			its said premium membership required
    	// Any problem you faced while coding this :no


public class solution3 {
	static int search_infiniteArray( int A[], int K ) 
	{ 
		
		//assume high to be of certain constant value and increase it exponentially in a while loop
		//till the condition of high being > k is met
		//take the high value and pass it to our binary search function
	    int low = 0; 
	    int high = 1;
	    while (A[high] < K)
	    { 
	       low = high ;      
	       high = 2 * high;    
	    }
	   return binsearch(A, low, high, K);
	}
	
    public static int binsearch(int[] onearray, int low, int high, int target) {

    	
    	while (low <= high) {
    	int mid = (low+high) /2;
    	if(onearray[mid] == target) {
    		return mid;    	   
    	}
    	else if(onearray[mid]> target) {
    		high = mid - 1;
 
    	}
    	else if(onearray[mid] < target) {
    		low = mid + 1;  
    		}
    	} 
    	return -1;
    }
    
    public static void main(String[] args) {
    
    int[] a = {1,2,4,6,7,9,14,25,40,100};
    	
    System.out.println("the infinite array is " + search_infiniteArray(a, 25));
    	
    }
	
}
