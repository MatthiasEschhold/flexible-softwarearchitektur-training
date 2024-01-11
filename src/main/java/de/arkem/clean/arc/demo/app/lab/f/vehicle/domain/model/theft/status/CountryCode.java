package de.arkem.clean.arc.demo.app.lab.f.vehicle.domain.model.theft.status;

public enum CountryCode {
    DE("DE"),
    FR("FR"),
    IT("IT"),
    ESP("ES"),
    GB("GB"),
    RU("RU"),
    SA("SA"),
    BZ  ("BZ"),
    MEX("MX"),
    USA("US"),
    NOT_RELEVANT("XX");

    private String value;
    CountryCode(String value) {
        this.value = value;
    }

    public String countryCodeValue() {
        return value;
    }
}
