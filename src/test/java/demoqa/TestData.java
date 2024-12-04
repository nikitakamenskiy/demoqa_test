package demoqa;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Collections;

public class TestData {
    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String fullName = firstName + " " + lastName;
    String email = faker.internet().emailAddress();
    String mobile = faker.phoneNumber().subscriberNumber(10);
    String currentAddress = faker.address().fullAddress();
    String gender = faker.options().option("Male", "Female", "Other");
    String subject = faker.options().option("Hindi", "Social Studies", "Data Science");
    String birthMonth = faker.options().option("January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November", "December");
    ;
    String birthYear = faker.number().numberBetween(1940, 2005) + "";
    String birthDay = setRandomDay(birthMonth, birthYear);
    String fullBirthDay = birthDay + " " + birthMonth + "," + birthYear;
    String hobby = faker.options().option("Sports", "Reading", "Music");
    String img = "img.jpg";
    String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    String city = setRandomCity(state);
    String fullStateAndCity = state + " " + city + " ";

    public String setRandomDay(String birthMonth, String birthYear) {
        int day;
        int year = Integer.parseInt(birthYear);

        if ("January".equals(birthMonth) || "March".equals(birthMonth) || "May".equals(birthMonth) ||
                "July".equals(birthMonth) || "August".equals(birthMonth) || "October".equals(birthMonth) ||
                "December".equals(birthMonth)) {
            day = faker.number().numberBetween(1, 32);
        } else if ("April".equals(birthMonth) || "June".equals(birthMonth) || "September".equals(birthMonth) ||
                "November".equals(birthMonth)) {
            day = faker.number().numberBetween(1, 31);
        } else if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
            day = faker.number().numberBetween(1, 30);
        } else {
            day = faker.number().numberBetween(1, 29);
        }

        return String.format("%02d", day);
    }
        public String setRandomCity (String state){
            String city;
            ArrayList<String> values = new ArrayList<>();
            switch (state) {
                case "NCR":
                    Collections.addAll(values, "Delhi", "Gurgaon", "Noida");
                    city = values.get(faker.random().nextInt(0, values.size() - 1));
                    break;
                case "Uttar Pradesh":
                    Collections.addAll(values, "Agra", "Lucknow", "Merrut");
                    city = values.get(faker.random().nextInt(0, values.size() - 1));
                    break;
                case "Haryana":
                    Collections.addAll(values, "Karnal", "Panipat");
                    city = values.get(faker.random().nextInt(0, values.size() - 1));
                    break;
                case "Rajasthan":
                    Collections.addAll(values, "Jaipur", "Jaiselmer");
                    city = values.get(faker.random().nextInt(0, values.size() - 1));
                    break;
                default:
                    city = null;
                    break;
            }
            return city;
        }
    }

