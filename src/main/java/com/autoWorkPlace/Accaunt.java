package com.autoWorkPlace;

public class Accaunt {
    private Integer id;
    private String firstName;
    private String secondName;
    private String fathersName;
    private String birthDate;
    private String birthPlace;
    private String flat;
    private String square;
    private String sertNumber;
    private String regDate;
    private String passportSerie;
    private String passportNumber;
    private String passportOutput;
    private String passportCode;
    private String regAdress;
    private String liveAdress;
    private String phone;
    private String mail;
    private String gasService;

    public Accaunt(Integer id,
                   String firstName,
                   String secondName,
                   String fathersName,
                   String birthDate,
                   String birthPlace,
                   String flat,
                   String square,
                   String sertNumber,
                   String regDate,
                   String passportSerie,
                   String passportNumber,
                   String passportOutput,
                   String passportCode,
                   String regAdress,
                   String liveAdress,
                   String phone,
                   String mail,
                   String gasService) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.fathersName = fathersName;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.flat = flat;
        this.square = square;
        this.sertNumber = sertNumber;
        this.regDate = regDate;
        this.passportSerie = passportSerie;
        this.passportNumber = passportNumber;
        this.passportOutput = passportOutput;
        this.passportCode = passportCode;
        this.regAdress = regAdress;
        this.liveAdress = liveAdress;
        this.phone = phone;
        this.mail = mail;
        this.gasService = gasService;
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

    public String getFlat() {
        return flat;
    }

    public String getSquare() {
        return square;
    }

    public String getSertNumber() {
        return sertNumber;
    }

    public String getRegDate() {
        return regDate;
    }

    public String getPassportSerie() {
        return passportSerie;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public String getPassportOutput() {
        return passportOutput;
    }

    public String getPassportCode() {
        return passportCode;
    }

    public String getRegAdress() {
        return regAdress;
    }

    public String getLiveAdress() {
        return liveAdress;
    }

    public String getPhone() {
        return phone;
    }

    public String getMail() {
        return mail;
    }

    public String getGasService() {
        return gasService;
    }
}