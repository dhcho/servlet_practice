package com.douzone.guestbook.dao.test;

import java.util.List;

import com.douzone.guestbook.dao.GuestBookDao;
import com.douzone.guestbook.vo.GuestBookVo;

public class GuestBookDaoTest {
	public static void main(String[] args) {
		insertTest();
		// findAllTest();
	}

	private static void findAllTest() {
		List<GuestBookVo> list = new GuestBookDao().findAll();
		for(GuestBookVo vo : list) {
			System.out.println(vo);
		}
	}

	public static void insertTest() {
		GuestBookVo vo = null;
		
		vo = new GuestBookVo();
		vo.setName("douzone");
		vo.setPassword("102938");
		vo.setMessage("douzone");
		new GuestBookDao().insert(vo);
	}
}
