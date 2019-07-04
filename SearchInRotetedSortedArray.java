//search target element in rotated array.
//reference leetcode solution
class SearchInArray {
	public int search(int[] array, int target) {
		//if array is null and array length is 0 then return -1
		if(array == null || array.length == 0) return -1;
		int left=0, right =array.length-1;
		
		//iterate till left is less than right
		while(left<right) {
			int median =left+(right-left)/2;
			
			//if array[median] is grater than array[left]
			if(array[median]>=array[left]) {
				//if target is greater than equal to array[left] and target is less than equal to array[median] then set right to median
				if(target>=array[left] && target<=array[median]) right=median;
				//target is grater than median so set left to median+1
				else left = median+1;
			}else {
				//if target is less than array[right] and target is grater than array[median] then set left to median+1
				if(target<=array[right] && target>array[median]) left= median+1; 
				//if target is less than array[median]then set right to median
				else right = median;
			}
			
		}
		
		// target is not equal to array[left]
		if( array[left]!=target) return -1;
		System.out.println("index of target element="+left);
		
		return left;
	}
}



public class SearchInRotetedSortedArray {
	public static void main(String[] args) {
		SearchInArray searchInArray = new SearchInArray();
		int[] input = {4,5,6,7,0,1,2};
		int target =1;
		for (int i =0 ; i<input.length;i++) {
			System.out.println("input array  is ="+input[i]);
		}
		
		System.out.println("target is="+target);
		int index = searchInArray.search(input,target);
		
	}
}
