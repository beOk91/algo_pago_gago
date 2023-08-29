# baekjoon 알고리즘 1929
# 2023.08.29 이주현

import sys
import math

min , max = map(int, sys.stdin.readline().rstrip().split())

prime_cnt = 0 

def is_prime(num):
    if num == 1 :
        return False
    for i in range(2,int(math.sqrt(num)) + 1): # 효율성
        if num % i == 0:
            return False
    return True

for num in range(min , max + 1):
    if is_prime(num):
        print(num)
