/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 91310
 */
@Stateless
public class LecturerFacade extends AbstractFacade<Lecturer> {

    @PersistenceContext(unitName = "ARS-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LecturerFacade() {
        super(Lecturer.class);
    }
    
}
