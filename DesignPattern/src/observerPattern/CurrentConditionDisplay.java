package observerPattern;

public class CurrentConditionDisplay implements Display, Observer {

	private WeatherData wd;
	private float temperature;
	private float humidity;

	public CurrentConditionDisplay(WeatherData wd) {
		super();
		this.wd = wd;
		wd.registerObserver(this);
	}

	@Override
	public void update(WeatherData wd) {
		this.temperature = wd.getTemperature();
		this.humidity = wd.getHumidity();
		display();
	}

	@Override
	public void display() {
		System.out.println("CurrentConditionDisplay [temperature = " + temperature + ", humidity = " + humidity + "]");
	}

}
