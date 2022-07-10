# 後悔しないためのSpring Boot 入門書：Spring 解体新書（第2版）: Spring Bootが丸分かり Spring解体新書 Kindle版

[本と環境替えたせいで再起不能。](https://github.com/miyawaki0225/interruption-of-the-work-springbootsample)
スキルがついてから戻る

この際なので勉強法も変更
- プログラムの中身にもメモを入れる（自分しか見ない！、後から見直せるように）


- よく使うアノテーション  
https://learning-collection.com/spring-boot%E3%81%A7%E3%82%88%E3%81%8F%E4%BD%BF%E3%81%86%E3%82%A2%E3%83%8E%E3%83%86%E3%83%BC%E3%82%B7%E3%83%A7%E3%83%B3%E4%B8%80%E8%A6%A7/

- PRGパターンとは
https://zenn.dev/imah/articles/3d186a6462ecc8

- BindingResult バインドエラーやバリデーションエラーを確認
- th:errorclass 同じタグでth:field使用していると有効
- th:errors フィールド名指定して、エラーメッセージ表示
- th:if 条件分


SpringBootポイント
- Bean、DI、Autowiredの違いを知る
  - Spring Bootはシングルトンでコードを書きます
  -  DI … JavaクラスをSpringの内部管理下に設定すること（Dependency Injectionの略）
  -  Bean … DIされて、Spring管理下にあるJavaクラス
  -  Autowired … DIされたBeanを利用するときの記述

- レイヤードアーキテクチャを学ぶ
  - Javaクラスを機能別に分けることで、読みやすく、複雑なコードにならないようにする開発方法
    - Application層 … UIやAPIリクエスト/レスポンスを書く
    - Domain層 … ビジネスロジックを書く
    - Infrastructure層 … データストアとのやり取りを書く


https://qiita.com/yuku_t/items/961194a5443b618a4cac