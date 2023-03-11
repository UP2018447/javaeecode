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
import tutorial.learnprogramming.form4.ent.Thing;
//import tutorial.learnprogramming.form4.ent.foulRecord;

/**
 *
 * @author adamt
 */
@Named(value = "start")
@RequestScoped
public class Start {

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
    
    public Start() {
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
        //fL.getFouls(fouls);
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
        int timeRemaining = Integer.parseInt(timeLeft);
        setReferee(getOfficial1InString());
        foul.setTime(timeRemaining);
        foul.setOfficial1(referee);
        ss.start(foul);
        
        List<Foul> foulList = ss.retrieveFoul();
        
        for(int i = foulList.size()-1; i >= 0; i--){
            foulsAdded.add(foulList.get(i));
        }
    }
    
    @PostConstruct
    public void populateFoulCodes(){
        FoulCodes fc = new FoulCodes();
//        Codes c = new Codes();
//        final Map<String,String> codeMap = c.getCodes();
        final List<String> fcs = fc.getCodes();
        
        for(int i=0; i < fcs.size(); i++){
            ss.populateFoulCodeTable(i);
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
    
    public void delete(){
        int records = Integer.parseInt(record);
        List<Foul> foulTable = ss.retrieveFoul();
        Foul foul = foulTable.get(records-1);
        ss.delete(foul);
    }
    
    public void edit(){
        String timeLeft = String.valueOf(this.data2);
        int timeRemaining = Integer.parseInt(timeLeft);
        setReferee(getOfficial1InString());
        List<Foul> foulLists = ss.retrieveFoul();
        int records = Integer.parseInt(record);
        Foul foul2 = foulLists.get(records-1);
        int id = 163 + 82*(records-1);
        long longID = id;
        foul.setId(longID);
        ss.edit(timeRemaining, referee, foul, foul2);
    }
    
    private String record;

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
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