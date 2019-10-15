package com.halbert.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Plan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "patientId",foreignKey = @ForeignKey(name = "fk_pp"))
    private Patient patient;

    ////PERSIST新增，保存级联操作、MERGE更新级联操作、REFRESH刷新级联操作、REMOVE删除级联操作
    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH },fetch = FetchType.LAZY)
    //多的一方维护的列，foreignKey实际为索引值，并不是外键值
    @JoinColumn(name = "planId", foreignKey = @ForeignKey(name = "fk_ps", value =ConstraintMode.CONSTRAINT))
    private Set<Shot> shots;

    private String name;

    public Plan(){

    }
    public Plan(String name){
        this.name = name;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Shot> getShots() {
        return shots;
    }

    public void setShots(Set<Shot> shots) {
        this.shots = shots;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", name=" + name +
                ", patient=" + patient +
                ", shots='" + shots + '\'' +
                '}';
    }
}
