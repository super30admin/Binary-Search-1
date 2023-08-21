// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

class rotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[low]<=nums[mid]){
                if(target>=nums[low] && target <nums[mid]){
                    high=mid-1;
                }
                else {
                    low=mid+1;
                }
            }
            else{
                 if(target>nums[mid] && target <=nums[high]){
                    low=mid+1;
                }
                else {
                     high=mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        rotatedSortedArray rs = new rotatedSortedArray();
        int[] matrix = {4,5,6,7,0,1,2};
        System.out.println(rs.search(matrix,0)); // ans = 4
        System.out.println(rs.search(matrix,3)); // ans = -1
    }
}