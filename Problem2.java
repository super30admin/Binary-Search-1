// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : understood from class


// Your code here along with comments explaining your approach
//search in a sorted array of unknown size

class Solution {
    public int search(ArrayReader reader, int target) {
        
        int high=1;
        while(reader.get(high)!=Integer.MAX_VALUE){high*=2;}
        return binarySearch(reader, target,0,high);}
    
    private int binarySearch(ArrayReader reader, int target, int low, int high){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(reader.get(mid)==target){return mid;}
            else if(reader.get(mid)<target){low=mid+1;}
            else{high=mid-1;}
        }return -1;
    }
}