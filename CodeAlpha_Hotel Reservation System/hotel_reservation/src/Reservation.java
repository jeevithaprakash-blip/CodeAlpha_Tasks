class Reservation {
    private String customerName;
    private int roomNumber;
    private double amountPaid;

    public Reservation(String customerName, int roomNumber, double amountPaid) {
        this.customerName = customerName;
        this.roomNumber = roomNumber;
        this.amountPaid = amountPaid;
    }

    @Override
    public String toString() {
        return customerName + "," + roomNumber + "," + amountPaid;
    }
}
