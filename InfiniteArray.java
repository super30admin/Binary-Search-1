// Time Complexity : O(log(n))
// Space Complexity :
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//simple binary search
// Your code here along with comments explaining your approach
class Solution {
    public int search(ArrayReader reader, int target) {
        int h = 0;
        while(reader.get(h) < target ){
            h = h + 1;
        }
        
        int l = 0;
        int mid = 0;
        while(l <= h){

            mid = (l + h )/2;
            if (reader.get(mid) == target){
                return mid;
            }
            if (target < reader.get(mid)){
                h = mid -1;
            }
            else{
                l = mid + 1;
            }
        }
        return -1;
        
    }

    }
