class Solution {

    search = function(reader, target) {

        var low = 0; 
        var high = 1;

        while(reader.get(high) < target){

            low = high;

            high = 2 * high;

        }

        return binarySearch(reader, target, low, high);

    }

    binarySearch = function(reader, target, low, high){

        while(low <= high){

            var mid = Math.floor(low + (high - low)/2);

            if(reader.get(mid) == target){

                return mid;

            } else if (reader.get(mid) > target){

                high = mid - 1;

            } else {

                low = mid + 1;

            }

        }

        return -1;

    }

}

