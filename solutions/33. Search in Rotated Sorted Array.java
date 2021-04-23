//Time complexity: log(n)*log(x)-->this is after calulating mid we have to move over the range in which the element is available.
//here is we are firstcaluting the mid then checking the which part is sorted then and then we are checking whetehr the element lies in the sorted part or the other //side then we are repeting the same thing till low<=high.
​
//Note: I didnt understand one thing that is why we are looking or for the sorted part here. Can you plz explain once.
​
​
class Solution {
    public int search(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
​
        if(nums.length==0){
            return -1;
        }else{
            while(low<=high){
                int mid=low+(high-low)/2;
                if (nums[mid] == target) {
                    return mid;
                }else if(nums[low]<=nums[mid]){
                    if (target<nums[mid] && target>=nums[low]) {
                        high=mid-1;
                    }else{
                        low=mid+1;
                    }
                }
               else if (nums[mid]<=nums[high]) {
                   if (target>nums[mid] && target<=nums[high]) {
                       low=mid+1;
                   }else{
                       high=mid-1;
                   }
               }
​
            }
            return -1;
        }
    }
}
