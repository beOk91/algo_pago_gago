# baekjoon 알고리즘 1912
# 2023.10.08 이주현

import sys

num = int(sys.stdin.readline())

num_list = list(map(int, sys.stdin.readline().strip().split()))

result = min(num_list)

for i in range( 1 , len(num_list)):
    num_list[i] = max(num_list[i], num_list[i] + num_list[i-1]) # 이전까지 모든 수의 합 중 큰값

print(max(num_list))