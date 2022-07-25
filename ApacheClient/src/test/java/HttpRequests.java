import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.http.client.methods.HttpGet;
import org.junit.Test;


public class HttpRequests {

    @Test
    public void getMethod(){

        CloseableHttpClient client = HttpClients.createDefault();

        HttpGet request = new HttpGet("https://demoqa.com");

    }
}
