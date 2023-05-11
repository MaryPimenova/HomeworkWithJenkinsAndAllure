package ru.maruspim.utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Locale;

// Class for fake data generating
public class RandomUtils {
        Faker faker = new Faker(new Locale("en-IND"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyy MMMM dd", Locale.ENGLISH);
        String str = sdf.format(faker.date().birthday()); //generating of birthday date
        String[] splitDate = str.split(" "); //splitting into year? month and day
        String[]
                gendersChoice = {"Male", "Female", "Other"},
                subjectsChoice = {"Hindi", "English", "Maths", "Physics", "Chemistry", "Biology", "Computer Science", "Commerce", "Accounting", "Economics", "Arts", "Social Studies", "History", "Civics"},
                hobbiesChoice = {"Sports", "Reading", "Music"},
                statesChoice = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"},
                citiesOfNCR = {"Delhi", "Gurgaon", "Noida"},
                citiesOfUttarPradesh = {"Agra", "Lucknow", "Merrut"},
                citiesOfHaryana = {"Karnal", "Panipat"},
                citiesOfRajasthan = {"Jaipur", "Jaiselmer"};


        public String createRandomFirstName() {

            return faker.name().firstName();
        }
        public String createRandomLastName() {

            return faker.name().lastName();
        }
        public String createRandomEmail() {

            return faker.internet().emailAddress();
        }
        public String createRandomGender() {

            return faker.options().option(gendersChoice);
        }
        public String createRandomMobileNumber() {

            return faker.phoneNumber().subscriberNumber(10);
        }
        public String createRandomYear() {

            return splitDate[0];
        }
        public String createRandomMonth() {

            return splitDate[1];
        }
        public String createRandomDay() {

            return splitDate[2];
        }
        public String createRandomSubject() {

            return faker.options().option(subjectsChoice);
        }
        public String createRandomHobby() {

            return faker.options().option(hobbiesChoice);
        }
        public String createRandomCurrentAddress() {

            return faker.address().fullAddress();
        }
        public String createRandomState() {

            return faker.options().option(statesChoice);
        }
        public String createRandomCity(String state) {
            switch (state) {
                case "NCR": {
                    return faker.options().option(citiesOfNCR);
                }
                case "Uttar Pradesh": {
                    return faker.options().option(citiesOfUttarPradesh);
                }
                case "Haryana": {
                    return faker.options().option(citiesOfHaryana);
                }
                case "Rajasthan": {
                    return faker.options().option(citiesOfRajasthan);
                }
            }
            return null;
        }

}
