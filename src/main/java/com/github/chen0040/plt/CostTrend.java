package com.github.chen0040.plt;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.util.Arrays;
import java.util.List;


/**
 * Created by xschen on 18/6/2017.
 */
public class CostTrend extends ApplicationFrame {

   public CostTrend(List<Double> costTrend, String title) {
      super(title);
      JFreeChart lineChart = ChartFactory.createLineChart(
              title,
              "Generation","Costs",
              createDataset(costTrend),
              PlotOrientation.VERTICAL,
              true,true,false);

      ChartPanel chartPanel = new ChartPanel( lineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
      setContentPane( chartPanel );
      this.pack( );
   }

   private DefaultCategoryDataset createDataset( List<Double> costTrend) {
      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
      for(int i=0; i < costTrend.size(); ++i){
         dataset.addValue( costTrend.get(i) , "cost" , "" + i );
      }
      return dataset;
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
      List<Double> costTrends = Arrays.asList(1.0, 1.2, 1.3, 1.34, 1.23, 1.11, 1.5);
      CostTrend chart = new CostTrend(costTrends, "cost vs generation");

      RefineryUtilities.centerFrameOnScreen( chart );
      chart.showIt(true);
   }
}
