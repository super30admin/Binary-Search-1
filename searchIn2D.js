/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}

 solutions
 => consider it as 1-D array
 how to convert 1- to indexes?
 elem/cols => column
 elem%cols => row
 */
 var searchMatrix = function(matrix, target) {
    let m = matrix.length;
    let n = matrix[0].length

    // low and high in the form of 1D array
    let low = 0;
    let high = m*n-1;

    while(low<=high) {
        let mid = Math.floor((low+high)/2); // worked but why

        // find corresponding column and row for the 2D matrix
        let c = mid % n;
        let r =  Math.floor(mid / n); // math.floor worked but why?
        console.log(r,c)

        let twoDcell = matrix[r][c]

        // Binary search
        if(twoDcell === target) {
            return true;
        } else if (target < twoDcell) {
            high=mid-1;
        } else {
            // check for the whole range 
            low=mid+1
        }
    }
    return false;
};