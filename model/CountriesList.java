
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CountriesList {
    private List<EastAsiaCountries> countryList = new ArrayList<>();

    public List<EastAsiaCountries> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<EastAsiaCountries> countryList) {
        this.countryList = countryList;
    }
    
    public void addList(EastAsiaCountries ct){
        try {
            for (EastAsiaCountries c : countryList) {
                if (c.getCountryCode().equalsIgnoreCase(ct.getCountryCode())) {
                    throw new IllegalArgumentException("Code is already existed. Failed to add!");
                }
            }
            countryList.add(ct);
            System.out.println("Added successfully.");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void SearchByCondition(Predicate<EastAsiaCountries> p) {
        for (int i = 0; i < countryList.size(); ++i) {
            if (p.test(countryList.get(i))) {
                countryList.get(i).toString();
            }

        }
    }
    
    
}
