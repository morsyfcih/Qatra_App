/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Morsy
 */
@Entity
@Table(name = "REQUESTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requests.findAll", query = "SELECT r FROM Requests r"),
    @NamedQuery(name = "Requests.findByRequestID", query = "SELECT r FROM Requests r WHERE r.requestID = :requestID"),
    @NamedQuery(name = "Requests.findByPost", query = "SELECT r FROM Requests r WHERE r.post = :post"),
    //Search query for requests
    @NamedQuery(name = "Requests.searchPosts" , query = "SELECT r FROM Requests r WHERE r.post LIKE :post"),
    @NamedQuery(name = "Requests.findByCreatedAt", query = "SELECT r FROM Requests r WHERE r.createdAt = :createdAt"),
    @NamedQuery(name = "Requests.findByStatus", query = "SELECT r FROM Requests r WHERE r.status = :status")})
public class Requests implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RequestID")
    private Integer requestID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "Post")
    private String post;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "Status")
    private Boolean status;
    @JoinColumn(name = "user_id", referencedColumnName = "UserID")
    @ManyToOne(optional = false)
    private Users userId;

    public Requests() {
    }

    public Requests(Integer requestID) {
        this.requestID = requestID;
    }

    public Requests(Integer requestID, String post, Date createdAt) {
        this.requestID = requestID;
        this.post = post;
        this.createdAt = createdAt;
    }

    public Integer getRequestID() {
        return requestID;
    }

    public void setRequestID(Integer requestID) {
        this.requestID = requestID;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requestID != null ? requestID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requests)) {
            return false;
        }
        Requests other = (Requests) object;
        if ((this.requestID == null && other.requestID != null) || (this.requestID != null && !this.requestID.equals(other.requestID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Requests[ requestID=" + requestID + " ]";
    }
    
}
