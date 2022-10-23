package com.autoWorkPlace;

public class Accaunt {
    private Integer id;
    private String firstName;
    private String secondName;
    private String fathersName;
    private String birthDate;
    private String birthPlace;
    private String street;
    private String house;
    private String block;
    private String flat;
    private String square;
    private String other;

    public Accaunt(Integer id,
                   String firstName,
                   String secondName,
                   String fathersName,
                   String birthDate,
                   String birthPlace,
                   String street,
                   String house,
                   String block,
                   String flat,
                   String square,
                   String other
    ) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.fathersName = fathersName;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.street = street;
        this.house = house;
        this.block = block;
        this.flat = flat;
        this.square = square;
        this.other = other;
    }

    public Integer getId() {
        return id;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFathersName() {
        return fathersName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }
    public String getStreet() {
        return street;
    }

    public String getHouse() {
        return house;
    }

    public String getBlock() {
        return block;
    }

    public String getFlat() {
        return flat;
    }

    public String getSquare() {
        return square;
    }



    public String getOther() {
        return other;
    }
}