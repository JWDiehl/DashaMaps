package com.github.zipcodewilmington.sample;

    public class Person implements PersonInterface {
        private String firstName;
        private String lastName;
        private Integer age;

        public Person() {
            this.firstName = "";
            this.lastName = "";
            this.age = 0;
        }

        public Person(String firstName, String lastName, Integer age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        @Override
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        @Override
        public String getFirstName() {
            return firstName;
        }

        @Override
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        @Override
        public String getLastName() {
            return lastName;
        }

        @Override
        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public Integer getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", age=" + age +
                    '}';
        }
    }