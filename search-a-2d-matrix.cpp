// The code treats the 2D matrix as a 1D sorted array and performs a binary search.
// It calculates mid, extracts the corresponding matrix element, and adjusts the search space based on the comparison with the target.
// The search continues until the target is found or the search space is exhausted.
// Time Complexity: O(log(m * n))
// Space Complexity: O(1)

#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if(matrix.empty() || matrix[0].empty()){
            return false;
        }
        int m = matrix.size(), n= matrix[0].size();
        int start =0, end = m*n-1;
        while(start<=end){
            int mid = start +(end-start)/2;
            int e= matrix[mid/n][mid%n];
            if(target<e){
                end = mid-1;
            } else if(target >e){
                start = mid+1;
            } else{
                return true;
            }
        }
        return false;
    }
};