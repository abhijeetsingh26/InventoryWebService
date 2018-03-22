package com.inventorywebservice.inventorymanager.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.NonUniqueResultException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inventorywebservice.inventorymanager.Bean.UserLoginBean;
import com.inventorywebservice.inventorymanager.controller.RestApiController;

@Repository
public class LoginDAOImpl implements LoginDAO {

	public static final Logger logger = LoggerFactory.getLogger(LoginDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	Session session = sessionFactory.getCurrentSession();

	@Override
	public Boolean checkUserExists(UserLoginBean userLoginBean) {
		Session session = sessionFactory.openSession();
		int count = 0;
		try {
			String sql = "SELECT count(*) from endusers where user_email = :USER_EMAIL";
			Query<Integer> query = session.createNativeQuery(sql);
			query.setParameter("USER_EMAIL", userLoginBean.getUser_email());
			count = query.getSingleResult();
		} catch (NonUniqueResultException nUR) {
			// Not possible, YES ?
			logger.error("ERROR, OOPS!");
		} catch (NoResultException nRE) {
			// Fine, means user does not exist
			count = 0;
		}
		session.close();
		if (count == 1)
			return true;
		else
			return false;
	}

	@Override
	public Boolean createNewUserAssociation(UserLoginBean userLoginBean) {

		return null;
	}

}
