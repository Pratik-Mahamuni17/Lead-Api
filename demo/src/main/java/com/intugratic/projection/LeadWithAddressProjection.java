package com.intugratic.projection;

import java.util.List;

public interface LeadWithAddressProjection {

    Long getId();
    String getFirstName();
    String getLastName();
    String getPhone();
    String getSecondaryPhone();
    String getEmail();
    String getLeadStatus();
    String getPriority();
    String getFollowUpDate();

    List<AddressProjection> getAddresses();

    interface AddressProjection {
        String getAddressLine();
        String getStreet();
        String getCity();
        String getState();
        String getZipCode();
        String getCountry();
        String getSiteVisit();
        String getSiteVisitDate();
    }
}
