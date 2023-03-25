/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutorial.learnprogramming.form4.pers;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tutorial.learnprogramming.form4.ent.Flag;

/**
 *
 * @author adamt
 */
@Stateless
public class FlagFacade extends AbstractFacade<Flag> {

    @PersistenceContext(unitName = "adamPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FlagFacade() {
        super(Flag.class);
    }
    
}
