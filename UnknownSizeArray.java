// TC : O(log n)
// SC :  log(1)

//We need to  keep moving right until we find number that is less than target
//Then use binary search algo
public class class UnknownSizeArray {
    public int search(ArrayReader reader, int target) {

        int low  = 0;
        int high = 10;
        int mid = 0;

        while(low <=high){
            mid = (low + high)/2;

            if(reader.get(mid) == target)
                return mid;
            // binary search
            if(reader.get(low) < target <= reader.get(high)){
                if(reader.get(mid) < target)
                    low = target +1;

                if(reader.get(mid) >= target){
                    high = mid -1;
                }


            }
            else{   // move to the right side with bigger range
                low = high +1;
                high = 2* high;
            }


        }
        return -1;

    }