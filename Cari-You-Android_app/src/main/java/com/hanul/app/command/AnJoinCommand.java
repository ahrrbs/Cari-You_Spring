package com.hanul.app.command;

import org.springframework.ui.Model;

import com.hanul.app.dao.AnDAO;

public class AnJoinCommand implements AnCommand{

	@Override
	public void execute(Model model) {
		String member_id = (String) model.asMap().get("member_id");
		String password = (String)model.asMap().get("password");	
		String name = (String)model.asMap().get("name");
		String phone = (String)model.asMap().get("phone");
		String email = (String)model.asMap().get("email");
		
		//컨트롤러에서 받은 모델에서 값을 추출해 DAO에 넘겨준다
		AnDAO adao = new AnDAO(); 
		int state = adao.anJoin(member_id, password, name, phone, email);
		
		
		//jsp에서 사용하기 위해 모델에 저장한다.
		model.addAttribute("anJoin", String.valueOf(state)); 
	}

}
