/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsfweb.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CHIKI
 */
@Entity
@Table(name = "USERINFOTABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userinfotable.findAll", query = "SELECT u FROM Userinfotable u"),
    @NamedQuery(name = "Userinfotable.findByUserid", query = "SELECT u FROM Userinfotable u WHERE u.userid = :userid"),
    @NamedQuery(name = "Userinfotable.findByFirstname", query = "SELECT u FROM Userinfotable u WHERE u.firstname = :firstname"),
    @NamedQuery(name = "Userinfotable.findByLastname", query = "SELECT u FROM Userinfotable u WHERE u.lastname = :lastname"),
    @NamedQuery(name = "Userinfotable.findByEmail", query = "SELECT u FROM Userinfotable u WHERE u.email = :email"),
    @NamedQuery(name = "Userinfotable.findByMobile", query = "SELECT u FROM Userinfotable u WHERE u.mobile = :mobile"),
    @NamedQuery(name = "Userinfotable.findByScrtQsn", query = "SELECT u FROM Userinfotable u WHERE u.scrtQsn = :scrtQsn"),
    @NamedQuery(name = "Userinfotable.findByScrtAns", query = "SELECT u FROM Userinfotable u WHERE u.scrtAns = :scrtAns")})
public class Userinfotable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "USERID")
    private String userid;
    @Size(max = 32)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(max = 32)
    @Column(name = "LASTNAME")
    private String lastname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 15)
    @Column(name = "MOBILE")
    private String mobile;
    @Size(max = 250)
    @Column(name = "SCRT_QSN")
    private String scrtQsn;
    @Size(max = 100)
    @Column(name = "SCRT_ANS")
    private String scrtAns;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usertable usertable;

    public Userinfotable() {
    }

    public Userinfotable(String userid) {
        this.userid = userid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getScrtQsn() {
        return scrtQsn;
    }

    public void setScrtQsn(String scrtQsn) {
        this.scrtQsn = scrtQsn;
    }

    public String getScrtAns() {
        return scrtAns;
    }

    public void setScrtAns(String scrtAns) {
        this.scrtAns = scrtAns;
    }

    public Usertable getUsertable() {
        return usertable;
    }

    public void setUsertable(Usertable usertable) {
        this.usertable = usertable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userinfotable)) {
            return false;
        }
        Userinfotable other = (Userinfotable) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ username ").append(userid).
                append(" email ").append(email)
                .append(" ]");
        return sb.toString();
    }
    
}
