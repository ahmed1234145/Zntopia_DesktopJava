/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author MSI
 */
public class Evenement {
    String Id;
    String Nom;
    String Type;
    String Organisateur;
    Date Date_Debut;
    Date Date_Fin;

    public Evenement(String Id, String Nom, String Type, String Organisateur, Date Date_Debut, Date Date_Fin) {
        this.Id = Id;
        this.Nom = Nom;
        this.Type = Type;
        this.Organisateur = Organisateur;
        this.Date_Debut = Date_Debut;
        this.Date_Fin = Date_Fin;
    }

    public Evenement(String Id, String Nom, String Type, String Organisateur, LocalDate Date_Debut, LocalDate Date_Fin) {
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getOrganisateur() {
        return Organisateur;
    }

    public void setOrganisateur(String Organisateur) {
        this.Organisateur = Organisateur;
    }

    public Date getDate_Debut() {
        return Date_Debut;
    }

    public void setDate_Debut(Date Date_Debut) {
        this.Date_Debut = Date_Debut;
    }

    public Date getDate_Fin() {
        return Date_Fin;
    }

    public void setDate_Fin(Date Date_Fin) {
        this.Date_Fin = Date_Fin;
    }

  
   
    
}
