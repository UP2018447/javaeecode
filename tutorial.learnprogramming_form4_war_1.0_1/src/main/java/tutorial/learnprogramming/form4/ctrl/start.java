/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package tutorial.learnprogramming.form4.ctrl;

import java.time.LocalTime;
import java.util.Arrays;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import tutorial.learnprogramming.form4.bus.StartService;

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
    private String time = "m's''";
    private String team = "team";
    private String player = "player";
    private String official = "official";
    private String[] official1;
    private String homeOrAway;
    private LocalTime periodTime;
    private String decision;
    
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
        foulType = foulType + "!";
        foulType = ss.startStarting(foulType);
        return "";
    }
    
    public String runFoulCode(){
        foulCode = foulCode + "...";
        return "";
    }
    
    public String runQuarter(){
        quarter = quarter + quarter;
        quarter = ss.startQuarter(quarter);
        return"";
    }
    
    public String runTime(){
        time = time + "...";
        time = ss.startTime(time);
        return "";
    }
    
    public String runTeam(){
        team = team + ",";
        team = ss.startTeam(team);
        return "";
    }
    
    public String runPlayer(){
        player = player + ".";
        player = ss.startPlayer(player);
        return "";
    }
    
    public String runOfficial(){
        official = official + "!";
        official = ss.startOfficial(official);
        return "";
    }
    
    public String runHomeOrAway(){
        homeOrAway = homeOrAway;
        homeOrAway = ss.startHomeOrAway(homeOrAway);
        return "";
    }
    
    public String runOfficial1(){
        String referee = getOfficial1InString();
        referee = ss.startOfficial1(referee);
        return "";
    }
    
    public String runDecision(){
        decision = decision;
        decision = ss.startDecision(decision);
        return "";
    }
}
