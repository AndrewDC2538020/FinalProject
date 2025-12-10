package org.andrew;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Address {
    @Setter private int streetNo;
    @Setter private String street;
    @Setter private String city;
    @Setter private Province province;
    private String postalCode;

    public enum Province {
        NL, PE, NS, NB, QC, ON, MB, SK, AB, BC, YT, NT, NU
    }

    /**
     * Checks if a postcode is valid or not.
     * @param postalCode the input postal code
     * @return if valid = true or if not valid = false
     */
    public static boolean isPostalCodeValid(String postalCode) {
        if (postalCode == null || postalCode.length() != 6)
            return false;

        postalCode = postalCode.toUpperCase();

        return Character.isLetter(postalCode.charAt(0)) &&
                Character.isDigit(postalCode.charAt(1)) &&
                Character.isLetter(postalCode.charAt(2)) &&
                Character.isDigit(postalCode.charAt(3)) &&
                Character.isLetter(postalCode.charAt(4)) &&
                Character.isDigit(postalCode.charAt(5));
    }

    /**
     * check if the parameter postalCode is valid or not, if it is valid, then set
     * all fields, while postal code with all character uppercase to the field, else set everything as null.
     * @param streetNo the street number input
     * @param street the street name input
     * @param city the city name input
     * @param province the province input
     * @param postalCode the postal code input
     */
    public Address(int streetNo, String street, String city, Province province, String postalCode) {

        if (isPostalCodeValid(postalCode)) {
            this.streetNo = streetNo;
            this.street = street;
            this.city = city;
            this.province = province;
            this.postalCode = postalCode.toUpperCase();
        } else {
            // invalid → set everything to null (streetNo becomes 0)
            this.streetNo = 0;
            this.street = null;
            this.city = null;
            this.province = null;
            this.postalCode = null;
        }
    }

    /**
     * sets the postal codes
     * @param postalCode the postal input
     */
    public void setPostalCode(String postalCode) {
        if (isPostalCodeValid(postalCode)) {
            this.postalCode = postalCode.toUpperCase();
        }
    }
}
