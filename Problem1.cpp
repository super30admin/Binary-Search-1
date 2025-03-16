// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Difficulty calculating x and y axis of given number.


// Your code here along with comments explaining your approach in three sentences only
// 1. used binary search
// 2. first element is 0 and last element is m*n.
// 3. converted this number into x and y axis of matrix

class Solution {
public:
    int binarys(vector<vector<int>>& matrix,int f,int l,int target){
        int mid= f + (l-f)/2;
        if(f>l){
            return 0;
        }
        int matrixa= (matrix.size()), matrixb=(matrix[0].size());
        int midx=((mid-1)/matrixb);
        int midy=((mid-1)%matrixb);
        cout<<matrix[midx][midy]<<' ';
        if(matrix[midx][midy]==target){
            return 1;
        }
        else if(matrix[midx][midy]>target){
            return binarys(matrix,f,mid-1,target);
        }
        else{
            return binarys(matrix,mid+1,l,target);
        }
    }
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int f=1,l=( (matrix.size()) * (matrix[0].size()) );
        return binarys(matrix,f,l,target);
    }
};