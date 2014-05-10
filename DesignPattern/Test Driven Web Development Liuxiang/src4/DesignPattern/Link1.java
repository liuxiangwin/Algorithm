package DesignPattern;
public class Link1 implements Link
{
  Link next;

  public Link1(Link n)
  {
    next = n;
  }

  public void check(boolean b)
  {
    if(b){
      next.check(true);
    } else {
      next.check(false);
    }
  }
}
