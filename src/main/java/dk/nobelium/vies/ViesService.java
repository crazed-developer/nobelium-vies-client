package dk.nobelium.vies;

import dk.nobelium.vies.models.ViesDetailResponse;
import dk.nobelium.vies.models.ViesSimpleResponse;
import eu.europa.ec.taxud.vies.services.checkvat.CheckVatPortType;
import eu.europa.ec.taxud.vies.services.checkvat.CheckVatService;

import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.ws.Holder;
import jakarta.xml.ws.soap.SOAPFaultException;
import java.time.LocalDate;
import java.util.Optional;

public class ViesService {

    /**
     * @param traderCountryCode
     * @param traderVatNumber
     * @return
     * @throws ViesVatServiceException
     */
    public static Optional<ViesSimpleResponse> lookupVatSimple(
            String traderCountryCode,
            String traderVatNumber
    ) throws ViesVatServiceException {

        CheckVatService service = new CheckVatService();

        CheckVatPortType cv = service.getCheckVatPort();

        Holder<String> countryCode = new Holder<>(traderCountryCode);
        Holder<String> vatNumber = new Holder<>(traderVatNumber);
        Holder<XMLGregorianCalendar> requestDate = new Holder<>();
        Holder<Boolean> valid = new Holder<>();
        Holder<String> traderName = new Holder<>();
        Holder<String> traderAddress = new Holder<>();

        try {
            cv.checkVat(countryCode, vatNumber, requestDate, valid, traderName, traderAddress);
        } catch (SOAPFaultException ex) {

            throw new ViesVatServiceException(
                    ex.getFault().getFaultString()
            );
        }

        if (valid.value != null && valid.value) {

            LocalDate localRequestDate = gregCalToLocalDate(requestDate);

            ViesSimpleResponse response = new ViesSimpleResponse(
                    countryCode.value,
                    vatNumber.value,
                    localRequestDate,
                    valid.value,
                    traderName.value,
                    traderAddress.value
            );

            return Optional.of(response);

        }

        return Optional.empty();

    }

    /**
     * @param requesterCountryCode
     * @param requesterVatNumber
     * @param traderCountryCode
     * @param traderVatNumber
     * @return
     * @throws ViesVatServiceException
     */
    public static Optional<ViesDetailResponse> lookupVatDetail(
            String requesterCountryCode,
            String requesterVatNumber,
            String traderCountryCode,
            String traderVatNumber
    ) throws ViesVatServiceException {

//        100 = Valid request with Valid VAT Number
//        200 = Valid request with an Invalid VAT Number
//        201 = Error : INVALID_INPUT
//        202 = Error : INVALID_REQUESTER_INFO
//        300 = Error : SERVICE_UNAVAILABLE
//        301 = Error : MS_UNAVAILABLE
//        302 = Error : TIMEOUT
//        400 = Error : VAT_BLOCKED
//        401 = Error : IP_BLOCKED
//        500 = Error : GLOBAL_MAX_CONCURRENT_REQ
//        501 = Error : GLOBAL_MAX_CONCURRENT_REQ_TIME
//        600 = Error : MS_MAX_CONCURRENT_REQ
//        601 = Error : MS_MAX_CONCURRENT_REQ_TIME

        CheckVatService service = new CheckVatService();

        CheckVatPortType cv = service.getCheckVatPort();

        Holder<String> countryCode = new Holder<>(traderCountryCode);
        Holder<String> vatNumber = new Holder<>(traderVatNumber);
        Holder<XMLGregorianCalendar> requestDate = new Holder<>();
        Holder<Boolean> valid = new Holder<>();
        Holder<String> traderName = new Holder<>();
        Holder<String> traderCompanyType = new Holder<>();
        Holder<String> traderAddress = new Holder<>();
        Holder<String> traderStreet = new Holder<>();
        Holder<String> traderPostcode = new Holder<>();
        Holder<String> traderCity = new Holder<>();
        Holder<String> traderNameMatch = new Holder<>();
        Holder<String> traderCompanyTypeMatch = new Holder<>();
        Holder<String> traderStreetMatch = new Holder<>();
        Holder<String> traderPostcodeMatch = new Holder<>();
        Holder<String> traderCityMatch = new Holder<>();
        Holder<String> requestIdentifier = new Holder<>();

        try {
            cv.checkVatApprox(
                    countryCode,
                    vatNumber,
                    traderName,
                    traderCompanyType,
                    traderStreet,
                    traderPostcode,
                    traderCity,
                    requesterCountryCode,
                    requesterVatNumber,
                    requestDate,
                    valid,
                    traderAddress,
                    traderNameMatch,
                    traderCompanyTypeMatch,
                    traderStreetMatch,
                    traderPostcodeMatch,
                    traderCityMatch,
                    requestIdentifier);
        } catch (SOAPFaultException ex) {

            throw new ViesVatServiceException(
                    ex.getFault().getFaultString()
            );

        }

        if (valid.value != null && valid.value) {

            LocalDate localRequestDate = gregCalToLocalDate(requestDate);

            ViesDetailResponse response = new ViesDetailResponse(
                    countryCode.value,
                    vatNumber.value,
                    localRequestDate,
                    valid.value,
                    traderName.value,
                    traderCompanyType.value,
                    traderAddress.value,
                    traderStreet.value,
                    traderPostcode.value,
                    traderCity.value,
                    traderNameMatch.value,
                    traderCompanyTypeMatch.value,
                    traderStreetMatch.value,
                    traderPostcodeMatch.value,
                    traderCityMatch.value,
                    requestIdentifier.value
            );

            return Optional.of(response);
        } else {
            return Optional.empty();
        }

    }

    private static LocalDate gregCalToLocalDate(Holder<XMLGregorianCalendar> requestDate) {
        LocalDate localRequestDate = null;

        if (requestDate.value != null) {
            int year = requestDate.value.getYear();
            int month = requestDate.value.getMonth();
            int day = requestDate.value.getDay();

            localRequestDate = LocalDate.of(year, month, day);
        }
        return localRequestDate;
    }


}