## 요구사항

###  규칙

1. 카드는 조커를 제외한 총 52장이다.
2. 플레이어는 최소 2명부터 최대 4명이다.
3. 딜러는 1명이며, 카드를 섞고 카드를 나눠주고 승자를 알려주는 역할을 한다.
4. 각 플레이어는 카드 7장씩 받는다.
5. 각 플레이어는 순서대로 턴을 갖게 된다. (1p → 2p → 3p → 1p)
    
    턴이 아닐 때는 어떠한 행동도 하지 못한다.
    
6. 자신의 턴이 되었을 때 카드를 낼 수 있다.
7. 카드를 내는 조건은 놓여진 카드와 같은 문양 또는 같은 숫자이어야 한다. (본인 카드 1장 감소)
    
    놓여진 카드와 같은 문양 또는 숫자가 없다면 카드를 1장 가져간다.
    
8. 한 턴에 1장의 카드만 낼 수 있다.

### 승리 조건

1. 총 카드의 수가 0이 되면 가장 적은 수의 카드를 가진 플레이어가 승리한다.
    
    만약 가장 적은 수의 카드를 가진 플레이어가 여러 명이라면 공동 승리한다.
    
2. 플레이어가 가진 카드의 수가 0이 되면 그 플레이어가 승리한다.

***

### 설계 원칙
- 클래스 우선이 아닌, 객체의 속성과 행위가 우선이다.
    - 클래스는 객체를 추상화하는 도구일 뿐이다.
      
- 데이터가 아닌 메세지(행위)를 중심으로 객체를 설계해라.   
    - 객체는 혼자 있을 수 없다. 다른 객체와의 **협력** 안에서만 존재할 수 있다.
    - 메세지를 중심으로, 해당 메세지가 어떤 객체를 필요로 하는지를 생각하자.
      
- 하나하나 지시하지 말고 요청해라.
    - 예를들어, 판사가 증인에게 1) 목격했던 장면을 떠올리고, 2) 떠오르는 시간을 순서대로 구성하고, 3) 말로 간결하게 표현해라 라고 요청하지 않는다. 그냥 "증언하라" 라고 요청한다.
    - 마찬가지로 객체의 설계단계에서도 책임이 있는 객체에 요청만 하도록 설계한다.
      
- 하나의 메소드는 하나의 일만 해야한다.
  
- 처음부터 완벽한 설계는 없다.
    - 설계를 코드로 구현해가는 과정에서 수정이 필요하다면 설계를 수정한다.

***

## 클래스 다이어그램
