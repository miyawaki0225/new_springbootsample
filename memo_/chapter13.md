JPAとは
Java標準のO/Rマッパー＞＞spring data jpa利用

@Entity,  
@Table,  
@Id  

Optionalクラス


JPAのデフォルトメソッド
- findById()
- findAll()
- save()
- deleteById()


@Modifyingアノテーションを付けたメソッドを実行するためには、@Transactionalアノテーションを付けなければいけませ ん。@Modifyingアノテーションの有無にかかわらず、登録・更新・削除のSQLであれば@Transactionalアノテーションを付け ます。