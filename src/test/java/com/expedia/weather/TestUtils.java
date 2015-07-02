/**
 * 
 */
package com.expedia.weather;

/**
 * @author Prem
 *
 */
public class TestUtils {

	/**
	 * Mocks Error JSON response
	 * 
	 * @return String
	 */
	public static String getErrorResultString()
	{
		return "{\n  \"response\": {\n  \"version\":\"0.1\",\n  \"termsofService\":\"http://www.wunderground.com/weather/api/d/terms.html\",\n  \"features\": {\n  \"conditions\": 1\n  }\t\t,\n\t\"error\": {\n\t\t\"type\": \"querynotfound\"\n\t\t,\"description\": \"No cities match your search query\"\n\t}\n\t}\n}";
	}
	/**
	 * Mocks valid JSON response
	 * 
	 * @return String
	 */
	public static String getValidResponse()
	{
		return "{\n  \"response\": {\n  \"version\":\"0.1\",\n  \"termsofService\":\"http://www.wunderground.com/weather/api/d/terms.html\",\n  \"features\": {\n  \"conditions\": 1\n  }\n\t}\n  ,\t\"current_observation\": {\n\t\t\"image\": {\n\t\t\"url\":\"http://icons.wxug.com/graphics/wu2/logo_130x80.png\",\n\t\t\"title\":\"Weather Underground\",\n\t\t\"link\":\"http://www.wunderground.com\"\n\t\t},\n\t\t\"display_location\": {\n\t\t\"full\":\"Newark, NJ\",\n\t\t\"city\":\"Newark\",\n\t\t\"state\":\"NJ\",\n\t\t\"state_name\":\"New Jersey\",\n\t\t\"country\":\"US\",\n\t\t\"country_iso3166\":\"US\",\n\t\t\"zip\":\"07104\",\n\t\t\"magic\":\"1\",\n\t\t\"wmo\":\"99999\",\n\t\t\"latitude\":\"40.76642609\",\n\t\t\"longitude\":\"-74.16773987\",\n\t\t\"elevation\":\"25.00000000\"\n\t\t},\n\t\t\"observation_location\": {\n\t\t\"full\":\"HSNN4 - WXLINK, Harrison, New Jersey\",\n\t\t\"city\":\"HSNN4 - WXLINK, Harrison\",\n\t\t\"state\":\"New Jersey\",\n\t\t\"country\":\"US\",\n\t\t\"country_iso3166\":\"US\",\n\t\t\"latitude\":\"40.752438\",\n\t\t\"longitude\":\"-74.150131\",\n\t\t\"elevation\":\"46 ft\"\n\t\t},\n\t\t\"estimated\": {\n\t\t},\n\t\t\"station_id\":\"KNJHARRI8\",\n\t\t\"observation_time\":\"Last Updated on July 1, 1:17 PM EDT\",\n\t\t\"observation_time_rfc822\":\"Wed, 01 Jul 2015 13:17:42 -0400\",\n\t\t\"observation_epoch\":\"1435771062\",\n\t\t\"local_time_rfc822\":\"Wed, 01 Jul 2015 13:19:11 -0400\",\n\t\t\"local_epoch\":\"1435771151\",\n\t\t\"local_tz_short\":\"EDT\",\n\t\t\"local_tz_long\":\"America/New_York\",\n\t\t\"local_tz_offset\":\"-0400\",\n\t\t\"weather\":\"Partly Cloudy\",\n\t\t\"temperature_string\":\"82.6 F (28.1 C)\",\n\t\t\"temp_f\":82.6,\n\t\t\"temp_c\":28.1,\n\t\t\"relative_humidity\":\"58%\",\n\t\t\"wind_string\":\"From the ENE at 2.0 MPH Gusting to 10.0 MPH\",\n\t\t\"wind_dir\":\"ENE\",\n\t\t\"wind_degrees\":59,\n\t\t\"wind_mph\":2.0,\n\t\t\"wind_gust_mph\":\"10.0\",\n\t\t\"wind_kph\":3.2,\n\t\t\"wind_gust_kph\":\"16.1\",\n\t\t\"pressure_mb\":\"1009\",\n\t\t\"pressure_in\":\"29.79\",\n\t\t\"pressure_trend\":\"0\",\n\t\t\"dewpoint_string\":\"66 F (19 C)\",\n\t\t\"dewpoint_f\":66,\n\t\t\"dewpoint_c\":19,\n\t\t\"heat_index_string\":\"85 F (29 C)\",\n\t\t\"heat_index_f\":85,\n\t\t\"heat_index_c\":29,\n\t\t\"windchill_string\":\"NA\",\n\t\t\"windchill_f\":\"NA\",\n\t\t\"windchill_c\":\"NA\",\n\t\t\"feelslike_string\":\"85 F (29 C)\",\n\t\t\"feelslike_f\":\"85\",\n\t\t\"feelslike_c\":\"29\",\n\t\t\"visibility_mi\":\"10.0\",\n\t\t\"visibility_km\":\"16.1\",\n\t\t\"solarradiation\":\"--\",\n\t\t\"UV\":\"9\",\"precip_1hr_string\":\"0.00 in ( 0 mm)\",\n\t\t\"precip_1hr_in\":\"0.00\",\n\t\t\"precip_1hr_metric\":\" 0\",\n\t\t\"precip_today_string\":\"1.51 in (38 mm)\",\n\t\t\"precip_today_in\":\"1.51\",\n\t\t\"precip_today_metric\":\"38\",\n\t\t\"icon\":\"partlycloudy\",\n\t\t\"icon_url\":\"http://icons.wxug.com/i/c/k/partlycloudy.gif\",\n\t\t\"forecast_url\":\"http://www.wunderground.com/US/NJ/Newark.html\",\n\t\t\"history_url\":\"http://www.wunderground.com/weatherstation/WXDailyHistory.asp?ID=KNJHARRI8\",\n\t\t\"ob_url\":\"http://www.wunderground.com/cgi-bin/findweather/getForecast?query=40.752438,-74.150131\",\n\t\t\"nowcast\":\"\"\n\t}\n}";
	}
	
}
