# 요구사항
1. 게임이 시작되면 프로그램이 1에서 9까지 서로 다른 임의의 수 3개를 정한다
2. 유저는 정답을 맞추기 위해서 1에서 9까지 서로 다른 임의의 수로 이루어진 3자리수를 입력하고 힌트를 받는다.
3. 힌트는 야구용어인 볼과 스트라이크로 받는데, 정답과 같은 자리에 같은 숫자가 있는 경우 스트라이크 값을 추가하며 다른 자리에 같은 숫자가 있는 경우 볼 값을 추가한다.
4. 힌트의 출력은 다음과 같다:
   1. 스트라이크 값만 1 이상: `2스트라이크`
   2. 볼 값만 1 이상: `1볼`
   3. 볼과 스트라이크 값이 둘다 1 이상: `1볼 2스트라이크`
   4. 같은 숫자가 하나도 없는 경우: `낫싱`
5. 점수가 3 스트라이크인 경우 게임이 종료된다.
6. 게임이 종료되면 유저에게 입력을 받아 다시 시작하거나 완전히 종료할 수 있다

# 기능 사항
1. 1~9 범위의 숫자 3개 생성
2. 1~9 범위의 서로 다른 숫자 3개 생성
3. 사용자에게 숫자를 입력 받음
4. 입력받은 숫자가 세자리인지 확인
5. 입력받은 숫자에 중복이 있는지 확인
6. 스트라이크와 볼 개수를 계산
7. End Condition이 만족되지 않았다면 게임 재시작