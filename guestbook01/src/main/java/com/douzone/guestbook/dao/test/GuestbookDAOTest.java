package com.douzone.guestbook.dao.test;

import java.util.List;

import com.douzone.guestbook.dao.GuestbookDAO;
import com.douzone.guestbook.vo.GuestbookVO;

public class GuestbookDAOTest {

	public static void main(String[] args) {
//		insertTest();
		findAllTest();

	}

	private static void findAllTest() {
		List<GuestbookVO> list = new GuestbookDAO().findAll();
		for (GuestbookVO vo : list) {
			System.out.println(vo);
		}
	}
	private static
	
	void insertTest() {
		GuestbookVO vo = null;
		GuestbookDAO dao = new GuestbookDAO();

		vo = new GuestbookVO();
		vo.setName("만두");
		vo.setPassword("2345");
		vo.setMessage("만두욤");
		dao.insert(vo);

		vo = new GuestbookVO();
		vo.setName("감자");
		vo.setPassword("3456");
		vo.setMessage("감자욤");
		dao.insert(vo);

		vo = new GuestbookVO();
		vo.setName("임자");
		vo.setPassword("4567");
		vo.setMessage("임자욤");
		dao.insert(vo);
		
	}


}
