/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package adam.project.ctrl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import javax.ejb.EJB;
import javax.inject.Named;
import adam.project.bus.StartService;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import adam.project.ents.Foul;
import adam.project.ents.Game;
import java.util.LinkedHashMap;
import javax.faces.view.ViewScoped;

/**
 *
 * @author adamt
 */
@Named(value = "start")
@ViewScoped
public class Start implements Serializable {

    /**
     * Creates a new instance of addFoul
     */
    
    private String[] official1;
    private String referee;
    private static Map<String,String> officialList;
    private Map<String, String> fouls;
    private Map<String, String> positions;
    private static Map<String, String> updatedFouls;

    public Start() {
        this.fouls = updatedFouls;
        
    }
    
    private Foul foul = new Foul();

    public Foul getFoul() {
        return foul;
    }

    public void setFoul(Foul foul) {
        this.foul = foul;
    }

    private Game g = new Game();

    public Game getG() {
        return g;
    }

    public void setG(Game g) {
        this.g = g;
    }

    public Map<String, String> getOfficials() {
        officialList = new LinkedHashMap<>();
        officialList.put("R", "R");
        officialList.put("U", "U");
        officialList.put("HL", "HL");
        officialList.put("LJ", "LJ");
        officialList.put("BJ", "BJ");
        officialList.put("FJ", "FJ");
        officialList.put("SJ", "SJ");
        officialList.put("CJ", "CJ");
        officialList.put("VJ", "VJ");
        officialList.put("N/A", "N/A");
        return officialList;
    }

    public Map<String, String> getUpdatedFouls() {
        updatedFouls = populateFoulMap();
        return updatedFouls;
    }

    private String filter;

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public Map<String, String> getPositions() {
        positions = ss.populatePositions(positions);
        return positions;
    }

    public void setPositions(Map<String, String> positions) {
        this.positions = positions;
    }

    public Map<String, String> getFouls() {
        return fouls;
    }

    public void setFouls(Map<String, String> fouls) {
        this.fouls = fouls;
    }

    public void updateComboBox() {
        Map<String, String> newFoulHashMap = new LinkedHashMap<>();

        for (Map.Entry<String, String> mapToBeFiltered : getUpdatedFouls().entrySet()) {
            if (mapToBeFiltered.getKey().contains(filter)) {
                newFoulHashMap.put(mapToBeFiltered.getKey(), mapToBeFiltered.getValue());
            }
        }
        setFouls(newFoulHashMap);
    }

    public String[] getOfficial1() {
        return official1;
    }

    public void setOfficial1(String[] official1) {
        this.official1 = official1;
    }

    public String getOfficial1InString() {
        return Arrays.toString(official1);
    }

    public String getReferee() {
        return referee;
    }

    public void setReferee(String referee) {
        this.referee = referee;
    }

    @EJB
    private StartService ss;

    public void action() {
        setReferee(getOfficial1InString());
        foul.setOfficial1(referee);
        business("Add", 0);
        flag = false;
    }

    @PostConstruct
    public void populateFoulCodes() {
        List<String> fcs = null;
        fcs = ss.populateCodeList(fcs);

        for (int i = 0; i < fcs.size(); i++) {
            business("Codes", i);
        }
    }

    public List<Foul> business(String cmd, int records) {
        g.setId(gameID);
        ss.interact(cmd, records, foul, g, foulsAdded);
        return foulsAdded;
    }

    public void delete() {
        int records = Integer.parseInt(record);
        business("Delete", records);
    }

    public void edit() {
        setReferee(getOfficial1InString());
        foul.setOfficial1(referee);
        int records = Integer.parseInt(record);
        business("Edit", records);
    }

    private String record;

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    private Long gameID;

    public Long getGameID() {
        return gameID;
    }

    public void setGameID(Long gameID) {
        this.gameID = gameID;
    }

    private int count;

