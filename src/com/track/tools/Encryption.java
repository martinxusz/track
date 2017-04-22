package com.track.tools;

import java.security.*;   
import java.util.*;

public class Encryption {
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
	   
	   public static   String  encryptToMD5(String info) {   
	      byte[] digesta = null;   
	      try {              
	    	  MessageDigest alga = MessageDigest.getInstance("MD5");   
	         
              alga.update(info.getBytes());   
             
              digesta = alga.digest();   
	       } catch (NoSuchAlgorithmException e) {   
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
}
