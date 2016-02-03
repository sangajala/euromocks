package euromocks;

import com.github.tomakehurst.wiremock.client.VerificationException;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import java.io.FileReader;
import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

/**
 * Created by sriramangajala on 22/01/16.
 */
public class Etap implements CommandLineRunner {

    private void error_500() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/test/resources/euromocks/error_500.json");
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

    private void pnr_not_found_in_SBE() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/test/resources/euromocks/pnr_not_found_in_SBE.json");
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

    private void pnr_blank() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/test/resources/euromocks/pnr_blank.json");
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

    private void pos_invalid() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/test/resources/euromocks/pos_invalid.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);
            stubFor(post(urlEqualTo("/bookings?pos=ABCDE"))
                    .willReturn(aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody(json.toJSONString())
                    ).atPriority(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void old_pnr() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/test/resources/euromocks/old_pnr.json");
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

    private void no_access() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/test/resources/euromocks/no_access.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);
            stubFor(post(urlPathMatching("/bookings?.*"))
                    .withRequestBody(notMatching("accessKey"))
                    .willReturn(aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody(json.toJSONString())
                    ).atPriority(200));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void no_access_key_field() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/test/resources/euromocks/no_access.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);
            stubFor(post(urlPathMatching("/bookings?.*"))
                    .withRequestBody(containing("\"accessKey\": \"\""))
                    .willReturn(aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody(json.toJSONString())
                    ).atPriority(2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void booking_already_created() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/test/resources/euromocks/booking_already_created.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);
            stubFor(post(urlPathMatching("/bookings?.*"))
                    .withRequestBody(containing("\"accessKey\": \""))
                    .withRequestBody(containing("pnr"))
                    .withRequestBody(containing(":"))
                    .withRequestBody(containing("Q"))
                    .willReturn(aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody(json.toJSONString())
                    ).atPriority(3));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void booking_success_happy_path() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/test/resources/euromocks/booking_success.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);
            stubFor(post(urlPathMatching("/bookings?.*"))
                    .withRequestBody(containing("\"accessKey\": \""))
                    .withRequestBody(containing("\"pnr\": \"T"))
                    .withHeader("cid", equalTo("test"))
                    .willReturn(aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody(json.toJSONString())
                    ).atPriority(8));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void get_refresh_booking_fail() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/test/resources/euromocks/pnr_not_found_in_SBE.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);
            stubFor(get(urlPathMatching("/bookings/.*"))
                    .withQueryParam("accessKey", containing("1"))
                    .withQueryParam("pos",containing("G"))
                    .withQueryParam("refresh",containing("true"))
                    .withHeader("cid", equalTo("test"))
                    .willReturn(aResponse().withStatus(404).withHeader("Content-Type", "application/json").withBody(json.toJSONString())
                    ).atPriority(5));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void get_refresh_booking_success() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/test/resources/euromocks/booking_success_message_ETAP_802.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);
            stubFor(get(urlPathMatching("/bookings/T.*"))
                    .withQueryParam("accessKey", containing("1"))
                    .withQueryParam("pos", containing("G"))
//                    .withQueryParam("refresh",containing("true"))
//                    .withHeader("cid", equalTo("test"))
                    .willReturn(aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody(json.toJSONString())
                    ).atPriority(5));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void booking_RuntimeException() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/test/resources/euromocks/RunTimeException.json");
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

    public void optionsEtap() {
        stubFor(options(urlMatching("/.*"))
                .willReturn(aResponse()
                                .withHeader("Access-Control-Allow-Origin", "*")
                                .withHeader("Access-Control-Allow-Credentials", "true")
                                .withHeader("Access-Control-Allow-Headers", "accept, cid")
                                .withHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE")
                                .withStatus(200)

                ));

    }


    public static void main(String[] args) throws IOException {
        SpringApplication.run(Etap.class, args);
    }

    public void run(String... args) throws Exception {
        WireMock.configureFor(Constants.URL, Constants.PORT);
        try
        {
            resetAllRequests();
            resetToDefault();

        }
        catch (VerificationException e)
        {

            optionsEtap();
            pnr_blank();
            error_500();
            pos_invalid();
            old_pnr();
            no_access();
            no_access_key_field();
            booking_already_created();
            booking_success_happy_path();
            pnr_not_found_in_SBE();

            get_refresh_booking_fail();
            get_refresh_booking_success();
            booking_RuntimeException();
            saveAllMappings();

        }



    }
}
