/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package tutorial.learnprogramming.form4.bus;

import java.util.ArrayList;
import java.util.Arrays;
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

    // addFoul business logic below. (Right-click in editor and choose
    // "Insert Code > addFoul Business Method")
    @EJB
    private FoulFacade ff;
    
    @EJB
    private CodesFacade cf;
    
    @EJB
    private NewFoulCodesFacade nfcf;
    
    @EJB
    private GameFacade gf;
    
    public List<Foul> interact(String cmd, int records, Foul foul, Game g) {
        List<Foul> foulRetrieved = new ArrayList<>();
        if (null != cmd) {
            switch (cmd) {
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
                    addFoul(foul, g);
                    break;
                case "Retrieve":
                    foulRetrieved = retrieveFoul();
                    break;
                default:
                    break;
            }
        }
        return foulRetrieved;
    }
    
    
    public Foul addFoul(Foul foul, Game g) {
//        Game g2 = new Game();
//        Long gameID = g.getId();
//        Foul f = foul;
//        Game game = new Game();
        foul.setGame(g);
//        ff.create(f);
        List<Foul> fouls = retrieveFoul();
        fouls.add(foul);
//        Game game = new Game();
//        g.setId(gameID);
        g.setFoulList(fouls);
//        Game edit = gf.edit(g);
        gf.edit(g);
//        String foulList = String.valueOf(foul);
//        g.setFoulInString(foulList);
//        g.setFoulList(fouls);
        
        return foul;
    }

//    public Game addGame(Game g){
//        return g;
//    }
    public String Fouls() {
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
    
    public void delete(int records) {
        List<Foul> foulTable = retrieveFoul();
//        Game g = gf.find(1);
//        List<Foul> games = g.getFoulList();
//        games.remove(records-1);
//        g.setFoulList(games);
//        gf.edit(g);
        Foul foul = foulTable.get(records - 1);
        ff.remove(foul);
    }
    
    public void edit(Foul foul) {
        ff.edit(foul);
    }
    
    public List<Foul> retrieveFoul() {
        List<Foul> fouls = ff.findAll();
        return fouls;
    }
}
