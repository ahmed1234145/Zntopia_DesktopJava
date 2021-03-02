/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;
import java.util.Objects;



/**
 *
 * @author leila
 */
public class Client{
    
    private Integer id_client;
    String username;
    String email;
    String password;
    String nom ;
    String prenom ;
    java.util.Date dateNai ;
    String adresse ;
    String tel ;

    public Client(Integer id_client, String username, String email, String password, String nom, String prenom, java.util.Date dateNai, String adresse, String tel) {
        this.id_client = id_client;
        this.username = username;
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNai = dateNai;
        this.adresse = adresse;
        this.tel = tel;
    }

    public Integer getId_client() {
        return id_client;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public java.util.Date getDateNai() {
        return dateNai;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setId_client(Integer id_client) {
        this.id_client = id_client;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNai(java.util.Date dateNai) {
        this.dateNai = dateNai;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }


   
 

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id_client);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Client other = (Client) obj;
        if (!Objects.equals(this.id_client, other.id_client)) {
            return false;
        }
        return true;
    }



    @Override
    public String toString() {
        return "Client{" + "id_client=" + id_client + ", username=" + username + ", email=" + email + ", password=" + password + ", nom=" + nom + ", prenom=" + prenom + ", dateNai=" + dateNai + ", adresse=" + adresse + ", tel=" + tel + '}';
    }


    
} 
