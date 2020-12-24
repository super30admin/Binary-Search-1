// Time Complexity :O(log(n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//We will use teh slow and fast poiners to check the gap in which the number belongs.
//once we get the gap then we will do binary search within that gap.


/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        if(reader.get(0)==target){
            return 0;
        }
        int low=0;
        int high=1;
        while(reader.get(high)<Integer.MAX_VALUE){
            low=high;
            high=high*2;
            if(target>=reader.get(low) && target<=reader.get(high)){
                break;
            }
        }
        // System.out.println(low);
        // System.out.println(high);
        return binarySearch(reader,low,high,target);
        
    }
    
    public static int binarySearch(ArrayReader reader,int low,int high,int target){
        int midPoint=0;
        while(low<=high){
            midPoint=low+(high-low)/2;
            if(target<reader.get(midPoint)){
                high=midPoint-1;
            }else if(target>reader.get(midPoint)){
                low=midPoint+1;
            }else{
                return midPoint;
            }
        }
        
        return -1;
    }
}