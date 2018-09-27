package life.at;

import org.jbehave.core.annotations.Given;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class HttpCallSteps {



    @Given("a system state")
    public void givenASystemState() {
        URL u = null;
        Map<String, String> parameters = new HashMap<String, String>();

        parameters.put("name", "Felipe");
        try{
            u = new URL("http://www.mocky.io/v2/5bab95f83100004c00654436");
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        HttpCallApi test = new HttpCallApi(u, parameters);
        System.out.println(test.test());

    }

}
