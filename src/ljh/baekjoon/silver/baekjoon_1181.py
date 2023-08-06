#  baekjoon 알고리즘 1181
# 2023.08.06 이주현

# 길이가 짧은 것
# 길이가 같으면 -> 사전 순으로
import sys
num_of_words = int(sys.stdin.readline())

words_list = []
for _ in range(num_of_words):
    word = sys.stdin.readline().rstrip()

    if word not in words_list:
        words_list.append(word)

sort_words_list = []
for word in words_list:
    sort_words_list.append((len(word), word)) # tuple 을 사용해서 sort 

sort_words_list = sorted(sort_words_list)

for len, word in sort_words_list:
    print(word)