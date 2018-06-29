package com.nitheesh.mvc.primary.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Random;


@AttributeOverrides({
        @AttributeOverride(name = "personalEmailId.emailId", column = @Column(name = "personal_email_id")),
        @AttributeOverride(name = "workEmailId.emailId", column = @Column(name = "work_email_id")),
        @AttributeOverride(name = "personalPhoneNumber.phoneNumber", column = @Column(name = "personal_phone_number")),
        @AttributeOverride(name = "workPhoneNumber.phoneNumber", column = @Column(name = "work_phone_number"))

})


@Entity
@Table
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    Email personalEmailId;
    Email workEmailId;
    Phone personalPhoneNumber;
    Phone workPhoneNumber;
     @OneToMany
    List<Address> addressList;






    public Person(List<Address> addressList) {
        String[] names = {"Abbott", "Acevedo", "Acosta", "Adams", "Adkins", "Bryan", "Bryant", "Buchanan", "Buck",
                "Buckley", "Buckner", "Bullock", "Burch", "Burgess", "Burke", "Burks", "Burnett", "Cardenas", "Carey",
                "Carlson", "Carney", "Carpenter", "Carr", "Carrillo", "Carroll", "Carson", "Carter", "Carver", "Case"};
        this.name = names[new Random().nextInt(names.length)];
        this.personalEmailId = new Email().randomEmailId();
        this.workEmailId = new Email().randomEmailId();
        this.personalPhoneNumber = new Phone().randomPhone();
        this.workPhoneNumber = new Phone().randomPhone();
       this.addressList=addressList;
    }

    @Embeddable
    @Data
    public static class Email {

        private String emailId;




        public Email randomEmailId() {
            String[] emailIds = {"consectetuer.ipsum@eget.com", "mi@odioAliquam.com", "tellus@ametrisusDonec.org", "Maecenas@consequatlectus.edu"};
            this.emailId = "consectetuer.ipsum@eget.com";
            return this;
        }
    }

    @Embeddable
    @Data
    public static class Phone {
        private String phoneNumber;


        public Phone randomPhone() {
            String[] phoneNumbers = {"52793756499", "89699982699", "85398338399", "17434003499", "64490739899"};
            this.phoneNumber = (phoneNumbers[new Random().nextInt(phoneNumbers.length)]);
            return this;
        }
    }
}