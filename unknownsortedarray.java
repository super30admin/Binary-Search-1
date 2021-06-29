// Time Complexity : O(log n)
// Space Complexity : O(1)

public class UnknownSortedArray {

    public int search(ArrayReader reader, int target){

        int low = 0, high = 1;

        while(reader.get(high) <= target){
            low = high;
            high = high * 2;

        }
		while(low <= high){
			int mid = low + (high - low) / 2;
			if(reader.get(mid) == target){
				return mid;
			}
			else if(reader.get(mid) > target){
				high = mid - 1;
			}
			else{
				low = mid + 1;
			}		
		}
		return -1;
    }
}