import java.util.*;

class Solution {

    static Scanner fs = new Scanner(System.in);
    static int n;
    static  ArrayList<pair> spy,house;

    static class pair {
        int x,y;
        pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        n = fs.nextInt();
        spy = new ArrayList<>();
        house = new ArrayList<>();
        for(int i=0;i<n;i++){
            char []line = fs.next().toCharArray();
            for(int j=0;j<line.length;j++){
                char c = line[j];
                if(c == 'S'){
                    spy.add(new pair(i,j));
                    continue;
                }
                if(c == 'H'){
                    house.add(new pair(i,j));
                }
            }
        }
        int max = -1;
        for(pair s:spy){
            int min = 987654321;
            for(pair h:house){
                int curr = Math.abs(s.x-h.x) + Math.abs(s.y-h.y);
                //System.out.println(curr);
                if(min > curr){
                    min = curr;
                }
            }
            if(max < min){
                max = min;
            }
        }
        System.out.println(max);
    }
}