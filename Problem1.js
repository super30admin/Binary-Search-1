// Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)
// accepted in LeetCode
// tc is O(m*n) and sc O(1) is 

var searchMatrix = function(matrix, target) {

    if(matrix == null || matrix.length== 0){
         return false;
       // console.log("false")
        }
    let m = matrix.length;
    let n = matrix[0].length;

    let left =0; right = m*n-1;

    while(left<= right){

    let mid = Math.floor(left+(right-left)/2);
    let r = Math.floor(mid/n);
    let c = mid%n;

    if(matrix[r][c] == target){ 
       
       // console.log("true")
        return true
    }

    else if(matrix[r][c] > target){
        right =  mid-1;
    }
    else{
        left= mid+1;
    }
    
    
    }

  
  //console.log("false")
  return false; 
};

// let matrix = [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]];
// let target = 3;

// searchMatrix(matrix, target);