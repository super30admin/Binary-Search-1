//the idea is to calculate the range of array where our target is present and applying binary search on them

class Solution {
public:
    int search(const ArrayReader& reader, int target) {

        int low = 0;
        int high = 1;

        while(reader.get(high)<target){
            low=high;
            high= 2*high;
        }
        while (low<=high){
            int mid = low + (high - low)/2;

            if(reader.get(mid)==target){
                return mid;
            }else if (reader.get(low)<=target && reader.get(mid)>target){
                high =mid -1;
            }else{
                low =mid+1;
            }
            
        }
        return -1;
        
    }
};