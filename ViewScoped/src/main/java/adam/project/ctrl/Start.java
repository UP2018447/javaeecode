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
import javax.enterprise.context.RequestScoped;
import adam.project.bus.StartService;
import adam.project.ents.TimeData;
//import tutorial.learnprogramming.form4.ent.Fouls;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import adam.project.ents.Codes;
import adam.project.ents.Foul;
import adam.project.ents.FoulCodes;
import adam.project.ents.Game;
import adam.project.ents.Positions;
import javax.faces.view.ViewScoped;
//import tutorial.learnprogramming.form4.ent.foulRecord;

/**
 *
 * @author adamt
 */
@Named(value = "start")
@ViewScoped
public class Start implements Serializable{

    /**
     * Creates a new instance of addFoul
     */
    
    private String foulType;
    private String foulCode = "code";
    private String quarter;
    private String time = "m's";
    private String team = "team";
    private String player;
    private String playerPosition;
    private String official = "official";
    private String[] official1;
    private String homeOrAway;
    private String decision;
    //private String min;
    //private String sec;
    private TimeData data2;
    private String test;
    private String referee;
    private Map<String,String> fouls;
    private Map<String,String> positions;
    private Map<String,String> updatedFouls;
    
    public Start() {
    }

    public Map<String, String> getUpdatedFouls() {
        return updatedFouls;
    }

    public void setUpdatedFouls(Map<String, String> updatedFouls) {
        this.updatedFouls = updatedFouls;
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

    

    //private Codes codes = new Codes();
    //public Codes getCodes() {
    //return codes;
    //}
    //public void setCodes(Codes codes) {
    //this.codes = codes;
    //}
    
    private String filter;

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public Map<String,String> getPositions() {
//        positions = new HashMap<>();
        Positions pos = new Positions();
        positions = pos.getPositions();
        return positions;
    }

    public void setPositions(Map<String, String> positions) {
        this.positions = positions;
    }
    
    public Map<String,String> getFouls(){
//        fouls = new HashMap<>();
        Codes codes = new Codes();
        fouls = codes.getCodes();
        return fouls;
    }

    public void setFouls(Map<String, String> fouls) {
        this.fouls = fouls;
    }
    
    public void updateComboBox(){
        Map<String,String> newFouls = getFouls();
        Set<String> updatedFoulCodes = newFouls.keySet();
        List<String> listOfFoulCodes = new ArrayList<>();
        listOfFoulCodes.addAll(updatedFoulCodes);
        String filterValue = getFilter();
//        for(String code : updatedFoulCodes){
//            listOfFoulCodes.add(code);
//        }
//        for(Iterator<String> iterator = listOfFoulCodes.iterator(); iterator.hasNext();){
//            if(!iterator.next().contains(updatedFoul)){
//                iterator.remove();
//            }
//        }
        List<String> updatedFoulCodeList = new ArrayList<>();
        List<String> updatedFoulNames = new ArrayList<>();
        String filterLetter = filterValue;
        for(int i = 0; i < listOfFoulCodes.size(); i++){
            String selectedFoulCode = listOfFoulCodes.get(i);
            if(selectedFoulCode.contains(filterLetter)){
                String newName = newFouls.get(selectedFoulCode);
                updatedFoulNames.add(newName);
                updatedFoulCodeList.add(selectedFoulCode);
            }
            
        }
        newFouls.clear();
//        Map<String,String> updatedFoulMap = new HashMap<>();
        for(int i = 0; i < updatedFoulCodeList.size(); i++){
            newFouls.put(updatedFoulCodeList.get(i), updatedFoulNames.get(i));
        }
        
        setFouls(newFouls);
    }
    
    public String nothing(){
        quarter = quarter + quarter;
        return "";
    }

    public String getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(String playerPosition) {
        this.playerPosition = playerPosition;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getHomeOrAway() {
        return homeOrAway;
    }

    public void setHomeOrAway(String homeOrAway) {
        this.homeOrAway = homeOrAway;
    }

    public String[] getOfficial1() {
        return official1;
    }

    public void setOfficial1(String[] official1) {
        this.official1 = official1;
    }

    public String getOfficial1InString(){
        return Arrays.toString(official1);
    }
    
    //private String officials = getOfficial1InString();

    public String getFoulType() {
        return foulType;
    }

    public void setFoulType(String foulType) {
        this.foulType = foulType;
    }

    public String getFoulCode() {
        return foulCode;
    }

    public void setFoulCode(String foulCode) {
        this.foulCode = foulCode;
    }

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getOfficial() {
        return official;
    }

    public void setOfficial(String official) {
        this.official = official;
    }

    public String getReferee() {
        return referee;
    }

    public void setReferee(String referee) {
        this.referee = referee;
    }
    
    @EJB
    private StartService ss;
    
    public void action(){
//        String timeLeft = String.valueOf(this.data2);
//        int timeRemaining = Integer.parseInt(timeLeft);
        setReferee(getOfficial1InString());
//        foul.setTime(timeRemaining);
        foul.setOfficial1(referee);
//        Game g = new Game();
//        g.setId(gameID);
        business("Add", 0);
//        ss.addFoul(foul);
        
        List<Foul> foulList = business("Retrieve", 0);//ss.retrieveFoul();
        
        for(int i = foulList.size()-1; i >= 0; i--){
            foulsAdded.add(foulList.get(i));
        }
    }
    
//    @PostConstruct
    public void populateFoulCodes(){
        FoulCodes fc = new FoulCodes();
        final List<String> fcs = fc.getCodes();
        
        for(int i=0; i < fcs.size(); i++){
            business("Codes", i);
        }
    }
    
    public List<Foul> business(String cmd, int records){
//        Game g = new Game();
        g.setId(gameID);
        List<Foul> retrievedFoul = ss.interact(cmd, records, foul, g);
        return retrievedFoul;
    }
    
    public String timeConversion(String time){
        int secs = Integer.parseInt(time);
        int remainingSeconds = secs % 60;
        secs = secs - remainingSeconds;
        int minutes = secs / 60;
        String mins = Integer.toString(minutes);
        String secsRemaining = Integer.toString(remainingSeconds);
        String realTime = mins + "'" + secsRemaining;
        return realTime;
    }
    
    public void delete(){
        int records = Integer.parseInt(record);
        business("Delete", records);
    }
    
    public void edit(){
//        String timeLeft = String.valueOf(this.data2);
//        int timeRemaining = Integer.parseInt(timeLeft);
        setReferee(getOfficial1InString());
//        foul.setTime(timeRemaining);
        foul.setOfficial1(referee);
//        List<Foul> foulLists = ss.retrieveFoul();
        int records = Integer.parseInt(record);
        int id = 1 + 82*(records-1);
        long longID = id;
//        foul.setId(longID);
        business("Edit", records);
//        ss.edit(foul);
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
        return foulsAdded.size();
    }

    public void setCount(int count) {
        this.count = count;
    }

    public TimeData getData2() {
        return data2;
    }

    public void setData2(TimeData data2) {
        this.data2 = data2;
    }
    
    private List<Foul> foulsAdded = new ArrayList<>();

    public List<Foul> getFoulsAdded() {
        return foulsAdded;
    }

    public void setFoulsAdded(List<Foul> foulsAdded) {
        this.foulsAdded = foulsAdded;
    }
    
    public void populateTable(){
        foulsAdded.add(foul);
    }
}
