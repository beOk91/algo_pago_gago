# baekjoon 알고리즘 1920
# 2023.07.23 이주현

num_of_array = int(input())
array = set(map(int, input().split())) ## time out 으로 인해 set으로 받기!!

num_of_q = int(input())
array_of_q = list(map(int, input().split()))

for q in array_of_q:
    print(1) if q in array else print(0)
  