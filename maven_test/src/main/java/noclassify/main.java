package noclassify;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        CloseableHttpClient client = HttpClients.createSystem();
        String host = "https://rule34hentai.net";
        String url= host + "/_images/660b172027c17f5117b7496c10537590/117073%20-%20Candy_Chiu%20Crocface%20Gravity_Falls.jpg";
        BufferedReader in=null;
        StringBuilder html=new StringBuilder();
        try {
            HttpPost post=new HttpPost(url);
            CloseableHttpResponse response = client.execute(post);
            Header setCookie = response.getFirstHeader("Set-Cookie");
            in=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String buf;
            while ((buf=in.readLine())!=null){
                html.append(buf);
            }
            Document parse = Jsoup.parse(html.toString());
            Element script = parse.selectFirst("script");
            Element form = parse.selectFirst("form#challenge-form");
            MyForm myForm = new MyForm(form.attr("action"), form.attr("method"));
            form.children().stream().forEach(c->{
                myForm.addParam(c.attr("name"),c.attr("value"));
            });
            System.out.println(script);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (in != null) {
                    in.close();
                }
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

