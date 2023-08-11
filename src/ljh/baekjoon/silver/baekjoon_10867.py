#  baekjoon 알고리즘 10867
# 2023.08.11 이주현

import sys

num_of_N = int(sys.stdin.readline())

nums_set = set(map(int, sys.stdin.readline().strip().split()))
nums_list = list(nums_set)
nums_list= sorted(nums_list)

print(*nums_list , sep = " ")
