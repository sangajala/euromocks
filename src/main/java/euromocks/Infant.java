package euromocks;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

/**
 * Created by sriramangajala on 05/02/16.
 */
public class Infant {

     void infant_get_success() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/main/resources/euromocks/post_infant_success.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);
            //http://ec2-52-18-131-154.eu-west-1.compute.amazonaws.com/bookings/TBQUNO/infants?accessKey=user
            stubFor(get(urlPathMatching("/bookings/.*/infants/.*"))
                    .withQueryParam("accessKey", matching("success"))
//                    .withRequestBody(containing("\"accessKey\": \""))
                            //    .withRequestBody(containing("ETAP_500"))
//                    .withHeader("cid", equalTo("test"))
                    .willReturn(aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody(json.toJSONString())
                                    .withHeader("Access-Control-Allow-Origin", "*")
                                    .withHeader("Access-Control-Allow-Credentials", "true")
                                    .withHeader("Access-Control-Allow-Headers", "accept, cid")
                                    .withHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE")
                    )
                    .atPriority(9));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     void post_infant_booking_already_created() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/main/resources/euromocks/infant_already_created.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);
            stubFor(post(urlPathMatching("/bookings/.*/infants"))
                    .withQueryParam("accessKey", matching("created"))
                    .willReturn(aResponse().withStatus(422).withHeader("Content-Type", "application/json").withBody(json.toJSONString())
                                    .withHeader("Access-Control-Allow-Origin", "*")
                                    .withHeader("Access-Control-Allow-Credentials", "true")
                                    .withHeader("Access-Control-Allow-Headers", "accept, cid")
                                    .withHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE")
                    ).atPriority(11));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     void post_infant_booking_pnr_access_not_found() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/main/resources/euromocks/pnr_not_found_in_SBE.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);
            stubFor(post(urlPathMatching("/bookings/.*/infants"))
                    .withQueryParam("accessKey", matching(".*"))
                    .willReturn(aResponse().withStatus(404).withHeader("Content-Type", "application/json").withBody(json.toJSONString())
                                    .withHeader("Access-Control-Allow-Origin", "*")
                                    .withHeader("Access-Control-Allow-Credentials", "true")
                                    .withHeader("Access-Control-Allow-Headers", "accept, cid")
                                    .withHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE")
                    ).atPriority(11));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


     void post_infant_passenger_id_unknown() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/main/resources/euromocks/infant_e682.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);
            stubFor(post(urlPathMatching("/bookings/.*/infants"))
                    .withQueryParam("accessKey", matching("ETAP_682"))
                    .willReturn(aResponse().withStatus(422).withHeader("Content-Type", "application/json").withBody(json.toJSONString())
                                    .withHeader("Access-Control-Allow-Origin", "*")
                                    .withHeader("Access-Control-Allow-Credentials", "true")
                                    .withHeader("Access-Control-Allow-Headers", "accept, cid")
                                    .withHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE")
                    ).atPriority(11));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


      void infant_post_success() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/main/resources/euromocks/post_infant_success.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);
            //http://ec2-52-18-131-154.eu-west-1.compute.amazonaws.com/bookings/TBQUNO/infants?accessKey=user
            stubFor(post(urlPathMatching("/bookings/.*/infants"))
                    .withQueryParam("accessKey", matching("success"))
//                    .withRequestBody(containing("\"accessKey\": \""))
                            //    .withRequestBody(containing("ETAP_500"))
//                    .withHeader("cid", equalTo("test"))
                    .willReturn(aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody(json.toJSONString())
                                    .withHeader("Access-Control-Allow-Origin", "*")
                                    .withHeader("Access-Control-Allow-Credentials", "true")
                                    .withHeader("Access-Control-Allow-Headers", "accept, cid")
                                    .withHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE")
                    )
                    .atPriority(9));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
