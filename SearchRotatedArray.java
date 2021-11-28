//Time Complexity: O(n);
//Space Complexity: O(1);
//Code Run: Yes;

class Solution {
    int low, high, mid;
    
   
    public int search(int[] nums, int target) {
        
        low=0;
        high=nums.length-1;
        
        //What i am going to check is if:
        //my target lies in which range, if it lies in the sorted range of first half;
        // or if it lies in the sorted region of the next half;
        
        //How do i check which portion is sorted?
        //I will check the mid element with the high/low of the array;
        
        while(low<=high){
            mid= low+(high-low)/2; //to avaoid int overflow;
            if(target==nums[mid]){
                // System.out.println(target);
                return mid;
                }
               if(nums[low]<=nums[mid]){        
                   //Checking if fisrt is sorted and then checking the target element;
                 if(target>=nums[low] && target<nums[mid]){
                      high=mid-1;
                 }else{
                     low=mid+1;
                  }
                } else{     //nums<=high
//Checking if second half is sorted and then checking the target element;                   
                    if(target<=nums[high] && target>nums[mid]){
    
                            low=mid+1;
                        }else{
                            high=mid-1;
                        }
                    } 
        }
        return -1;
    }
}
