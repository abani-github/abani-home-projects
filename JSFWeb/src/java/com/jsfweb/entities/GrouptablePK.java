/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsfweb.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author CHIKI
 */
@Embeddable
public class GrouptablePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "USERID")
    private String userid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "GROUPID")
    private String groupid;

    public GrouptablePK() {
    }

    public GrouptablePK(String userid, String groupid) {
        this.userid = userid;
        this.groupid = groupid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        hash += (groupid != null ? groupid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrouptablePK)) {
            return false;
        }
        GrouptablePK other = (GrouptablePK) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        if ((this.groupid == null && other.groupid != null) || (this.groupid != null && !this.groupid.equals(other.groupid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jsfweb.entities.GrouptablePK[ userid=" + userid + ", groupid=" + groupid + " ]";
    }
    
}
