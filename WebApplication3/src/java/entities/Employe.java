/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;

/**
 *
 * @author user
 */
@Entity
public class Employe implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    @ManyToOne
    private Service service;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_employe_id")
    private List<Employe> subEmploye;

    public Employe() {
    }

    public Employe(int id) {
        this.id = id;
    }

    public Employe(String nom) {
        this.nom = nom;
    }

    public Employe(String nom, String prenom, Date dateNaissance, Service sevice, List<Employe> subEmploye) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.service = sevice;
        this.subEmploye = subEmploye;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service sevice) {
        this.service = sevice;
    }

    public List<Employe> getSubEmploye() {
        return subEmploye;
    }

    public void setSubEmploye(List<Employe> subEmploye) {
        this.subEmploye = subEmploye;
    }

    @Override
    public String toString() {
        return  nom ;
    }

}
