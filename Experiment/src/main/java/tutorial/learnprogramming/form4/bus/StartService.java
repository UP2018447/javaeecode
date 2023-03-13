/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package tutorial.learnprogramming.form4.bus;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import tutorial.learnprogramming.form4.ent.Foul;
import tutorial.learnprogramming.form4.ent.FoulCodes;
import tutorial.learnprogramming.form4.ent.Game;
import tutorial.learnprogramming.form4.ent.NewFoulCodes;
import tutorial.learnprogramming.form4.pers.CodesFacade;
import tutorial.learnprogramming.form4.pers.FoulFacade;
import tutorial.learnprogramming.form4.pers.GameFacade;
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
    
    @EJB
    private GameFacade gf;
    
    public List<Foul> interact(String cmd, int records, Foul foul){
        List<Foul> foulRetrieved = new ArrayList<>();
        if (null != cmd)switch (cmd) {
            case "Delete":
                delete(records);
                break;
            case "Edit":
                edit(foul);
                break;
            case "Codes":
                populateFoulCodeTable(records);
                break;
            case "Add":
                Add(foul);
                break;
            case "Retrieve":
                foulRetrieved = retrieveFoul();
                break;
            default:
                break;
        }
        return foulRetrieved;
    }

    public Foul Add(Foul foul) {
        ff.create(foul);
//        Game g = new Game();
//        List<Foul> foulList = g.getFoulList();
//        foulList.add(foul);
//        g.setFoulList(foulList);
//        gf.edit(g);
//        List<Foul> gameFoul = new ArrayList<>();
//        gameFoul = g.getFoulList();
//        gameFoul.add(foul)
        return foul;
    }
    
    public String Fouls(){
        List<NewFoulCodes> nfc = nfcf.findAll();
        NewFoulCodes nf = nfc.get(0);
        String code = nf.getFoulCode();
        return code;
    }

    public void populateFoulCodeTable(int i) {
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
    
    public void delete(int records){
        List<Foul> foulTable = retrieveFoul();
        Foul foul = foulTable.get(records-1);
        ff.remove(foul);
    }
    
    public void edit(Foul foul){
        ff.edit(foul);
    }
    
    public List<Foul> retrieveFoul(){
        List<Foul> fouls = ff.findAll();
        return fouls;
    }
}
