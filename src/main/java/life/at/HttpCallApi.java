package life.at;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class HttpCallApi {

    URL url;
    Map<String, String> parameters;

    public HttpCallApi(URL url, Map<String, String> parameters){
        this.url = url;
        this.parameters = parameters;
    }

    public String test(){

        HttpURLConnection con;
        StringBuffer content = null;
        try{
            con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("Content-Type", "application/json");
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);
            con.setInstanceFollowRedirects(true);
            con.setRequestMethod("GET");
            con.setDoOutput(true);
            DataOutputStream out = new DataOutputStream(con.getOutputStream());
            //out.writeBytes(life.at.ParameterStringBuilder.getParamsString(parameters));
            out.flush();
            out.close();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();

        }catch (Exception e){
            e.printStackTrace();
        }

        return content.toString();
    }

    public void setURL(URL url){
        this.url = url;
    }

    public void setParameters(Map<String, String> parameters){
        this.parameters = parameters;
    }
}
