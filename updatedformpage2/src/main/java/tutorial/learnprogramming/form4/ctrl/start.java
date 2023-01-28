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
import tutorial.learnprogramming.form4.ent.timeData;
import tutorial.learnprogramming.form4.ent.fouls;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import tutorial.learnprogramming.form4.ent.Foul;
import tutorial.learnprogramming.form4.ent.Positions;
//import tutorial.learnprogramming.form4.ent.foulRecord;

/**
 *
 * @author adamt
 */
@Named(value = "start")
@RequestScoped
public class start {

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
    private timeData data2;
    private String test;
    private String referee;
    private Map<String,String> fouls;
    private Map<String,String> positions;
    private List<Records> recordList = new ArrayList<>();
    
    public start() {
    }
    
    private Foul foul = new Foul();

    public Foul getFoul() {
        return foul;
    }

    public void setFoul(Foul foul) {
        this.foul = foul;
    }
    
    
    
    public void populate(){
        recordList.add(new Records(foul.getQuarter(), foul.getTime(), foul.getHomeOrAway(), foul.getFoulName(), foul.getPlayer(), foul.getPosition(), foul.getOfficial1(), foul.getDecision()));
    }

    public List<Records> getRecordList() {
        return recordList;
    }

    public Map<String,String> getPositions() {
        Map<String,String> positionList = new HashMap<>();
        Positions pL = new Positions();
        pL.getPositions(positionList);
        return positionList;
    }

    public void setPositions(Map<String, String> positions) {
        this.positions = positions;
    }
    
    public Map<String,String> getFouls(){
        Map<String,String> foulList = new HashMap<>();
        fouls fL = new fouls();
        fL.getFouls(foulList);
        return foulList;
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
        populate();
    }

    public timeData getData2() {
        return data2;
    }

    public void setData2(timeData data2) {
        this.data2 = data2;
    }
}
