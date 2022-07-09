|||
|---|---|
|@Controller|画面からリクエストを受けるクラス。コントローラー|
|@GetMapping|GETメソッドのリクエストを受け付ける。|
|@PostMapping|POSTメソッドのリクエストを受け付ける。|
|@RequestParam|入力された値をサーバーが取得する方法の内ひとつ|
|@Repository|DB操作を表すリポジトリにつける|
|@Autowired|DI用|

lombok
|||
|---|---|
|@Data|getter,setter,toString,hashCode,equals|

下記がDIのコンポねーとスキャンの対象
- @Component
- @Controller
- @Service 
- @Repository 
- @Configuration 
- @RestController 
- @ControllerAdvice 
- @ManagedBean 
- @Named
- @Mapper
- @Bean

### @Scopeでライフサイクル管理
スコープとは、インスタンスが生存する期間のことです。例えば、リクエストスコープではHTTPのリクエストが送られてくるたびにインスタンスが生成されます。そして、リクエストの処理が終わったらインスタンスが破棄されます。


|スコープ|説明|
|---|---|
|singleton(デフォルト)	|DIコンテナの起動時にBeanのインスタンスを生成し、同一のインスタンスを共有して利用する。スコープを設定しない場合はsingletonとして扱われる。|
|prototype	|Beanの取得時に毎回インスタンスを生成する。スレッドアンセーフなBeanの場合、singletonスコープを利用できないためprototypeを利用する。|
|session	|HTTPのセッション単位でBeanのインスタンスを生成する。Webアプリケーションの場合のみ有効。|
|request	|HTTPのリクエスト単位でBeanのインスタンスを生成する。Webアプリケーションの場合のみ有効。|
|globalSession	|ポートレット環境におけるGlobalSessionの単位でインスタンスを生成する。ポートレットに対応したWebアプリケーションの場合のみ有効。|
|application	|サーブレットのコンテキスト単位でBeanのインスタンスを生成する。Webアプリケーションの場合のみ有効。|
|カスタムスコープ(独自の命名)	|独自に定義したルールでBeanのインスタンスを生成する。|

DIの実装（@Autowired）
- フィールド
- コンストラクタ（@Autowiredを省略できる）
- setter

よく使うアノテーション
- @Component
- @Controller
- @Service
- @Repository
- @Bean
- @Mapper


流れ：クラスにアノテーションをつけてDIコンテナにBeanを登録
Beanのインスタンスを生成するクラス：JavaConfig

### DIの落とし穴
1. singletonスコープ（デフォルトがsingletonになるので複数からアクセスされる場合は注意）
2. 異なるスコープをフィールドに持つとインスタンスが破棄されない場合がある。
3. Bean以外からはDIできない