// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    public int search(ArrayReader reader, int target) {
        
        int start = 0;
        int end = 1;
        int mid;
        
        while((reader.get(end) < target) && (reader.get(end) < Integer.MAX_VALUE)){
            start = end ;
            end = end *2;
        }
            
        while(start<=end){
            
            mid = (start + end)/2;
        
            if(reader.get(mid) == target){
                return mid;
            }
            
            if(reader.get(mid)> target){
                end = mid -1;
            }else{
                start = mid +1;
            }
        }
        
        return -1;
    }
}