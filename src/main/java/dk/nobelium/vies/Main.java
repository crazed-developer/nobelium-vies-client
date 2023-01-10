package dk.nobelium.vies;


import dk.nobelium.vies.models.ViesDetailResponse;
import dk.nobelium.vies.models.ViesSimpleResponse;

import java.util.Optional;

public class Main {
//    private static final String bmwCountryCode = "DE";
//    private static final String mercedesCountryCode = "DE";
//
//    private static final String bmwVatNumber = "129273398";
//    private static final String mercedesVatNumber = "812526315";

    private static final String bmwCountryCode = "DK";
    private static final String mercedesCountryCode = "PL";

    private static final String bmwVatNumber = "36045841";
    private static final String mercedesVatNumber = "7891575087";



    public static void main(String[] args) {

        try {
            // Simple reqiest example
            // We request status on Mercedes Benz VAT status
            Optional<ViesSimpleResponse> requestSimple = ViesService.lookupVatSimple(
                    mercedesCountryCode,
                    mercedesVatNumber);

            requestSimple.ifPresent(System.out::println);

            // Detail request example
            // We request status on BMW VAT status + Identify our selves as Mercedes Benz as a requester.
            Optional<ViesDetailResponse> responseDetail = ViesService.lookupVatDetail(
                    mercedesCountryCode,
                    mercedesVatNumber,
                    bmwCountryCode,
                    bmwVatNumber
            );

            responseDetail.ifPresent(System.out::println);

        } catch (ViesVatServiceException e) {
            e.printStackTrace();
        }
    }
}
