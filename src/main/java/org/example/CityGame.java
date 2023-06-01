package org.example;

import java.util.ArrayList;

public class CityGame {

    private ArrayList<String> city = new ArrayList<>();


    public boolean isEmpty() {
        if (city.isEmpty() == true) {
            return true;
        } else {
            return false;
        }
    }


    public String TheLastCity() {
        String lastCity = city.get(city.size() - 1);
        return lastCity;
    }

    public boolean CitiesThatAreNotTrue(String citys) {
        String lastCity = city.get(city.size() - 1);
        String lastLetter1 = lastCity.substring(lastCity.length() - 1);
        String lastLetter2 = citys.substring(0, 1).toLowerCase();

        if(city.contains(citys) == true){
            return false;
        } if (lastLetter1.equals(lastLetter2)){
            return true;
        }else {
            return false;
        }
    }


    public void addCity(String cityes) {
        System.out.println("Пользователь ввел: " + cityes);
        city.add(cityes);
    }
}

