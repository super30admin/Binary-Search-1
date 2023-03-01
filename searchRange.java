// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
 Divide the array into two halves and individually check if the targets are present there.
 Store result array as -1,-1 initially. 
 If nums[mid] == target, store into the result array. 
 */
public class searchRange {
    public int[] searchRange(int nums[],int key){
        int result[]={-1,-1};
        int low = 0; 
        int high = nums.length-1;
        int mid;
        while(low <= high){
             mid = (low+high)/2;
            if(nums[mid] == key){
            int left = mid;
            int right = mid;
            
            while(left > 0 && nums[left-1] == key){
                left --;
            }
            while(right < nums.length-1 && nums[right+1]==key){
                right++;
            }
        result[0] = left;
        result[1] = right; 
        return result;
            }
        else if(key > nums[mid]){
            low = mid+1;
        }
        else if(key < nums[mid]){
            high = mid-1;
        }

       
    }
    return result;
}

}
