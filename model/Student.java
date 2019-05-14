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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author 91310
 */
@Entity
public class Student implements Serializable {

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
    private String attendance;
    private String c;
    
    @OneToMany
    private ArrayList<Classes> classeslist = new ArrayList<Classes>();
    @OneToMany
    private ArrayList<Schedule> schelist = new ArrayList<Schedule>();
   //@ManyToOne

    public Student() {
    }

    public Student(String id, String name, String gender, String phone, String passport, String email, String address,String att,String c) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.passport = passport;
        this.email = email;
        this.address = address;
        this.attendance = att;
       // alist.add(att);
        this.c = c;
    }

    public ArrayList<Schedule> getSchelist() {
        return schelist;
    }

    public void setSchelist(ArrayList<Schedule> schelist) {
        this.schelist = schelist;
    }

    public String getC() {
        return c;
    }

    public void setCla(String c) {
        this.c = c;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public ArrayList<Classes> getClasseslist() {
        return classeslist;
    }

    public void setClasseslist(ArrayList<Classes> classeslist) {
        this.classeslist = classeslist;
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
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Student[ id=" + id + " ]";
    }
    
}
