public class SortedBinarySearch {
    //log n time complexity
    public int search(int[] nums, int target) {
        int first = 0;
        int last = nums.length-1;
        while(first<=last){
            int mid = first+(last-first)/2;
            
            if(target == nums[mid]){
                return mid;
            }
            
            // check if the half is sorted
            if(nums[first] <= nums[mid]){
                //if target exists in that sorted, else its in the other half
                if(target < nums[mid] && target >= nums[first]){
                    last = mid-1;
                    continue;
                }
                else{
                    first = mid+1;
                }
            }
            else{
                if(target <= nums[last] && target > nums[mid]){
                    first = mid+1;
                }
                else{
                    last = mid-1;
                }
            }
        }
        return -1;
    }
    
}
