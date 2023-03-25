/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package adam.project2.bus;

import adam.project2.ents.Foul;
import adam.project2.pers.FoulFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;

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
    
    public void startStarting(Foul foul){
        ff.create(foul);
    }
}
