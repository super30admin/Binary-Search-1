// Operation:            search
// Time Complexity:      O(logn)
// Space Complexity:      O(1)
// Yes, this code ran successfully
// No, I didn't face any problem in this problem statement in Brute force approach

package src;

public class RotatedSearch
{
    public int search(int[] nums, int target)
    {
        int l = 0 ;
        int r = nums.length - 1 ;

        while(l <= r)
        {
            int mid = l + (r-l)/2 ;
            if(nums[mid] == target)                                     // mid element is target
                return mid ;

            if(nums[l]<=nums[mid])                                      // if left sub-array is sorted
                if(nums[l]<=target && target<nums[mid])                 // if element falls in that sub-array
                    r = mid - 1 ;
                else                                                    // if element doesn't fall in that sub-array
                    l = mid + 1 ;
            else                                                        // if right sub-array is sorted
                if(nums[mid]<target && target<=nums[r])                 // if element falls in that sub-array
                    l = mid + 1 ;
                else                                                    // if element doesn't fall in that sub-array
                    r = mid - 1 ;
        }
        return -1 ;                                                     // if element isn't present in the entire array
    }

    public static void main(String[] args) {

        int[] arr = new int [] {4,5,6,7,0,1,2};
        int target = 3 ;
        RotatedSearch rs = new RotatedSearch() ;
        System.out.println("Position: "+rs.search(arr, target)) ;
    }
}