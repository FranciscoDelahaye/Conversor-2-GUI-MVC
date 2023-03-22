package multiconversor.Model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import multiconversor.Recursos.API_Request;

public class Model {
	public List<Lista> symbolList = new ArrayList<>();
	public List<Lista> temperaturaList = new ArrayList<>();
	public List<Lista> longitudList = new ArrayList<>();
	public List<Lista> pesoList = new ArrayList<>();
	
	private JLabel titleLabel = new JLabel();
	private JLabel origenLabel = new JLabel();
	private JLabel destinoLabel = new JLabel();
	
	public String txtTitleDivisa = "DIVISAS";
	public String txtTitleTemperatura = "TEMPERATURA";
	public String txtTitleLongitud = "LONGITUD";
	public String txtTitlePeso = "PESO";
	
	public String txtLabelDivisa = "divisa";
	public String txtLabelTemperatura = "temperatura";
	public String txtLabelLongitud = "longitud";
	public String txtLabelPeso = "peso";
	
	private String buttonNameActive=null;

	private double calculateResult = 0;
	
	public Model() {
		symbolList.add(0, new Lista("Peso Argentino", "ARS"));
		symbolList.add(1, new Lista("Dolar Estadounidense", "USD"));
		symbolList.add(2, new Lista("Euro", "EUR"));
		symbolList.add(3, new Lista("Libra Esterlina", "GBP"));
		symbolList.add(4, new Lista("Yen Japones", "JPY"));
		symbolList.add(5, new Lista("Won sul-coreano", "KRW"));
		
		temperaturaList.add(0, new Lista("Celsius", "°C"));
		temperaturaList.add(1, new Lista("Fahrenheit", "°F"));
		temperaturaList.add(2, new Lista("Kelvin", "°K"));
		
		longitudList.add(0, new Lista("Kilometros", "km", 0.00001));			//Las equivalencias corresponden a 1 centimetro
		longitudList.add(1, new Lista("Metros", "m", 0.01));
		longitudList.add(2, new Lista("Decimetros", "dc", 0.1));
		longitudList.add(3, new Lista("Centimetros", "cm", 1));
		longitudList.add(4, new Lista("Milimetros", "mm", 10));
		longitudList.add(5, new Lista("Millas", "mi", 0.000006213711922373));
		longitudList.add(6, new Lista("Pies", "ft", 0.03280839895013));
		longitudList.add(7, new Lista("Pulgadas", "in", 0.3937007874016));
		
		pesoList.add(0, new Lista("Tonelada", "t", 0.000001));					//Las equivalencias corresponden a 1 gramo
		pesoList.add(1, new Lista("Kilogramo", "kg", 0.001));
		pesoList.add(2, new Lista("Gramo", "g", 1));
		pesoList.add(3, new Lista("Miligramo", "mg", 1000));
		pesoList.add(4, new Lista("Libra", "lb", 0.0022046244201837776));
		pesoList.add(5, new Lista("Onza", "oz", 0.03527461286112385));
	}
	
	//Title Label
	public void setTitleLabelText(String text) {
		this.titleLabel.setText(text);
	}
	public String getTitleLabel() {
		return titleLabel.getText();
	}
	
	//Origen Label
	public void setOrigenLabelText(String text) {
		this.origenLabel.setText(text);
	}
	public String getOrigenLabel() {
		return origenLabel.getText();
	}
	
	//Destino Label
	public void setDestinoLabelText(String text) {
		this.destinoLabel.setText(text);
	}
	public String getDestinoLabel() {
		return destinoLabel.getText();
	}
	
	//Button activo
	public void setButtonActive(String btnName) {
		this.buttonNameActive=btnName;
	}
	public String getButtonActive() {
		return this.buttonNameActive;
	}
	
	public void setCalculateResult(double value) {
		this.calculateResult = value;
	}
	
	public double getCalculateResult() {
		return this.calculateResult;
	}
	
	//Divisas
	public void setAPIResult(double cantidad, String convertFrom, String convertTo) {
		API_Request request = new API_Request();	
		setCalculateResult(request.getRequest(cantidad, convertFrom, convertTo));
	}

	//Temperatura
	public void setTemperaturaResult(double cantidad, String convertFrom, String convertTo) {
		double temperaturaCelsius=0;
		double temperaturaFahrenheit=0;
		double temperaturaKelvin=0;
		try {
			if(convertFrom == "Celsius") {
				temperaturaCelsius = cantidad;
				temperaturaFahrenheit = (1.8*cantidad)+32;
				temperaturaKelvin = cantidad+273;
			}
			if(convertFrom == "Fahrenheit") {
				temperaturaCelsius = (cantidad-32)/1.8;
				temperaturaFahrenheit = cantidad;
				temperaturaKelvin = 5/9*(cantidad-32)+273.15;
			}
			if(convertFrom == "Kelvin") {
				temperaturaCelsius = cantidad-273.15;
				temperaturaFahrenheit = 1.8*(cantidad-2733.15)+32;
				temperaturaKelvin = cantidad;
			}
			if(convertTo == "Celsius")			setCalculateResult(temperaturaCelsius);
			if(convertTo == "Fahrenheit")		setCalculateResult(temperaturaFahrenheit);
			if(convertTo == "Kelvin")			setCalculateResult(temperaturaKelvin);
		} catch (Exception e) {
			setCalculateResult(0);
		}
	}
	
	//Longitud
	public void setLongitudResult(double cantidad, String convertFrom, String convertTo) {
		int cm=99,origen=99,destino=99;
		for(int i=0; i<longitudList.size(); i++) {
			if("cm" == longitudList.get(i).getName())			cm = i;
			if(convertFrom == longitudList.get(i).getName())	origen = i;
			if(convertTo == longitudList.get(i).getName())		destino = i;
		}
		if(cm != longitudList.size() && origen != longitudList.size() && destino != longitudList.size()) {
			setCalculateResult((cantidad * (longitudList.get(destino).getEquivalencia())) / (longitudList.get(origen).getEquivalencia()));
		}else {
			setCalculateResult(0);
		}
	}
	
	//Peso
	public void setPesoResult(double cantidad, String convertFrom, String convertTo) {
		int g=99,origen=99,destino=99;
		for(int i=0; i<pesoList.size(); i++) {
			if("g" == pesoList.get(i).getName())			g = i;
			if(convertFrom == pesoList.get(i).getName())	origen = i;
			if(convertTo == pesoList.get(i).getName())		destino = i;
		}
		if(g != pesoList.size() && origen != pesoList.size() && destino != pesoList.size()) {
			setCalculateResult((cantidad * (pesoList.get(destino).getEquivalencia())) / (pesoList.get(origen).getEquivalencia()));
		} else {
			setCalculateResult(0);
		}
	}
}