package dk.nobelium.vies.models;

import java.time.LocalDate;
import java.util.Objects;

public class ViesDetailResponse {

    private final String countryCode;
    private final String vatNumber;
    private final LocalDate requestDate;
    private final Boolean valid;
    private final String traderName;
    private final String traderCompanyType;
    private final String traderAddress;
    private final String traderStreet;
    private final String traderPostcode;
    private final String traderCity;
    private final String traderNameMatch;
    private final String traderCompanyTypeMatch;
    private final String traderStreetMatch;
    private final String traderPostcodeMatch;
    private final String traderCityMatch;
    private final String requestIdentifier;

    public ViesDetailResponse(String countryCode, String vatNumber, LocalDate requestDate, Boolean valid, String traderName, String traderCompanyType, String traderAddress, String traderStreet, String traderPostcode, String traderCity, String traderNameMatch, String traderCompanyTypeMatch, String traderStreetMatch, String traderPostcodeMatch, String traderCityMatch, String requestIdentifier) {
        this.countryCode = countryCode;
        this.vatNumber = vatNumber;
        this.requestDate = requestDate;
        this.valid = valid;
        this.traderName = traderName;
        this.traderCompanyType = traderCompanyType;
        this.traderAddress = traderAddress;
        this.traderStreet = traderStreet;
        this.traderPostcode = traderPostcode;
        this.traderCity = traderCity;
        this.traderNameMatch = traderNameMatch;
        this.traderCompanyTypeMatch = traderCompanyTypeMatch;
        this.traderStreetMatch = traderStreetMatch;
        this.traderPostcodeMatch = traderPostcodeMatch;
        this.traderCityMatch = traderCityMatch;
        this.requestIdentifier = requestIdentifier;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public Boolean getValid() {
        return valid;
    }

    public String getTraderName() {
        return traderName;
    }

    public String getTraderCompanyType() {
        return traderCompanyType;
    }

    public String getTraderAddress() {
        return traderAddress;
    }

    public String getTraderStreet() {
        return traderStreet;
    }

    public String getTraderPostcode() {
        return traderPostcode;
    }

    public String getTraderCity() {
        return traderCity;
    }

    public String getTraderNameMatch() {
        return traderNameMatch;
    }

    public String getTraderCompanyTypeMatch() {
        return traderCompanyTypeMatch;
    }

    public String getTraderStreetMatch() {
        return traderStreetMatch;
    }

    public String getTraderPostcodeMatch() {
        return traderPostcodeMatch;
    }

    public String getTraderCityMatch() {
        return traderCityMatch;
    }

    public String getRequestIdentifier() {
        return requestIdentifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViesDetailResponse that = (ViesDetailResponse) o;
        return Objects.equals(countryCode, that.countryCode) &&
                Objects.equals(vatNumber, that.vatNumber) &&
                Objects.equals(requestDate, that.requestDate) &&
                Objects.equals(valid, that.valid) &&
                Objects.equals(traderName, that.traderName) &&
                Objects.equals(traderCompanyType, that.traderCompanyType) &&
                Objects.equals(traderAddress, that.traderAddress) &&
                Objects.equals(traderStreet, that.traderStreet) &&
                Objects.equals(traderPostcode, that.traderPostcode) &&
                Objects.equals(traderCity, that.traderCity) &&
                Objects.equals(traderNameMatch, that.traderNameMatch) &&
                Objects.equals(traderCompanyTypeMatch, that.traderCompanyTypeMatch) &&
                Objects.equals(traderStreetMatch, that.traderStreetMatch) &&
                Objects.equals(traderPostcodeMatch, that.traderPostcodeMatch) &&
                Objects.equals(traderCityMatch, that.traderCityMatch) &&
                Objects.equals(requestIdentifier, that.requestIdentifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryCode, vatNumber, requestDate, valid, traderName, traderCompanyType, traderAddress, traderStreet, traderPostcode, traderCity, traderNameMatch, traderCompanyTypeMatch, traderStreetMatch, traderPostcodeMatch, traderCityMatch, requestIdentifier);
    }

    @Override
    public String toString() {
        return "ViesDetailResponse{" +
                "countryCode='" + countryCode + '\'' +
                ", vatNumber='" + vatNumber + '\'' +
                ", requestDate=" + requestDate +
                ", valid=" + valid +
                ", traderName='" + traderName + '\'' +
                ", traderCompanyType='" + traderCompanyType + '\'' +
                ", traderAddress='" + traderAddress + '\'' +
                ", traderStreet='" + traderStreet + '\'' +
                ", traderPostcode='" + traderPostcode + '\'' +
                ", traderCity='" + traderCity + '\'' +
                ", traderNameMatch='" + traderNameMatch + '\'' +
                ", traderCompanyTypeMatch='" + traderCompanyTypeMatch + '\'' +
                ", traderStreetMatch='" + traderStreetMatch + '\'' +
                ", traderPostcodeMatch='" + traderPostcodeMatch + '\'' +
                ", traderCityMatch='" + traderCityMatch + '\'' +
                ", requestIdentifier='" + requestIdentifier + '\'' +
                '}';
    }
}