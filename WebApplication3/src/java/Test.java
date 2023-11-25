
import entities.Employe;
import entities.Service;
import java.sql.Date;
import service.EmployeService;
import service.ServiceService;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("test");
        Service service =new Service();
        service = new Service("informatique","info");
        System.out.println("fin");
        ServiceService  serviceService= new ServiceService();
        serviceService.create(service);
        Employe employe=new Employe();
        Date date= new Date(0, 01, 0);
        employe =new Employe("ayoub","Elmouwahid",date,service,null);
        EmployeService employeService=new EmployeService();
        employeService.create(employe);
    }
}
