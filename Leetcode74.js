// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach: Simply just concatenated the arrays inside base array into base array and then searched with linear approach and using indexOf().


/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {
    const arr = [].concat(...matrix);
    return arr.indexOf(target)!==-1?true:false;
};