class Solution {
    static HashMap<String, String> monthNumbder = new HashMap<>();
    static {
       
        monthNumbder.put("Jan", "01");
        monthNumbder.put("Feb", "02");
        monthNumbder.put("Mar", "03");
        
        monthNumbder.put("Apr", "04");
        monthNumbder.put("May", "05");
        monthNumbder.put("Jun", "06");
        
        monthNumbder.put("Jul", "07");
        monthNumbder.put("Aug", "08");
        monthNumbder.put("Sep", "09");
        
        monthNumbder.put("Oct", "10");
        monthNumbder.put("Nov", "11");
        monthNumbder.put("Dec", "12");
    }
    public String reformatDate(String date) {
    
        String splitStr[] = date.split(" ");
        String ans = "";
        
        ans = splitStr[2] + "-" + monthNumbder.get(splitStr[1]) + "-";
        if(splitStr[0].length() < 4) 
            ans = ans + "0"+splitStr[0].charAt(0);
        else
            ans = ans + splitStr[0].substring(0, 2) ;
        
        return ans;
        
    }
}
