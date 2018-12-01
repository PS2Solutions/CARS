/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataclasses;

/**
 *
 * @author shinu.k
 */
public class MaterialDto {

    int id;
    String materialName;
    String materialCode;
    String remark;
    double perPointRate;
    String quotationType;
    int quoteTypeId;
    String  category;
    int categoryId;
    String brand;
    String status;
    String lastEdit;
    String imagePath;
    String warrentyPeriod;
    boolean warrentyEligibility;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public double getPerPointRate() {
        return perPointRate;
    }

    public void setPerPointRate(double perPointRate) {
        this.perPointRate = perPointRate;
    }

    public String getQuotationType() {
        return quotationType;
    }

    public void setQuotationType(String quotationType) {
        this.quotationType = quotationType;
    }

    public int getQuoteTypeId() {
        return quoteTypeId;
    }

    public void setQuoteTypeId(int quoteTypeId) {
        this.quoteTypeId = quoteTypeId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLastEdit() {
        return lastEdit;
    }

    public void setLastEdit(String lastEdit) {
        this.lastEdit = lastEdit;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getWarrentyPeriod() {
        return warrentyPeriod;
    }

    public void setWarrentyPeriod(String warrentyPeriod) {
        this.warrentyPeriod = warrentyPeriod;
    }

    public boolean isWarrentyEligibility() {
        return warrentyEligibility;
    }

    public void setWarrentyEligibility(boolean warrentyEligibility) {
        this.warrentyEligibility = warrentyEligibility;
    }
    
    
}
