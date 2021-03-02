class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums. length == 0) return -1;
       
        int left = 0;
        int right = nums.length-1;
        
        while(left < right){
            int mp = left + (right-left) / 2;
            if(nums[mp] > nums[right])
            {
                left = mp+1;
            } else {
                right = mp;
            }
            }
        int start = left;
        left=0;
        right= nums.length-1;
        
        if(target>= nums[start] && target<=nums[right]){
            left=start;
        }
        else{
            right= start;
        }
        
        while(left<=right){
            int mp= lefy +(right-left)/2;
            if(nums[mp] == target){
                return mp;
                
            }else if(nums[mp] < taget){
                left= mp+1;
            } else
            {right=mp-1;}
      }
        }
   return -1;
        }
       
}
