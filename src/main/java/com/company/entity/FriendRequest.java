/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author roma-cervice
 */
@Entity
@Table(name = "friend_request")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FriendRequest.findAll", query = "SELECT f FROM FriendRequest f")
    , @NamedQuery(name = "FriendRequest.findById", query = "SELECT f FROM FriendRequest f WHERE f.id = :id")})
public class FriendRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "from_user", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User fromUser;
    @JoinColumn(name = "to_user", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User toUser;

    public FriendRequest() {
    }

    public FriendRequest(Integer id) {
        this.id = id;
    }

    public FriendRequest(Integer id,User fromUser,User toUser) {
        this.id = id;
        this.fromUser=fromUser;
        this.toUser=toUser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getFromUser() {
        return fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    public User getToUser() {
        return toUser;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof FriendRequest)) {
            return false;
        }
        FriendRequest other = (FriendRequest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.company.entity.FriendRequest[ id=" + id + " ]";
    }

}
