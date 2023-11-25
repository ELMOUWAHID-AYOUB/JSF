/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import entities.Employe;
import entities.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import service.EmployeService;

/**
 *
 * @author user
 */
@ManagedBean
@SessionScoped
public class EmployeBean {

    private Employe employe;
    private List<Employe> employes;
    private List<Employe> sousemployes;
    private EmployeService  employeService;

    /**
     * Creates a new instance of MachineBean
     */
    
    public EmployeBean() {
        employe = new Employe();
        employes = new ArrayList<>();
        employeService = new EmployeService();
        sousemployes= new ArrayList<>();
        lodEmployes();
    }
 public List<Employe> lodEmployes() {
        employes = employeService.getAll();
        return employes;
    }
    public void onCreateAction() {
        sousemployes = null;
        System.out.println("start");
        Service s= new Service(36);
//        Employe employe1;
//        employe1 =employeService.getById(1);
//       
//       sousemployes.add(employe1);
//  System.out.println(employe1.getNom());
        employe.setService(s);
        employeService.create(employe);
         System.out.println("creat");
        employes.add(employe);
        System.out.println("creat");
        employe = new Employe();
        lodEmployes();
         
        System.out.println("fin");
    }
  public void onUpdateAction(int id) {
        String nom = employe.getNom();
        String prenom = employe.getPrenom();
        Date dateNaissance = employe.getDateNaissance();
        Service service = employe.getService();
        employe =employeService.getById(id);
       employe.setNom(nom);
       
       employe.setPrenom(prenom);
//       employe.setDateNaissance(dateNaissance);
//       employe.setService(service);
        employeService.update(employe);
        lodEmployes();
    }
  public void onDeleteAction(int id) {
        employe = new Employe(id);
        employeService.delete(employe);
       lodEmployes();
    }
    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public List<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }

}
