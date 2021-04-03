// Time Complexity : O(logn) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int m = matrix.size();
        int n = matrix[0].size();
        int l = 0;
        int r = m*n-1;
        int mid, pivotElement;
        while(l<=r){
            mid = l+(r-l)/2;
            pivotElement = matrix[mid/n][mid%n];
            if(pivotElement==target){
                return true;
            }
            else if(target<pivotElement){
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        return false;
    }
};

// // Time Complexity : O(nlogn) 
// // Space Complexity : O(1)
// // Did this code successfully run on Leetcode : yes
// // Any problem you faced while coding this : yes


// class Solution {
// public:
//     bool searchMatrix(vector<vector<int>>& matrix, int target) {
//         int l = 0;
//         int h = 0;
//         int m = 0;
//         for(int i=0;i<matrix.size();i++){
//             l = 0;
//             h = matrix[i].size()-1;
//             while(l<=h){
//                 m = l+(h-l)/2;
//                 if(matrix[i][m]==target){
//                     return true;
//                 }
//                 else if(matrix[i][m]<target){
//                     l = m+1;
//                 }
//                 else{
//                     h = m-1;
//                 }
//             }
            
//         }
//         return false;
//     }
// };
