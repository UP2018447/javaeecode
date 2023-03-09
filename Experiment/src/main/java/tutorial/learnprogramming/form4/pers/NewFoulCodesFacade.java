/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutorial.learnprogramming.form4.pers;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tutorial.learnprogramming.form4.ent.NewFoulCodes;

/**
 *
 * @author adamt
 */
@Stateless
public class NewFoulCodesFacade extends AbstractFacade<NewFoulCodes> {

    @PersistenceContext(unitName = "adamPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NewFoulCodesFacade() {
        super(NewFoulCodes.class);
    }
    
}
