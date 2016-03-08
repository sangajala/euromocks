package euromocks;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

/**
 * Created by sriramangajala on 16/02/16.
 */
public class Enovation_payment {

    void setuppayment_200() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/main/resources/euromocks/enovation/setuppayment_200.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);
            stubFor(post(urlPathMatching("/enov/pay/setup?.*"))
                    .withRequestBody(containing("merchantReference"))
                    .withRequestBody(containing("\"pageSetId\":\"1\""))
                    .withRequestBody(containing("returnUrl"))
                    .willReturn(aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody(json.toJSONString())
                                    .withHeader("Access-Control-Allow-Origin", "*")
                                    .withHeader("Access-Control-Allow-Credentials", "true")
                                    .withHeader("Access-Control-Allow-Headers", "accept, cid")
                                    .withHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE")
                    ).atPriority(31));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    void setuppayment_500() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/main/resources/euromocks/enovation/setuppayment_500.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);
            stubFor(post(urlPathMatching("/enov/pay/setup?.*"))
                    .willReturn(aResponse().withStatus(500).withHeader("Content-Type", "application/json").withBody(json.toJSONString())
                                    .withHeader("Access-Control-Allow-Origin", "*")
                                    .withHeader("Access-Control-Allow-Credentials", "true")
                                    .withHeader("Access-Control-Allow-Headers", "accept, cid")
                                    .withHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE")
                    ).atPriority(32));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void querypayment_400() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/main/resources/euromocks/enovation/querypayment_400.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);
            stubFor(get(urlPathMatching("/enov/pay/query/123456789"))
                    .willReturn(aResponse().withStatus(400).withHeader("Content-Type", "application/json").withBody(json.toJSONString())
                                    .withHeader("Access-Control-Allow-Origin", "*")
                                    .withHeader("Access-Control-Allow-Credentials", "true")
                                    .withHeader("Access-Control-Allow-Headers", "accept, cid")
                                    .withHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE")
                    ).atPriority(33));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    void querypayment_200() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/main/resources/euromocks/enovation/querypayment_200.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);
            stubFor(get(urlPathMatching("/enov/pay/query"))
//                    .withRequestBody(containing("merchantReference"))
//                    .withRequestBody(containing("\"pageSetId\":\"1\""))
//                    .withRequestBody(containing("returnUrl"))
                    .willReturn(aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody(json.toJSONString())
                                    .withHeader("Access-Control-Allow-Origin", "*")
                                    .withHeader("Access-Control-Allow-Credentials", "true")
                                    .withHeader("Access-Control-Allow-Headers", "accept, cid")
                                    .withHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE")
                    ).atPriority(34));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
