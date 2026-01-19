class Room {
    private int roomNumber;
    private String category;
    private double price;
    private boolean available = true;

    public Room(int roomNumber, String category, double price) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.price = price;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void book() {
        available = false;
    }

    public void cancel() {
        available = true;
    }
}
