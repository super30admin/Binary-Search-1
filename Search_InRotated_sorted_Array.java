/*
    Time Complexity : 
        O(log(n)) because in each iteration we will reduce the input size by half (avoiding the other half because element is not in that half)
    Space Complexity : 
        O(1) we are not using any auxilary space

    Did this code successfully run on Leetcode : YES
    
    Any problem you faced while coding this :
        Handling edge case was tricky
*/

public class Search_InRotated_sorted_Array {
    public int search(int[] nums, int target) {
        int left = 0;
        int right =  nums.length-1;
        while( left <= right){
            int mid = (left +right)/2;

            if (nums[mid] == target) {return mid;}
            
            // if left array is sorted 
            if( nums[left]<= nums[mid]  ){
                //  if array is in left sorted  array search in left side so change right to mid-1
                if(target <= nums[mid] && target >= nums[left]){
                    right = mid-1;
                }else{
                    // else element is in right side of array update the left = mid+1
                    left = mid + 1;
                }
            }
            // if right array is sorted 
            else{
                // if element is in right sorted array
                if ( target >= nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }else{
                    // else element is in left side of array
                    right = mid -1;
                }
            }
            
        }

        return -1;
        
    }
    public static void main(String[] args) {
        Search_InRotated_sorted_Array  obj = new Search_InRotated_sorted_Array();
        int arr []={4,5,6,7,0,1,2};
        int target  = 4;
        int index = obj.search(arr, target);   
        System.out.println("index"+index);
    }
}