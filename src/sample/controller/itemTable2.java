package sample.controller;

public class itemTable2 {
    String type,name,mediumName,bigName;
    Double mediumPrice,bigPrice;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMediumName() {
        return mediumName;
    }

    public void setMediumName(String mediumName) {
        this.mediumName = mediumName;
    }

    public String getBigName() {
        return bigName;
    }

    public void setBigName(String bigName) {
        this.bigName = bigName;
    }

    public Double getMediumPrice() {
        return mediumPrice;
    }

    public void setMediumPrice(Double mediumPrice) {
        this.mediumPrice = mediumPrice;
    }

    public Double getBigPrice() {
        return bigPrice;
    }

    public void setBigPrice(Double bigPrice) {
        this.bigPrice = bigPrice;
    }

    public itemTable2(String type, String name, String mediumName, String bigName, Double mediumPrice, Double bigPrice) {
        this.type = type;
        this.name = name;
        this.mediumName = mediumName;
        this.bigName = bigName;
        this.mediumPrice = mediumPrice;
        this.bigPrice = bigPrice;
    }
}
