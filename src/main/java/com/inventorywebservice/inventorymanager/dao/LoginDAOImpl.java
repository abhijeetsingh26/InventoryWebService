package com.inventorywebservice.inventorymanager.dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.NonUniqueResultException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inventorywebservice.inventorymanager.Bean.UserLoginBean;
import com.inventorywebservice.inventorymanager.controller.RestApiController;
import com.inventorywebservice.inventorymanager.model.EnduserModel;

@Repository
public class LoginDAOImpl implements LoginDAO {

	public static final Logger logger = LoggerFactory.getLogger(LoginDAOImpl.class);
	@Autowired
	private static SessionFactory sessionFactory;
	static Session session ;
	
	@Override
	public Boolean checkUserExists(UserLoginBean userLoginBean) {
		SessionFactory sessionFactory;
		try {
			System.out.println(">>>>>>>>>>>>>>> In check user exists DAO");
			Configuration config = new Configuration();
			sessionFactory = config.buildSessionFactory();
			session = sessionFactory.getCurrentSession();
        	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        	sessionFactory = config.buildSessionFactory(serviceRegistry);

		} catch (Throwable e) {
			System.err.println("Error in creating SessionFactory object."
					+ e.getMessage());
			throw new ExceptionInInitializerError(e);
		}
		Session session = sessionFactory.openSession();
		int count = 0;
		try {
			String sql = "SELECT * from endusers where user_email = :USER_EMAIL";
			NativeQuery<EnduserModel>  query = session.createNativeQuery(sql);
			query.setParameter("USER_EMAIL", userLoginBean.getUser_email());
			List<EnduserModel> userList =query.getResultList();
			for(EnduserModel eum:userList)
				System.out.println(eum.getUser_email() + eum.getUser_uuid());
			System.out.println("Count =" +  count);
			System.out.println("intList =" +  userList.toString());
		} catch (NonUniqueResultException nUR) {
			// Not possible, YES ?
			logger.error("ERROR, OOPS!");
		} catch (NoResultException nRE) {
			logger.error("Exception" + nRE);
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
