package models;

public class User {

    private String firstName;
    private String lastname;
    private String email;
    private String password;
    private String dayOfBirth;
    private String monthOfBirth;
    private String yearOfBirth;
    private String gender;
    private String pronoun;
    private String customGenderInput;

    public User(String firstName, String lastname, String email, String password, String dayOfBirth, String monthOfBirth, String yearOfBirth, String gender) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
    }

    public User(String firstName, String lastname, String email, String password, String dayOfBirth, String monthOfBirth, String yearOfBirth, String gender, String pronoun, String customGender) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.pronoun = pronoun;
        this.customGenderInput = customGender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public String getMonthOfBirth() {
        return monthOfBirth;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPronoun(String pronoun) {
        this.pronoun = pronoun;
    }

    public void setCustomGenderInput(String customGenderInput) {
        this.customGenderInput = customGenderInput;
    }

    public String getPronoun() {
        return pronoun;
    }

    public String getCustomGenderInput() {
        return customGenderInput;
    }
}
