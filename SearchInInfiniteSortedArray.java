// TimeComplexity: O(logn)
// SpaceComplexity: O(1)

class Solution {
public:
    int search(const ArrayReader& reader, int target) {
        int low =0;
        int high =10001;

        while(low<=high) {
            int mid = low+ (high-low)/2;
            if(reader.get(mid) == target) {
                return mid;
            }
            if(reader.get(mid)<target) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;

        
    }
};



 // Time Complexity: O(logn)
 // SpaceComplexity: O(1)

class Solution {
public:
    int search(const ArrayReader& reader, int target) {
        int low =0;
        int high =1;
        while(reader.get(high) < target) {
            low = high;
            high = high*2;
        }

        while(low<=high) {
            int mid = low+ (high-low)/2;
            if(reader.get(mid) == target) {
                return mid;
            }
            if(reader.get(mid)<target) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;

        
    }
};
