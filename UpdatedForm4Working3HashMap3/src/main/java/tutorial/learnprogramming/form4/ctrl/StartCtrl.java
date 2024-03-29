/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package tutorial.learnprogramming.form4.ctrl;

import java.util.ArrayList;
import java.util.Arrays;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import tutorial.learnprogramming.form4.bus.StartService;
import tutorial.learnprogramming.form4.ent.TimeData;
//import tutorial.learnprogramming.form4.ent.Fouls;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import tutorial.learnprogramming.form4.ent.Codes;
//import javax.annotation.PostConstruct;
import tutorial.learnprogramming.form4.ent.Foul;
import tutorial.learnprogramming.form4.ent.FoulCodes;
import tutorial.learnprogramming.form4.ent.Positions;
//import tutorial.learnprogramming.form4.ent.foulRecord;

/**
 *
 * @author adamt
 */
@Named(value = "start")
@RequestScoped
public class StartCtrl {

    /**
     * Creates a new instance of start
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
    
    public StartCtrl() {
    }
    
    private Foul foul = new Foul();

    public Foul getFoul() {
        return foul;
    }

    public void setFoul(Foul foul) {
        this.foul = foul;
    }
    
    //private Codes codes = new Codes();

    //public Codes getCodes() {
        //return codes;
    //}

    //public void setCodes(Codes codes) {
        //this.codes = codes;
    //}
    
    public Map<String,String> getPositions() {
        positions = new HashMap<>();
        Positions pL = new Positions();
        pL.getPositions(positions);
        return positions;
    }

    public void setPositions(Map<String, String> positions) {
        this.positions = positions;
    }
    
    public Map<String,String> getFouls(){
        fouls = new HashMap<>();
        //Fouls fL = new Fouls();
        Codes codes = new Codes();
        fouls = codes.getCodes();
        //fL.getFouls(foulList);
        return fouls;
    }

    public void setFouls(Map<String, String> fouls) {
        this.fouls = fouls;
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
        String timeLeft = String.valueOf(this.data2);
        setReferee(getOfficial1InString());
        ss.start(timeLeft, referee, foul);
        //ss.populate();
        for(int i=0; i < 81; i++){
            ss.populate3(i);
        }
        
        //ss.convert(foul);
        List<Foul> foulList = ss.retrieveFoul();
        
        for(int i = foulList.size()-1; i >= 0; i--){
            //Foul fouli = new Foul();
            foul = foulList.get(i);
            String time1 = foul.getTime();
            String time2 = timeConversion(time1);
            foul.setTime(time2);
            foulList.set(i, foul);
            foulsAdded.add(foulList.get(i));
        }
        
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
    
    public void finish(){
        List<Foul> listOfFouls = ss.retrieveFoul();
        
        for(int i = listOfFouls.size()-1; i >= 0; i--){
            foulsAdded.add(listOfFouls.get(i));
        }
    }
    
    private String record;

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }
    
    public void delete(){
        int records = Integer.parseInt(record);
        List<Foul> foulTable = ss.retrieveFoul();
        Foul foul = foulTable.get(records-1);
        ss.delete(foul);
    }
    
    private int count;

    public int getCount() {
        return foulsAdded.size();
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    private List<Foul> allFouls;

    public List<Foul> getAllFouls() {
        return allFouls;
    }

    public void setAllFouls(List<Foul> allFouls) {
        this.allFouls = allFouls;
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
