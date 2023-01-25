package pl.lotto.resultchecker.dto;

public enum TicketStateDto {
    NOT_FOUND,
    CHECKED,
    TOO_EARLY;

    public boolean isNotFound(){
        return this.equals(NOT_FOUND);
    }
    public boolean isChecked(){
        return this.equals(CHECKED);
    }
    public boolean isTooEarly(){
        return this.equals(TOO_EARLY);
    }
}
