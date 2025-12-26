class Solution {
public:
    int search(ArrayReader &reader, int target) {
        int low = 0;
        int high = 1; //  choose small window of [low,high] == [0,1] intially

        while (reader.get(high) < target){ 
            low = high ;
            high *= 2; // increasing the window size by double
        }

        while(low < high){ // binary search
            int mid = low + (high - low) / 2; // mid computation to prevent integer over flow
            if(reader.get(mid) == target) return mid; // target found at mid

            if(reader.get(mid) > target){ // target is on left of mid
                high = mid - 1;// so decrease high pointer one step down from prev mid
            }
            else{// target is on right side of mid
                low = mid + 1; //  so increase low pointer oen step up from prev mid
            }
        }

        if (reader.get(low) == target) return low;// edge case where low == high, cant be included in while so is dealt separately
        // we can low or high to check here as low == high anyways
        return -1;
        // we return to indicate everything possible was tried but target not found
    }
};
