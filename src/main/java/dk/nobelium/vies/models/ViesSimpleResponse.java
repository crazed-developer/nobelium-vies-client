package dk.nobelium.vies.models;

import java.time.LocalDate;
import java.util.Objects;

public class ViesSimpleResponse {
    private final String countryCode;
    private final String vatNumber;
    private final LocalDate requestDate;
    private final Boolean valid;
    private final String traderName;
    private final String traderAddress;

    public ViesSimpleResponse(
            String countryCode,
            String vatNumber,
            LocalDate requestDate,
            Boolean valid,
            String traderName,
            String traderAddress) {
        this.countryCode = countryCode;
        this.vatNumber = vatNumber;
        this.requestDate = requestDate;
        this.valid = valid;
        this.traderName = traderName;
        this.traderAddress = traderAddress;
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


    public String getTraderAddress() {
        return traderAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViesSimpleResponse response = (ViesSimpleResponse) o;
        return Objects.equals(countryCode, response.countryCode) &&
                Objects.equals(vatNumber, response.vatNumber) &&
                Objects.equals(requestDate, response.requestDate) &&
                Objects.equals(valid, response.valid) &&
                Objects.equals(traderName, response.traderName) &&
                Objects.equals(traderAddress, response.traderAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryCode, vatNumber, requestDate, valid, traderName, traderAddress);
    }

    @Override
    public String toString() {
        return "ViesSimpleResponse{" +
                "countryCode='" + countryCode + '\'' +
                ", vatNumber='" + vatNumber + '\'' +
                ", requestDate=" + requestDate +
                ", valid=" + valid +
                ", traderName='" + traderName + '\'' +
                ", traderAddress='" + traderAddress + '\'' +
                '}';
    }
}