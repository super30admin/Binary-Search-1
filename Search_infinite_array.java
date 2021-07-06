/*
    Time Complexity :  O(log(N)) N = position where target is 
    Space Complexity :  O(1) No Auxilary Space is used
    is Tested on Leetcode : No because it is locked, I dont have premium subscription
    Difficulty faced : No I find it easier after class discussion
    Technique I learned : Binary Search is not all about devide array in two half,
    you can also use expansion technique
*/

public class Search_infinite_array {
    public int search(ArrayReader reader, int target){
        int left = 0;
        int right =1;
        // find upper limit for the element
        while(reader.get(right) < target){
            left = right;
            right = right*2;
        }

        return binarySearch(reader,target, left,right);
    }

    int binarySearch(ArrayReader reader, int target, int left, int right){
        while(left  <= right){
            mid = left + (right-left)/2;
            if (reader.get(mid) == target) return mid;
            else if(reader.get(mid) > target){
                right = mid -1;
            }else{
                left = mid +1;
            }
        }
        return -1;
    }
}