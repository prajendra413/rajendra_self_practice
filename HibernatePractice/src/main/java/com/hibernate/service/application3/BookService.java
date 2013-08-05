package com.hibernate.service.application3;

import java.math.BigDecimal;

import org.hibernate.Session;

import com.hibernate.domain.application3.AnnEditionBook;
import com.hibernate.domain.application3.Book;
import com.hibernate.domain.application3.SpecialEditionBook;
import com.hibernate.service.HibernateUtil;

public class BookService {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		org.hibernate.Transaction tx = session.beginTransaction();
		
		Book book = new Book();
		book.setName("Spring");
		book.setPrice(new BigDecimal(450));
		book.setType("J2EE");
		
		session.save(book);
		
		AnnEditionBook eBook = new AnnEditionBook();
		
		eBook.setId((short)2);
		eBook.setName("AnnSpring");
		eBook.setPrice(new BigDecimal(450));
		eBook.setType("AnnJ2SE");
		
		session.save(eBook);
		
		SpecialEditionBook spBook = new SpecialEditionBook();
		
		spBook.setId((short)3);
		spBook.setName("specialBook");
		spBook.setPrice(new BigDecimal(450));
		spBook.setType("SpecialJ2SE");
		
		session.save(spBook);
		
		session.flush();
		
		tx.commit();
		
		session.close();
		
		HibernateUtil.shutDown();// TODO Auto-generated method stub

	}

}
