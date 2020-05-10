package com.niit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Category;
import com.niit.model.Supplier;

@Repository("supplierDAO")
@ComponentScan("com.niit")
@Transactional
public class SupplierDAOImplementation implements SupplierDAO{
	
	@Autowired
	SessionFactory sessionfactory;

	public boolean addSupplier(Supplier supplier) {
		try{
			sessionfactory.getCurrentSession().save(supplier);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	public boolean deleteSupplier(Supplier supplier) {
		try{
			sessionfactory.getCurrentSession().delete(supplier);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	public boolean updateSupplier(Supplier supplier) {
		try{
			sessionfactory.getCurrentSession().update(supplier);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	public List<Supplier> listSupplier() {
		Session session = sessionfactory.openSession();
		Query query = session.createQuery("from Supplier");
		List<Supplier> listsupplier = query.list();
		session.close();
		return listsupplier;
	}

	public Supplier getSupplier(int supplierID) {
		Session session =  sessionfactory.openSession();
		Supplier supplier = (Supplier)session.get(Supplier.class,supplierID);
		session.close();
		return supplier;
	}

}
