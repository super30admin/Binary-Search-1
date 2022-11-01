//Time complexity is O(log N)
//space complexity is O(N)
//Able to submit in leetcode

class Solution {
    public int search(int[] nums, int target) {
        int rot = -1;
        int i=0;
        int m = nums.length;
        while(i<(m-1)){
            if(nums[i]>nums[i+1]){
                rot = i;
                break;
            }
            i=i+1;
        }
        
        int result = -1;
        if(rot!=-1){
            result = helper(nums, 0, rot, target);
            System.out.println(result);
            if(result !=-1)
            {
                return result;
            }
            return helper(nums, rot+1, m-1, target);

        }
        else{
            return helper(nums, 0, m-1, target);
        }
    }
    public int helper(int[] arr, int i, int j, int target){
        int l =i;
        int r= j;
        
        while(l<=r){
            int m = l+(r-l)/2;
            
            if(arr[m]==target){
                return m;
            }
            else if(arr[m]<target){
                l=m+1;
            }
            else{
                r=m-1;
            }
        }
        return -1;
    }
}
