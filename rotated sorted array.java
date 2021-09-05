Time complexity: O(logn)
Space complexity: O(1)

class Solution { //performing binary operation
    public int search(int[] nums, int target) {
        int l = 0; //l to 0
        int h = nums.length-1; //h to last element
        if(nums == null || nums.length ==0) return -1; //initial check
        while(l<=h){
        int mid = l+(h-l) / 2; //initialising mid 
        if (nums[mid] == target) //if current mid element is equal to target, then return the index
            return mid;

        else if (nums[l] <= nums[mid]) { //else if nums[l] is less than or equal to nums[mid]
            if (target >= nums[l] && target < nums[mid]){ //if target is greater than nums[l] and less than nums[mid], then move h to mid-1
                h = mid-1;
        } else {
            l = mid+1; //else move l to mid+1
            }
        } else {
                if (nums[mid] < target && nums[h] >= target){ // else if target is greater than nums[mid] and less than or equal to  nums[h], then move l to mid+1
                    l = mid+1;
                }
                else { //else moce h to mid-1
                    h = mid-1;
                }
        }
        }
         return -1  ; //if nothing then return -1
}
}