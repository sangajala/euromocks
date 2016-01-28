package euromocks;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.apache.commons.io.IOUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

/**
 * Created by sriramangajala on 22/01/16.
 */
public class SatishStuff implements CommandLineRunner{


    private void ods() throws IOException {
//        String response = IOUtils.toString(this.getClass().getResourceAsStream("/euromocks/ods1.json"), "UTF-8");
        stubFor(get(urlEqualTo("/enov/ods"))
                        .willReturn(
                                aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody(responseData.ods))

        );
    }

    private void proposals() throws IOException {
        //String response = IOUtils.toString(this.getClass().getResourceAsStream("/euromocks/ods1.json"), "UTF-8");
        stubFor(get(urlPathEqualTo("/enov/proposals"))
//                        .withQueryParam("origin", equalTo("GBLON"))
//                        .withQueryParam("destination", equalTo("FRPAR"))
//                        .withQueryParam("noOfPassengers",equalTo("2"))
//                        .withQueryParam("journeyType",equalTo("Outbound/Return"))
//                        .withQueryParam("startDate",equalTo("2016-06-20"))
//                        .withQueryParam("endDate",equalTo("2016-06-27"))
                        .willReturn(
                                aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody(responseData.getProposals()))

        );
    }

    private void reference() throws IOException {
        //String response = IOUtils.toString(this.getClass().getResourceAsStream("/euromocks/ods1.json"), "UTF-8");
        stubFor(get(urlPathMatching("/enov/play/.*"))
                        .willReturn(
                                aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody(responseData.getReference()))

        );
    }

    public static void main(String[] args) throws IOException {
        SpringApplication.run(SatishStuff.class, args);
    }
    public void run(String... args) throws Exception {
//        WireMock.configureFor("localhost",9090);
        WireMock.configureFor(Constants.URL,Constants.PORT);
//        try
//        {
//            resetAllRequests();
//            resetToDefault();
//        }
//        catch (Exception e)
//        {
//
//        }

        ods();
        proposals();
        reference();

    }
}
