package com.spring.jpa.dao;

public interface IJPADao {
	<T> void createEntity(T t);
	<T> void updateEntity(T t);
	<T> void deleteEntity(T t);
}
