package observerPattern;

public class HeatIndexDisplay implements Observer, Display{
	WeatherData wd;
	float temperature;
	public HeatIndexDisplay(WeatherData wd) {
		super();
		this.wd = wd;
		wd.registerObserver(this);
	}
	
	@Override
	public void display() {
		System.out.println("HeatIndexDisplay [temperature=" + temperature + "]");
	}
	@Override
	public void update(WeatherData wd) {
		this.temperature = wd.getTemperature();		
		display();
	}
	
}
