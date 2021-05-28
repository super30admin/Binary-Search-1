// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : -

class SearchInArrayOfUnknownSize{
    int search(const ArrayReader& reader, int target) {
        int low = 0;
        int high = 1;

        while(reader.get(high) < target){
            low = high;
            high = high*2;
        }

        while(low<=high){
            int mid = low + (high-low)/2;
            if(reader.get(mid) == target) return mid;
            else if(reader.get(mid) < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}