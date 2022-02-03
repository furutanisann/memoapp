package com.example.demo.app.survey;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.app.inquiry.InquiryForm;

@Controller
@RequestMapping("/survey")
public class SurveyController {
//  トップページ（入力用）
	@GetMapping("/form")
	public String form(SurveyForm surveyForm,
			           Model model,
//			           作成時に返すメッセ設定
			           @ModelAttribute("complete") String complete) {
		model.addAttribute("title", "メインページ");
		return "survey/form";
	}

//	確認画面に移動
	@PostMapping("/confirm")
	public String confirm(@Validated SurveyForm surveyForm,
			              Model model,
//					   バリデーション結果を受け取っている
			              BindingResult result) {
//	バリデーションにひかかったとき
		if(result.hasErrors()) {
			model.addAttribute("title", "メインページ");
			return "survey/form";
		}
//	成功時
		model.addAttribute("title","確認ページ");
		return "survey/confirm";
	}

//  再編集でもどる
	@PostMapping("/form")
	public String formBack(SurveyForm survayForm,
						   Model model) {
		model.addAttribute("title","メインページに戻りました");
		return "survey/form";
	}
	
//  送信を押して終了後の処理
	@PostMapping("/complete")
	public String complete(@Validated SurveyForm survayForm,
						   BindingResult result,
						   Model model,
						   RedirectAttributes redirecutAttributes ) {
		if(result.hasErrors()) {
			model.addAttribute("title","メインページに戻りました");
			return "survey/form";
		}
		redirecutAttributes.addAttribute("complete","Registered");
		return "redirect:/survey/form";
	}
	   
	
	          
}