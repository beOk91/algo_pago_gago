# baekjoon 알고리즘 1158
# 2023.08.20 이주현

import sys

num_of_people, number = map(int, sys.stdin.readline().strip().split())

people = []
for n in range(0, num_of_people):
    people.append(n)

start_index = 0
number = number - 1

print_arr = [] #  ['<']
while len(people) > 0:
    # print("start_index" , start_index)
    # print("number " , number)

    if start_index + number >= len(people):
        index = (start_index + number) % len(people)
    else:
        index = start_index + number

    p = people.pop(index)
    start_index = index
    
    # print(p + 1)
    print_arr.append(str(p+1))

# 프린트 형식 신경 쓰기!
print('<'+', '.join(print_arr)+'>')
