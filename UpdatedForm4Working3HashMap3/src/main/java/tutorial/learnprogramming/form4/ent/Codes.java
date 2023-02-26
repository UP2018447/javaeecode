/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutorial.learnprogramming.form4.ent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;

/**
 *
 * @author adamt
 */
@Entity(name = "foulCodes1")
public class Codes implements Serializable {

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
    
    @ElementCollection
    @MapKeyColumn(name = "foulCodes")
    @Column(name = "foulNames")
    @CollectionTable(name = "foulCodesCollectionTable") /*, joinColumns=@JoinColumn(name = "example_id"))*/
    private static Map<String, String> codes = null;

    private void init() {
        if (codes == null) {
            codes = new HashMap<>();

            codes.put("APS", "Altering playing surface");
            codes.put("ATR", "Assisting the runner");
            codes.put("BAT", "Illegal batting");
            codes.put("DEH", "Holding, defense");
            codes.put("DOD", "Delay of game, defense");
            codes.put("DOF", "Offside, defense");
            codes.put("DOG", "Delay of game, offense");
            codes.put("DPI", "Pass interference, defense");
            codes.put("DSH", "Delay of game, start of half");
            codes.put("DSQ", "Disqualification");
            codes.put("ENC", "Encroachment (offense)");
            codes.put("FGT", "Fighting");
            codes.put("FST", "False start");
            codes.put("IBB", "Illegal block in the back");
            codes.put("IBK", "Illegal block during kick");
            codes.put("IBP", "Illegal backward pass");
            codes.put("IDP", "Ineligible downfield on pass");
            codes.put("IFD", "Illegal formation, defense (3-on-1)");
            codes.put("IFH", "Illegal forward handling");
            codes.put("IFK", "Illegal free kick formation");
            codes.put("IFP", "Illegal forward pass");
            codes.put("IJY", "Illegal jerseys");
            codes.put("IKB", "Illegally kicking ball");
            codes.put("ILF", "Illegal formation");
            codes.put("ILM", "Illegal motion");
            codes.put("ING", "Intentional grounding");
            codes.put("IPN", "Improper numbering");
            codes.put("IPR", "Illegal procedure");
            codes.put("ISH", "Illegal shift");
            codes.put("ISP", "Illegal snap");
            codes.put("ITP", "Illegal touching of a forward pass");
            codes.put("IUH", "Illegal use of hands");
            codes.put("IWK", "Illegal wedge on kickoff");
            codes.put("KCI", "Kick-catch interference");
            codes.put("KIK", "Illegal kick");
            codes.put("KOB", "Free kick out of bounds");
            codes.put("OBK", "Out of bounds during kick");
            codes.put("OFH", "Holding, offense");
            codes.put("OFK", "Offside, free kick");
            codes.put("OPI", "Pass interference, offense");
            codes.put("PF-BBW", "Personal Foul, Blocking Below the Waist");
            codes.put("PF-BOB", "Personal Foul, Blocking Out of Bounds");
            codes.put("PF-BTH", "Personal Foul, Blow To the Head");
            codes.put("PF-CHB", "Personal Foul, Chop Block");
            codes.put("PF-CLP", "Personal Foul, Clipping");
            codes.put("PF-FMM", "Personal Foul, Face Mask");
            codes.put("PF-HCT", "Personal Foul, Horse Collar Tackle");
            codes.put("PF-HDR", "Personal Foul, Hit on Defenseless Receiver");
            codes.put("PF-HTF", "Personal Foul, Hands To the Face");
            codes.put("PF-HUR", "Personal Foul, Hurdling");
            codes.put("PF-ICS", "Personal Foul, Illegal Contact with Snapper");
            codes.put("PF-LEA", "Personal Foul, Leaping");
            codes.put("PF-LHP", "Personal Foul, Late Hit/Piling on");
            codes.put("PF-LTO", "Personal Foul, Late Hit out of Bounds");
            codes.put("PF-OTH", "Personal Foul, Other");
            codes.put("PF-RFK", "Personal Foul, Roughing Free Kicker");
            codes.put("PF-RTH", "Personal Foul, Roughing The Holder");
            codes.put("PF-RTK", "Personal Foul, Roughing The Kicker");
            codes.put("PF-RTP", "Personal Foul, Roughing The Passer");
            codes.put("PF-SKE", "Personal Foul, Striking/Kneeing/Elbowing");
            codes.put("PF-TGT", "Personal Foul, Targeting");
            codes.put("PF-TRP", "Personal Foul, Tripping");
            codes.put("PF-UNR", "Personal Foul, Unnecessary Roughness");
            codes.put("RNH", "Running into the holder");
            codes.put("RNK", "Running into the kicker");
            codes.put("SLI", "Sideline interference, 5 yards");
            codes.put("SLM", "Sideline interference, 15 yards");
            codes.put("SLW", "Sideline interference, warning");
            codes.put("SUB", "Illegal substitution");
            codes.put("UC-2PN", "Unsportsmanlike conduct, two players with same number");
            codes.put("UC-ABL", "Unsportsmanlike conduct, abusive language");
            codes.put("UC-BCH", "Unsportsmanlike conduct, bench");
            codes.put("UC-DEA", "Unsportsmanlike conduct, delayed/excessive act");
            codes.put("UC-FCO", "Unsportsmanlike conduct, forcibly contacting an official");
            codes.put("UC-RHT", "Unsportsmanlike conduct, removal of helmet");
            codes.put("UC-SBR", "Unsportsmanlike conduct, simulating being roughed");
            codes.put("UC-STB", "Unsportsmanlike conduct, spiking/throwing ball");
            codes.put("UC-TAU", "Unsportsmanlike conduct, taunting/baiting");
            codes.put("UC-UNS", "Unsportsmanlike conduct, other");
            codes.put("UFA", "Unfair acts");
            codes.put("UFT", "Unfair tactics");
        }
    }

    public Codes() {
        init();
    }

    public Map<String, String> getCodes() {
        return codes;
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
        if (!(object instanceof Codes)) {
            return false;
        }
        Codes other = (Codes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tutorial.learnprogramming.form4.ent.codes[ id=" + id + " ]";
    }

}
