class Solution {
public:
    int binary_search(const ArrayReader& a, int low, int high, int target){
        while(low<=high){
            int mid = low + (high - low)/2;
            if(a.get(mid)==target){
                return mid;
            }
            else if(a.get(mid)<target){
                low = mid+1;
            }
            else{
                high = mid -1;
            }
        }   
        
        return -1;
    }
    
    
    int search(const ArrayReader& reader, int target) {
        
        int high = 1; 
        while(reader.get(high)!=INT_MAX){
            high *=2;
        }
        
        return binary_search(reader, 0, high, target);
        
    }
};
