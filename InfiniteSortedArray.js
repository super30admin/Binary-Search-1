// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

var search = function (reader, target) {

    let low = 0, high = 1;
    while (reader.get(high) < target) {
        low = high;
        high = high * 2;
    }

    while (low <= high) {
        let mid = Math.floor(low + (high - low) / 2);
        if (reader.get(mid) === target) return mid;
        else if (reader.get(mid) < target) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return -1;

};