/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsfweb.ejbs;

import com.jsfweb.entities.Grouptable;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author CHIKI
 */
@Stateless
public class GrouptableFacade extends AbstractFacade<Grouptable> {
    @PersistenceContext(unitName = "JSFWebPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public GrouptableFacade() {
        super(Grouptable.class);
    }
    
}
