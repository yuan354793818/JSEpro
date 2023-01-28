package noclassify;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        CloseableHttpClient client = HttpClients.createSystem();
        //String url= "https://rule34hentai.net" + "/_images/660b172027c17f5117b7496c10537590/117073%20-%20Candy_Chiu%20Crocface%20Gravity_Falls.jpg";
        String url="https://rule34hentai.net/_images/132de45de6ac11db7c8dc51ef516b827/412673%20-%203D%20Animated%20Life_is_Strange%20MadrugaSFM%20Rachel_Amber%20Sound%20evilaudio.mp4";
        InputStream in=null;
        BufferedReader bd=null;
        FileOutputStream fos=new FileOutputStream("D:\\JavaEEworkspace\\JSEpro\\maven_test\\src\\main\\java\\noclassify\\txt\\xxx.mp4");
        StringBuilder html=new StringBuilder();
        try {
            HttpPost post=new HttpPost(url);
            CloseableHttpResponse response = client.execute(post);
            //Header setCookie = response.getFirstHeader("Set-Cookie");
            //bd=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            in=response.getEntity().getContent();
            byte[] buf=new byte[1024];
            int len;
            while ((len=in.read(buf))!=-1){
                fos.write(buf,0,len);
            }
//            String buf;
//            while ((buf = bd.readLine()) != null) {
//                System.out.println(buf);
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if (in != null) {
                    in.close();
                }
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyForm{
    private String action;
    private String method;
    private Map<String,String> params;

    public MyForm() {
    }

    public MyForm(String action, String method) {
        this.action = action;
        this.method = method;
        this.params = new HashMap<>();
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void addParam(String key, String val) {
        this.params.put(key, val);
    }
}

