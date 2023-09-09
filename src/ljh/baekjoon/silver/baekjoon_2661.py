# baekjoon 알고리즘 2661
# 2023.09.09 이주현

import sys

def is_good(num):
    length = len(num)
    for idx in range(1, length//2 + 1):
        
        if num[-idx:] == num[-(idx*2):-idx]:
            return False
    else:
        return True

def make_seq(result):
    
    if len(result) >= N:
        print(result)
        exit() ## 최솟값만 구하고 python 종료
    
    if len(result) == 0:
        last = -1
    else:
        last = result[-1]
    for i in range(1, 4):
        if i != last:
            if is_good(result + str(i)):
                make_seq(result + str(i))

N = int(sys.stdin.readline())

result = ''
make_seq(result)
# print(result)