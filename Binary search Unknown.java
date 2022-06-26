
class Solution {
    public int search(ArrayReader reader, int target) {
        int low=0;
        int high=1;
        //Finding the range for the binary search
        while(reader.get(high)<target){
            low=high;
            high=2*high;
        }
        while (low<=high){
            //Finding middle element and checking for the target
            int mid=low+(high-low)/2;
            if (reader.get(mid)==target) return mid;
            //Compressing the search space by moving low pointer to the one place after the middle element
            else if (reader.get(mid)<target){
                low=mid+1;
            else{
                high=mid-1
            }
            }
        }
        return -1;
    }}