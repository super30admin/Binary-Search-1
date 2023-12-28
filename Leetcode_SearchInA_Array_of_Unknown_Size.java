/*
 * Given a sorted array of unknown length and a number to search for,
 *  return the index of the number in the array. Accessing an element out of bounds throws exception. 
 * If the number occurs multiple times, return the index of any occurrence. 
 * If it isn’t present, return -1.
 */

//with the array reader
//tc: O(log n); search space ncreased in 2 fold, and then we again apply binary searchon that
//sc - constant
public class TargetInUnknownsizedRotatedArray {
    public int search(ArrayReader reader, int target) {
        int low = 0, high = 1;
        while (reader.get(high) <= target) {
            low = high;
            high = high * 2;

        }
        return binarySearch(reader, target, low, high);

    }

    public int binarySearch(ArrayReader reader, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) > target) // targt exists in left sub tree
            {
                high = mid - 1;
            } else // target lies in right subtree.
            {
                low = mid + 1;
            }
        }
        return -1;
    }

}
