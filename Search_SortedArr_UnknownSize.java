// Time Complexity : O(log (m*n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : -
// Any problem you faced while coding this : -

public class Search_SortedArr_UnknownSize {
    public int search(ArrayReader reader, int target){
        int l =0; //low
        int h = 1;//high
        while(target < reader.get(h)){
            l = h;
            h = 2*h;
        }

        while(l<=h){
            int mid = l + (h - l)/2;
            if(reader.get(mid) == target){
                return mid;
            }
            else if(reader.get(mid) < target){
                l = mid + 1;
            }
            else{
                h = mid -1;
            }
        }
        return -1;
    }   
}
