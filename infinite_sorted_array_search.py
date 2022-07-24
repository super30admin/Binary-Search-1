from typing import List


class InfiniteArraySearch:
    def __init__(self, arr: List[int], target: int):
        self._a = arr
        self._target = target

    def search(self) -> int:
        _low = 0
        _high = 1
        while self._a[_high] < self._target:
            _low = _high
            _high = _high * 2
        while _low <= _high:
            _mid = _low + ((_high - _low) // 2)
            if self._a[_mid] == self._target:
                return _mid
            elif self._a[_mid] < self._target:
                _low = _mid + 1
            else:
                _high = _mid - 1
        return -1


if __name__ == "__main__":
    arr_ = [1, 2, 3, 4, 5, 6, 7, 8, 9, 20, 21, 22, 34, 39, 45, 47, 49, 54, 57, 61]
    target_ = 21
    obj = InfiniteArraySearch(arr_, target_)
    print(obj.search())
