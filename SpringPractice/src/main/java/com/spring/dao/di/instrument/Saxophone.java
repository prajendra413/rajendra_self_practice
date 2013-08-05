package com.spring.dao.di.instrument;

import org.springframework.stereotype.Repository;

@Repository
//@Repository("instrument1")
public class Saxophone implements Instrument{
	public void play() {
		System.out.println("Saxophone");
	}
}
