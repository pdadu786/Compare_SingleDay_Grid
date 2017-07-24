package CompareGrids;

/**
 * Created by praveendadu on 14/07/2017.
 */
import java.io.IOException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;

public class TestGrdiresponse {


    public static String JsonResponse(String Jsonstring, String AuthURL, String ContentType) throws IOException {
        HttpPost postRequst = new HttpPost(AuthURL);
        ResponseHandler<String> handler = new BasicResponseHandler();
        StringEntity entity = new StringEntity(Jsonstring);
        entity.setContentType(ContentType);
        entity.setContentEncoding(new BasicHeader("Content-Type", ContentType));
        postRequst.setEntity(entity);
        HttpClient httpclient = HttpClientBuilder.create().build();
        String Responsebody = (String)httpclient.execute(postRequst, handler);
        return Responsebody;
    }
}