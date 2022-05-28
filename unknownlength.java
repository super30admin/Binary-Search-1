class Solution {
    public int search(int[] nums, int target) {
        int first=0;last=1;
        while(target >nums[high]){
            first=last+1;
            last=last*2;
        }
        while(first<=last){
        int mid=first+(last-first)/2;
        if(target==nums[mid])return mid;
            //left array sorted
        else if(target>nums[mid])  first=mid+1;  
        else last=mid-1;
        }
        return -1;
    }
}
