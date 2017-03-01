package net.tabka.akram.model;

/**
 * Created by PMTA07911 on 01/03/2017.
 */
public class Identification {
    String indentification;
    Long number;

    public Identification(String indentification, Long number) {
        this.indentification = indentification;
        this.number = number;
    }

    public String getIndentification() {
        return indentification;
    }

    public void setIndentification(String indentification) {
        this.indentification = indentification;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }
}
