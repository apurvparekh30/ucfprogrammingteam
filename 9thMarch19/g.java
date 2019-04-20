import java.util.*;

class g {

    static Scanner fs = new Scanner(System.in);
    static double a,b,c;
    static double r;

    static double gg(int x1,int y1,int x2,int y2){
        return Math.hypot(x1-x2, y1-y2);
    }

    static double area(double a,double b,double c){
        double temp;
        temp = (4 * (a*a) * (b*b)) - ((a*a + b*b - c*c) * (a*a + b*b - c*c));
        temp = Math.sqrt(temp);
        temp = temp / 4;
        return temp;
    }
    
    static double rr(double area,double a,double b,double c){
        area = area * 2;
        double div = a + b + c;
        return (area/div);
    }

    public static void main(String[] args) {
        int []x,y;
        x = new int[3];
        y = new int[3];
        for(int i=0;i<3;i++){
            x[i] = fs.nextInt();
            y[i] = fs.nextInt();
        }
        r = fs.nextDouble();

        a = gg(x[0],y[0],x[1],y[1]);
        b = gg(x[1],y[1],x[2],y[2]);
        c = gg(x[0],y[0],x[2],y[2]);

        double area = area(a,b,c);

        double rr = rr(area,a,b,c);

        double val = (rr * 100) / r;
        
        System.out.printf("%.3f\n",val - 100);


    }
}