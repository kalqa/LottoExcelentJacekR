package pl.lotto.numberreceiver;

record ValidationResult(String message) {

    public boolean isNotValid() {
        return this.message.equals("failure");
    }
}
