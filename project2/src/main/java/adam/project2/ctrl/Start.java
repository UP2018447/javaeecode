/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package adam.project2.ctrl;

import adam.project2.bus.StartService;
import adam.project2.ents.Foul;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author adamt
 */
@Named(value = "start")
@RequestScoped
public class Start {

    /**
     * Creates a new instance of Start
     */
    public Start() {
    }
    
    Foul foul = new Foul();

    public Foul getFoul() {
        return foul;
    }

    public void setFoul(Foul foul) {
        this.foul = foul;
    }
    
    @EJB
    private StartService ss;
    
    public void action(){
        ss.startStarting(foul);
    }
    
}
