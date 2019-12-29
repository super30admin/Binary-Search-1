// Time Complexity :log(n)
// Space Complexity :log(n)
// Did this code successfully run on Leetcode 
// Any problem you faced while coding this :No
public class BsUnknownArrayLength {
	public static int getSearchIndex(int[] arr,int target){
		int low=0;
		int high=1;
		while (target>arr[high]){
			low=high;
			high=2*high;
		}
		while(low<high){
			int mid=low+(high-low)/2;
			if (arr[mid]==target){
				return mid;
			}
			else if (arr[mid]>target){
				high=mid-1;
			}
			else{
				low=mid+1;
			}	
		}
		
		return -1;
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr={1,3,5,8,9,12,34,65,78};
		int target=34;
		System.out.println(BsUnknownArrayLength.getSearchIndex(arr,target));
			
		}
		

	}

