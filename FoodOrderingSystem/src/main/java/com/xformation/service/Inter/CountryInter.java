package com.xformation.service.Inter;

import com.xformation.model.Country;

public interface CountryInter {
    void addCountry(String name);

    Country findCountryByName(String name);

    Country findCountryById(int id);
}
