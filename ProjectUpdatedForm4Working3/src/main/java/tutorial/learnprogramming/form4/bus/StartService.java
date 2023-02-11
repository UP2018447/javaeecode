/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package tutorial.learnprogramming.form4.bus;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import tutorial.learnprogramming.form4.ent.Foul;
import tutorial.learnprogramming.form4.pers.FoulFacade;

/**
 *
 * @author adamt
 */
@Stateless
public class StartService {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @EJB
    private FoulFacade ff;
    
    public Foul start(String timeLeft, String official, Foul foul){
        foul.setTime(timeLeft);
        foul.setOfficial1(official);
        ff.create(foul);
        return foul;
    }
    
}
