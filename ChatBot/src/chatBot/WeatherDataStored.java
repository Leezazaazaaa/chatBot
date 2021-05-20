package chatBot;

import java.sql.Date;

public class WeatherDataStored {
	
	Date date;
	String temp,weatherDesc,humidity,pressure;
	
	public WeatherDataStored(Date date, String temp, String weatherDesc, String humidity, String pressure) {
		super();
		this.date = date;
		this.temp = temp;
		this.weatherDesc = weatherDesc;
		this.humidity = humidity;
		this.pressure = pressure;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public String getWeatherDesc() {
		return weatherDesc;
	}
	public void setWeatherDesc(String weatherDesc) {
		this.weatherDesc = weatherDesc;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	public String getPressure() {
		return pressure;
	}
	public void setPressure(String pressure) {
		this.pressure = pressure;
	}
}
