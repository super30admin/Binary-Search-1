//Time Complexity : O(log (n * m) = O(log(n)+ log(m)) where n is total number of elements and m is no of time high is multiplying by 2
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : No (Premium)
//Any problem you faced while coding this : No
public class SearchInfinteLength {
public int search(int arr[],int target) {
	int low=0;
	int high=1;
	while(arr[high]<target) {
		low=high;
		high=2*high;
	}
	while(low<=high) {
	int mid=low+(high-low)/2;
	if(arr[mid]==target) {
		return mid;
	}
	else if(arr[mid]>target) {
	  high=mid-1;
	}
	else {
		low=mid+1;
	}
}
	return -1;
}
	
	public static void main(String args[]) {
		int arr[]= {1,2,3,4,5,6,7,8,9};
		SearchInfinteLength ob=new SearchInfinteLength();
		System.out.print(ob.search(arr, 7));
		
	}
}
