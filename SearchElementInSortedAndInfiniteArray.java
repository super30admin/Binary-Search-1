// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : NA
// Any problem you faced while coding this : Couldn't think of better way

public class SearchElementInSortedAndInfiniteArray {

    //Using linear search we just find first occurance of the element
    public static int search(int[] nums, int n){
        int i = 0;
        while(nums[i] <= n){
            if(nums[i] == n){
                return i;
            } else {
                i++;
            }
        }

        return -1;
    }

    public static void main(String args[]){
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10};
        System.out.println(search(nums, 6));
    }
}
