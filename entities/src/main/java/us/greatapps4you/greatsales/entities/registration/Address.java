/*
 * Copyright (c) 2021 GreatApps4you LLC
 *  This Software is licenced under the GNU GENERAL PUBLIC LICENSE v3
 *  https://www.gnu.org/licenses/gpl-3.0.txt
 *  https://greatapps4you.us
 *  CSSML NDSMD VRS + SNMV SMQL IVB
 */

package us.greatapps4you.greatsales.entities.registration;

import lombok.Builder;
import lombok.Data;
import java.util.UUID;

@Data
@Builder
public class Address {
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

}
