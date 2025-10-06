class Phone {

    String ownerName;
    String countryCode;
    String cityCode;
    String number;

    public Phone(String ownerName, String number) {
        this.ownerName = ownerName;
        this.number = number;
    }

    public Phone(String ownerName, String countryCode, String cityCode, String number) {
        this.ownerName = ownerName;
        this.countryCode = countryCode;
        this.cityCode = cityCode;
        this.number = number;
    }
}

class Test {
    public static void main(String[] args) {
        Phone phone = new Phone("Patrick", "89678762345");
        print(phone);
        phone = new Phone("John", "+4", "876", "+47868761253");
        print(phone);
    }

    public static void print(Phone phone) {
        System.out.println("Phone{" +
                "ownerName='" + phone.ownerName + '\'' +
                ", countryCode='" + phone.countryCode + '\'' +
                ", cityCode='" + phone.cityCode + '\'' +
                ", number='" + phone.number + '\'' +
                '}');
    }
}