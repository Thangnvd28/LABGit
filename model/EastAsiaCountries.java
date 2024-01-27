
package model;

import java.util.Objects;

public class EastAsiaCountries extends Country implements Comparable <EastAsiaCountries> {
    
    private String countryTerrain;

    public EastAsiaCountries(String countryTerrain, String countryCode, String countryName, float totalArea) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }

    public EastAsiaCountries() {
    }

    public String getCountryTerrain() {
        return countryTerrain;
    }

    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EastAsiaCountries other = (EastAsiaCountries) obj;
        return Objects.equals(this.countryCode.toLowerCase(), other.countryCode.toLowerCase());
    }
    
    

    @Override
    public String toString() {
        System.out.printf("%s  | %-40s\n", super.toString(), this.countryTerrain);
        return "";
    }

    @Override
    public int compareTo(EastAsiaCountries ea) {
        return this.countryName.compareToIgnoreCase(ea.countryName);
    }

    

    
    
    
    
    
}
