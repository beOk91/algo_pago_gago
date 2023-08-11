#  baekjoon 알고리즘 11651
# 2023.08.11 이주현

import sys

num_of_dots = int(sys.stdin.readline())

dots_list = []
for _ in range(num_of_dots):
    dot = list(map(int, sys.stdin.readline().split()))
    dot.reverse()
    
    dots_list.append(dot)

dots_list = sorted(dots_list) # list도 sort 가 먹는다!

for dot in dots_list:
    print(dot[1] , dot[0])
