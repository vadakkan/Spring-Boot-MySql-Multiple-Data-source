package com.nitheesh.mvc.primary.domain;


import lombok.Data;

import javax.persistence.*;


@AttributeOverrides({
        @AttributeOverride(name = "workLocation.city", column = @Column(name = "work_location_city")),
        @AttributeOverride(name = "workLocation.state", column = @Column(name = "work_location_state")),
        @AttributeOverride(name = "workLocation.country", column = @Column(name = "work_location_country")),
        @AttributeOverride(name = "workLocation.pinCode", column = @Column(name = "work_location_pin_code")),
        @AttributeOverride(name = "homeLocation.city", column = @Column(name = "home_location_city")),
        @AttributeOverride(name = "homeLocation.state", column = @Column(name = "home_location_state")),
        @AttributeOverride(name = "homeLocation.country", column = @Column(name = "home_location_country")),
        @AttributeOverride(name = "homeLocation.pinCode", column = @Column(name = "home_location_pin_code")),

})


@Entity(name = "address")
@Table
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String address1;
    String address2;
    Location workLocation;
    Location homeLocation;


    public Address defaultAddressOne() {
        this.address1 = "445 Mount Eden Road, Mount Eden, Auckland";
        this.address1 = "21 Greens Road RD 2 Ruawai 0592";
        this.workLocation = new Location().defaultLocationOne();
        this.homeLocation = new Location().defaultLocationTwo();
        return this;

    }

    public Address defaultAddressTwo() {

        this.address1 = "Main Highway Otaki; 32 Wilson Street";
        this.address1 = "PO Box 39100, Howick";
        this.workLocation = new Location().defaultLocationOne();
        return this;

    }


    @Embeddable
    @Data
    public static class Location {

        String city;
        String state;
        String country;
        Integer pinCode;


        public Location defaultLocationOne() {
            this.city = "Ernakulam";
            this.state = "Kerala";
            this.country = "India";
            this.pinCode = 682314;
            return this;
        }

        public Location defaultLocationTwo() {
            this.city = "Kottayam";
            this.state = "Kerala";
            this.country = "India";
            this.pinCode = 78596;

            return this;
        }
    }
}
