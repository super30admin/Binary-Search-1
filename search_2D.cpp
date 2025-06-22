// Time Complexity :O(log((no.of rows)*(no.of columns))) ==  O(log(m*n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :if(l<=r) condition in binary search forgot to write


// Your code here along with comments explaining your approach in three sentences only

//doing binary search same as if these are arranged in  an array . how ever without arranging in an array  
//we can access the element and the index of the mid in the array
//finding row array index divided by n
//and column index is array index % n

#include <iostream>
#include <vector>
using namespace std;

class Solution {
    bool binarysearch(vector<vector<int>>& matrix, int l, int h, int x){
        while(l <= h){   // base condition        
        
            int mid  =  l+ ((h-l)/2);
            int row = mid / matrix[0].size(); // finding row index 
            int column = mid % matrix[0].size(); // finding column index
            if(matrix[row][column] == x){
                return true;
            }
            if(matrix[row][column] > x){
               h = mid - 1; //changing high to mid-1
            }
            if(matrix[row][column] < x){
                l = mid + 1; //changing low to mid + 1
            }
        }
        return false;

    }
public:    
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if(matrix.empty()){ // if matrix is empty base case
            return false;
        }
        int rows = matrix.size();
        int columns = matrix[0].size();
        return binarysearch(matrix, 0, ((rows * columns)-1), target);
    }
};
