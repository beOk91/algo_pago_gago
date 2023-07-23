# baekjoon 알고리즘 2751
# 2023.07.23 이주현

import sys
num_of_arr = int(sys.stdin.readline()) # python time out - input()보다 sys.stdin이 빠르다

arr = list()
for i in range(num_of_arr):
	arr.append(int(sys.stdin.readline()))

arr.sort()

for num in arr:
    print(num)