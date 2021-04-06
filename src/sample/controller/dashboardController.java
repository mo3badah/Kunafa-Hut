package sample.controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.Parent;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;

public class dashboardController implements Initializable{

    private LineChart<?, ?>linechart;
    @FXML
    private BorderPane border_pane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setLineChart();

    }
    private void setLineChart() {
        XYChart.Series series = new XYChart.Series();
        series.getData().add(new XYChart.Data("monday",80));
        series.getData().add(new XYChart.Data("tuesday",90));
        series.getData().add(new XYChart.Data("wednesday",85));
        series.getData().add(new XYChart.Data("thursday",110));
        series.getData().add(new XYChart.Data("friday",130));
        series.getData().add(new XYChart.Data("saturday",80));
        series.getData().add(new XYChart.Data("sunday",50));
        linechart.getData().addAll(series);
        linechart.lookup(".chart-plot-background").setStyle("-fx-background-color: transparent;");


    }
    private void showdashboard(MouseEvent event){
        try {
            Parent dashbord = FXMLLoader.load(getClass().getResource("sample/fxml/dashboard.fxml"));
            border_pane.setCenter(dashbord);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
