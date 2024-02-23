### 프로레머스
#
# 몫 구하기
# 정수 num1, num2가 매개변수로 주어질 때, num1을 num2로 나눈 몫을 return 하도록 solution 함수를 완성해주세요.
#
# 제한사항
# 0 < num1 ≤ 100
# 0 < num2 ≤ 100
# 입출력 예
# num1	num2	result
# 10	5	2
# 7	2	3
# 입출력 예 설명
# 입출력 예 #1
#
# num1이 10, num2가 5이므로 10을 5로 나눈 몫 2를 return 합니다.
# 입출력 예 #2
#
# num1이 7, num2가 2이므로 7을 2로 나눈 몫 3을 return 합니다.

def solution(num1,num2):
    answer = 0

    if num2 != 0:
        answer = num1/num2


    return int(answer)



# 두 수의 나눗셈
# 문제 설명
# 정수 num1과 num2가 매개변수로 주어질 때, num1을 num2로 나눈 값에 1,000을 곱한 후 정수 부분을 return 하도록 soltuion 함수를 완성해주세요.
#
# 제한사항
# 0 < num1 ≤ 100
# 0 < num2 ≤ 100
# #

def solution(num1, num2):
    answer = 0

    if num2 != 0:
        answer = num1/num2*1000

    return int(answer)


# 문자열 출력하기
# 제출 내역
# 문제 설명
# 문자열 str이 주어질 때, str을 출력하는 코드를 작성해 보세요.
#
# 제한사항
# 1 ≤ str의 길이 ≤ 1,000,000
# str에는 공백이 없으며, 첫째 줄에 한 줄로만 주어집니다.

str = input()

if str.count(" ") == 0:
    print(str)


# a와 b 출력하기
# 제출 내역
# 문제 설명
# 정수 a와 b가 주어집니다. 각 수를 입력받아 입출력 예와 같은 형식으로 출력하는 코드를 작성해 보세요.
#
# 제한사항
# -100,000 ≤ a, b ≤ 100,000

a, b = map(int, input().strip().split(' '))

print('a = {}'.format(a))
print('b = {}'.format(b))



# 문자열 반복해서 출력하기
# 제출 내역
# 문제 설명
# 문자열 str과 정수 n이 주어집니다.
# str이 n번 반복된 문자열을 만들어 출력하는 코드를 작성해 보세요.
# 제한사항
# 1 ≤ str의 길이 ≤ 10
# 1 ≤ n ≤ 5

a, b = input().strip().split(' ')
b = int(b)

print(a*b)


# 대소문자 바꿔서 출력하기
# 제출 내역
# 문제 설명
# 영어 알파벳으로 이루어진 문자열 str이 주어집니다. 각 알파벳을 대문자는 소문자로 소문자는 대문자로 변환해서 출력하는 코드를 작성해 보세요.
#
# 제한사항
# 1 ≤ str의 길이 ≤ 20
# str은 알파벳으로 이루어진 문자열입니다.

str = input()

str_len = len(str)

answer = '';

for i in range(0, str_len):
    pre_str = str[i]

    if pre_str.isupper():
        answer += pre_str.lower()
    else :
        answer += pre_str.upper()

print(answer)

# 좋은 풀이
print(input().swapcase())



# 특수문자 출력하기
# 제출 내역
# 문제 설명
# 다음과 같이 출력하도록 코드를 작성해 주세요.
#
# 출력 예시
#
# !@#$%^&*(\'"<>?:;

print("!@#$%^&*(\\'\"<>?:;")

# 좋은 풀이
print(r'!@#$%^&*(\'"<>?:;')