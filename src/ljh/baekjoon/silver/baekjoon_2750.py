# baekjoon 알고리즘 2750
# 2023.07.23 이주현

num_of_arr = int(input())

arr = list()
for i in range(num_of_arr):
	arr.append(int(input()))

arr.sort()

for num in arr:
    print(num)