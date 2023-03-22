package multiconversor.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import multiconversor.Controller.Controller;
import multiconversor.Model.Model;

public class View extends JFrame {
	private Model model = new Model();
	
	private JButton btnDivisa;
	private JButton btnTemperatura;
	private JButton btnLongitud;
	private JButton btnPeso;
	private JButton btnConvertir;
	
	private ImageIcon btnDivisaIcon;
	private ImageIcon btnTemperaturaIcon;
	private ImageIcon btnLongitudIcon;
	private ImageIcon btnPesoIcon;
	
	private String btnDivisaIconeSrc = "src/multiconversor/Recursos/divisas.png";
	private String btnTemperaturaIconSrc = "src/multiconversor/Recursos/temperaturas.png";
	private String btnLongitudIconSrc = "src/multiconversor/Recursos/longitud.png";
	private String btnPesoIconSrc = "src/multiconversor/Recursos/peso.png";
	
	private JLabel titleLabel = new JLabel();
	private JLabel origenLabel = new JLabel();
	private JLabel destinoLabel = new JLabel();
	
	private JComboBox boxInputOrigen = new JComboBox<>();
	private JComboBox boxInputDestino = new JComboBox<>();
	
	private JTextField cantidadField = new JTextField();
	private JTextField resultField = new JTextField();
	
	public View() {
		super("Multi Conversor");
		setLayout(null);
        int FRAME_WIDTH = 630;
        int FRAME_HEIGHT = 640;
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        btnDivisaIcon = new ImageIcon(resizeImage(btnDivisaIcon,btnDivisaIconeSrc,120, 120));
        btnTemperaturaIcon = new ImageIcon(resizeImage(btnTemperaturaIcon,btnTemperaturaIconSrc,120, 120));
        btnLongitudIcon = new ImageIcon(resizeImage(btnLongitudIcon,btnLongitudIconSrc,120, 120));
        btnPesoIcon = new ImageIcon(resizeImage(btnPesoIcon,btnPesoIconSrc,120, 120));
		
		btnDivisa = new JButton(btnDivisaIcon);
		btnTemperatura = new JButton(btnTemperaturaIcon);
		btnLongitud = new JButton(btnLongitudIcon);
		btnPeso = new JButton(btnPesoIcon);
		
		btnDivisa.setBounds(20, 10, 130, 130);
		btnTemperatura.setBounds(165, 10, 130, 130);
		btnLongitud.setBounds(310, 10, 130, 130);
		btnPeso.setBounds(455, 10, 130, 130);
		
		btnConvertir = new JButton("CONVERTIR");
		btnConvertir.setBounds(260, 500, 100, 50);
		btnConvertir.setVisible(false);
		
		btnDivisa.setName("btnDivisa");
		btnTemperatura.setName("btnTemperatura");
		btnLongitud.setName("btnLongitud");
		btnPeso.setName("btnPeso");
		
		btnDivisa.setBackground(Color.LIGHT_GRAY);
		btnTemperatura.setBackground(Color.LIGHT_GRAY);
		btnLongitud.setBackground(Color.LIGHT_GRAY);
		btnPeso.setBackground(Color.LIGHT_GRAY);
		
		titleLabel.setBounds(105, 150, 400, 70);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 25));
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		
		origenLabel.setBounds(70, 200, 350, 70);
		origenLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		
		destinoLabel.setBounds(70, 350, 350, 70);
		destinoLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		
		boxInputOrigen.setBounds(70, 250, 300, 70);
		boxInputOrigen.setFont(new Font("Arial", Font.PLAIN, 20));
		boxInputOrigen.setVisible(false);
		
		boxInputDestino.setBounds(70, 400, 300, 70);
		boxInputDestino.setFont(new Font("Arial", Font.PLAIN, 20));
		boxInputDestino.setVisible(false);
		
		cantidadField.setBounds(390, 250, 200, 70);
		cantidadField.setFont(new Font("Arial", Font.PLAIN, 20));
		cantidadField.setHorizontalAlignment(JTextField.CENTER);
		cantidadField.setVisible(false);
		
		resultField.setBounds(390, 400, 200, 70);
		resultField.setFont(new Font("Arial", Font.PLAIN, 20));
		resultField.setHorizontalAlignment(JTextField.CENTER);
		resultField.setVisible(false);
		
		add(btnDivisa);
        add(btnTemperatura);
        add(btnLongitud);
        add(btnPeso);
        add(btnConvertir);
        
        add(titleLabel);
        add(origenLabel);
        add(destinoLabel);
        
        add(cantidadField);
        add(resultField);
        
        add(boxInputOrigen);
        add(boxInputDestino);
		
		new Controller(this, model);
	}
	
	//Title Label
	public void setTitleLabelText(String text) {
		this.titleLabel.setText(text);
	}
	
	//Origen Label
	public void setOrigenLabelText(String text) {
		this.origenLabel.setText(text);
	}
	public Object getOrigenItem() {
		return this.boxInputOrigen.getSelectedItem();
	}
	
	//Destino Label
	public void setDestinoLabelText(String text) {
		this.destinoLabel.setText(text);
	}
	public Object getDestinoItem() {
		return this.boxInputDestino.getSelectedItem();
	}
	
	//Cantidad Area
	public void setCantidadText(String value) {
		this.cantidadField.setText(value);
	}
	public String getCantidadField() {
		return this.cantidadField.getText();
	}
	public void setCantidadVisible(boolean flag) {
		this.cantidadField.setVisible(flag);
	}
	
	//Resultado Area
	public void setResultadoText(double value) {
		this.resultField.setText(String.format("%.2f",value));
	}
	public void setResultadoVisible(boolean flag) {
		this.resultField.setVisible(flag);
	}
	
	
	//Box 1
	public void boxInput1Clear() {
		this.boxInputOrigen.removeAllItems();
	}	
	public void boxInput1Add(String item) {
		this.boxInputOrigen.addItem(item);
	}	
	public void boxInput1Visible(boolean flag) {
		this.boxInputOrigen.setVisible(flag);
	}
	//Box 2
	public void boxInput2Clear() {
		this.boxInputDestino.removeAllItems();
	}	
	public void boxInput2Add(String item) {
		this.boxInputDestino.addItem(item);
	}	
	public void boxInput2Visible(boolean flag) {
		this.boxInputDestino.setVisible(flag);
	}
	
	//Button Getters
	public JButton getButtonDivisa() {
		return this.btnDivisa;
	}
	public JButton getButtonTemperatura() {
		return this.btnTemperatura;
	}
	public JButton getButtonLongitud() {
		return this.btnLongitud;
	}
	public JButton getButtonPeso() {
		return this.btnPeso;
	}
	public JButton getButtonConvertir() {
		return this.btnConvertir;
	}
	
	//Button Convertir
	public void setButtonConvertirVisible(boolean flag) {
		this.btnConvertir.setVisible(flag);
	}
	public void convertirResultado(ActionListener actionListener) {
		btnConvertir.addActionListener(actionListener);
	}
	
	public void selectView(ActionListener actionListener) {
		btnDivisa.addActionListener(actionListener);
		btnTemperatura.addActionListener(actionListener);
		btnLongitud.addActionListener(actionListener);
		btnPeso.addActionListener(actionListener);
    }
	
	public Image resizeImage(ImageIcon icon,String imageSrc, int ancho, int alto) {
		icon = new ImageIcon(imageSrc);
		Image image = icon.getImage();
		Image newimg = image.getScaledInstance(ancho, alto,  java.awt.Image.SCALE_SMOOTH);
		return(newimg);
	}
}