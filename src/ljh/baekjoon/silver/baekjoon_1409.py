#  baekjoon 알고리즘 1409
# 2023.08.03 이주현

## 커서 표현을 index로 => timeout // 두개 stack을 써서 문제 해결
# L : 왼쪽으로 한칸
# D : 오른쪽으로 한칸
# B : 커서의 왼쪽 삭제 
# P$ : $를 커서의 왼쪽에 추가

import sys

text_left = list(sys.stdin.readline().rstrip()) 
text_right = []
num_of_query = int(sys.stdin.readline())

cursor = len(text_left) # 4

for _ in range(num_of_query):

    query = sys.stdin.readline()
        
    if query[0] == 'L':
        if len(text_left) > 0 :
            text_right.append(text_left.pop())
        
    elif query[0] == 'D':
        if len(text_right) > 0:        
            text_left.append(text_right.pop())
    elif query[0] == 'B': 
        if len(text_left) > 0:
            text_left.pop()
    elif query[0] == 'P':
        text_left.append(query[2])

text_left.extend(reversed(text_right)) 

print(''.join(text_left))

  