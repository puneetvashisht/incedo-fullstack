package com.cts.repos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cts.entities.BankUser;
import com.cts.entities.Employee;

public class BankUserRepo {
	static SessionFactory sessionFactory;

	static {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	public void addBankUser(BankUser user) {
		// Physical connection to perform db operations
		Session session = sessionFactory.openSession();

		// Manual transactions
		Transaction tx = session.beginTransaction();
		session.save(user);
		
		//

		tx.commit();
		session.close();
		
	}

	@Override
	protected void finalize(){
		HibernateUtil.closeSessionFactory();
	}

	public BankUser findBankUser(BankUser id) {
		// Physical connection to perform db operations
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		BankUser bankUser = session.get(BankUser.class, id);
		
		
		tx.commit();
		session.close();
		return bankUser;
			
		
	}

}
