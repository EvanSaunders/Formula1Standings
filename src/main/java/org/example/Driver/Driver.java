package org.example.Driver;

public class Driver {
    private String driverId;
    private String code;
    private  String permanentNumber;
    private String givenName;
    private String familyName;
    private String dateOfBirth;
    private String nationality;
    private String position;
    private String points;
    private String wins;
    private String constructorName;
    private String constructorNationality;
    public Driver(String driverId_, String code_, String permanentNumber_, String givenName_, String familyName_, String dateOfBirth_, String nationality_,
                  String position_, String points_, String wins_, String constructorName_, String constructorNationality_){
        driverId = driverId_;
        code = code_;
        permanentNumber = permanentNumber_;
        givenName = givenName_;
        familyName = familyName_;
        dateOfBirth = dateOfBirth_;
        nationality = nationality_;
        position = position_;
        points = points_;
        wins = wins_;
        constructorName = constructorName_;
        constructorNationality = constructorNationality_;
    }



    public Driver(){

    }

    public String getId(){
        return driverId;
    }


    public String getCode(){
        return code;
    }

    public String getPermanentNumber(){
        return permanentNumber;
    }
    public String getGivenName(){
        return givenName;
    }

    public String getFamilyName(){
        return familyName;
    }

    public String getDateOfBirth(){
        return dateOfBirth;
    }
    public String getNationality(){
        return nationality;
    }

    public String getPosition(){
        return position;
    }

    public String getPoints(){
        return points;
    }

    public String getWins(){
        return wins;
    }

    public String getConstructor(){
        return constructorName;
    }
    public String getConstructorNationality(){
        return constructorNationality;
    }


    public String toString(){
        return "Driver Id: " + driverId + "\n Code: " + code + "\n Driver Number: " + permanentNumber + "\n Given Name: " +
                givenName + "\n FamilyName: " + familyName + "\n Date Of Birth: "+ dateOfBirth+ "\n Nationality: " + nationality +
                "\nPosition: " + position + "\nPoints: " + points + "\n Wins: " + wins +"\n Constructor: " + constructorName + "\n Constructor Nationality: " + constructorNationality;
    }


}
