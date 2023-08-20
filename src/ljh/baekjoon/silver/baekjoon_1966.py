# baekjoon 알고리즘 1966
# 2023.08.20 이주현

## 다시 한 번 더 볼 문제!! 
import sys

num_of_testcase = int(sys.stdin.readline())

for _ in range(num_of_testcase):

    num_of_doc, target_i = map(int, sys.stdin.readline().strip().split())
    priority = list(map(int, sys.stdin.readline().strip().split()))

    index = 0
    # max_priority = max(priority)
    count = 0

    while len(priority) > 0 :
        max_priority = max(priority)
        print_num = priority.pop(0)
        target_i = target_i -1

        if max_priority == print_num:
            count = count + 1
            if target_i < 0:
                print(count)
                break
        else:
            priority.append(print_num)
            if target_i < 0:
                target_i = len(priority) - 1
        
'''
3

1 0
5

4 2
1 2 3 4

6 0
1 1 9 1 1 1

'''