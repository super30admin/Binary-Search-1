//Time: O(log(mn)), Space O(1)
var searchMatrix = function(matrix, target) {
    let row = matrix.length, col = matrix[0].length;
    let low = 0, high = (row * col) - 1;
     
    while(low <= high){
        let mid = low + Math.floor((high-low)/2);
        let r = Math.floor(mid / col);
        let c = mid % col
        if(matrix[r][c] == target){
            return true
        }else if(matrix[r][c]<target){
            low = mid + 1
            
        }else{
            high = mid - 1
            
        }
    }
    return false 
};