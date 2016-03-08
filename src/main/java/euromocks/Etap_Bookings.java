package euromocks;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

/**
 * Created by sriramangajala on 05/02/16.
 */
public class Etap_Bookings {

     void error_500() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/main/resources/euromocks/error_500.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);
            stubFor(post(urlEqualTo("/bookings?pos=GBZXA"))
                    .withRequestBody(containing("\"accessKey\": \""))
                    .withRequestBody(containing("ER500"))
                    .willReturn(aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody(json.toJSONString()))
                    .atPriority(100));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     void pnr_not_found_in_SBE() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/main/resources/euromocks/pnr_not_found_in_SBE.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);
            stubFor(post(urlPathMatching("/bookings?.*"))
                    .withRequestBody(containing("\"accessKey\": \""))
                    .withRequestBody(containing("pnr"))
                    .withRequestBody(containing(":"))
//                    .withRequestBody(matching("?.*"))
                    .willReturn(aResponse().withStatus(404).withHeader("Content-Type", "application/json").withBody(json.toJSONString()))
                    .atPriority(100));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

     void pnr_blank() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/main/resources/euromocks/pnr_blank.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);
            stubFor(post(urlPathMatching("/bookings?.*"))
                    .withRequestBody(containing("\"accessKey\": \""))
                    .withRequestBody(containing("\"pnr\": \"\""))
                    .willReturn(aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody(json.toJSONString())
                    ).atPriority(2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     void pos_invalid() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/main/resources/euromocks/pos_invalid.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);
            stubFor(post(urlEqualTo("/bookings?pos=ABCDE"))
                    .willReturn(aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody(json.toJSONString())
                    ).atPriority(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     void old_pnr() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/main/resources/euromocks/old_pnr.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);
            stubFor(post(urlPathMatching("/bookings?.*"))
                    .withRequestBody(containing("\"accessKey\": \""))
                    .withRequestBody(containing("pnr"))
                    .withRequestBody(containing(":"))
                    .withRequestBody(containing("SNSIRW"))
                    .willReturn(aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody(json.toJSONString())
                    ).atPriority(2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     void no_access() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/main/resources/euromocks/no_access.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);
            stubFor(post(urlPathMatching("/bookings?.*"))
                    .withRequestBody(notMatching("accessKey"))
                    .willReturn(aResponse().withStatus(422).withHeader("Content-Type", "application/json").withBody(json.toJSONString())
                    ).atPriority(200));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     void no_access_key_field() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/main/resources/euromocks/no_access.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);
            stubFor(post(urlPathMatching("/bookings?.*"))
                    .withRequestBody(containing("\"accessKey\": \"\""))
                    .willReturn(aResponse().withStatus(422).withHeader("Content-Type", "application/json").withBody(json.toJSONString())

                            .withHeader("Access-Control-Allow-Origin", "*")
                            .withHeader("Access-Control-Allow-Credentials", "true")
                            .withHeader("Access-Control-Allow-Headers", "accept, cid")
                            .withHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE")).atPriority(20));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     void no_access_key_field_infant_post() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/main/resources/euromocks/no_access.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);
            stubFor(post(urlPathMatching("/bookings/.*/infant"))
                    .withQueryParam("accessKey", equalTo(""))
                    .willReturn(aResponse().withStatus(422).withHeader("Content-Type", "application/json").withBody(json.toJSONString())
                                    .withHeader("Access-Control-Allow-Origin", "*")
                                    .withHeader("Access-Control-Allow-Credentials", "true")
                                    .withHeader("Access-Control-Allow-Headers", "accept, cid")
                                    .withHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE")
                    ).atPriority(8));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



     void booking_already_created() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/main/resources/euromocks/booking_already_created.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);
            stubFor(post(urlPathMatching("/bookings?.*"))
                    .withRequestBody(containing("\"accessKey\": \""))
                    .withRequestBody(containing("pnr"))
                    .withRequestBody(containing(":"))
                    .withRequestBody(containing("Q"))
                    .willReturn(aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody(json.toJSONString())
                                    .withHeader("Access-Control-Allow-Origin", "*")
                                    .withHeader("Access-Control-Allow-Credentials", "true")
                                    .withHeader("Access-Control-Allow-Headers", "accept, cid")
                                    .withHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE")
                    ).atPriority(3));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     void booking_success_happy_path() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/main/resources/euromocks/booking_success.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);
            stubFor(post(urlPathMatching("/bookings?.*"))
                    .withRequestBody(containing("\"accessKey\": \""))
                    .withRequestBody(containing("\"pnr\": \"T"))
                    .withHeader("cid", equalTo("test"))
                    .willReturn(aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody(json.toJSONString())
                                    .withHeader("Access-Control-Allow-Origin", "*")
                                    .withHeader("Access-Control-Allow-Credentials", "true")
                                    .withHeader("Access-Control-Allow-Headers", "accept, cid")
                                    .withHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE")
                    ).atPriority(8));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     void get_refresh_booking_fail() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/main/resources/euromocks/pnr_not_found_in_SBE.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);
            stubFor(get(urlPathMatching("/bookings/.*"))
//                    .withQueryParam("accessKey", containing("1"))
//                    .withQueryParam("pos",containing("G"))
//                    .withQueryParam("refresh",containing("true"))
//                    .withHeader("cid", equalTo("test"))
                    .willReturn(aResponse().withStatus(404).withHeader("Content-Type", "application/json").withBody(json.toJSONString())
                                    .withHeader("Access-Control-Allow-Origin", "*")
                                    .withHeader("Access-Control-Allow-Credentials", "true")
                                    .withHeader("Access-Control-Allow-Headers", "accept, cid")
                                    .withHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE")
                    ).atPriority(50));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     void get_refresh_booking_success() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/main/resources/euromocks/booking_success_message_ETAP_802.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);
            stubFor(get(urlPathMatching("/bookings/T.*"))
                    .withQueryParam("accessKey", matching(".*"))
//                    .withQueryParam("pos", containing("G"))
//                    .withQueryParam("refresh",containing("true"))
//                    .withHeader("cid", equalTo("test"))
                    .willReturn(aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody(json.toJSONString())
                                    .withHeader("Access-Control-Allow-Origin", "*")
                                    .withHeader("Access-Control-Allow-Credentials", "true")
                                    .withHeader("Access-Control-Allow-Headers", "accept, cid")
                                    .withHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE")
                    ).atPriority(22));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     void no_access_key() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/main/resources/euromocks/no_access_key.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);
            stubFor(get(urlMatching("/bookings/T.*"))
                    .withQueryParam("accessKey", equalTo(""))
//                            .
//                    .withQueryParam("pos", containing("G"))
//                    .withQueryParam("refresh",containing("true"))
//                    .withHeader("cid", equalTo("test"))
                    .willReturn(aResponse().withStatus(422).withHeader("Content-Type", "application/json").withBody(json.toJSONString())

                            .withHeader("Access-Control-Allow-Origin", "*")
                            .withHeader("Access-Control-Allow-Credentials", "true")
                            .withHeader("Access-Control-Allow-Headers", "accept, cid")
                            .withHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE")).atPriority(5));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     void booking_RuntimeException() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/main/resources/euromocks/RunTimeException.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);
            stubFor(post(urlPathMatching("/bookings?.*"))
//                    .withRequestBody(containing("\"accessKey\": \""))
                    .withRequestBody(containing("ETAP_500"))
//                    .withHeader("cid", equalTo("test"))
                    .willReturn(aResponse().withStatus(500).withHeader("Content-Type", "application/json").withBody(json.toJSONString())
                    ).atPriority(6));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
