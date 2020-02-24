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
        System.out.print("�������������");
        String regex = sc.next();//����������
        Pattern p = Pattern.compile(regex);
        try {
            System.out.print("��������Ҫ��ȡ��URL��");
            String scUrl= sc.next();//������ȡ��URL
            URL url = new URL(scUrl);//��ȡ����ַ��������ȡ����һ��������վ
            URLConnection urlconn = url.openConnection();
            pw = new PrintWriter(new FileWriter("out/wanan.txt"), true);//����ȡ�������ӷŵ�D�̵�wanan�ļ���.
            br = new BufferedReader(new InputStreamReader(urlconn.getInputStream()));
            String buf = "";
            while ((buf = br.readLine()) != null) {
                Matcher buf_m = p.matcher(buf);
                while (buf_m.find()) {
                    pw.println(buf_m.group());
                }
            }
            System.out.println("ȫ����ȡ�ɹ���Ŷ^_^"+""+"ôô��!");
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
