// Time complexity-O(log(n))
// space complexity O(1);
// Did this code successfully run on Leetcode :no(problem is on premium only)
// Any problem you faced while coding this : no

/**

 * // This is ArrayReader's API interface.

 * // You should not implement it, or speculate about its implementation

 * interface ArrayReader {

 *     public int get(int index) {}

 * }

 */


#include<iostream>
using namespace std;
#include<vector>
class Solution {
public:
    int search(ArrayReader reader,vector<int>& nums, int target) {
        if (nums.empty()){return -1;}
        int low =0; int high =1;
        
        while(reader.get(high) < target){
          
              low =high;
              high = 2*high;


          
        }


        return binary_search(reader,low,high,target);
        
    }

    int binary_search(ArrayReader reader, int target, int low, int high){

        while(low <= high){

            int mid = low + (high - low)/2;

            if(reader.get(mid) == target){

                return mid;

            } else if (reader.get(mid) > target){

                high = mid - 1;

            } else {

                low = mid + 1;

            }

        }

        return -1;

    }


};