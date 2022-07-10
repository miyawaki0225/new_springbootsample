/** 画面ロード時の処理 */
jQuery(function($){

	/** 登録ボタンを押したときの処理 */
	$('#btn-signup').click(function (event) {
		//ユーザー登録
		signupUser();	
	});

});

/** ユーザー登録処理 */
function signupUser() {

	//バリデーション結果をクリア
	removeValidationResult();

	//ファームの値を取得
	var formData = $('#signup-form').serializeArray();
	
	//ajax 通信
	$.ajax({
		type : "POST",
		cache : false,
		url : '/user/signup/rest',
		data : formData,
		dataType : 'json',
	}).done(function(data) {
	
		//ajax success
		console.log(data);
		
		if(data.result == 90) {
			//when a validation error occurs
			$.each(data.errors, function (key, value) {
				reflectValidResult(key, value)
			});
			
		} else if (data.result == 0) {
			alert('ユーザーを登録しました');
			//redirect to login screen
			window.location.href = '/login';
			
		}

	}).fail(function(jqXHR, textStatus, errorThrown) {
		//ajax failed
		alert('ユーザー登録に失敗しました');
	}).always(function() {
		//常に実行する処理
	});	
}

//バリデーション結果をクリア
function removeValidationResult() {
	$('.is-invalid').removeClass('is.invalid');
	$('.invalid-feedback').remove();
	$('.text-danger').remove();
	
}

//バリデーション結果の反映
function reflectValidResult(key, value) {

	//エラーメッセージ追加
	if(key == 'gender') {
		//CSS適用
		$('input[name=' + key + ']').addClass('is-invalid');
		//エラーメッセージ追加
		$('input[name=' + key + ']')
			.parent().parent()
			.append('<div class="text-danger">' + value + '</div>');
	} else {
		//CSS適用
		$('input[id=' + key + ']').addClass('is-invalid');
		//エラーメッセージ追加
		$('input[id=' + key + ']')
			.after('<div class="invalid-feedback">' + value + '</div>');
	
	}
	
	
}





