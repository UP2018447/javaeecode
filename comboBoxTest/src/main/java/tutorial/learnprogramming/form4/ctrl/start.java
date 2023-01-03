/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package tutorial.learnprogramming.form4.ctrl;

import java.util.Arrays;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import tutorial.learnprogramming.form4.bus.StartService;
import tutorial.learnprogramming.form4.ent.timeData;
import tutorial.learnprogramming.form4.ent.fouls;
import java.util.HashMap;
import java.util.Map;

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
    
    
    private String foulType = "foul";
    private String foulCode = "code";
    private String quarter = "quarter";
    private String time = "m's";
    private String team = "team";
    private String player = "player";
    private String official = "official";
    private String[] official1;
    private String homeOrAway;
    private String decision;
    private String min;
    private String sec;
    private timeData data2;
    private String test;
    private Map<String,String> fouls;
    
    public start() {
    }
    
    public Map<String,String> getFouls(){
        Map<String,String> foulList = new HashMap<String,String>();
        fouls fL = new fouls();
        fL.getFouls(foulList);
        return foulList;
    }

    public void setFouls(Map<String, String> fouls) {
        this.fouls = fouls;
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
    
    @EJB
    private StartService ss;
    
    public void action2(){
        this.data2 = data2;
        timeData data = new timeData();
        String timeLeft = String.valueOf(data2);
        String referee = getOfficial1InString();
        ss.doStarting(foulType, quarter, timeLeft, player, homeOrAway, referee, decision);
    }
    
    public void action3(){
        String Test = getTest();
        this.data2 = data2;
        timeData data = new timeData();
        String timeLeft = String.valueOf(data2);
        String referee = getOfficial1InString();
        ss.doStarting2(quarter, timeLeft, player, homeOrAway, referee, decision, Test);
    }

    public timeData getData2() {
        return data2;
    }

    public void setData2(timeData data2) {
        this.data2 = data2;
    }
}
