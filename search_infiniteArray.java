/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 
 Runtime : O(logn)
 Successfully ran in the leetcode
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int left=0;
        //int right=10000;
        int right = target-reader.get(0); //Better approach compared to the previous line.
        if(reader.get(right)==target)
            return right;
        while(left<=right)
        {
            int mid=left+(right-left)/2;
            int midelement=reader.get(mid);
            //System.out.println("left: "+left+"right: "+right+" , "+midelement);
            if(midelement ==target)
                return mid;
            else if(midelement>target)
                right=mid-1;
            else
                left=mid+1;
        }
        return -1;
    }
}