    public int getCount() {
        count = foulsAdded.size();
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private List<Foul> foulsAdded = new ArrayList<>();

    public List<Foul> getFoulsAdded() {
        foulsAdded = new ArrayList<>();
        business("Retrieve", 0);
        return foulsAdded;
    }

    public void setFoulsAdded(List<Foul> foulsAdded) {
        this.foulsAdded = foulsAdded;
    }

    public void populateTable() {
        foulsAdded.add(foul);
    }
    
    private boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    
    public void checkForm(){
        if(!foul.getQuarter().isEmpty() && !foul.getHomeOrAway().isEmpty() && !foul.getFoulName().isEmpty() && !foul.getDecision().isEmpty()){
            flag = true;
        }
    }

    private Map<String, String> populateFoulMap() {
        fouls = new LinkedHashMap<>();
        fouls.put("APS", "Altering playing surface");
        fouls.put("ATR", "Assisting the runner");
        fouls.put("BAT", "Illegal batting");
        fouls.put("DEH", "Holding, defense");
        fouls.put("DOD", "Delay of game, defense");
        fouls.put("DOF", "Offside, defense");
        fouls.put("DOG", "Delay of game, offense");
        fouls.put("DPI", "Pass interference, defense");
        fouls.put("DSH", "Delay of game, start of half");
        fouls.put("DSQ", "Disqualification");
        fouls.put("ENC", "Encroachment (offense)");
        fouls.put("FGT", "Fighting");
        fouls.put("FST", "False start");
        fouls.put("IBB", "Illegal block in the back");
        fouls.put("IBK", "Illegal block during kick");
        fouls.put("IBP", "Illegal backward pass");
        fouls.put("IDP", "Ineligible downfield on pass");
        fouls.put("IFD", "Illegal formation, defense (3-on-1)");
        fouls.put("IFH", "Illegal forward handling");
        fouls.put("IFK", "Illegal free kick formation");
        fouls.put("IFP", "Illegal forward pass");
        fouls.put("IJY", "Illegal jerseys");
        fouls.put("IKB", "Illegally kicking ball");
        fouls.put("ILF", "Illegal formation");
        fouls.put("ILM", "Illegal motion");
        fouls.put("ING", "Intentional grounding");
        fouls.put("IPN", "Improper numbering");
        fouls.put("IPR", "Illegal procedure");
        fouls.put("ISH", "Illegal shift");
        fouls.put("ISP", "Illegal snap");
        fouls.put("ITP", "Illegal touching of a forward pass");
        fouls.put("IUH", "Illegal use of hands");
        fouls.put("IWK", "Illegal wedge on kickoff");
        fouls.put("KCI", "Kick-catch interference");
        fouls.put("KIK", "Illegal kick");
        fouls.put("KOB", "Free kick out of bounds");
        fouls.put("OBK", "Out of bounds during kick");
        fouls.put("OFH", "Holding, offense");
        fouls.put("OFK", "Offside, free kick");
        fouls.put("OPI", "Pass interference, offense");
        fouls.put("PF-BBW", "Personal Foul, Blocking Below the Waist");
        fouls.put("PF-BOB", "Personal Foul, Blocking Out of Bounds");
        fouls.put("PF-BTH", "Personal Foul, Blow To the Head");
        fouls.put("PF-CHB", "Personal Foul, Chop Block");
        fouls.put("PF-CLP", "Personal Foul, Clipping");
        fouls.put("PF-FMM", "Personal Foul, Face Mask");
        fouls.put("PF-HCT", "Personal Foul, Horse Collar Tackle");
        fouls.put("PF-HDR", "Personal Foul, Hit on Defenseless Receiver");
        fouls.put("PF-HTF", "Personal Foul, Hands To the Face");
        fouls.put("PF-HUR", "Personal Foul, Hurdling");
        fouls.put("PF-ICS", "Personal Foul, Illegal Contact with Snapper");
        fouls.put("PF-LEA", "Personal Foul, Leaping");
        fouls.put("PF-LHP", "Personal Foul, Late Hit/Piling on");
        fouls.put("PF-LTO", "Personal Foul, Late Hit out of Bounds");
        fouls.put("PF-OTH", "Personal Foul, Other");
        fouls.put("PF-RFK", "Personal Foul, Roughing Free Kicker");
        fouls.put("PF-RTH", "Personal Foul, Roughing The Holder");
        fouls.put("PF-RTK", "Personal Foul, Roughing The Kicker");
        fouls.put("PF-RTP", "Personal Foul, Roughing The Passer");
        fouls.put("PF-SKE", "Personal Foul, Striking/Kneeing/Elbowing");
        fouls.put("PF-TGT", "Personal Foul, Targeting");
        fouls.put("PF-TRP", "Personal Foul, Tripping");
        fouls.put("PF-UNR", "Personal Foul, Unnecessary Roughness");
        fouls.put("RNH", "Running into the holder");
        fouls.put("RNK", "Running into the kicker");
        fouls.put("SLI", "Sideline interference, 5 yards");
        fouls.put("SLM", "Sideline interference, 15 yards");
        fouls.put("SLW", "Sideline interference, warning");
        fouls.put("SUB", "Illegal substitution");
        fouls.put("UC-2PN", "Unsportsmanlike conduct, two players with same number");
        fouls.put("UC-ABL", "Unsportsmanlike conduct, abusive language");
        fouls.put("UC-BCH", "Unsportsmanlike conduct, bench");
        fouls.put("UC-DEA", "Unsportsmanlike conduct, delayed/excessive act");
        fouls.put("UC-FCO", "Unsportsmanlike conduct, forcibly contacting an official");
        fouls.put("UC-RHT", "Unsportsmanlike conduct, removal of helmet");
        fouls.put("UC-SBR", "Unsportsmanlike conduct, simulating being roughed");
        fouls.put("UC-STB", "Unsportsmanlike conduct, spiking/throwing ball");
        fouls.put("UC-TAU", "Unsportsmanlike conduct, taunting/baiting");
        fouls.put("UC-UNS", "Unsportsmanlike conduct, other");
        fouls.put("UFA", "Unfair acts");
        fouls.put("UFT", "Unfair tactics");
        return fouls;
    }
}
