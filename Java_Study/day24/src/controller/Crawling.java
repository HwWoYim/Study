package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawling {
   public static void main(String[] args) {

      final String url="https://www.op.gg/champions";
      Document doc=null;
      try {
         doc=Jsoup.connect(url).get();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      Elements eles=doc.select("nav.css-1x3kezq > ul > li > a > img");

      Iterator<Element> itr=eles.iterator();
      int N=1;
      while(itr.hasNext()) {
         String path=itr.next().attr("src");
         path=path.substring(0, path.lastIndexOf("?"));
         try {
            FileInputStream fis=new FileInputStream(path);
            FileOutputStream fos=new FileOutputStream("D:\\0607KIM\\resource\\"+N+".png");
            N++;
            byte[] buff=new byte[3000];
            int len;
            while((len=fis.read(buff))!=-1) {
               fos.write(buff,0,len);
            }
            fos.flush();
            fos.close();
         } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }

   }
}