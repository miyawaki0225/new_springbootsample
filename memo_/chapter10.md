
- ${status}
- ${error}
- ${message}

エラーの実装方法
- @AfterThrowingアスペクト
- コントローラークラスごと
- Webアプリケーション全体

- @ExceptionHandler

- @ControllerAdvice
全てのコントローラーで共有するメソッドを用意できる。ただし以下のメソッドのみ
    1. @ExceptionHandler
    2. @InitBinder
    3. @ModelAttribute