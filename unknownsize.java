// Time complexity : O(logn)
// Space Complexity: O(1)
class Solution{
    public int search(ArrayReader reader, int target){
        int low = 0;
        int high = 1;

        while(arr[high] < target){
            low = high;
            high = 2*high;
        }

        while( low <= high){
            mid = low + ( high-low ) / 2;
            if(target == reader.get(mid)){
                return mid;
            }
            else if(target < reader.get(mid)){
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }
}