# baekjoon 알고리즘 15711
# 2023.09.17 이주현

# 문제 6588이랑 같이 다시보기! 
import sys

n=2*(10**6)
a=[False,False]+[True]*(n-1)
for i in range(2,int(n**0.5)+1):
    if a[i]:
        for j in range(2*i,n+1,i):
            a[j]=False
prime=[i for i in range(2,n) if a[i]]


num_of_testcase = int(sys.stdin.readline())
for _ in range(num_of_testcase):
    line1 , line2 = map(int, sys.stdin.readline().split())
    sum_line = line1 + line2
    if sum_line<4:
        print("NO")
    elif sum_line % 2 == 0:
        print("YES")
    else:
        if sum_line-2>=n: # 메모리 초과로 인해 작업
            flag=0
            for p in prime:
                if not (sum_line-2)%p:
                    flag=1
                    print("NO")
                    break
            if not flag:
                print("YES")
        else:
            if sum_line-2 in prime:
                print("YES")
            else:
                print("NO")
