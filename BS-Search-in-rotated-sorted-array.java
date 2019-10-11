//Time Complexity: O(Logn)
//Space Complexity: O(1)

class Solution {
    public int search(int[] nums, int target) {

        
       int left = 0;
       int right = nums.length - 1;
       
        
        while (left<=right){
            
            int mid = left + (right-left)/2; // To avoid overflow
            
            //case 1
            
             if(nums[mid] == target){
                return mid;
                
            }
            //Case 2
            
           else if(nums[left] <= nums[mid]){  
               
               
               // To check which side of array is sorted . One side of the mid will always be sorted. Here left is sorted
               
               if(nums[left] <= target && nums[mid] >= target){ //Check if target present here
                   
                   right  = mid -1;   
               }
               
               else {
                   left = mid+1; //Move to right side
               }
               
                
            }
            //Case 3
            else {  //Here Right side is sorted
                
                if (nums[mid] <= target && nums[right] >= target){ //Check if target present here
                    left  = mid + 1;
                } 
                else
                    right = mid - 1; // Move to left side
                
            }
            
        }
        
      return -1;  
        
    }
}