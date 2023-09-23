# baekjoon 알고리즘 1003
# 2023.09.23 이주현

import sys
import math


num_of_T = int(sys.stdin.readline())

for _ in range(num_of_T): # 규칙성!! , 재귀는 오히려 시간 초과
    num = int(input())
    zero, one = 1, 0 
    for i in range(num):
        zero, one = one, zero+one 
    print(zero, one)