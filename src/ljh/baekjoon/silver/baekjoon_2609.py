# baekjoon 알고리즘 2609
# 2023.08.29 이주현

import sys
import math

a , b = map(int, sys.stdin.readline().rstrip().split())

min_num = min(a, b)
max_num = max(a, b)

while True:
    
    mod = max_num % min_num
    if mod == 0:
        print(min_num)
        print(int((a*b)/min_num))
        break
    max_num = min_num
    min_num = mod


