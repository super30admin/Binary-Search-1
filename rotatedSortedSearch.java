public class rotatedSortedSearch {
    public int search(int[] nums, int target) {
        if (nums.length == 0){
            return -1;
        }
        if (nums == null){
            return -1;
        }
        int first = 0; 
        int last = nums.length - 1;
        while (first <= last){
            int mid = first + (last - first)/2;
            if(nums[mid] == target) return mid;
            
            else if(nums[first] > nums[mid]){
                if(nums[mid] < target && nums[last] >= target){
                    first = mid+1;
                }else{
                    last = mid-1;
                }
            }
            else{
                if(nums[mid] > target && nums[first] <= target){
                    last = mid - 1;
                }else{
                    first = mid + 1;
                }
            }
        }
        return -1;
    }
    
}
