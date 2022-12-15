/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package tutorial.learnprogramming.form4.ctrl;

import java.time.LocalTime;
import static java.time.LocalTime.parse;
import java.util.Arrays;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import tutorial.learnprogramming.form4.bus.StartService;
import tutorial.learnprogramming.form4.ent.timeData;

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
    
    public start() {
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
    
    public String action(){
        //foulType = foulType + "!";
        foulType = ss.startStarting(foulType);
        return "";
    }
    
    public String runFoulCode(){
        foulCode = foulCode + "...";
        return "";
    }
    
    public String runQuarter(){
        //quarter = quarter + quarter;
        quarter = ss.startQuarter(quarter);
        return"";
    }
    
    public String findSeconds(){
        String[] array;
        if(time.contains("'")){
            array = time.split("'");
        }
        else if(time.contains(".")){
            array = time.split(".");
        }
        else if(time.contains(":")){
            array = time.split(":");
        }
        else if(time.contains(";")){
            array = time.split(";");
        }
        else if(time.contains(",")){
            array = time.split(",");
        }
        else {
            array = time.split("0");
        }
        String min = array[0];
        String secs = array[1];
        int mins = getSecondsAndMinutes(min);
        int sec = getSecondsAndMinutes(secs);
        int minsToSecs = mins * 60;
        sec = sec + minsToSecs;
        String totalSeconds = Integer.toString(sec);
        return totalSeconds;
    }
    
    public String runTotalSeconds(){
        this.data2 = data2;
        
        timeData data = new timeData();
        String timeLeft = String.valueOf(data2);
        timeLeft = ss.startTime(timeLeft);
        return "";
    }
    
    public int getSecondsAndMinutes(String time){
        int value = 0;
        value = Integer.parseInt(time);
        return value;
    }
    
    public String runPlayer(){
        //player = player + ".";
        player = ss.startPlayer(player);
        return "";
    }
    
    public String runHomeOrAway(){
        //homeOrAway = homeOrAway;
        homeOrAway = ss.startHomeOrAway(homeOrAway);
        return "";
    }
    
    public String runOfficial1(){
        String referee = getOfficial1InString();
        referee = ss.startOfficial1(referee);
        return "";
    }
    
    public String runDecision(){
        //decision = decision;
        decision = ss.startDecision(decision);
        return "";
    }

    public timeData getData2() {
        return data2;
    }

    public void setData2(timeData data2) {
        this.data2 = data2;
    }
}
