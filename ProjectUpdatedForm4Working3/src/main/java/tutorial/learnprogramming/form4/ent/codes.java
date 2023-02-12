/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tutorial.learnprogramming.form4.ent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
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
public class codes implements Serializable {

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
    
    private static final List<String> codes = new ArrayList<>(Arrays.asList(
            "APS",
            "ATR",
            "BAT",
            "DEH",
            "DOD",
            "DOF",
            "DOG",
            "DPI",
            "DSH",
            "DSQ",
            "ENC",
            "FGT",
            "FST",
            "IBB",
            "IBK",
            "IBP",
            "IDP",
            "IFD",
            "IFH",
            "IFK",
            "IFP",
            "IJY",
            "IKB",
            "ILF",
            "ILM",
            "ING",
            "IPN",
            "IPR",
            "ISH",
            "ISP",
            "ITP",
            "IUH",
            "IWK",
            "KCI",
            "KIK",
            "KOB",
            "OBK",
            "OFH",
            "OFK",
            "OPI",
            "PF-BBW",
            "PF-BOB",
            "PF-BTH",
            "PF-CHB",
            "PF-CLP",
            "PF-FMM",
            "PF-HCT",
            "PF-HDR",
            "PF-HTF",
            "PF-HUR",
            "PF-ICS",
            "PF-LEA",
            "PF-LHP",
            "PF-LTO",
            "PF-OTH",
            "PF-RFK",
            "PF-RTH",
            "PF-RTK",
            "PF-RTK",
            "PF-RTP",
            "PF-SKE",
            "PF-TGT",
            "PF-TRP",
            "PF-UNR",
            "RNH",
            "RNK",
            "SLI",
            "SLM",
            "SLW",
            "SUB",
            "UC-2PN",
            "UC-ABL",
            "UC-BCH",
            "UC-DEA",
            "UC-FCO",
            "UC-RHT",
            "UC-SBR",
            "UC-STB",
            "UC-TAU",
            "UC-UNS",
            "UFA",
            "UFT"
    ));

    public static List<String> getCodes() {
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
        if (!(object instanceof codes)) {
            return false;
        }
        codes other = (codes) object;
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
