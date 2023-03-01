/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutorial.learnprogramming.form4.ent;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author adamt
 */
@Entity
public class GameData implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    private List<Foul> foulList;

    public List<Foul> getFoulList() {
        return foulList;
    }

    public void setFoulList(List<Foul> foulList) {
        this.foulList = foulList;
    }
    
    private String referee;
    private String umpire;
    private String headLinesman;
    private String lineJudge;
    private String backingJudge;
    private String fieldJudge;
    private String sideJudge;
    private String centreJudge;
    private String videoJudge;

    public String getReferee() {
        return referee;
    }

    public void setReferee(String referee) {
        this.referee = referee;
    }

    public String getUmpire() {
        return umpire;
    }

    public void setUmpire(String umpire) {
        this.umpire = umpire;
    }

    public String getHeadLinesman() {
        return headLinesman;
    }

    public void setHeadLinesman(String headLinesman) {
        this.headLinesman = headLinesman;
    }

    public String getLineJudge() {
        return lineJudge;
    }

    public void setLineJudge(String lineJudge) {
        this.lineJudge = lineJudge;
    }

    public String getBackingJudge() {
        return backingJudge;
    }

    public void setBackingJudge(String backingJudge) {
        this.backingJudge = backingJudge;
    }

    public String getFieldJudge() {
        return fieldJudge;
    }

    public void setFieldJudge(String fieldJudge) {
        this.fieldJudge = fieldJudge;
    }

    public String getSideJudge() {
        return sideJudge;
    }

    public void setSideJudge(String sideJudge) {
        this.sideJudge = sideJudge;
    }

    public String getCentreJudge() {
        return centreJudge;
    }

    public void setCentreJudge(String centreJudge) {
        this.centreJudge = centreJudge;
    }

    public String getVideoJudge() {
        return videoJudge;
    }

    public void setVideoJudge(String videoJudge) {
        this.videoJudge = videoJudge;
    }
    
    private String dateOfGame;

    public String getDateOfGame() {
        return dateOfGame;
    }

    public void setDateOfGame(String dateOfGame) {
        this.dateOfGame = dateOfGame;
    }
    
    private String homeTeam;

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }
    
    private String awayTeam;

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GameData)) {
            return false;
        }
        GameData other = (GameData) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tutorial.learnprogramming.form4.ent.GameData[ id=" + id + " ]";
    }
    
}
