// time complexity - O(log n)
public class Problem3{
    public int search(ArrayReader reader, int target){
        int low = 0, high = 1;
        //this block has log(n)
        while(reader.get(high) <= target){
            low = high;
            high = high * 2;
        }
        return binarySearch(reader, target, low, high);
    }

    // O(log(high - low + 1)) 
    // worst case we end up search last half or first half of the array
    // asymptoticaly O(log n)
    private int binarySearch(ArrayReader reader, int target, int low, int high){
        while(low <= high){
            int mid = low + (high - low)/2;
            int x = reader.get(mid);
            if(x == target) return mid;
            else if(target < x){
                high = mid -1;
            }else{
                low = mid +1;
            }
        }
        return -1;
    }
}