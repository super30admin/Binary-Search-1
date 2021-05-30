//time complexity: O(log n)
// space complexity: O(log n)
public class UnknownSizeArray {
    public int search(ArrayReader reader, int target) {
        int low =0;
        int high =1;
        while(reader.get(high)<target){
            low=high;
            high=2*high;
        }
        return binarySearch(reader, low, high, target);
    }
    
    public int binarySearch(ArrayReader reader, int low, int high, int target){
        while(high >= low){
            int mid = low + (high-low)/2;
            if(reader.get(mid)== target){
                return mid;
            }
            else if (reader.get(low)<= target && reader.get(mid)> target){
                high= mid-1;
            }
            else{
                low= mid+1;
            }
        }
        return -1;
    }    
}
