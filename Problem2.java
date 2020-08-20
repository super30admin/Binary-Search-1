// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Faced problem to find the upper bound. Class was helpful.


//Approach

/*
Step 1: start with low =0 and high =1
Step 2: Move low to high and high to 2 times high as long as high is less than target. Once high becomes more than the target,
then we have our range where our target lies.
Step 3: Once we have the range, call a binary search on the range between high and low.
*/

import java.util.*;
class Problem2 {
    public int search(int[] reader, int target) {  
        // Step 1: start with low =0 and high =1      
        int low = 0;
        int high =1;
        

        //Step 2: Move low to high and high to 2 times high as long as high is less than target. Once high becomes more than the target,
        //then we have our range where our target lies.
        while(reader[high]<target){
            low = high;
            high = 2* high;
        } 
        //Step 3: Once we have the range, call a binary search on the range between high and low.
        return binarySearch(reader, target, low, high);
        
    }


    public int binarySearch(int[] reader, int target, int low, int high){
        while(low<=high){
            int mid = low+(high-low)/2;
            if(target==reader[mid]){
                return mid;
            }else if(target>reader[mid]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }
}


class Driver { 
    public static void main(String args[]) 
    { 
        SearchSolution s = new SearchSolution(); 
        int nums[] = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(s.search(nums, target)); 
        target = 3;
        System.out.println(s.search(nums, target)); 

    } 
}