/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.IDao;
import entities.Employe;
import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author user
 */
public class EmployeService extends AbstractSevice<Employe>{
    @Override
    public boolean create(Employe o) {
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        return true;
    }
    @Override
    public boolean update(Employe o) {
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        return true;
    }
    @Override
    public boolean delete(Employe o) {
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public Employe getById(int id) {
        Employe salle  = null;
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        salle  = (Employe) session.get(Employe.class, id);
        session.getTransaction().commit();
        return salle;
    }

    @Override
    public List<Employe> getAll() {
        
         List <Employe> salles = null;
        Session session  = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        salles  = session.createQuery("from Employe").list();
        session.getTransaction().commit();
        return salles;
    }
    
}
