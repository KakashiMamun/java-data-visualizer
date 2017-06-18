package com.github.chen0040.plt;


import com.github.chen0040.data.utils.TupleTwo;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by xschen on 18/6/2017.
 */
public class ParetoFront  extends ApplicationFrame {

   public ParetoFront( List<TupleTwo<Double, Double>> data, String chartTitle ) {
      super(chartTitle);
      JFreeChart lineChart = ChartFactory.createScatterPlot(
              chartTitle,
              "objective-1","objective-2",
              createDataset(data));

      ChartPanel chartPanel = new ChartPanel( lineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
      setContentPane( chartPanel );
      this.pack( );
   }

   private XYDataset createDataset(List<TupleTwo<Double, Double>> sample) {
      XYSeriesCollection xySeriesCollection = new XYSeriesCollection();
      XYSeries series = new XYSeries("DataSet");
      for (int x = 0; x < sample.size(); x++) {
         series.add(sample.get(x)._1(), sample.get(x)._2());
      }
      xySeriesCollection.addSeries(series);
      return xySeriesCollection;
   }

   public void showIt(){
      setVisible( true );
   }

   public void showIt(boolean centered) {
      if(centered) {
         RefineryUtilities.centerFrameOnScreen(this);
      }
      showIt();
   }


   public static void main(String[] args) {
      List<TupleTwo<Double, Double>> data = new ArrayList<>();
      data.add(new TupleTwo<>(1.0, 1.0));
      data.add(new TupleTwo<>(3.0, 3.0));
      ParetoFront chart = new ParetoFront(data, "pareto front");

      chart.showIt(true);
   }
}
