/*  ACM Mid-Central Programming competition 2015 Problem B: Agglomerator
    solution by Andy Harrington

    robustness check: test with pos, neg, 0 dEPS:  here neg
*/

import java.util.*;
import static java.lang.Math.*;

 public class ag_ahneg {
    public static void main(String[] args) {
      blobneg.solve(args);
    }
 }

class blobneg {  

   double x, y, vx, vy, r, ti; 
   boolean dead; // if already used
   int i; //index in blobs: debug

   static double dEPS = -.001, tEPS = .001, sepEPS = .01;

   public blobneg(double x_, double y_, double vx_, double vy_, double r_, double t) {
      x = x_;
      y = y_; 
      vx = vx_; 
      vy = vy_;
      r = r_;
      ti = t;
      i = blobs.size();  //debug
      for (blobneg b: blobs) 
        if (!b.dead && dist(b) < sepEPS)
           System.out.format("blob %d CLOSE to new %d: %f\n", b.i, i, dist(b));
      System.err.println("new " + this);
   }

   double dist(blobneg b) // when move older blob b to time ti
   {
      double dt = ti - b.ti;
      return hypot(b.x + dt*b.vx - x, b.y + dt*b.vy - y) - r - b.r;
   }
   // intersect newer blob
   double intersect (blobneg b) {  // change frame:  b fixed at origin, relative v
      double dt = b.ti - ti;
      move(dt);
      double xr = x - b.x, yr = y - b.y, vxr = vx - b.vx, vyr = vy - b.vy;
      move(-dt);
      if (xr*vxr + yr*vyr >= 0) return Double.POSITIVE_INFINITY; // moving away or parallel
      double vmag = hypot(vxr, vyr), 
             d = abs((vyr*xr - vxr*yr)/vmag), //(unit normal to v) dot position = closest
             rr = r + b.r;
      if (d > rr+dEPS) {
          return Double.POSITIVE_INFINITY; // never close enough
      }
      double ds = -(xr*vxr + yr*vyr)/vmag ;
      if (d  < rr) // (unit direction vec) dot position = dist to pt of closest centers
           ds -= sqrt(rr*rr - d*d); //  - dist inside circle = dist to touch

      return ds/vmag + b.ti;
   }

   void move(double t)
   {
      x += vx*t;
      y += vy*t;
   }

   blobneg combine(blobneg b, double t) {  
      move(t - ti);
      b.move(t - b.ti); // now touching
      System.err.format("touching at time %f\n    %s and \n    %s\n", t, this, b);
      double a = r*r, ab = b.r*b.r, totA = a + ab, w = a/totA, wb = ab/totA;
      dead = b.dead = true;
      
      return new blobneg(x*w + b.x*wb, y*w + b.y*wb, 
                      vx*w + b.vx*wb, vy*w + b.vy*wb, sqrt(totA), t);
   }

   public String toString() { // debug display only
      if (dead) return i + " dead";
      return String.format("i %d P=(%f, %f), v=(%f, %f), r=%f, t=%f", 
                            i, x, y, vx, vy, r, ti);
   }

    static PriorityQueue<glomneg> pq = new PriorityQueue<glomneg>(); 
    static ArrayList<blobneg> blobs = new ArrayList<blobneg>();
    static int n;
    static double lastT;

    static void solve(String[] args) {
      Scanner in = new Scanner(System.in);
      n = in.nextInt();
      for (int i = 0; i < n; i++)  
         addIntersections(new blobneg(in.nextDouble(), in.nextDouble(), 
                                in.nextDouble(), in.nextDouble(), in.nextDouble(), 0));
      lastT = 0;
      while(!pq.isEmpty()  && n > 1) {
         glomneg g = pq.poll();
         if (g.b1.dead || g.b2.dead) continue;
         if (g.t - lastT < tEPS) System.out.println("TIMES OF COLLISIONS TOO CLOSE");
         lastT = g.t;
         addIntersections(g.b1.combine(g.b2, lastT)); 
         n--;         
      }
      System.out.println(n + " " + lastT);
    }

    static void addIntersections(blobneg b) 
    {
         for (blobneg b2: blobs) 
            if (!b2.dead) {
              double t = b2.intersect(b); // intersect newer
              if (t < Double.POSITIVE_INFINITY) 
                  pq.offer(new glomneg(t, b, b2));
            }
         blobs.add(b);
    }
}

class glomneg implements Comparable<glomneg>
{
    double t;
    blobneg b1, b2;

    public glomneg(double t_, blobneg b1_, blobneg b2_)
    {                      // newer   older
      t = t_;
      b1 = b1_;
      b2 = b2_;
      System.err.format("glom at t=%f blobs %d and %d\n", t, b1.i, b2.i);
    }

    public int compareTo(glomneg g)
    {
       double dif = t - g.t;
       if (dif > 0) return 1;
       if (dif < 0) return -1;
       return 0;
    }
}
