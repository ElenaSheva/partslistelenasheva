package ru.javarush.internship.partslistelenasheva.entity;


import javax.persistence.*;

@Entity
@Table(name = "part", schema = "test1")
public class PartEntity {
    public PartEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer fId;

    @Column(name = "Partname", length = 255, nullable = false, unique = true)
    private String fPartname = null;

    @Column(name = "Necessary", nullable = false, columnDefinition = "TINYINT", length = 1)
    private boolean fNecessary = false;

    @Column(name = "Quantity", nullable = false)
    private Integer fQuantity = null;

    public Integer getId() {
        return fId;
    }

    public void setId(Integer fId) {
        this.fId = fId;
    }

    public String getPartname() {
        return fPartname;
    }

    public void setPartName(String aPartname) {
        if (aPartname != null){
            fPartname = aPartname;
        } else {
            throw new IllegalArgumentException("Partname is null");
        }
    }

    public boolean isNecessary() {
        return fNecessary;
    }

    public String getTextFromNecessary(){
        String lResult = "No";
        if (fNecessary){
            lResult = "Yes";
        }
        return lResult;
    }

    public void setNecessary(boolean aNecessary) {
        fNecessary = aNecessary;
    }

    public Integer getQuantity() {
        return fQuantity;
    }

    public void setQuantity(Integer aQuantity) {
        if (aQuantity != null){
            fQuantity = aQuantity;
        } else {
            throw new IllegalArgumentException("Quantity is null");
        }
    }

    @Override
    public String toString() {
        return  " - " + fId +
                " - " + fPartname +
                " - " + getTextFromNecessary() +
                " - " + fQuantity
                ;
    }
}
