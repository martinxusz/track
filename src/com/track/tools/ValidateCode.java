package com.track.tools;
import javax.servlet.http.HttpServlet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValidateCode extends HttpServlet {
	 public void doGet(HttpServletRequest request, HttpServletResponse response)
     	throws ServletException, IOException {
		 this.doPost(request, response);
	 }	 

     public void doPost(HttpServletRequest request, HttpServletResponse response)
                   throws ServletException, IOException {
            BufferedImage img = new BufferedImage(68, 19,BufferedImage.TYPE_INT_RGB);
         
            Graphics g = img.getGraphics();
            Random r = new Random();
            Color c = new Color(200, 150, 255);
            g.setColor(c);            
          
            g.fillRect(0, 0, 68, 19);
            
            StringBuffer sb = new StringBuffer();
            char[] ch = "ABCDEFGHIJKLMNPQRSTUVWXYZ123456789".toCharArray();
            int index, len = ch.length;
            for (int i = 0; i < 4; i ++) {
                   index = r.nextInt(len);
                   g.setColor(new Color(r.nextInt(88), r.nextInt(188), r.nextInt(255)));
                   g.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 17));               
                   g.drawString("" + ch[index], (i * 15) + 5, 14);
                   sb.append(ch[index]);
            }              
            request.getSession().setAttribute("validateCode", sb.toString()); 
            ImageIO.write(img, "JPG", response.getOutputStream());
            img.flush();
     } 
}

