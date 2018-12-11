/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise.Entities;

import Business.Organization.Organization;
import java.util.HashMap;

/**
 *
 * @author amber
 */
public class SupplierWarehouse {
    private String warehousenameString;
    private HashMap<Material,Integer> avaliableMaterialHashMap;
    private String locationString;
    private Organization organization;

    public String getWarehousenameString() {
        return warehousenameString;
    }

    public void setWarehousenameString(String warehousenameString) {
        this.warehousenameString = warehousenameString;
    }

    public HashMap<Material, Integer> getAvaliableMaterialHashMap() {
        return avaliableMaterialHashMap;
    }

    public void setAvaliableMaterialHashMap(HashMap<Material, Integer> avaliableMaterialHashMap) {
        this.avaliableMaterialHashMap = avaliableMaterialHashMap;
    }

    public String getLocationString() {
        return locationString;
    }

    public void setLocationString(String locationString) {
        this.locationString = locationString;
    }
    
    public String toString(){
        return warehousenameString;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
