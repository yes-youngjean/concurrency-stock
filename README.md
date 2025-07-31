### 비관적 락 (Pessimistic Lock)
* 실제로 데이터에 Lock을 걸어 정합성을 맞추는 방법
* Exclusive Lock을 걸게되면 다른 트랜잭에서는 Lock이 해제되기 전까지 데이터에 접근 불가
* 단, 데드락에 걸릴 수 있음

### 낙관적 락 (Optimistic Lock)
* 실제로 Lock을 이용하지 않고, Version을 이용하여 정합성을 맞추는 방법
* 데이터를 읽은 후 update를 수행할 때 내가 읽은 version이 맞는지 확인하여 업데이트
* 읽은 버전에 수정사항이 생긴 경우 application에서 다시 읽은 후 작업 수행
