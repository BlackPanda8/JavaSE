
package loginsystem;

import java.util.HashMap;


public class IDandPasswords {
    
    HashMap<String, String> logininfo = new HashMap<>();

    public IDandPasswords() {
        logininfo.put("Bro", "123");
        logininfo.put("BroCode", "953257");
    
    }
   protected HashMap getLogininfo(){
        return logininfo;
    }
    
}
