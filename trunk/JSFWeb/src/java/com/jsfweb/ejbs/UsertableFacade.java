/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsfweb.ejbs;

import com.jsfweb.entities.Usertable;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author CHIKI
 */
@Stateless
public class UsertableFacade extends AbstractFacade<Usertable> {
    @PersistenceContext(unitName = "JSFWebPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public UsertableFacade() {
        super(Usertable.class);
    }
    
}
