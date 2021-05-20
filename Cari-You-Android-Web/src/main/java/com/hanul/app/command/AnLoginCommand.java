package com.hanul.app.command;

import org.springframework.ui.Model;

import com.hanul.app.dao.AnDAO;
import com.hanul.app.dto.MemberDTO;

public class AnLoginCommand implements AnCommand{

	@Override
	public void execute(Model model) {
		String member_id = (String)model.asMap().get("member_id");
		String password = (String)model.asMap().get("password");	
		
		AnDAO adao = new AnDAO();
		MemberDTO adto = adao.anLogin(member_id, password);
		
		model.addAttribute("anLogin", adto); 
		
	}

}
