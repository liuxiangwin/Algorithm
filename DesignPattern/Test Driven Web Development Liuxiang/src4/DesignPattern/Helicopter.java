package DesignPattern;
public class Helicopter extends Vehicle 
{
  public Helicopter() 
  {
    setGoAlgorithm(new GoByFlyingAlgorithm());
  }
}
