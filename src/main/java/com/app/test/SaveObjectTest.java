package com.app.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.app.entity.Product;

public class SaveObjectTest {
	 
public static void main(String[] args)throws Exception,ClassNotFoundException {
	Configuration config=null;
	 SessionFactory factory=null;
	 Session session=null;
	 Transaction txn=null;
	 Product prod=null;
	 Boolean flag=false;
	//create configuration object(BootStrap hibernate)
	config.configure("com/app/cfgs/configuration.hbm.xml");
	//Build session factory Object
	factory=config.buildSessionFactory();
//Open session
	session=factory.openSession();
	//create Entity Objec to save DB's s/w
	prod=new Product();
	prod.setPId(101);
	prod.setPName("Dipak");
	prod.setPQty(6);
	prod.setPrice(50000);
	
	try {
		//internally calls con.setAutoCommit(false) to begin the transactin
		txn=session.beginTransaction();
	    session.save(prod);
	    System.out.println("Record is saved");
	    flag=true;
	}catch(HibernateException he) {
		he.printStackTrace();
		flag=false;
	}
	finally {
		//commit and rollback txn
		if(flag==true) 
			txn.commit();//internally calls con.commit
			else
				txn.rollback();
		}
	}
}

