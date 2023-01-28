/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutorial.learnprogramming.form4.ctrl;

/**
 *
 * @author adamt
 */
public class Records {
    
  private final String quarter;
  private final String time;
  private final String team;
  private final String foul;
  private final String player;
  private final String position;
  private final String official;
  private final String decision;

  public Records(String quarter, String time, String team, String foul, String player, String position, String official, String decision) {
    this.quarter = quarter;
    this.time = time;
    this.team = team;
    this.foul = foul;
    this.player = player;
    this.position = position;
    this.official = official;
    this.decision = decision;
  }

  public String getQuarter() {
    return quarter;
  }

  public String getTime() {
    return time;
  }

  public String getTeam() {
    return team;
  }

  public String getFoul() {
    return foul;
  }

    public String getPlayer() {
        return player;
    }

    public String getPosition() {
        return position;
    }

    public String getOfficial() {
        return official;
    }

    public String getDecision() {
        return decision;
    }
  
  
    
}
