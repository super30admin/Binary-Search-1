package BinarySearch1;

//Time Complexity : O(logn) for searching using binary search
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


//Your code here along with comments explaining your approach
//Intuition here is, Since the array size is unknown we can start low at 0 and high at 1 and then keep increasing the pointers untill element is found.
//This is to reduce the number of steps and search space by half acc to algo
//otherwise normal binary search is done

class Solution {
    public int search(ArrayReader reader, int target) {
        
        int left=0, right =1;
        if(reader.get(0) == target)
        {
            return 0;
        }
        while(reader.get(right) != Integer.MAX_VALUE &&  reader.get(right) < target)
        {
            left=right;
            right=right * 2;
        }
        
       return  binarySearch(reader,left,right,target);
        
    }
    
     private static int binarySearch(ArrayReader reader,int low,int high,int target)
    {
        int pivotIndex  ;
        while(low<=high)
        {
             pivotIndex = low +( high-low)/2 ;
            
            if(reader.get(pivotIndex) == target)
            {
                return pivotIndex;
            }
            else if(reader.get(pivotIndex) > target)
            {
                high = pivotIndex-1;
            } else 
            {
                low = pivotIndex+1;
            }
        }
        return -1;
    }
}