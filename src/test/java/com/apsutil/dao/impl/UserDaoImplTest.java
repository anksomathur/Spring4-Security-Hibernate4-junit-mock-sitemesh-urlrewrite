package com.apsutil.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.engine.transaction.spi.AbstractTransactionImpl;
import org.hibernate.engine.transaction.spi.TransactionCoordinator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;

import com.apsutil.dao.UserDao;

import junit.framework.Assert;;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { HibernateTestConfiguration.class })
public  class UserDaoImplTest   {
	@Autowired
	private UserDao userDao;
	
	@SuppressWarnings("deprecation")
	@Test
	@Transactional
	public void findById(){
		Long id= new Long(1l);
		Assert.assertNotNull(userDao.findById(id));
	} 
	@Test
	@Transactional
	public void findByUserName(){
		Assert.assertNotNull(userDao.findByUserName("ankit"));
	} 
}
