// Time Complexity : log(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int search(ArrayReader reader, int target) {
        int start=0;
        int end=1;
        while(reader.get(end)<target && reader.get(end)<Integer.MAX_VALUE){
            start=end+1;
            end=2*end;
        }
        
        while(start<=end){
            int mid=(start+end)/2;
            if(reader.get(mid)==target) return mid;
            if(reader.get(mid)<target) start=mid+1;
            else end=mid-1;
        }
        
        return -1;
    }
    
    
}