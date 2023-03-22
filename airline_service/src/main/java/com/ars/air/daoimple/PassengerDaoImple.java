package com.ars.air.daoimple;

import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.ars.air.config.HibernateUtil;
import com.ars.air.dao.PassengerDao;
import com.ars.air.entity.Passenger;

public class PassengerDaoImple implements PassengerDao{

	@Override
	public void savePassenger(Passenger passenger) {
		try(Session session=HibernateUtil.getSession())
		{
			session.beginTransaction();
			session.save(passenger);
			session.getTransaction().commit();
			session.clear();
		} catch (Exception e) {

		}
		
	}
	@Override
	public boolean Plogin(String userName, String password) {
		Session session=HibernateUtil.getSession();
		Passenger passenger=(Passenger)session.get(Passenger.class, ((Integer.parseInt(JOptionPane.showInputDialog("Enter id","Type here")))));
		if (passenger.getUsername().equals(userName) && passenger.getPassword().equals(password)) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public Passenger getPassenger(int id) {
		try (Session session = HibernateUtil.getSession()) {
			Passenger passenger=(Passenger)session.get(Passenger.class, id);
			return passenger;
	}
	catch (HibernateException e) {
		System.out.println(e);
	}
		return null;
	}
	@Override
	public Passenger updatePassenger(int id, Passenger passenger) {
		try (Session session = HibernateUtil.getSession()) {
			Passenger passenger2=(Passenger)session.load(Passenger.class, id);
			passenger2.setName(passenger.getName());
			passenger2.setEmail(passenger.getEmail());
			passenger2.setPhno(passenger.getPhno());
			passenger2.setUsername(passenger.getUsername());
			passenger2.setPassword(passenger.getPassword());
			session.beginTransaction();
			session.saveOrUpdate(passenger2);
			session.getTransaction().commit();
			return passenger2;
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		return null;
	}
	@Override
	public void deletePassenger(int id) throws PersistenceException {
		try (Session session = HibernateUtil.getSession()) {
			Passenger passenger2=(Passenger)session.load(Passenger.class, id);
			//session.beginTransaction();
			session.delete(passenger2);
			session.beginTransaction().commit();
		}catch (HibernateException e) {
			System.out.println(e);
		}
	}		
	

	public Passenger getPassengerByEmail(String email) {
		try(Session session =HibernateUtil.getSession() ) {
			String query="from Passenger p where p.email=:e ";
			Query q=session.createQuery(query);
			q.setParameter("e", email);
			Passenger passenger= (Passenger)q.uniqueResult();
			return passenger;
		} catch (HibernateException e) {
			System.out.println(e);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
		}
	}
