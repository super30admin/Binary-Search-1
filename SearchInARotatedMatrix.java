/*Time complexity:O(lg(n)) where n is the length of the array
Space complexity:O(1) constant time because we are not using any extra space 
Did this code successfully run on Leetcode :YES
Any problem you faced while coding this :No */

public class SearchInARotatedMatrix {
        public int search(int[] nums, int target) {
            if(nums==null || nums.length==0){
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
                    if(target>=nums[low] && target<nums[mid]){
                        high=mid-1;
                    }
                    else{
                        low=mid+1;
                    }
                }
                else{
                    if(target>nums[mid] && target<=nums[high]){
                        low=mid+1;
                    }
                    else{
                        high=mid-1;
                    }
                }
            }
            return -1;
        }
    public static void main(String args[]){
            SearchInARotatedMatrix obj=new SearchInARotatedMatrix();
            int nums[]={4,5,6,7,0,1,2};
            int target=0;
            System.out.println(obj.search(nums, target));
    }
}
