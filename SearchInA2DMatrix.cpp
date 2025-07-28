#include<iostream>
#include<vector>
using namespace std;
/*
->Using the sizes of the row and column of the matrix
->We can imagine a falttened 2D matrix where each index contains an array of numbers
-> Time Complexity: Binary Search, Space Complexity: O(1)
*/
class Solution{
public:
    bool searchMatrix(vector<vector<int>> &matrix, int target){
        int row=matrix.size();
        int column=matrix[0].size();

        int startIndex=0;
        int endIndex=row*column-1;
        while(startIndex<=endIndex){
            int mid=startIndex+(endIndex-startIndex)/2;
            //creating a variable "element" to track each number in the matrix 
            int element=matrix[mid/column][mid%column];
            if(element==target) return true;
            else if(element<target) startIndex=mid+1;
            else endIndex=mid-1;
        }
        return false;
    }
};