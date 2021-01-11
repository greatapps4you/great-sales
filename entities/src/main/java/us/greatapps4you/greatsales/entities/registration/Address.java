/*
 * Copyright (c) 2021. GreatApps4you LLC
 * This Software is licenced to you according to the GNU GENERAL PUBLIC LICENSE
 * https://www.gnu.org/licenses/gpl-3.0.txt
 * https://greatapps4you.us
 * CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.entities.registration;

import java.io.Serializable;
import java.util.UUID;

public class Address implements Serializable {

    private Long sequential;
    private UUID uuid;
    private String street;
    private String number;
    private String complement;
    private String zip;
    private String neighborhood;
    private String city;
    private String countryState;
    private String country;
    private String website;
    private String email;
    private String cellPhone;
    private String phone;

    public Address() {
    }

    public Address(Long sequential, UUID uuid, String street, String number, String complement, String zip, String neighborhood, String city, String countryState, String country, String website, String email, String cellPhone, String phone) {
        this.sequential = sequential;
        this.uuid = uuid;
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.zip = zip;
        this.neighborhood = neighborhood;
        this.city = city;
        this.countryState = countryState;
        this.country = country;
        this.website = website;
        this.email = email;
        this.cellPhone = cellPhone;
        this.phone = phone;
    }

    public Long getSequential() {
        return sequential;
    }

    public void setSequential(Long sequential) {
        this.sequential = sequential;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountryState() {
        return countryState;
    }

    public void setCountryState(String countryState) {
        this.countryState = countryState;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (!street.equals(address.street)) return false;
        if (!number.equals(address.number)) return false;
        if (!zip.equals(address.zip)) return false;
        if (!city.equals(address.city)) return false;
        return country.equals(address.country);
    }

    @Override
    public int hashCode() {
        int result = street.hashCode();
        result = 31 * result + number.hashCode();
        result = 31 * result + zip.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + country.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", zip='" + zip + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", city='" + city + '\'' +
                ", countryState='" + countryState + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
