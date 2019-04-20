// MCPC'15: Agglomerator
// Author: Bob Pilgrim
import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class agglomerator_working
{
   public static double curtime = 0.0;
   public static List<Blob> blobs = new ArrayList<Blob>();
   public static void main(String args[]) throws FileNotFoundException
   {
      int n;
      boolean done = false;
      double nexttime = Double.MAX_VALUE;
      double thistime = 0.0;
      double x,y,vx,vy,rad;
      Blob p,q,r;
      Scanner in = new Scanner(System.in);  //standard input
      n = in.nextInt();
      for(int i = 0;i<n;i++)
      {
         x = in.nextDouble();
         y = in.nextDouble();
         vx = in.nextDouble();
         vy = in.nextDouble();
         rad = in.nextDouble();
         blobs.add(new Blob(x,y,vx,vy,rad));
      }
      
      while(!done)
      {
         p = null;
         q = null;
         r = null;
         
         done = true;
         nexttime = Double.MAX_VALUE;
         for(int i=0;i<blobs.size()-1;i++)             // find the nearest (soonest) collision in the future
         {
            for(int j=i+1;j<blobs.size();j++)
            {
               thistime = hitTime(blobs.get(i),blobs.get(j));
               if(thistime>= 0.0 && thistime < nexttime)
               {
                  nexttime = thistime;
                  p = blobs.get(i);
                  q = blobs.get(j);
                  done = false;
               }
            }
         }
         if(!done)
         {
            for(Blob b : blobs)
            {
                b.X = b.X + b.Vx*nexttime;
                b.Y = b.Y + b.Vy*nexttime;
            }
            collide(p,q);      // combine colliding objects p and q into object p then remove q
            blobs.remove(q);
            curtime += nexttime;  // accumulate simulation time
 //           System.out.print("collision at time = " + nexttime);   //uncomment for verbose
 //           System.out.println(" new " + p.X + " " + p.Y + " " + p.Vy + " " + p.Vy + " " + p.Rad);
         }
      }
      System.out.println(blobs.size() + " " + curtime);
   }
   
   public static void collide(Blob p, Blob q)
   {
       double x,y,vx,vy,rad;
       rad = p.Rad*p.Rad + q.Rad*q.Rad;
       double wp = p.Rad*p.Rad/(rad);
       double wq = q.Rad*q.Rad/(rad);
       rad = Math.sqrt(rad);
       x = wp*p.X + wq*q.X;
       y = wp*p.Y + wq*q.Y;
       vx = wp*p.Vx + wq*q.Vx;
       vy = wp*p.Vy + wq*q.Vy;
       p.X = x;
       p.Y = y;
       p.Vx = vx;
       p.Vy = vy;
       p.Rad = rad;
   }
   
   public static double hitTime(Blob p, Blob q)
   {
      double t = 0.0;
      double t1 = -1.0;
      double t2 = -1.0;
      double A = Math.pow((p.Vx - q.Vx),2.0) + Math.pow((p.Vy - q.Vy),2.0);
      double B = 2.0 * ((p.X - q.X) * (p.Vx - q.Vx) + (p.Y - q.Y) * (p.Vy - q.Vy));
      double C = Math.pow((p.X - q.X),2.0) + Math.pow((p.Y - q.Y),2.0) - Math.pow((p.Rad + q.Rad),2.0);
      double radical = B * B - 4.0 * A * C;
      
      if (radical < 0.0 || A == 0.0)
         t = -1.0;
      else
      {
         t1 = (-B + Math.sqrt(radical)) / (2.0 * A);
         t2 = (-B - Math.sqrt(radical)) / (2.0 * A);
         if (t1 < 0.0 && t2 < 0.0)
            t = -1.0;
         else
         {
            if (t1 >= 0.0 && t2 < 0.0)
               t = t1;
            if (t2 >= 0.0 && t1 < 0.0)
               t = t2;
            if (t1 >= 0.0 && t2 >= 0.0)
            {
               t = Math.min(t1, t2);
            }
         }
      }
      return t;
   }
}

class Blob                    // slap dash - use like a struct - OOP purists please avert your eyes
{
   public double X;
   public double Y;
   public double Vx;
   public double Vy;
   public double Rad;
       
   public Blob(double x, double y, double vx, double vy, double radius)
   {
      X=x;
      Y=y;
      Vx=vx;
      Vy=vy;
      Rad=radius;
   }
}
