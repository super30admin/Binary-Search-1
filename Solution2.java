// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach



class Solution2 {
    public int search(ArrayReader reader, int target) {
             int l = 0;
            int h = 1;
            while(reader.get(h) <target){
                l = h;
                h = 2 * h;
            }
            return BinarySearchWithRange(reader, target, l , h);
        }
        
        private int BinarySearchWithRange(ArrayReader reader,int target,int l ,int h){
            while(l <= h){
                int mid = l + (h-l)/2; //integer overflow
                if(reader.get(mid) == target){
                    return mid;
                }else if(reader.get(mid) > target){
                    h = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
            return -1;
        }
    }