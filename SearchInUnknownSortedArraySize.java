import java.util.*;
import java.lang.*;
import java.io.*;

class SearchInUnknownSortedArray {
    public int search(ArrayReader reader, int target) {
        int left = 0, right = 1;
        // if left is less than right and target is greater element at index right then increment the right index by *2
        while(left <= right){
            if(reader.get(right) < target){
                left = right + 1;
                right *= 2;
                continue;
            }
            int mid = (right - left) / 2 + left;
            //if target is found at mid then return mid index
            if(reader.get(mid) == target){
                return mid;
            }
            //else increment left if target > element at mid position
            else
            if(reader.get(mid) < target){
                left =  mid + 1;
            } 
            //else decerement right
            else{
                right = mid - 1;
            }
        }
        return -1;
    }
}

//Time complexity - O(log(n)) n is the index of target value since we double the right index until we reach the upper bound
//Space complexity - O(1)
