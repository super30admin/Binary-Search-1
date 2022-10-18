// Time complexity log(n)
// Space complexity O(1)

func search(_ reader: ArrayReader, _ target: Int) -> Int {
    var low = 0, high = 10
    
    while target > reader.get(high) {
        low = high + 1
        high = high * 2
    }
    
    while low <= high {
        var middle = low + (high - low) / 2
        
        if reader.get(middle) == target {
            return middle
        } else if reader.get(middle) > target  {
            high = middle - 1
        } else {
            low = middle + 1
        }
    }
    return -1
}
