# University of Seoul. Dept of Computer Science.
# 2018430021 김형철
# week6_08

## 전역변수 선언 부분 ##
i,k=0,0

## 메인 코드 부분 ##
i = 0#i는 줄수이다. 0번째줄부터 8번째 줄까지 while이 돈다.
while i<9: #while과 맨끝의 i+=1과 같이보면 range(0,9)와 동치, 즉 9번 반복하겠다는 의미
    if i<5:#i in [0,1,2,3,4] 즉 5번 if이하를 실행할것임
        k = 0#다음반복문을 위해 k=0 초기화
        while k<4-i:#while 이하의 의미는 4-i개의 공백을 출력한다는 의미
                    #공백 4개에서 시작해 1개씩 덜 출력한다는 의미
            print(' ',end='')
            k +=1
        k=0#다음반복문을 위해 k=0 초기화
        while k<i*2+1:#while 이하의 의미는 i*2+1개의 별을 출력한다는 의미
                      #별 1개에서 시작해 2개씩 더 출력한다는 의미
            print('\u2605',end='')
            k +=1
    else:#i in [5,6,7,8] 즉 4번 if이하를 실행할것임
        k=0#다음반복문을 위해 k=0 초기화
        while k<i-4:#while 이하의 의미는 i-4개의 공백을 출력한다는 의미
                    #i=5부터이므로 공백 1개에서 시작해 1개씩 덜 출력한다는 의미
            print(' ',end='')
            k+=1
        k=0#다음반복문을 위해 k=0 초기화
        while k<(9-i)*2-1:#while 이하의 의미는 (9-i)*2-1개의 별을 출력한다는 의미
                          #i=5부터이므로 7개에서 시작해 2개씩 덜 출력한다는 의미
            print('\u2605',end='')
            k+=1
    print()#한줄 출력을 완료했으니 newline
    i+=1#i를 증가시켜 반목문 수행