/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author 91310
 */
@Entity
public class Lecturer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private String gender;
    private String phone;
    private String passport;
    private String email;
    private String address;
    private String hos;
    private HOS hos1;
    @OneToMany
    private ArrayList<Classes> clist = new ArrayList<Classes>();
    

    public Lecturer() {
    }

    public Lecturer(String id, String name, String gender, String phone, String passport, String email, String address) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.passport = passport;
        this.email = email;
        this.address = address;
    }

    public Lecturer(String id, String name, String gender, String phone, String passport, String email, String address, String hos,HOS hos1) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.passport = passport;
        this.email = email;
        this.address = address;
        this.hos = hos;
        this.hos1 = hos1;
    }

    public HOS getHos1() {
        return hos1;
    }

    public void setHos1(HOS hos1) {
        this.hos1 = hos1;
    }

    public String getHos() {
        return hos;
    }

    public void setHos(String hos) {
        this.hos = hos;
    }

    public ArrayList<Classes> getClist() {
        return clist;
    }

    public void setClist(ArrayList<Classes> clist) {
        this.clist = clist;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

   
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lecturer)) {
            return false;
        }
        Lecturer other = (Lecturer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Lecturer[ id=" + id + " ]";
    }
    
}
