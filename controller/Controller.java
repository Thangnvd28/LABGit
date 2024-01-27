
package controller;

import java.util.List;
import java.util.Collections;
import java.util.Scanner;
import model.CountriesList;
import model.EastAsiaCountries;
import utils.FormatString;
import utils.InputUtils;
import view.Menu;


public class Controller {

    
    public static void main(String[] args) {
        CountriesList cl = new CountriesList();
        int choice;
        while (true) {
            choice = Menu.chooseMenuOption();
            switch (choice) {
                case 1 -> {
                    addCountryInformation(cl);
                }
                case 2 -> {
                    getRecentlyEnteredInformation(cl);
                }
                case 3 -> {
                    searchInformationByName(cl);
                }
                case 4 -> {
                    sortInformationByAscendingOrder(cl);
                }
                case 5 ->
                    System.exit(0);
            }
        }
    }

    public static EastAsiaCountries inputInformation() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter country's code:");
        String code = InputUtils.inputCode();
        System.out.println("Enter country's name:");
        String name = InputUtils.inputName();
        name = FormatString.formatName(name);
        System.out.println("Enter country's total area: ");
        float area = InputUtils.inputFloat();
        System.out.println("Enter terrant: ");
        String tr = sc.nextLine();
        EastAsiaCountries eac = new EastAsiaCountries(tr, code, name, area);
        return eac;
    }

    public static void addCountryInformation(CountriesList cl) {
        boolean back;
        do {
            back  = false;
            EastAsiaCountries eac = inputInformation();
            cl.addList(eac);
            System.out.println("Do you want to continue?\n1.Yes\n2.No");
            int choice = InputUtils.inputOption(1, 2);
            if (choice == 1) {
                back = true;
            }
        } while (back == true);
    }

    public static void searchInformationByName(CountriesList cl) {
        System.out.print("Enter name to find: ");
        String name = InputUtils.inputName();
        cl.SearchByCondition((EastAsiaCountries t) -> t.getCountryName().toLowerCase().contains(name.toLowerCase()));
    }

    public static void getRecentlyEnteredInformation(CountriesList cl) {
        List<EastAsiaCountries> clList = cl.getCountryList();
        EastAsiaCountries last = clList.get(clList.size() - 1);
        last.toString();
    }

    public static void sortInformationByAscendingOrder(CountriesList cl) {
        Collections.sort(cl.getCountryList());
        System.out.printf("ID               | Name                  | Area                  | Terrant\n");
        for (EastAsiaCountries eac : cl.getCountryList()) {
            eac.toString();
        }
    }

}
