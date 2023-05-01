package org.example;

public class RaceWeek {
	private String country;
	private String city;
	private int round;
	private String date;
	private String FP1Start;
	private String FP2Start;
	private String FP3Start;
	private String qualyStart;
	private String raceStart;

	public RaceWeek() {

	}

	public RaceWeek(String countryTemp, String cityTemp, int roundTemp, String dateTemp, String FP1StartTemp,
			String FP2StartTemp, String FP3StartTemp, String qualyStartTemp, String raceStartTemp) {
		country = countryTemp;
		city = cityTemp;
		round = roundTemp;
		date = dateTemp;
		FP1Start = FP1StartTemp;
		FP2Start = FP2StartTemp;
		FP3Start = FP3StartTemp;
		qualyStart = qualyStartTemp;
		raceStart = raceStartTemp;
	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	public int getRound() {
		return round;
	}

	public String getDate() {
		return date;
	}

}
