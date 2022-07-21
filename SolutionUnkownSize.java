// Time Complexity : O(log(m) + log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

class SolutionUnkownSize {
    public int search(ArrayReader reader, int target){
        int low =0;
        int high =1;

        while(target<=reader.get(high)){
            low = high;
            high = 2*high;
        }
        while(low<=high){
            int mid = low +(high-low)/2;
            int tmp = reader.get(mid);
            if(target==tmp) return mid;

            if(tmp>target){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }
}
