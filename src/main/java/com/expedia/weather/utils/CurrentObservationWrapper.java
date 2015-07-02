/**
 * 
 */
package com.expedia.weather.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Wrapper class that contains CurrentObservation
 * @author Prem
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentObservationWrapper {
	
	@JsonProperty("image")
	ImageWrapper imageWrapper;
	
	@JsonProperty("display_location")
	DisplayLocationWrapper displayLocationWrapper;
	
	@JsonProperty("observation_location")
	ObservationLocationWrapper observationLocationWrapper;
	
	
	@JsonProperty("observation_time")
	private String observationTime;
	
	@JsonProperty("observation_time_rfc822")
	private String observationTimeRfc822;
	
	@JsonProperty("local_time_rfc822")
	private String localTimeRfc822;
	
	@JsonProperty("local_tz_short")
	private String localTzShort;
	
	@JsonProperty("local_tz_long")
	private String localTzLong;
	
	@JsonProperty("local_tz_offset")
	private String localTzOffset;
	
	@JsonProperty("weather")
	private String weather;
	
	@JsonProperty("temperature_string")
	private String temperatureString;
	
	@JsonProperty("temp_f")
	private String tempF;
	
	@JsonProperty("temp_c")
	private String tempC;
	
	@JsonProperty("relative_humidity")
	private String relative_humidity;
	
	@JsonProperty("wind_string")
	private String windString;
	
	@JsonProperty("wind_dir")
	private String wind_dir;
	
	@JsonProperty("wind_degrees")
	private String wind_degrees;
	
	@JsonProperty("wind_mph")
	private String wind_mph;
	
	@JsonProperty("wind_gust_mph")
	private String wind_gust_mph;
	
	@JsonProperty("wind_kph")
	private String wind_kph;
	
	@JsonProperty("wind_gust_kph")
	private String wind_gust_kph;
	
	@JsonProperty("pressure_trend")
	private String pressureTrend;
	
	@JsonProperty("dewpoint_string")
	private String dewpointString;
	
	@JsonProperty("dewpoint_f")
	private String dewpointF;
	
	@JsonProperty("dewpoint_c")
	private String dewpointC;
	
	@JsonProperty("heat_index_string")
	private String heat_indexString;
	
	@JsonProperty("heat_index_f")
	private String heat_indexF;
	
	@JsonProperty("heat_index_c")
	private String heat_indexC;
	
	@JsonProperty("windchill_string")
	private String windchillString;
	
	@JsonProperty("windchill_f")
	private String windchillF;
	
	@JsonProperty("windchill_c")
	private String windchillC;
	
	@JsonProperty("feelslike_string")
	private String feelslikeString;
	
	@JsonProperty("feelslike_f")
	private String feelslikeF;
	
	@JsonProperty("feelslike_c")
	private String feelslikeC;
	
	@JsonProperty("visibility_mi")
	private String visibilityMi;
	
	@JsonProperty("visibility_km")
	private String visibilityKm;
	
	@JsonProperty("solarradiation")
	private String solarradiation;
	
	@JsonProperty("UV")
	private String UV;
	
	@JsonProperty("icon")
	private String icon;
	
	@JsonProperty("icon_url")
	private String iconUrl;
	
	

	public ImageWrapper getImageWrapper() {
		return imageWrapper;
	}

	public void setImageWrapper(ImageWrapper imageWrapper) {
		this.imageWrapper = imageWrapper;
	}

	public DisplayLocationWrapper getDisplayLocationWrapper() {
		return displayLocationWrapper;
	}

	public void setDisplayLocationWrapper(
			DisplayLocationWrapper displayLocationWrapper) {
		this.displayLocationWrapper = displayLocationWrapper;
	}

	public ObservationLocationWrapper getObservationLocationWrapper() {
		return observationLocationWrapper;
	}

	public void setObservationLocationWrapper(
			ObservationLocationWrapper observationLocationWrapper) {
		this.observationLocationWrapper = observationLocationWrapper;
	}

	public String getObservationTime() {
		return observationTime;
	}

	public void setObservationTime(String observationTime) {
		this.observationTime = observationTime;
	}

	public String getObservationTimeRfc822() {
		return observationTimeRfc822;
	}

	public void setObservationTimeRfc822(String observationTimeRfc822) {
		this.observationTimeRfc822 = observationTimeRfc822;
	}

	public String getLocalTimeRfc822() {
		return localTimeRfc822;
	}

	public void setLocalTimeRfc822(String localTimeRfc822) {
		this.localTimeRfc822 = localTimeRfc822;
	}

	public String getLocalTzShort() {
		return localTzShort;
	}

	public void setLocalTzShort(String localTzShort) {
		this.localTzShort = localTzShort;
	}

	public String getLocalTzLong() {
		return localTzLong;
	}

	public void setLocalTzLong(String localTzLong) {
		this.localTzLong = localTzLong;
	}

	public String getLocalTzOffset() {
		return localTzOffset;
	}

	public void setLocalTzOffset(String localTzOffset) {
		this.localTzOffset = localTzOffset;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getTemperatureString() {
		return temperatureString;
	}

	public void setTemperatureString(String temperatureString) {
		this.temperatureString = temperatureString;
	}

	public String getTempF() {
		return tempF;
	}

	public void setTempF(String tempF) {
		this.tempF = tempF;
	}

	public String getTempC() {
		return tempC;
	}

	public void setTempC(String tempC) {
		this.tempC = tempC;
	}

	public String getRelative_humidity() {
		return relative_humidity;
	}

	public void setRelative_humidity(String relative_humidity) {
		this.relative_humidity = relative_humidity;
	}

	public String getWindString() {
		return windString;
	}

	public void setWindString(String windString) {
		this.windString = windString;
	}

	public String getWind_dir() {
		return wind_dir;
	}

	public void setWind_dir(String wind_dir) {
		this.wind_dir = wind_dir;
	}

	public String getWind_degrees() {
		return wind_degrees;
	}

	public void setWind_degrees(String wind_degrees) {
		this.wind_degrees = wind_degrees;
	}

	

	public String getWind_gust_mph() {
		return wind_gust_mph;
	}

	public void setWind_gust_mph(String wind_gust_mph) {
		this.wind_gust_mph = wind_gust_mph;
	}


	public String getWind_mph() {
		return wind_mph;
	}

	public void setWind_mph(String wind_mph) {
		this.wind_mph = wind_mph;
	}

	public String getWind_kph() {
		return wind_kph;
	}

	public void setWind_kph(String wind_kph) {
		this.wind_kph = wind_kph;
	}

	public String getWind_gust_kph() {
		return wind_gust_kph;
	}

	public void setWind_gust_kph(String wind_gust_kph) {
		this.wind_gust_kph = wind_gust_kph;
	}

	public String getPressureTrend() {
		return pressureTrend;
	}

	public void setPressureTrend(String pressureTrend) {
		this.pressureTrend = pressureTrend;
	}

	public String getDewpointString() {
		return dewpointString;
	}

	public void setDewpointString(String dewpointString) {
		this.dewpointString = dewpointString;
	}

	public String getDewpointF() {
		return dewpointF;
	}

	public void setDewpointF(String dewpointF) {
		this.dewpointF = dewpointF;
	}

	public String getDewpointC() {
		return dewpointC;
	}

	public void setDewpointC(String dewpointC) {
		this.dewpointC = dewpointC;
	}

	public String getHeat_indexString() {
		return heat_indexString;
	}

	public void setHeat_indexString(String heat_indexString) {
		this.heat_indexString = heat_indexString;
	}

	public String getHeat_indexF() {
		return heat_indexF;
	}

	public void setHeat_indexF(String heat_indexF) {
		this.heat_indexF = heat_indexF;
	}

	public String getHeat_indexC() {
		return heat_indexC;
	}

	public void setHeat_indexC(String heat_indexC) {
		this.heat_indexC = heat_indexC;
	}

	public String getWindchillString() {
		return windchillString;
	}

	public void setWindchillString(String windchillString) {
		this.windchillString = windchillString;
	}

	public String getWindchillF() {
		return windchillF;
	}

	public void setWindchillF(String windchillF) {
		this.windchillF = windchillF;
	}

	public String getWindchillC() {
		return windchillC;
	}

	public void setWindchillC(String windchillC) {
		this.windchillC = windchillC;
	}

	public String getFeelslikeString() {
		return feelslikeString;
	}

	public void setFeelslikeString(String feelslikeString) {
		this.feelslikeString = feelslikeString;
	}

	public String getFeelslikeF() {
		return feelslikeF;
	}

	public void setFeelslikeF(String feelslikeF) {
		this.feelslikeF = feelslikeF;
	}

	public String getFeelslikeC() {
		return feelslikeC;
	}

	public void setFeelslikeC(String feelslikeC) {
		this.feelslikeC = feelslikeC;
	}

	public String getVisibilityMi() {
		return visibilityMi;
	}

	public void setVisibilityMi(String visibilityMi) {
		this.visibilityMi = visibilityMi;
	}

	public String getVisibilityKm() {
		return visibilityKm;
	}

	public void setVisibilityKm(String visibilityKm) {
		this.visibilityKm = visibilityKm;
	}

	public String getSolarradiation() {
		return solarradiation;
	}

	public void setSolarradiation(String solarradiation) {
		this.solarradiation = solarradiation;
	}

	public String getUV() {
		return UV;
	}

	public void setUV(String uV) {
		UV = uV;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}


	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	@Override
	public String toString() {
		return "CurrentObservationWrapper [imageWrapper=" + imageWrapper
				+ ", displayLocationWrapper=" + displayLocationWrapper
				+ ", observationLocationWrapper=" + observationLocationWrapper
				+ ", observationTime=" + observationTime
				+ ", observationTimeRfc822=" + observationTimeRfc822
				+ ", localTimeRfc822=" + localTimeRfc822 + ", localTzShort="
				+ localTzShort + ", localTzLong=" + localTzLong
				+ ", localTzOffset=" + localTzOffset + ", weather=" + weather
				+ ", temperatureString=" + temperatureString + ", tempF="
				+ tempF + ", tempC=" + tempC + ", relative_humidity="
				+ relative_humidity + ", windString=" + windString
				+ ", wind_dir=" + wind_dir + ", wind_degrees=" + wind_degrees
				+ ", wind_mph=" + wind_mph + ", wind_gust_mph=" + wind_gust_mph
				+ ", wind_kph=" + wind_kph + ", wind_gust_kph=" + wind_gust_kph
				+ ", pressureTrend=" + pressureTrend + ", dewpointString="
				+ dewpointString + ", dewpointF=" + dewpointF + ", dewpointC="
				+ dewpointC + ", heat_indexString=" + heat_indexString
				+ ", heat_indexF=" + heat_indexF + ", heat_indexC="
				+ heat_indexC + ", windchillString=" + windchillString
				+ ", windchillF=" + windchillF + ", windchillC=" + windchillC
				+ ", feelslikeString=" + feelslikeString + ", feelslikeF="
				+ feelslikeF + ", feelslikeC=" + feelslikeC + ", visibilityMi="
				+ visibilityMi + ", visibilityKm=" + visibilityKm
				+ ", solarradiation=" + solarradiation + ", UV=" + UV
				+ ", icon=" + icon + ", iconUrl=" + iconUrl + "]";
	}
		
	
}
