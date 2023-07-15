// Time Complexity :O(log(mn))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach in three sentences only

/*
we will consider the matrix to be an array from 0-(mn-1) and will perform the binary search 
on the matrix., we will convert the indices to matrix rows and columns whenever needed to compare
the mid with target
*/
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {

        int m = matrix.size();
        int n = matrix[0].size();
        
        if(matrix.size()==0){
            return false;

        }

        int low=0;
        int high= (m*n)-1;

        while(low<=high){
            int mid = low + (high-low)/2;
            int r = mid/n;
            int c = mid%n;
            if(matrix[r][c]==target){
                return true;

            }
            else if(matrix[r][c]<target){

                low = mid+1;
                
            }
            else{
                high = mid-1;
            }
        }

        return false;

        
        
    }
};
