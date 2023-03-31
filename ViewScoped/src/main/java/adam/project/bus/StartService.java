/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package adam.project.bus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import adam.project.ents.Foul;
import adam.project.ents.FoulCodes;
import adam.project.ents.Game;
import adam.project.ents.NewFoulCodes;
import adam.project.pers.CodesFacade;
import adam.project.pers.FoulFacade;
import adam.project.pers.GameFacade;
import adam.project.pers.NewFoulCodesFacade;
import java.util.HashMap;
import java.util.Map;

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

    public void interact(String cmd, int records, Foul foul, Game g) {
        if (null != cmd) {
            switch (cmd) {
                case "Delete":
                    delete(records);
                    break;
                case "Edit":
                    edit(foul, g, records);
                    break;
                case "Codes":
                    populateFoulCodeTable(records);
                    break;
                case "Add":
                    addFoul(foul, g);
                    break;
//                case "Retrieve":
//                    foulRetrieved = retrieveFoul();
//                    break;
                default:
                    break;
            }
        }
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

    public void edit(Foul foul, Game g, int records) {
        List<Foul> foulTable = retrieveFoul();
        Foul f = foulTable.get(records - 1);
        long id = f.getId();
        foul.setId(id);
        foul.setGame(g);
        ff.edit(foul);
    }

    public List<Foul> retrieveFoul() {
        List<Foul> fouls = ff.findAll();
        return fouls;
    }

    public Map<String, String> retrieveCodes(Map<String,String> codes) {
        codes.put("APS", "Altering playing surface");
        codes.put("ATR", "Assisting the runner");
        codes.put("BAT", "Illegal batting");
        codes.put("DEH", "Holding, defense");
        codes.put("DOD", "Delay of game, defense");
        codes.put("DOF", "Offside, defense");
        codes.put("DOG", "Delay of game, offense");
        codes.put("DPI", "Pass interference, defense");
        codes.put("DSH", "Delay of game, start of half");
        codes.put("DSQ", "Disqualification");
        codes.put("ENC", "Encroachment (offense)");
        codes.put("FGT", "Fighting");
        codes.put("FST", "False start");
        codes.put("IBB", "Illegal block in the back");
        codes.put("IBK", "Illegal block during kick");
        codes.put("IBP", "Illegal backward pass");
        codes.put("IDP", "Ineligible downfield on pass");
        codes.put("IFD", "Illegal formation, defense (3-on-1)");
        codes.put("IFH", "Illegal forward handling");
        codes.put("IFK", "Illegal free kick formation");
        codes.put("IFP", "Illegal forward pass");
        codes.put("IJY", "Illegal jerseys");
        codes.put("IKB", "Illegally kicking ball");
        codes.put("ILF", "Illegal formation");
        codes.put("ILM", "Illegal motion");
        codes.put("ING", "Intentional grounding");
        codes.put("IPN", "Improper numbering");
        codes.put("IPR", "Illegal procedure");
        codes.put("ISH", "Illegal shift");
        codes.put("ISP", "Illegal snap");
        codes.put("ITP", "Illegal touching of a forward pass");
        codes.put("IUH", "Illegal use of hands");
        codes.put("IWK", "Illegal wedge on kickoff");
        codes.put("KCI", "Kick-catch interference");
        codes.put("KIK", "Illegal kick");
        codes.put("KOB", "Free kick out of bounds");
        codes.put("OBK", "Out of bounds during kick");
        codes.put("OFH", "Holding, offense");
        codes.put("OFK", "Offside, free kick");
        codes.put("OPI", "Pass interference, offense");
        codes.put("PF-BBW", "Personal Foul, Blocking Below the Waist");
        codes.put("PF-BOB", "Personal Foul, Blocking Out of Bounds");
        codes.put("PF-BTH", "Personal Foul, Blow To the Head");
        codes.put("PF-CHB", "Personal Foul, Chop Block");
        codes.put("PF-CLP", "Personal Foul, Clipping");
        codes.put("PF-FMM", "Personal Foul, Face Mask");
        codes.put("PF-HCT", "Personal Foul, Horse Collar Tackle");
        codes.put("PF-HDR", "Personal Foul, Hit on Defenseless Receiver");
        codes.put("PF-HTF", "Personal Foul, Hands To the Face");
        codes.put("PF-HUR", "Personal Foul, Hurdling");
        codes.put("PF-ICS", "Personal Foul, Illegal Contact with Snapper");
        codes.put("PF-LEA", "Personal Foul, Leaping");
        codes.put("PF-LHP", "Personal Foul, Late Hit/Piling on");
        codes.put("PF-LTO", "Personal Foul, Late Hit out of Bounds");
        codes.put("PF-OTH", "Personal Foul, Other");
        codes.put("PF-RFK", "Personal Foul, Roughing Free Kicker");
        codes.put("PF-RTH", "Personal Foul, Roughing The Holder");
        codes.put("PF-RTK", "Personal Foul, Roughing The Kicker");
        codes.put("PF-RTP", "Personal Foul, Roughing The Passer");
        codes.put("PF-SKE", "Personal Foul, Striking/Kneeing/Elbowing");
        codes.put("PF-TGT", "Personal Foul, Targeting");
        codes.put("PF-TRP", "Personal Foul, Tripping");
        codes.put("PF-UNR", "Personal Foul, Unnecessary Roughness");
        codes.put("RNH", "Running into the holder");
        codes.put("RNK", "Running into the kicker");
        codes.put("SLI", "Sideline interference, 5 yards");
        codes.put("SLM", "Sideline interference, 15 yards");
        codes.put("SLW", "Sideline interference, warning");
        codes.put("SUB", "Illegal substitution");
        codes.put("UC-2PN", "Unsportsmanlike conduct, two players with same number");
        codes.put("UC-ABL", "Unsportsmanlike conduct, abusive language");
        codes.put("UC-BCH", "Unsportsmanlike conduct, bench");
        codes.put("UC-DEA", "Unsportsmanlike conduct, delayed/excessive act");
        codes.put("UC-FCO", "Unsportsmanlike conduct, forcibly contacting an official");
        codes.put("UC-RHT", "Unsportsmanlike conduct, removal of helmet");
        codes.put("UC-SBR", "Unsportsmanlike conduct, simulating being roughed");
        codes.put("UC-STB", "Unsportsmanlike conduct, spiking/throwing ball");
        codes.put("UC-TAU", "Unsportsmanlike conduct, taunting/baiting");
        codes.put("UC-UNS", "Unsportsmanlike conduct, other");
        codes.put("UFA", "Unfair acts");
        codes.put("UFT", "Unfair tactics");
        return codes;
    }
}
