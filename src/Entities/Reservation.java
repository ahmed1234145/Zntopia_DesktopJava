/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.logging.Logger;

/**
 *
 * @author MSI
 */
public class Reservation {
    String IdRes;
    String NomEvRes;
    String TypeEvRes;
    String MatriculeClient;

    public Reservation(String IdRes, String NomEvRes, String TypeEvRes, String MatriculeClient) {
        this.IdRes = IdRes;
        this.NomEvRes = NomEvRes;
        this.TypeEvRes = TypeEvRes;
        this.MatriculeClient = MatriculeClient;
    }

    public String getIdRes() {
        return IdRes;
    }

    public void setIdRes(String IdRes) {
        this.IdRes = IdRes;
    }

    public String getNomEvRes() {
        return NomEvRes;
    }

    public void setNomEvRes(String NomEvRes) {
        this.NomEvRes = NomEvRes;
    }

    public String getTypeEvRes() {
        return TypeEvRes;
    }

    public void setTypeEvRes(String TypeEvRes) {
        this.TypeEvRes = TypeEvRes;
    }

    public String getMatriculeClient() {
        return MatriculeClient;
    }

    public void setMatriculeClient(String MatriculeClient) {
        this.MatriculeClient = MatriculeClient;
    }

    
    
}
