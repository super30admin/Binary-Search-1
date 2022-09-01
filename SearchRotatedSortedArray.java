public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        int l=0,r=nums.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(target == nums[mid])
                return mid;
            if(nums[mid]>=nums[l]){
                if(target>nums[mid]){
                        l = mid+1;
                }else{
                    if(target<nums[l])
                        l = mid+1;
                    else
                        r = mid-1;
                }
            }else{
                if(target>nums[r] || target<nums[mid])
                        r = mid-1;
                    else
                       l = mid+1;
            }
        }
        return -1;
    }
}

// Time Complexity - O(logn)
// Space Complexity - O(1)
