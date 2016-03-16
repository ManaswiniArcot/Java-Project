package com.samplejs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

@Repository("userDao")
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class UserDaoImpl implements UserDao {

	
	private SessionFactory sessionFactory;

	  @Autowired
	    public UserDaoImpl(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> listAllUsers(String state, String country, String prof) {
		Session session = sessionFactory.getCurrentSession();
		boolean groupby = false;
		System.out.println("I am in list");

		Criteria criteria = session.createCriteria(Users.class);
		if(!state.isEmpty()){
		criteria.add(Restrictions.eq("state", state));}
		if(!country.isEmpty()){
		criteria.add(Restrictions.eq("country", country));
		//.setProjection(Projections.projectionList().add(Projections.groupProperty("profession")).add(Projections.count("profession")));
		groupby = true;
		}
		if(!prof.isEmpty())
		criteria.add(Restrictions.eq("profession", prof));
			List<Users> users = criteria.list();
		for (Iterator<Users> iterator = users.iterator(); iterator.hasNext();) {
			Users employee = (Users) iterator.next();
			System.out.print("First Name: " + employee.getFirstName());
			System.out.println("  Last Name: " + employee.getLastName());
			// System.out.println(" Salary: " + employee.getSalary());
		}
		session.close();
		return users;
	}

	@Override
	public Users verifyUser(String userEmail, String password) {

		Session session = sessionFactory.getCurrentSession();
		Criteria verifyCriteria = session.createCriteria(Users.class);
		verifyCriteria.add(Restrictions.eq("password", password));
		verifyCriteria.add(Restrictions.eq("useremail", userEmail));
		 Users myUser = (Users)verifyCriteria.uniqueResult();
		 // TODO Auto-generated method stub
		return myUser;
	}

	@Override
	public List groubyUsers(String country) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Users.class);
		criteria.add(Restrictions.eq("country", country))
		.setProjection(Projections.projectionList().add(Projections.groupProperty("profession")).add(Projections.count("profession")));
		@SuppressWarnings("unchecked")
		List<Object[]>  grouplist =  criteria.list();
		int i = 0;
		for (Iterator<Object[]> iterator = grouplist.iterator(); iterator.hasNext();){
			Object[] myobj = iterator.next();
			for(Object obj:myobj){
			 System.out.println(obj);
			// i++;
		}
			}
		return grouplist;
	}


		
}
