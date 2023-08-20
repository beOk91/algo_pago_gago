# baekjoon 알고리즘 1874
# 2023.08.20 이주현

import sys

# push : + // pop : - 
nums = int(sys.stdin.readline())

num_array = []
op_array = []

count = 1
impossible = False
for _ in range(nums):
    num = int(sys.stdin.readline())
    while count <= num:
        num_array.append(count)
        op_array.append('+')
        count = count + 1
    
    if num_array[-1] == num:
        num_array.pop()
        op_array.append('-')
    else:
        impossible = True

if impossible:
    print('NO')
else:
    for op in op_array:
        print(op)

'''
4
3
6
8
7
5
2
1

'''


'''
8
4
3
6
8
7
5
2
1

+ 
+ 
+
+ 
-
-
+
+
-
+
+
-
-
-
-
-

'''