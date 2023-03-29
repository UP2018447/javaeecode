/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adam.project.ents;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author adamt
 */
@Entity(name = "Game4")
public class Game implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @OneToMany(mappedBy = "game", cascade={CascadeType.PERSIST, CascadeType.ALL})
//    @JoinColumn(name = "Foul_ID", referencedColumnName = "ID")
    private List<Foul> foulList;

    public List<Foul> getFoulList() {
        return foulList;
    }

    public void setFoulList(List<Foul> foulList) {
        this.foulList = foulList;
    }
    
    public void addFoulList(Foul foul){
        foul.setGame(this);
        foulList.add(foul);
        
    }
    
    private String referee;
    private String umpire;
    private String headLinesman;
    private String lineJudge;
    private String backJudge;
    private String forwardJudge;
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

    public String getBackJudge() {
        return backJudge;
    }

    public void setBackJudge(String backJudge) {
        this.backJudge = backJudge;
    }

    public String getForwardJudge() {
        return forwardJudge;
    }

    public void setForwardJudge(String forwardJudge) {
        this.forwardJudge = forwardJudge;
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
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Game)) {
            return false;
        }
        Game other = (Game) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "adam.project.ent.Game[ id=" + id + " ]";
    }
    
}
