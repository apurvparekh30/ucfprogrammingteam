import java.util.*;
import java.io.*;

class prob5{

    static FastReader fs = new FastReader();
    static String num;
    static HashMap<Integer,String> hm = new HashMap<>();
    static String [] words = {"","thousand","million","billion","trillion","quadrillion","quintillion"};
    public static void main(String[] args) {
        hm.put(0,"");
        hm.put(1,"one");
        hm.put(2,"two");
        hm.put(3,"three");
        hm.put(4,"four");
        hm.put(5,"five");
        hm.put(6,"six");
        hm.put(7,"seven");
        hm.put(8,"eight");
        hm.put(9,"nine");
        hm.put(10,"ten");
        hm.put(11,"eleven");
        hm.put(12,"twelve");
        hm.put(13,"thirteen");
        hm.put(14,"fourteen");
        hm.put(15,"fifteen");
        hm.put(16,"sixteen");
        hm.put(17,"seventeen");
        hm.put(18,"eighteen");
        hm.put(19,"nineteen");
        hm.put(20,"twenty");
        hm.put(30,"thirty");
        hm.put(40,"forty");
        hm.put(50,"fifty");
        hm.put(60,"sixty");
        hm.put(70,"seventy");
        hm.put(80,"eighty");
        hm.put(90,"ninety");

        int n = fs.nextInt();
        for(int tt=0;tt<n;tt++){
            num = fs.next();
            ArrayDeque <String> ad = new ArrayDeque<>();
            int i = num.length();
            for(int k = 0;;k++,i=i-3){
                String number = num.substring(Math.max(i-3,0),Math.max(i,0));
                if(number.isEmpty())
                    break;
                if(Integer.parseInt(number) == 0)
                    continue;
                if(number.length()==1){
                    ad.addFirst(hm.get(number.charAt(0)- '0') + " " + words[k]+ " ");
                }
                else if(number.length()==2){
                    String curr = "";
                    int currNum = Integer.parseInt(number);
                    
                    if (currNum > 10 && currNum < 20) {
                        curr = hm.get(currNum);
                    }
                    else{
                        int tmp = 10;
                        for(int t = 0;t < 2; t++){
                            int nm = tmp * (number.charAt(t) - '0');
                            tmp = tmp / 10;
                            if(nm==0)
                                continue;
                            curr += hm.get(nm)+" ";
                            
                        }
                    }
                    
                    ad.addFirst(curr + words[k]+ " ");
                }
                else if(number.length()==3){
                    int tmp = 10;
                    String curr = "";
                    for(int t=0;t<3;t++){
                        if(t==0){
                            if(number.charAt(0)-'0' == 0)
                                continue;
                            curr+=hm.get(number.charAt(0)- '0') + " " + "hundred"+" ";
                        }
                        else {
                            int currNum = Integer.parseInt(number.substring(1));
                            //System.out.println(currNum);
                            if (currNum > 10 && currNum < 20) {
                                curr+=hm.get(currNum);
                                break;
                            }
                            else{
                                int nm = tmp * (number.charAt(t) - '0');
                                tmp = tmp / 10;
                                if(nm == 0)
                                    continue;
                                curr += hm.get(nm)+" ";
                                
                            }   
                            
                        }
                    }
                    ad.addFirst(curr + words[k] + " ");
                }
            }
            //System.out.println(ad);
            StringBuilder sb = new StringBuilder();
            for(String tok:ad){
                sb.append(tok);
            }
            System.out.println(sb);
        }

    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
    
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
    
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
    
        int nextInt() {
            return Integer.parseInt(next());
        }
    
        long nextLong() {
            return Long.parseLong(next());
        }
    
        double nextDouble() {
            return Double.parseDouble(next());
        }
    
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}