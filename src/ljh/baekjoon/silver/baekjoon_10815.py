# baekjoon 알고리즘 10815
# 2023.07.29 이주현

import sys
num_of_arr = int(sys.stdin.readline())
array = set(map(int, sys.stdin.readline().split()))

num_of_q = int(sys.stdin.readline())
q_arr = list(map(int, sys.stdin.readline().split()))

for q in q_arr:
    print(1) if q in array else print(0)
