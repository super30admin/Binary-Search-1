/*

Time Complexity : Binary search complexity O(log(n))
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:

1. I am initializing left index as 0 and right index is 1 as the size of the array is not defined
2. Now I am checking is the given target is even greater than element at the right index, then I am setting
my left index to right and increasing right 2 like right*2
3. Now I am looking for the target in the same manner we search in the basic binary search,
4. Taking mid and comparing value at the mid with target and based on the comparison results I am updating
my left and right pointer,
5. In this problem the main difference is, I am using interface ArrayReader to get the value for the mid index as
we don't know the size of the array.

 */
interface  ArrayReader {
    default int get(int k) {
        return Integer.MAX_VALUE;
    }
}
class ArrayReaderImpl implements ArrayReader {
    private int [] nums = null;
    public ArrayReaderImpl ( int [] a){
        nums = a;
    }

    @Override
    public int get(int k) {
        if( k >= nums.length || k < 0){
            return Integer.MAX_VALUE;
        }else {
            return nums[k];
        }
    }
}

public class SearchInSortedArrayOfUnknownSize {
    public int searchElement(ArrayReader reader, int target){
        if(reader.get(0) == target){
            return 0;
        }

        int left = 0;
        int right = 1;

        while(reader.get(right)<target){
            left = right;
            right = right*2;
        }

        int pivot, num;

        while(left<=right){
            pivot = left + (right-left)/2;

            num = reader.get(pivot);

            if(num == target){
                return pivot;
            }else if(num>target){
                right = pivot-1;
            }else{
                left = pivot+1;
            }
        }
        return -1;
    }

    public static void main(String [] args){
        SearchInSortedArrayOfUnknownSize s = new SearchInSortedArrayOfUnknownSize();
        ArrayReader a = new ArrayReaderImpl(new int[]{-1,0,3,5,9,12});
        System.out.println(s.searchElement(a,9));
    }
}
