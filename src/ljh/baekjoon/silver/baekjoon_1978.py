# baekjoon 알고리즘 1978
# 2023.08.29 이주현
import sys
import math

num_of_a = int(sys.stdin.readline())
array = list(map(int,sys.stdin.readline().split() ))

prime_cnt = 0 

def is_prime(num):
    if num == 1 :
        return False
    for i in range(2,int(math.sqrt(num)) + 1): # 효율성
        if num % i == 0:
            return False
    return True

for num in array:
    if is_prime(num):
        prime_cnt +=1 
    

print(prime_cnt)
    