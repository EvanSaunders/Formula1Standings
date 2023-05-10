package org.example;

public class Driver {
    private String driverId;
    private String code;
    private  String permanentNumber;
    private String givenName;
    private String familyName;
    private String nationality;
    public Driver(String driverId_, String code_, String permanentNumber_, String givenName_, String familyName_, String dateOfBirth_, String nationality_){
         driverId = driverId_;
        code = code_;
        permanentNumber = permanentNumber_;
        givenName = givenName_;
        familyName = familyName_;
        nationality = nationality_;
    }

    public Driver(String[] allInfoList){
            driverId = allInfoList[0];
            code = allInfoList[1];
            permanentNumber =allInfoList[2];
            givenName =  allInfoList[3];
            familyName = allInfoList[4];
            nationality = allInfoList[5];

    }

    public Driver(){

    }

    public String getDriverId(){
        return driverId;
    }



    public void setDriverId(String driverId_){
        driverId = driverId_;
    }

    public void setDriverCode(String driverId_){
        driverId = driverId_;
    }

    public void setDriverPermanentNumber(String driverId_){
        driverId = driverId_;
    }
    public void setDriverGivenName(String driverId_){
        driverId = driverId_;
    }

    public void setDriverFamilyName(String driverId_){
        driverId = driverId_;
    }

    public void setDriverNationality(String driverId_){
        driverId = driverId_;
    }

    public String toString(){
        return "Driver Id: " + driverId + "\n Code: " + code + "\n Driver Number: " + permanentNumber + "\n Given Name: " +
                 givenName + "\n FamilyName: " + familyName + "\n Nationality: " + nationality;
    }


}
