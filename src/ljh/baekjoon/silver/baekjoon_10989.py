# baekjoon 알고리즘 10989
# 2023.07.23 이주현

import sys
num_of_arr = int(sys.stdin.readline())

arr = [0 for i in range(10001)] # 메모리 초과하지 않기 위해 index로 기록

for i in range(num_of_arr):
    num = int(sys.stdin.readline())
    arr[num] = arr[num] + 1

for i in range(len(arr)):
    for _ in range(arr[i]):
        print(i)

