

/*          Successfully executed on leetcode
*           No problems faced
*
*           Time complexity: O(logn), where n is index of target element
*           Space Complexity: O(1)
*
* */

public class SearchInSortedArrayUnknownSize {
    public int search(ArrayReader reader, int target) {
        int i=0;
        int previousCheck = 0;
        if(reader.get(0) == target)
            return 0;
        while(true){
            int x = (int) Math.pow(2,i);
            if(reader.get(x) == 2147483647){
                return normalSearch(reader, target, previousCheck+1);
            }
            else if(reader.get(x) == target){
                return x;
            }
            else{
                if(target > reader.get(x)){
                    previousCheck = x;
                    i++;
                }
                else if (target < reader.get(x)){
                    return binarySearch(reader, target, previousCheck+1, x-1);
                }
            }
        }
    }

    public int binarySearch(ArrayReader reader, int target, int low, int high){
        int mid = low + (high-low) /2;
        if(high >= low){
            if(reader.get(mid) == target)
                return mid;
            else if (target > reader.get(mid) )
                return binarySearch(reader, target, mid+1, high);
            else
                return binarySearch(reader, target, low, mid-1);
        }
        return -1;
    }

    public int normalSearch(ArrayReader reader, int target, int start){
        while(true){
            if(reader.get(start) == 2147483647)
                return -1;
            if(reader.get(start) == target)
                return start;
            else
                start = start + 1;
        }
    }
}
