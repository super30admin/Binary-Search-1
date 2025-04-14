//Time Complexity: O(log n)
//Space Complexity O(1)
//Yes the code ran successfully in leetcode
//No problem faced
//33. Search in Rotated Sorted Array

class Problem2 {
    public int search(int[] nums, int target) {

        if(nums == null || nums.length == 0 ){ // Handle edge case where array is null or empty
            return -1;
        }
        
        int left=0,right=nums.length-1;
        int mid;

        while(left<=right){
            mid=left+(right-left)/2;

            if(nums[mid] == target){ // target found
                return mid;
            }
            if(nums[left]<=nums[mid]){ // Check if the left half is sorted
                if(nums[left]<=target && target < nums[mid]){ // Target lies in the left half
                    right=mid-1;
                }
                else{
                    left=mid+1; // Target lies in the right half
                }
            }
            else{
                // Right half is sorted
                // Target lies in the right half
                if(nums[mid]<target && target <= nums[right]){ 
                    left=mid+1;
                }
                else{
                    right=mid-1; // left half
                }
            } 
        }
        return -1;   // target not found
    }
}
