/*optimized solution the trick is to not look for pivot(MAX Element whcih i was doing before and at any middle there is always sorted list either left or right
  Rotating list multiple time is the intuition*/

//Time Complexity = O(logN)
//Space Complexity = O(N)
//Leet Code run    = Yes

class Solution {
    
    public int binary_search(int[] nums,int l,int r,int key){
        //calculate middle 
        int mid = (l + (r-l)/2);
        
        //Base case
        if(l > r)
            return -1;
        
        //truth condition
        if(nums[mid] == key)
            return mid;
        
        //check if left part is sorted    
        else if(nums[l] <= nums[mid]){
                    if(nums[mid] >= key && key >= nums[l]){
                        r = mid;
                    }else{
                        l = mid + 1;
                    }
        }else{
            if(nums[mid] <= key && key <= nums[r]){
                        l = mid;
                    }else{
                        r = mid - 1;
                    }
        }
        
        return(binary_search(nums,l,r,key));
    }
    
    public int search(int[] nums, int target) {
    if(nums.length == 0 || nums == null){
        return -1;
    } 
        return binary_search(nums,0,nums.length-1,target);   
    }
}
