package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

// 画面からHTTPリクエストを受け付けるため@Controllerアノテーションを付与する
@Controller
public class formController {
	
	@Autowired
	private formController  service;

    // http://localhost(ポート番号)/sampleにアクセスすると「form.html」が呼ばれる
	@GetMapping("/")
	public String getInput() {
        // 「form.html」が設置されている場所を文字列に指定「src/main/resources/templates」から見た相対パス
		return "input.html";
	}

	@PostMapping("/check")
    // formタグの「name」と一致する値を取得
	public String postDbRequest(@RequestParam("text2") String id, Model model) {
		// 1件検索
		Employee employee = service.getEmployee(id); // getEmployee(String id)メソッドの戻り値"employee"を取得
		
		// 検索結果をModelに登録
		model.addAttribute("employee", employee); 
		
		// db.htmlに画面遷移
		return "show";
	}
}
