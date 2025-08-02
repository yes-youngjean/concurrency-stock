### Lettuce
- setnx 명령어 활용 분산락 구현 
  - set if not exist, key-value set 시 기존 값이 없을 때만 set하는 방식
- spin lock 방식
  - lock을 획득하려는 Thread가 Lock을 사용할 수 있는지 반복하면서 확인하여 획득
- 장) 구현이 단순
- 단) spin lock 방식 -> 동시에 많은 Thread Lock 획득 대 상태라면 redis에 부하 발생

### Redisson
- pub-sub 기반으로 Lock 구현 제공
  - 채널 생성 후, Lock을 점유중인 Thread가 Lock을 획득하려고 점유중인 Thread에게 해제를 알려주면, 안내를 받은 Thread가 Lock 획득을 시도하는 방식
  - 장) Lock 획득 재시도를 기본적으로 제공
  - 단) 사용법에 대한 학습 필요

### 결론
- 재시도가 필요하지 않은 Lock -> Lettuce 활용
- 재시도가 필요한 Lock -> Redisson 활용