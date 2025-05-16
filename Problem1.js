//## Problem1 
//Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)

// Time Complexity : O(Log(N))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : YES, This being a very famous question, had to solve it multiple times i had memorized the formula or else i could not have solved had the formula not known to me
/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {
    //Set the starting points left and right
    let left = 0
    let right = matrix.length * matrix[0].length - 1
    //falttened the 2D array to makes it a 1d
    // and we know its sorted -> so we can directly perform binary search
    while(left<=right){
        let mid = Math.floor((left+right)/2)
        //convert 5.5 into a position in array 
        //Flattned Array need to find mid in 2d array
        let row = Math.floor(mid/matrix[0].length)
        let col = mid%matrix[0].length
        //
        //If element present , return true
        if(matrix[row][col] == target){
            return true
        }
        //If element we are at is less that means the left array WONT have it move the left pointer ahead 
        else if(matrix[row][col] < target){
            left = mid+1
        }
               //If element we are at is greater that means the right array WONT have it, move the right pointer 
        else{
            right = mid-1
        }
    }
    return false
};



// Your code here along with comments explaining your approach in three sentences only
