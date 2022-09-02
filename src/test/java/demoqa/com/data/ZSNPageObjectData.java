package demoqa.com.data;

import com.github.javafaker.Faker;

public class ZSNPageObjectData {
    String firstName;
    String lastName;
    String email;
    String gender;
    String mobile;
    String dateOfBirth;
    String hobbies;
    String picture;
    String currentAddress;
    String state;
    String city;
    String[] subjects = {"Maths", "Computer Science"};
    String[] monthStr = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private Integer day, month, year;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getMobile() {
        return mobile;
    }

    public String getDateOfBirth() {
        dateOfBirth = day + " " + monthStr[month-1] + "," + year;
        return dateOfBirth;
    }

    public String getHobbies() {
        return hobbies;
    }

    public String getCity() {
        return city;
    }

    public String getPicture() {
        return picture;
    }

    public String getState() {
        return state;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public ZSNPageObjectData() {
        this.userGenerate();
    }

    private void userGenerate() {
        Faker faker = new Faker();
        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.email = faker.internet().emailAddress();
        this.gender = "Male";
        this.mobile = faker.phoneNumber().subscriberNumber(10);
        this.day = faker.number().numberBetween(1, 28);
        this.month = faker.number().numberBetween(1, 12);
        this.year = faker.number().numberBetween(1920, 2000);
        this.dateOfBirth = String.format("%s.%s.%s", day, month, year);
        this.hobbies = "Reading";
        this.picture = "test.jpg";
        this.currentAddress = faker.address().fullAddress();
        this.state = "NCR";
        this.city = "Noida";
    }
}