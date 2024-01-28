// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : condition check, syntax - speed is not coming


/*  It is similar logic what was being explained in the class.
1. Sorted Array is by nature at least 1 side sorted
2. Check which side sorted, if left is sorted then target lies in between then perform Binary search there 
3. If not, then reverse logic 
*/
public class App {

    public int search(int[] nums, int target) {
        
        if (nums == null || nums.length==0)  return -1;
        
        int len = nums.length;
        int low = 0;
        int high = len-1;
        
        while(low<= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[low] <= nums[mid]) {
                //left is sorted
                if(nums[low]<= target && nums[mid] > target)
                    high = mid-1;
                else
                    low = mid +1;
                
            }else{
                //right is sorted
                if(nums[mid]< target && nums[high]>=target)
                    low = mid+1;
                else
                    high = mid-1;
            }

        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        App app = new App();
        //app.search(new int[]{4,5,6,7,0,1,2}, 0);
        app.search(new int[]{3,1}, 1);

    }
}
