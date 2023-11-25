/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import java.util.List;
import entities.Service;
import dao.IDao;
import util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author LACHGAR
 */
public class ServiceService extends AbstractSevice<Service>{
    @Override
    public boolean create(Service o) {
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        return true;
    }
    @Override
    public boolean update(Service o) {
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        return true;
    }
    @Override
    public boolean delete(Service o) {
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public Service getById(int id) {
        Service salle  = null;
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        salle  = (Service) session.get(Service.class, id);
        session.getTransaction().commit();
        return salle;
    }

    @Override
    public List<Service> getAll() {
        
         List <Service> salles = null;
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        salles  = session.createQuery("from Service").list();
        session.getTransaction().commit();
        return salles;
    }
    
    
}
