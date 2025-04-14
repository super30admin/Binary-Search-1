// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
/*
interface for get
 */
interface ArrayReader{
    int get(int index);
}
/*
class to implement get where if array is out of bounds returns infinity
 */
class ArrayReaderImpl implements ArrayReader {
    private int [] arr;
    public ArrayReaderImpl(int [] arr){
        this.arr = arr;
    }

    public int get(int index){
        if(index<0 || index>=arr.length){
            return (int) Math.pow(2,31)-1;
        }
        return arr[index];
    }
}
class UnknownSizeArray {
    /*
    Creates a low and high and slides the window everytime low and high is checked to new low and high.
    low = high+1 and high = 2 times the high
    2 times as durings earch we /2
    @param reader get and target
    @return final index
     */
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        while(reader.get(high)<target){
            low=high+1;
            high = high*2;
        }
        return binarySearch(reader, target, low, high);
    }
    /*
    basic binary search on found low and hig
    @param reader, target, low, high
    @return index or -1
     */
    private int binarySearch(ArrayReader reader, int target, int low, int high){
        while(low<=high){
            int mid = low+(high-low)/2;
            int midVal = reader.get(mid);
            if(midVal==target){
                return mid;
            }
            else if(midVal<target){
                low=mid+1;
            } else{
                high = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        UnknownSizeArray obj = new UnknownSizeArray();
        int [] nums = {-1,0,3,5,9,12};
        ArrayReader reader = new ArrayReaderImpl(nums);
        System.out.println(obj.search(reader, 9));
        System.out.println(obj.search(reader, 14));
    }
}
