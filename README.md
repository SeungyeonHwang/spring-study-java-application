# 2. 스프링 핵심 원리 - 기본편

# Spring Core

> **Basic Java Application**

## 機能一覧

### Service

- 회원
    - 회원을 가입하고 조회할 수 있다.
    - 회원은 일반과 VIP 두 가지 등급이 있다.
    - 회원 데이터는 자체 DB를 구축할 수 있고, 외부 시스템과 연동할 수 있다. (미확정)
      

- 주문과 할인 정책
    - 회원은 상품을 주문할 수 있다.
    - 회원 등급에 따라 할인 정책을 적용할 수 있다.
    - 할인 정책은 모든 VIP는 1000원을 할인해주는 고정 금액 할인을 적용해달라. (나중에 변경 될 수 있다.)
    - 할인 정책은 변경 가능성이 높다. 회사의 기본 할인 정책을 아직 정하지 못했고, 오픈 직전까지 고민을
미루고 싶다. 최악의 경우 할인을 적용하지 않을 수 도 있다. (미확정)
---

- 会員
    - 会員を登録し、照会することができる
    - 会員には一般とVIPの2つの等級がある
    - 会員データは独自DBを構築でき、外部システムと連動することができる。 (未確定)
    

- 注文と割引ポリシー
    - 会員は商品を注文することができる
    - 会員レベルに基づいて割引ポリシーを適用することができる
    - 割引ポリシーは、すべてのVIPは1000ウォンを割引する固定金額割引を適用してほしい。（後で変更されることがある。)
    - 割引政策は変更の可能性が高い。 会社の基本割引政策をまだ決めておらず、オープン直前まで悩みを
  先延ばししたい。最悪の場合、割引は適用されないかもしれない。 (未確定)

## What I learned

- DIP
- OCP
- Interface設計
- AppConfig設計
