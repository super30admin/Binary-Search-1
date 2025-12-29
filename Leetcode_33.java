//https://www.youtube.com/watch?v=u2LQVywF-H0&feature=youtu.be
//https://www.thes30.com/problem/5c910dbe6b94da0016a57018/solutions
//Identify mid point. Either of the side will be sorted array. Check if the given target is with in sorted array. If yes, search in that sorted array. Else, search in another side i.e., unsorted array

//TC: O(logn)
//SC: O(1)

class Solution {
    public int search(int[] nums, int target) {
        int low=0,high=nums.length-1;

        while(low<high){
            int mid=low+(high-low)/2;

            if(nums[mid]==target) return mid;

            if(nums[low]<=nums[mid]){
                if(target>=nums[low] && target<nums[mid]){
                    high=mid;
                }else{
                    low=mid+1;
                }
            }else{
                if(target>nums[mid] && target<=nums[high]){
                    low=mid+1;
                }else{
                    high=mid;
                }
            }
        }

        if(nums[low]==target){
            return low;
        }

        return -1;
    }
}



//Approach-2
//https://www.youtube.com/watch?v=u2LQVywF-H0&feature=youtu.be
//https://www.thes30.com/problem/5c910dbe6b94da0016a57018/solutions
//Identify mid point. Either of the side will be sorted array. Check if the given target is with in sorted array. If yes, search in that sorted array. Else, search in another side i.e., unsorted array

//TC: O(logn)
//SC: O(1)

class Solution {
    public int search(int[] nums, int target) {
        int low=0,high=nums.length-1;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(nums[mid]==target) return mid;

            if(nums[low]<=nums[mid]){
                if(target>=nums[low] && target<nums[mid]){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }else{
                if(target>nums[mid] && target<=nums[high]){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
        }

        return -1;
    }
}
