public class probelm2 {

    // Time Complexity : O(log n)
    // Space Complexity : Constant
    // Did this code successfully run on Leetcode :
    // Any problem you faced while coding this :
    
        public int search(int[] nums, int target) {
            int l = 0;
            int r = nums.length-1;
            
            while(l<=r){
                int m = r-(r-l)/2;
                
                if(target == nums[m]){return m;}
                
                if(nums[l]<=nums[m]){
                    if(target>nums[m] || target<nums[l]){
                        l=m+1;
                    }else{r=m-1;}
                }else {
                    if(target<nums[m] || target>nums[r]){
                        r=m-1;
                    }else{l=m+1;}
                }
            }
            return -1;
        }
    }
    