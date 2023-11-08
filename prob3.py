left, right = 0, 20000
while left < right:
    mid = (left + right) >> 1
    if reader.get(mid) >= target:
        right = mid
    else:
        left = mid + 1
return left if reader.get(left) == target else -1