// Time Complexity: O(log n + log n) = O(log n)
// Space Complexity: O(1)
// Steps: Find the boundary, and do BS in the boundary

class Solution {
    public int search(ArrayReader reader, int target) {
        int high = 1;
        int low = 0;
        //find max boundary for high
        while(reader.get(high) != Integer.MAX_VALUE && reader.get(high) < target){
            high = high * 2;
            if(reader.get(low) < target)
                low++;
        }
        
        return binarySearch(reader, target, low, high);
    }
    
    private int binarySearch(ArrayReader reader, int target, int low, int high){
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            if(reader.get(mid) == target){
                return mid;
            }
            else if(reader.get(mid) < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
}