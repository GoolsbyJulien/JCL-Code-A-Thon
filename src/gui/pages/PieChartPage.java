package gui.pages;

import gui.Game;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;

public class PieChartPage extends Page {
    @Override
    public Parent getPane() {

        PieChart pane = new PieChart();

        pane.setPrefSize(400,400);
        pane.setLabelsVisible(false);
        for (Game g : Game.getDummyList()) {

            pane.getData().add(new PieChart.Data(g.getName(), g.getSize()));

        }


        return pane;
    }
}
