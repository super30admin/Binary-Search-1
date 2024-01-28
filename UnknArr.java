//time complexity: O(log(m) + log(n)); worst case log(n) takes over
//space complexity: O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : condition check, syntax - coding speed is not coming due to lack of confidence (may be!)

//Sorted array has been given : Strictly Increasing array
//find range
//find an element
//modular code

public class UnknArr {

    public int search(ArrayReader reader, int target){
        //Let's find range first
        int low =0;
        int high = 1;
        
        if(reader.get(0) == target) return 0;
        if(reader.get(0)> target) return -1;
        
        while(low<high) {    
            if(reader.get(low) <= target && reader.get(high) > target){
                return binarySearch(reader, low, high, target);
            } else{
                low=high;
                high=high*2; //doubling down index pointer to find an element
            }
        }
        return -1;
    }

    public int binarySearch(ArrayReader arrayReader, int low, int high, int target){
        int index=0;
        //If mid itself is target //never fails as it will return infinity and not null

        while (low<=high) {
            int mid = low + (high -low)/2;
            if(arrayReader.get(mid) == target) return mid;

            if(arrayReader.get(low) <= target && arrayReader.get(mid) > target){
                high = mid-1;
            }else{ 
                low = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        UnknArr obj = new UnknArr();
        int target = 100;
        //search(ArrayReader ArrayReader, target);
        
    }
    
}
