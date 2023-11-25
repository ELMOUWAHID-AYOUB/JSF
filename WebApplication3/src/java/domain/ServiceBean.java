/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import entities.Service;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import service.ServiceService;

/**
 *
 * @author Lachgar
 */
@ManagedBean
@SessionScoped
public class ServiceBean {

    private Service service;
    private List<Service> services;
    private ServiceService serviceService;
    private String code;
    private String libelle;

    /**
     * Creates a new instance of ServiceBean
     */
    public ServiceBean() {
        services = new ArrayList<>();
        service = new Service();
        serviceService = new ServiceService();
         lodService();
    }

    public List<Service> lodService() {
        services = serviceService.getAll();
        return services;
    }

    public void onCreateAction() {
        System.out.println(service.getCode());
        System.out.println(service.getLibelle());
        serviceService.create(service);
        services.add(service);
        service = new Service();
        lodService();

    }

    public void onDeleteAction(int id) {
        service = new Service(id);
        serviceService.delete(service);
        lodService();
    }
     public void onRefreshAction() {
         
    }

    public void onUpdateAction(int id) {
        code=service.getCode();
        libelle=service.getLibelle();
        service = serviceService.getById(id);
        System.out.println(service);
        System.out.println(id);
         System.out.println("laffichage :" + code + " et " +libelle);
        System.out.println("laffichage :" + service.getCode() + " et " + service.getLibelle());
        service.setCode(code);
        service.setLibelle(libelle);
        serviceService.update(service);
        System.out.println(service);
        lodService();
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

}
