# java-data-visualizer
A data visualization tool for visualizing results from machine learning and optimization

# Install 

Add the following dependency to your POM file:

```xml
<dependency>
  <groupId>com.github.chen0040</groupId>
  <artifactId>java-data-visualizer</artifactId>
  <version>1.0.1</version>
</dependency>
```

# Usage

To visualize a 2-objective pareto front for a multi-objective optimization problem:

```java
// data stores a list of solution, which contains objective-1 and objective-2 values
List<TupleTwo<Double, Double>> data = new ArrayList<>();

data.add(new TupleTwo<>(1.0, 2.0)); // for this solution, objective-1 is 1.0 and objective-2 is 2.0
data.add(new TupleTwo<>(3.0, 3.0)); // for this solution, objective-1 is 3.0 and objective-2 is 3.0
ParetoFront chart = new ParetoFront(data, "pareto front");
chart.showIt(); // to center the chart, call chart.showIt(true) instead
```

To visualize the cost trend vs generation as the optimization progress:

```java
// cost trend means cost at generation 0 is 1.0, at generation 1 is 1.2, ...
List<Double> costTrends = Arrays.asList(1.0, 1.2, 1.3, 1.34, 1.23, 1.11, 1.5);

CostTrend chart = new CostTrend(costTrends, "cost vs generation");
chart.showIt(true);
```
