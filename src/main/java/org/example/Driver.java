package org.example;

public class Driver {
    private String driverId;
    private String code;
    private  String permanentNumber;
    private String givenName;
    private String familyName;
    private String dateOfBirth;
    private String nationality;
    public Driver(String driverId_, String code_, String permanentNumber_, String givenName_, String familyName_, String dateOfBirth_, String nationality_){
         driverId = driverId_;
        code = code_;
        permanentNumber = permanentNumber_;
        givenName = givenName_;
        familyName = familyName_;
        dateOfBirth = dateOfBirth_;
        nationality = nationality_;
    }

    public Driver(String[] allInfoList){
            driverId = allInfoList[0];
            code = allInfoList[1];
            permanentNumber =allInfoList[2];
            givenName =  allInfoList[3];
            familyName = allInfoList[4];
            dateOfBirth = allInfoList[5];
            nationality = allInfoList[6];


    }

    public Driver(){

    }

    public String getDriverId(){
        return driverId;
    }


    public String getDriverCode(String driverId_){
        return code;
    }

    public String getDriverPermanentNumber(String driverId_){
        return permanentNumber;
    }
    public String getDriverGivenName(String driverId_){
        return givenName;
    }

    public String getDriverFamilyName(String driverId_){
        return familyName;
    }
    public String setDriverNationality(String driverId_){
        return nationality;
    }

    public String toString(){
        return "Driver Id: " + driverId + "\n Code: " + code + "\n Driver Number: " + permanentNumber + "\n Given Name: " +
                 givenName + "\n FamilyName: " + familyName + "\n Date Of Birth: "+ dateOfBirth+ "\n Nationality: " + nationality;
    }


}
