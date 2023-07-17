//Time Complexity: (Log N)
  //Space Complexity: constant
public class SearchInRotatedSortedArrayUnknownSize {
    public int search(ArrayReader reader, int target) {
        // define an upper bound
        //check lower bound is less than target
        if(reader.get(0) > target){
            return -1;
        }

        // lets consider a random upper bound where value at upper bound is greater than target
        int right = 1;
        while(reader.get(right) < target){
            right = right * 2;
        }


        //apply binary search

        int begin = 0;
        int end = right;
        while(begin <= end){
            int mid = (begin + end)/ 2;
            int midValue = reader.get(mid);
            if(midValue == target){
                return mid;
            }
            if(midValue < target){
                begin = mid + 1;
            }
            if(midValue > target){
                end = mid - 1;
            }
        }

        return -1;

    }
}
