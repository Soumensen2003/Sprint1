package com.ars.air.daoimple;



import java.time.LocalDate;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ars.air.config.HibernateUtil;
import com.ars.air.dao.TicketDao;
import com.ars.air.entity.Airline;
import com.ars.air.entity.Flight;
import com.ars.air.entity.Passenger;
import com.ars.air.entity.TicketBooking;



public class TicketDaoImpl implements TicketDao{

	@Override
	public TicketBooking bookFlight(Airline airline, Passenger p, LocalDate date, Flight f, int no_of_passenger,
			float total_fare, int avilable_seat) {
		try(Session session=HibernateUtil.getSession())
		{
			session.beginTransaction();
			TicketBooking ticketBooking=new TicketBooking();
			ticketBooking.setAid(airline);
			ticketBooking.setDate(date);
			ticketBooking.setFid(f);
			ticketBooking.setTotal_fare(total_fare);
			session.save(ticketBooking);
			f.setAvilableSeats(avilable_seat);
			session.saveOrUpdate(f);
			session.getTransaction().commit();
			
			return ticketBooking;
			
		}catch (HibernateException e) {
			System.out.println("Hibernate Exception: "+e);
		}catch (Exception e) {
			System.out.println("Exception: "+e);
		}
		return null;
	}

	@Override
	public void cancelBooking(int id) {
		try(Session session=HibernateUtil.getSession()) {
			TicketBooking tb=(TicketBooking)session.load(TicketBooking.class, id);
			session.beginTransaction();
			int input=JOptionPane.showConfirmDialog(null, "do you want to cancel?","select what you want to cancel or not",JOptionPane.YES_NO_OPTION);
			if(input==0)
			{
				int nop=tb.getNo_of_passenger();
				tb.getFid().setAvilableSeats(tb.getFid().getAvilableSeats()+nop);
				session.delete(tb);
				
			}
			else 
				JOptionPane.showMessageDialog(null,"user wants to retain it!!!");
				session.getTransaction().commit();
		}catch (HibernateException e) {
			System.out.println("hibernate exception: "+e);
		}
		
	}

	@Override
	public TicketBooking getTicket(int id) {
		try(Session session=HibernateUtil.getSession()) {
			TicketBooking tick=(TicketBooking)session.get(TicketBooking.class,id );
			return tick;
		}catch (HibernateException e) {
			System.out.println("Hibernate Exception: "+e);
		}catch (Exception e) {
			System.out.println("Exception: "+e);
		}
		return null;
	
	}
}


