package com.douzone.emaillist.dao.test;

import java.util.List;

import com.douzone.emaillist.dao.EmaillistDAO;
import com.douzone.emaillist.vo.EmaillistVO;

public class EmaillistDAOTest {

	public static void main(String[] args) {
		// insertTest();
		findAllTest();
	}
	
	private static void findAllTest() {
		List<EmaillistVO> list = new EmaillistDAO().findAll();
		for (EmaillistVO vo : list) {
			System.out.println(vo);
		}
	}

	private static void insertTest() {
		EmaillistVO vo = new EmaillistVO();
		vo.setFirstName("마");
		vo.setLastName("이클");
		vo.setEmail("michol@gmail.com");
		
		new EmaillistDAO().insert(vo);
		
	}

	
	
	
}
