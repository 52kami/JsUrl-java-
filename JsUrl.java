import java.io.*;
import java.net.HttpURLConnection;
import java.net.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsUrl {
    public static void main(String[] args)throws IOException {
        PrintWriter pw = null;
        BufferedReader br = null;
//        String regex = "\"/+[A-Za-z]+/+[A-Za-z]+/+[A-Za-z]+[\\w_]+\"";
        Scanner sc=new Scanner(System.in);
        System.out.print("请输入你的正则：");
        String regex = sc.next();//输入爬正则
        Pattern p = Pattern.compile(regex);
        try {
            System.out.print("请输入需要爬取的URL：");
            String scUrl= sc.next();//输入爬取的URL
            URL url = new URL(scUrl);//爬取的网址、这里爬取的是一个生物网站
            URLConnection urlconn = url.openConnection();
            pw = new PrintWriter(new FileWriter("out/wanan.txt"), true);//将爬取到的链接放到D盘的wanan文件中.
            br = new BufferedReader(new InputStreamReader(urlconn.getInputStream()));
            String buf = "";
            while ((buf = br.readLine()) != null) {
                Matcher buf_m = p.matcher(buf);
                while (buf_m.find()) {
                    pw.println(buf_m.group());
                }
            }
            System.out.println("全部爬取成功了哦^_^"+""+"么么哒!");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            pw.close();
        }
    }
}
