while(!ad.isEmpty()) {
    String curr = ad.poll();
    
//				System.out.println(table(curr));
    
    int hr = -1, hc = -1, tr = -1, tc = -1;
    char[] temp = curr.toCharArray();
    for(int i = 0; i < n * m; ++i) {
        if(temp[i] >= '0' && temp[i] <= '9') {
            if(k == 1 && temp[i] == '0') {
                hr = i / m;
                hc = i % m;
                temp[i] = '.';
            }
            else if((int)(temp[i] - '0') == k - 1) {
                temp[i] = '.';
                tr = i / m;
                tc = i % m;
            }
            else temp[i]++;
            
            if(temp[i] == '1') {
                hr = i / m;
                hc = i % m;
            }
        }
    }
    
    if(hr == mr && hc == mc) {
        out = map.get(curr);
        break;
    }
    
    for(int i = 0; i < 4; ++i) {
        int nr = hr, nc = hc;
        if(i == 0) nc++;
        else if(i == 1) nr--;
        else if(i == 2) nc--;
        else nr++;
        
        if(check(nr, nc, temp) && !(k == 2 && nr == tr && nc == tc)) {
            char old = temp[nr * m + nc];
            temp[nr * m + nc] = '0';
            
            String go = new String(temp);
            if(!map.containsKey(go)) {
                map.put(go, map.get(curr) + 1);
                ad.add(go);
            }
            
            temp[nr * m + nc] = old;
        }
    }
    
}