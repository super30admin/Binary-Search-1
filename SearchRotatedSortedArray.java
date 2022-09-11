/* Algorithm:
* As the entire array is not sorted and rotated at some point which means one part of it from mid will be sorted
* Here we need to decide how to search in both the parts from mid
* From mid, check if target is greater than low and less than mid --> Its in left part
*                 else in the right part
* Run Binary search in the array where target can be located
* Else return -1
*
* Time Complexity: O(log n)
* Space Complexity: O(1)
*/

class SearchRotatedSortedArray{
    public int search(int[] nums, int target) {
        
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        int low = 0;
        int high = nums.length-1;
        
        while(low <= high){
            
            int mid = low + (high - low)/2;
            
            if(nums[mid] == target){
                return mid;
            }
            //left part is sorted
            if(nums[low] <= nums[mid]){
                //Target lies in left part of the array
                if(target >= nums[low] && target < nums[mid]){
                    high = mid - 1;
                 }
                else{
                    low = mid + 1;
                }
            }
            else{
                //Target lies in right part of the array
                if(target > nums[mid] && target <= nums[high]){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}