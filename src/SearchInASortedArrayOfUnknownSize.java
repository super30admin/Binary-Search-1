
public class SearchInASortedArrayOfUnknownSize {

	//Time complexity=O(log n);
	// Space Complexity = O(1);
	public int search(ArrayReader reader, int target) {
        // first find the high, increasing by 2 so array is increased in half.
        int low=0, high=1,mid=0;
        
        while ( target>=reader.get(high)){
        	high*=2;
        }

        while (low<=high){
            mid= low + (high-low)/2;
            if (reader.get(mid)==target){
                return mid;
            }
            if (reader.get(mid)>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return -1;
    }

}
