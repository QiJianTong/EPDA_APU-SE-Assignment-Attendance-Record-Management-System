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
public class Classes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String classname;
    private String lecid;//**
    private Lecturer lecturer;
    
    @OneToMany
    private ArrayList<Student> slist = new ArrayList<Student>();
    
    @OneToMany
    private ArrayList<Schedule> ScheList = new ArrayList<Schedule>();
    
    public Classes() {
    }

    public Classes(String id, String classname,String lecid,Lecturer lecturer) {
        this.id = id;
        this.classname = classname;
        this.lecid = lecid;
        this.lecturer = lecturer;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public String getLecid() {
        return lecid;
    }

    public void setLecid(String lecid) {
        this.lecid = lecid;
    }

    public ArrayList<Schedule> getScheList() {
        return ScheList;
    }

    public void setScheList(ArrayList<Schedule> ScheList) {
        this.ScheList = ScheList;
    }

    
 

    public ArrayList<Student> getSlist() {
        return slist;
    }

    public void setSlist(ArrayList<Student> slist) {
        this.slist = slist;
    }

    

 

    

    
    
    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
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
        if (!(object instanceof Classes)) {
            return false;
        }
        Classes other = (Classes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Class[ id=" + id + " ]";
    }
    
}
