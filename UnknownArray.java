/**
/**
 * what i know ? array is sorted, and fund the number, so i can try use binay search. 
 * 
 * thought process: thought to using a constant multiplier to do the binary search but the time 
 * complexity is nlog(m), next using a exponential multiplier which is optimal than the other process, becuase it has
 * o(logm) + log(n)***
 * 
 * back track: not helpful
 * 
 * 
 * 
 * issues:
 * int mid = low+ (high - low)/2;
 * wirte while condition withour break statements
 * used a mid even it is not needed
 */
 

class Solution {
    public int search(ArrayReader reader, int target) {
        int low =0;
        int high = 1;
        while(high >= low){
            int mid = low + (high - low)/2;
            if(reader.get(low) <= target && reader.get(high) >= target){
                break;
            }
            low = high+1;
            high = high * 2;
        }
        while(high >= low){
            int mid = low+ (high - low)/2;
            if(reader.get(mid) == target) return mid;
            if(reader.get(mid) >= target){
                high = mid -1;
            } else {
                low = mid +1;
            }
        }
        return -1;
    }
}
