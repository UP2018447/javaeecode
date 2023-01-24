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
    
    public void start(String foul, String quarter, String timeLeft, String player, String team, String official, String decision, String Position){
        Foul f = new Foul();
        f.setFoulName(foul);
        f.setQuarter(quarter);
        f.setTime(timeLeft);
        f.setPlayer(player);
        f.setPosition(Position);
        f.setHomeOrAway(team);
        f.setOfficial1(official);
        f.setDecision(decision);
        ff.create(f);
    }
    
    public String startStarting(String text){
        Foul f = new Foul();
        f.setFoulName(text);
        //save this in database
        ff.create(f);
        //return text + "?";
        return text;
    }
    
    public void doStarting(String foul, String quarter, String timeLeft, String player, String team, String official, String decision){
        Foul f = new Foul();
        f.setFoulName(foul);
        f.setQuarter(quarter);
        f.setTime(timeLeft);
        f.setPlayer(player);
        f.setHomeOrAway(team);
        f.setOfficial1(official);
        f.setDecision(decision);
        ff.create(f);
    }
    
    public String startQuarter(String text){
        Foul f = new Foul();
        f.setQuarter(text);
        //save this in database
        ff.create(f);
        //return text + "?";
        return text;
    }
    
    public String startTime(String text){
        Foul f = new Foul();
        f.setTime(text);
        
        ff.create(f);
        //return text + "?";
        return text;
    }
    
    public String startPlayer(String text){
        Foul f = new Foul();
        f.setPlayer(text);
        
        ff.create(f);
        //return text + "?";
        return text;
    }
    
    public String startHomeOrAway(String text){
        Foul f = new Foul();
        f.setHomeOrAway(text);
        
        ff.create(f);
        return text;
    }
    
    public String startOfficial1(String text){
        Foul f = new Foul();
        f.setOfficial1(text);
        
        ff.create(f);
        return text;
    }
    
    public String startDecision(String text){
        Foul f = new Foul();
        f.setDecision(text);
        
        ff.create(f);
        return text;
    }
}
