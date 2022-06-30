// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class Main {
    public static void main(String[] args) {        
        int nums[] = {1,10,15,20,40,80,90,100,120,150};
        System.out.println(findInInfiniteArray(nums, 100));
    }
    
    public static int findInInfiniteArray(int nums[], int target) {
        if(nums[0] == target) return 0;
        int index = 1;
        while(nums[index] < target)
            index = index * 2;
        
        int low = index / 2;
        int high = index;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                low = mid + 1;
            else
                high = high - 1;
        }
        return -1;  
    }
}