//Time Complexity : O(log n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


class SolutionRotatedArray{
    public int search(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target) return mid;
            if(nums[low]<=nums[mid]){
                if(nums[low]<=target && nums[mid]>=target){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
               else{
                   if(nums[mid]<=target && nums[high]>target){
                       low=mid+1;
                   }
                   else{
                       high=mid-1;
                   }
               }
        }
               return -1;
    }
    
    public static void main(String args[]) {
    	SolutionRotatedArray obj=new SolutionRotatedArray();
    	int arr[]= {4,5,6,7,0,1,2};
    	int result=obj.search(arr, 0);
    	System.out.print(result);
    	
    }
}