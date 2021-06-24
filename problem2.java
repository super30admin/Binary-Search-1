/*complexity analysis:
Time: O(LogN)- where N is length of nums, as I am dividing the search space into half each time
Space: O(1)- const auxilliary space


*/

class Solution {
    public int search(int[] nums, int target) {
        
        //find pivot element using binary search
        
        //store the pivot and compare it with the target also compare the last element with target to find whether the target is on pivot till end of array or on start_idx to pivot_idx-1 side
        //now re-use binary search to find the idx of the target
        
        int len=nums.length;
        
        int i=0, j=len-1;
      
        while(i<j){
        
            int mid=(i+(j-i)/2);
            
            if(nums[mid]> nums[j]){
                i=mid+1;
            }
            
            else j=mid;
          
        }
        
        int pivot=j;
        
        if(nums[pivot]==target) return pivot;
        
        if(target>nums[nums.length-1]){
            return bs(nums,0,pivot-1,target);
        }
        
        else{
            return bs(nums,pivot,nums.length-1,target);
        }
       
        }
    
    public static int bs(int[] nums,int i, int j, int target){
        
        while(i<=j){
            
            int mid=(i+(j-i)/2);
            
            if(nums[mid]==target) return mid;
            
            else if(nums[mid]>target) j--;
            
            else i++;
        }
        return -1;
    }
}