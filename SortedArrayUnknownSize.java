// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach
//I will take left=0, right=1, I will check whether right<target, then I will assign l=r and 
//I will multiply right by 2, if l>r return -1, if my mid is less than target  left=mid-1 else right=mid-1

class SortedArrayUnknownSize {
    public int search(ArrayReader reader, int target) {
        int left = 0;
        int right = 1;
        int mid;
        
        if(reader==null) return -1;
        
        while(reader.get(right)<target){
            left=right;
            right=right*2;
        }
        return binarySearch(reader, target, left, right);
    }
    public int binarySearch(ArrayReader reader, int target, int left, int right){
        if(left>right) return -1;
        
        int mid = left+(right-left)/2;
        
        if(reader.get(mid)==target) return mid;
        
        if(reader.get(mid)<target)
            return binarySearch(reader, target, mid+1, right);
        
        else{
            return binarySearch(reader, target, left, mid-1);
        }
    }
}