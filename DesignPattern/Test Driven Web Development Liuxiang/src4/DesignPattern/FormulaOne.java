package DesignPattern;
public class FormulaOne extends Vehicle 
{
  public FormulaOne() 
  {
    setGoAlgorithm(new GoByDrivingAlgorithm());
  }
}
