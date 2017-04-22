package com.track.tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Converter{
	public static String htmlspecialchars(String str) {
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}
	public static String  getVidateCode(){
		   Random  math = new Random();
		   int random = 1000*math.nextInt();
		   byte[] digesta = null;   
		   try{              
		    	  MessageDigest alga = MessageDigest.getInstance("MD5");   
		         
	              alga.update(String.valueOf(random).getBytes());   
	             
	              digesta = alga.digest();   
		    }catch (NoSuchAlgorithmException e) {   
		          e.printStackTrace();   
		   } 		      
		   String rs = byte2hex(digesta);   
		   return rs;
	   }
	public static String byte2hex(byte[] b) {   
	     String hs = "";   
	     String stmp = "";   
	     for (int n = 0; n < b.length; n++) {   
	        stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));   
	        if (stmp.length() == 1) {   
	           hs = hs + "0" + stmp;   
	        } else {   
	            hs = hs + stmp;   
	        }   
	    }   
	     return hs.toUpperCase();   
    }
	public static String converterDate(Date date ){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String now = df.format(date);
		String datetemp = now.substring(0,4);
		return datetemp;
		
	} 
	public static String converterNumber(int number){
		String numbertemp=Integer.toString(number);
		int digit= Integer.toString(number).length();
		switch(digit) { 
        case 6: 
        	break; 
        case 5:              
        	numbertemp="0"+numbertemp;
            break; 

        case 4: 
        	numbertemp="00"+numbertemp;
            break;
        case 3: 
        	numbertemp="000"+numbertemp;
            break;
        case 2:              
        	numbertemp="0000"+numbertemp;
            break; 
        case 1: 
        	numbertemp="00000"+numbertemp;
            break;
        case 0: 
        	numbertemp="000000"+numbertemp;
            break;
        default:   

		}
		return numbertemp;
	}
}
