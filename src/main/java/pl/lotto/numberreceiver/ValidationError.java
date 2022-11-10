package pl.lotto.numberreceiver;

public enum ValidationError {


    DUPLICATED_NUMBERS("userGaveDuplicatedNumbers"),
    LESS_THAN_SIX_NUMBER("UserGaveLessThanSixNumbers");

    String message;

    ValidationError(String message) {
        this.message = message;
    }
}
