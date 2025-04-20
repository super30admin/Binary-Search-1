/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {
    var m = matrix.length; 
    var n = matrix[0].length;


    var low = 0; 
    var high = (m*n)-1;

        while(low <= high){

            var mid = Math.floor(low + ((high - low)/2));

            var r = Math.floor(mid/n); 

            var c = Math.floor(mid%n);
            
            if(matrix[r][c] == target) return true;

            else if(matrix[r][c] > target){

                high = mid - 1;

            } else {

                low = mid + 1;

            }

        }

        return false;
    
};