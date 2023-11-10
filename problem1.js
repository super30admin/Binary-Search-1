// Time Complexity : O(logmn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : divide by number of coloumns formula 


// Your code here along with comments explaining your approach in three sentences only

const searchMatrix = function(matrix, target) {
    let m = matrix.length //r
    let n = matrix[0].length //c
    let low = 0, high = (m*n) - 1
    
    //since got the boundries do a binary search
    while(low <= high){
        let mid = low + Math.floor((high-low)/2)
        //to locate the position of the mid divide (R) and modulus (c)by columns 
        let row = Math.floor(mid/n)
        let col = Math.floor(mid%n)
        if(matrix[row][col] === target) return true
        if(matrix[row][col] > target){
            high = mid - 1
        }
        else{
            low = mid + 1
        }
    }
    return false
};

let nums = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
let target = 13  
const result = searchMatrix(nums,target);

console.log(`Index of ${target}: ${result}`);

