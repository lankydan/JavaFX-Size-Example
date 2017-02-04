package lankydan.tutorials.fxml.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Function;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;

public class MainAppController implements Initializable {

	@FXML
	private LineChart<Double, Double> lineGraph;

	@FXML
	private AreaChart<Double, Double> areaGraph;

	@FXML
	private Button lineGraphButton;

	@FXML
	private Button areaGraphButton;

	@FXML
	private Button xyButton;

	@FXML
	private Button xyButton2;

	@FXML
	private Button squaredButton;

	@FXML
	private Button squaredButton2;

	@FXML
	private Button cubedButton;

	@FXML
	private Button cubedButton2;

	@FXML
	private Button clearButton;

	private MyGraph mathsGraph;
	private MyGraph areaMathsGraph;

	@Override
	public void initialize(final URL url, final ResourceBundle rb) {
		mathsGraph = new MyGraph(lineGraph, 10);
		areaMathsGraph = new MyGraph(areaGraph, 10);
	}

	@FXML
	private void handleLineGraphButtonAction(final ActionEvent event) {
		lineGraph.setVisible(true);
		areaGraph.setVisible(false);
	}

	@FXML
	private void handleAreaGraphButtonAction(final ActionEvent event) {
		areaGraph.setVisible(true);
		lineGraph.setVisible(false);
	}

	@FXML
	private void handleXYButtonAction(final ActionEvent event) {
		plotLine(x -> x);
	}

	private void plotLine(Function<Double, Double> function) {
		if (lineGraph.isVisible()) {
			mathsGraph.plotLine(function);
		} else {
			areaMathsGraph.plotLine(function);
		}
	}

	@FXML
	private void handleXYButton2Action(final ActionEvent event) {
		plotLine(x -> x - 3);
	}

	@FXML
	private void handleSquaredButtonAction(final ActionEvent event) {
		plotLine(x -> Math.pow(x, 2));
	}

	@FXML
	private void handleSquaredButton2Action(final ActionEvent event) {
		plotLine(x -> Math.pow(x, 2) + 2);
	}

	@FXML
	private void handleCubedButtonAction(final ActionEvent event) {
		plotLine(x -> Math.pow(x, 3));
	}

	@FXML
	private void handleCubedButton2Action(final ActionEvent event) {
		plotLine(x -> Math.pow(x - 3, 3) - 1);
	}

	@FXML
	private void handleClearButtonAction(final ActionEvent event) {
		clear();
	}

	private void clear() {
		if (lineGraph.isVisible()) {
			mathsGraph.clear();
		} else {
			areaMathsGraph.clear();
		}
	}
}
