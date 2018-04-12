package com.tam.app;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CountryCollection {
    List countryList;
    Set countrySet;
    Map countryMap;
    Properties countryProp;
    public CountryCollection() {}
    public CountryCollection(List countryList, Set countrySet, Map countryMap, Properties countryProp) {
        super();
        this.countryList = countryList;
        this.countrySet = countrySet;
        this.countryMap = countryMap;
        this.countryProp = countryProp;
    }
    public List getCountryList() {
        return countryList;
    }
    public void setCountryList(List countryList) {
        this.countryList = countryList;
    }
    public Set getCountrySet() {
        return countrySet;
    }
    public void setCountrySet(Set countrySet) {
        this.countrySet = countrySet;
    }
    public Map getCountryMap() {
        return countryMap;
    }
    public void setCountryMap(Map countryMap) {
        this.countryMap = countryMap;
    }
    public Properties getCountryProp() {
        return countryProp;
    }
    public void setCountryProp(Properties countryProp) {
        this.countryProp = countryProp;
    }
    @Override
    public String toString() {
        return "CountryCollection [countryList=" + countryList + ", countrySet=" + countrySet + ", countryMap=" + countryMap + ", countryProp=" + countryProp + "]";
    }
    
    
}
