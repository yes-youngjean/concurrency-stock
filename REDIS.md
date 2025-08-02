### Lettuce
- setnx 명령어 활용 분산락 구현 
  - set if not exist, key-value set 시 기존 값이 없을 때만 set하는 방식
- spin lock 방식
  - lock을 획득하려는 Thread가 Lock을 사용할 수 있는지 반복하면서 확인하여 획득

### Redisson
- pub-sub 기반으로 Lock 구현 제공
  - 채널 생성 후, Lock을 점유중인 Thread가 Lock을 획득하려고 점유중인 Thread에게 해제를 알려주면, 안내를 받은 Thread가 Lock 획득을 시도하는 방식
  - 별도 Retry X