// Time complexity : o(log n)
class Solution {


    public int search(int[] nums, int target) {

        int low  =  0;
        int high = nums.length -1;
        

        while(low <= high){

            // find the mid
            
            int mid = low + (high - low )/2;

            if(nums[mid] == target) return mid;

            if(nums[low] <= nums[mid]){
                //left part is sorted
                if(nums[low] <= target && target <= nums[mid]){
                    //target is left
                    high = mid-1;
                }else{
                    // targe is in right
                    low = mid +1;
                }

            }else{
                // right part is sorted
                if(nums[mid]  <= target && target <= nums[high]){

                    low = mid +1;
                }else{
                    high = mid-1;
                }


            }



            
        }
      
    return -1;
        
    }
}