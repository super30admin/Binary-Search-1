// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Solution {
    public int search(ArrayReader reader, int target) {
        int s = 0;
        int e = 1;
        //This would set the upper limit to binary search
        while(reader.get(e) < target){
            s = e + 1;
            e = e * 2;
        }
        //Normal binary search
        while(s <= e){
            int mid = s + (e - s)/2;
            if(reader.get(mid) == target){
                return mid;
            }
            else if(target > reader.get(mid)){
                s = mid + 1;
            }
            else{
                e = mid - 1;
            }
        }
        return -1;
        
    }
}