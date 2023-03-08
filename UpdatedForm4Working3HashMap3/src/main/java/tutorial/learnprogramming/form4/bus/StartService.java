/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package tutorial.learnprogramming.form4.bus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import tutorial.learnprogramming.form4.ent.Codes;
import tutorial.learnprogramming.form4.ent.Foul;
import tutorial.learnprogramming.form4.ent.FoulCodes;
import tutorial.learnprogramming.form4.ent.NewFoulCodes;
import tutorial.learnprogramming.form4.pers.CodesFacade;
import tutorial.learnprogramming.form4.pers.FoulFacade;
import tutorial.learnprogramming.form4.pers.NewFoulCodesFacade;

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

    @EJB
    private CodesFacade cf;

    @EJB
    private NewFoulCodesFacade nfcf;

    public Foul start(String timeLeft, String official, Foul foul) {
        foul.setTime(timeLeft);
        foul.setOfficial1(official);
        ff.create(foul);
        return foul;
    }

    public void populate() {
        Codes foulCodes = new Codes();
        cf.create(foulCodes);
    }
    
    public void convert(Foul foul){
        String seconds = foul.getTime();
        int secs = Integer.parseInt(seconds);
        int remainingSeconds = secs % 60;
        secs = secs - remainingSeconds;
        int minutes = secs / 60;
        String mins = Integer.toString(minutes);
        String secsRemaining = Integer.toString(remainingSeconds);
        String realTime = mins + "'" + secsRemaining;
        foul.setTime(realTime);
    }
    
    public void delete(Foul foul){
        
        //Foul fouls = ff.find(ff);
        //Foul foul1 = new Foul();
        //Foul foulDelete2 = fD.get(fD.size()-1);
        //Foul fouls = foulDelete2;
        ff.remove(foul);
    }

    //public void populate2(){
    //FoulCodes fc = new FoulCodes();
    //NewFoulCodes nfc = new NewFoulCodes();
    //List<String> codes = fc.getCodes();
    //List<String> names = fc.getNames();
    //List<String> codes2 = nfc.getCodes();
    //List<String> names2 = nfc.getFoulNames();
    //for (int i = 0; i < codes.size(); i++){
    //String code = codes.get(i);
    //String name = names.get(i);
    //codes2.add(code);
    //names2.add(name);
    //nfc.setCodes(codes2);
    //nfc.setFoulNames(names2);
    //nfcf.create(nfc);
    //}
    //}
    public void populate3(int i) {
        NewFoulCodes nfc = new NewFoulCodes();
        FoulCodes fc = new FoulCodes();
        List<String> fouls = fc.getNames();
        List<String> codes = fc.getCodes();
        String foul = fouls.get(i);
        String code = codes.get(i);
        nfc.setFoulCode(code);
        nfc.setFoulName(foul);
        nfcf.create(nfc);
    }
    
    public List<Foul> retrieveFoul(){
        List<Foul> fouls = ff.findAll();
        return fouls;
    }
}