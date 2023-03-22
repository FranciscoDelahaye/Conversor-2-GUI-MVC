package multiconversor.Controller;

import multiconversor.Model.Model;
import multiconversor.View.View;

public class Controller {
	private View view;
	private Model model;
	
	public Controller(View view, Model model) {
		this.view= view;
		this.model = model;
		
		//Modelamos UI segun seleccion
        this.view.selectView(e -> {
        	this.view.boxInput1Clear();
        	this.view.boxInput2Clear();
        	try {
        		if(e.getSource() == this.view.getButtonDivisa()) {
        			this.model.setButtonActive(this.view.getButtonDivisa().getName());
        			this.model.setTitleLabelText(this.model.txtTitleDivisa);
        			this.model.setOrigenLabelText("Seleccione cantidad y "+this.model.txtLabelDivisa+" origen.");
        			this.model.setOrigenLabelText("Seleccione cantidad y "+this.model.txtLabelDivisa+" origen.");
        			this.model.setDestinoLabelText("Seleccione escala a convertir.");
        			for(int i=0; i<this.model.symbolList.size(); i++) {
        				this.view.boxInput1Add(this.model.symbolList.get(i).getSymbol());
        				this.view.boxInput2Add(this.model.symbolList.get(i).getSymbol());
        			}
        		}
        		if(e.getSource() == this.view.getButtonTemperatura()) {
        			this.model.setButtonActive(this.view.getButtonTemperatura().getName());
        			this.model.setTitleLabelText(this.model.txtTitleTemperatura);
        			this.model.setOrigenLabelText("Seleccione cantidad y "+this.model.txtLabelTemperatura+" origen.");
        			this.model.setDestinoLabelText("Seleccione escala a convertir.");
        			for(int i=0; i<this.model.temperaturaList.size(); i++) {
        				this.view.boxInput1Add(this.model.temperaturaList.get(i).getName());
        				this.view.boxInput2Add(this.model.temperaturaList.get(i).getName());
        			}
        		}
        		if(e.getSource() == this.view.getButtonLongitud()) {
        			this.model.setButtonActive(this.view.getButtonLongitud().getName());
        			this.model.setTitleLabelText(this.model.txtTitleLongitud);
        			this.model.setOrigenLabelText("Seleccione cantidad y "+this.model.txtLabelLongitud+" origen.");
        			this.model.setDestinoLabelText("Seleccione escala a convertir.");
        			for(int i=0; i<this.model.longitudList.size(); i++) {
        				this.view.boxInput1Add(this.model.longitudList.get(i).getName());
        				this.view.boxInput2Add(this.model.longitudList.get(i).getName());
        			}
        		}
        		if(e.getSource() == this.view.getButtonPeso()) {
        			this.model.setButtonActive(this.view.getButtonPeso().getName());
        			this.model.setTitleLabelText(this.model.txtTitlePeso);
        			this.model.setOrigenLabelText("Seleccione cantidad y "+this.model.txtLabelPeso+" origen.");
        			this.model.setDestinoLabelText("Seleccione escala a convertir.");
        			for(int i=0; i<this.model.pesoList.size(); i++) {
        				this.view.boxInput1Add(this.model.pesoList.get(i).getName());
        				this.view.boxInput2Add(this.model.pesoList.get(i).getName());
        			}
        		}
        		this.view.setButtonConvertirVisible(true);
        		this.view.boxInput1Visible(true);
        		this.view.boxInput2Visible(true);
        		this.view.setCantidadVisible(true);
        		this.view.setResultadoVisible(true);
        		this.view.setTitleLabelText("CONVERSOR DE "+this.model.getTitleLabel());
        		this.view.setOrigenLabelText(this.model.getOrigenLabel());
        		this.view.setDestinoLabelText(this.model.getDestinoLabel());
        		System.out.println(this.model.getButtonActive());
        	} catch (Exception ex) {
				ex.printStackTrace();
			}
        });
        //Definimos accion de boton convertir
        this.view.convertirResultado(e ->{
        	try {
        		if(this.model.getButtonActive() == "btnDivisa") {
            		this.model.setAPIResult(Double.parseDouble(this.view.getCantidadField()),this.view.getOrigenItem().toString(),this.view.getDestinoItem().toString());
                	this.view.setResultadoText(this.model.getAPIResult());
            	}
            	if(this.model.getButtonActive() == "btnTemperatura") {
            		this.model.setTemperaturaResult(Double.parseDouble(this.view.getCantidadField()),this.view.getOrigenItem().toString());
            		if(this.view.getDestinoItem().toString()=="Celsius") {
            			this.view.setResultadoText(this.model.getCelsius());
            		}
            		if(this.view.getDestinoItem().toString()=="Fahrenheit") {
            			this.view.setResultadoText(this.model.getFahrenheit());
            		}
            		if(this.view.getDestinoItem().toString()=="Kelvin") {
            			this.view.setResultadoText(this.model.getKelvin());
            		}
            	}
            	if(this.model.getButtonActive() == "btnLongitud") {
            		this.model.setLongitudResult(Double.parseDouble(this.view.getCantidadField()),this.view.getOrigenItem().toString(),this.view.getDestinoItem().toString());
            		this.view.setResultadoText(this.model.getLongitud());
            	}
    			if(this.model.getButtonActive() == "btnPeso") {
    				this.model.setPesoResult(Double.parseDouble(this.view.getCantidadField()),this.view.getOrigenItem().toString(),this.view.getDestinoItem().toString());
            		this.view.setResultadoText(this.model.getPeso());
    			}
        	} catch (Exception ex) {
        		this.view.setResultadoText(00000);
        		ex.printStackTrace();
			}
        });        
	}
}