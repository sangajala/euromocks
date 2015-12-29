package euromocks;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

/**
 * Created by sriramangajala on 09/11/15.
 */
public class Stubs {

//    @Rule
//    public WireMockRule wireMockRule = new WireMockRule(wireMockConfig().httpsPort(8443));

    @BeforeClass
    public static void start() {
//        WireMock.shutdownServer();
        WireMock.configureFor("52.18.159.167", 8080);

//        WireMock.configureFor("localhost", 9099);
//        resetAllRequests();
//        resetToDefault();
    }

    @Test
    public void invalidLogin() {
//        resetAllRequests();
//        resetToDefault();
        stubFor(post(urlEqualTo("/auth/authenticate?lang=uk-en"))
                .atPriority(2)
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                                .withHeader("Access-Control-Allow-Origin", "*")
                                .withStatus(401)
                                .withHeader("Content-Type", "application/json")
//                                .withBodyFile("/Users/sriramangajala/Downloads/euromocks/src/accounts.json")
                                .withBody(responseData.invalid_login_response)
                ));

    }

    @Test
    public void epp_user() {

        stubFor(post(urlEqualTo("/auth/authenticate?lang=uk-en"))
                .atPriority(1)
                .withRequestBody(containing("stub_engaged_user@mailinator.com"))
              //  .withHeader("Content-Type", containing("application/json"))
//                .withQueryParam("lang", equalTo("uk-en"))
                .willReturn(aResponse()
                                .withHeader("Access-Control-Allow-Origin", "*")
                                .withHeader("Access-Control-Allow-Credentials", "true")
                                .withHeader("Access-Control-Allow-Headers", "x-requested -with, Content-Type, Accept,Authorization, cid")
                                .withHeader("Access - Control - Allow - Methods", "POST, GET, OPTIONS, PUT, DELETE")
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                        // .withBodyFile("/Users/sriramangajala/Downloads/euromocks/src/accounts.json")
                                .withBody(responseData.engaged_login_response)
                ));

    }

    @Test
    public void register() {
        stubFor(post(urlEqualTo("/app/register?lang=uk-en"))
                .withRequestBody(containing("default-api-key"))
//                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                        //  .withHeader("Access-Control-Allow-Origin", "*")
                        .withStatus(200)
                                //  .withHeader("Content-Type", "application/json")
                        .withBody("{\n" +
                                "  \"client_id\" : \"9d396d4b-c5e3-476c-abe6-12d3683e6d03\"\n" +
                                "}")));

    }

    @Test
    public void optionstest() {

        stubFor(options(urlMatching("/.*"))
//                .withHeader("Content-Type", containing("application/json"))
//                .withQueryParam("lang", equalTo("uk-en"))
                .willReturn(aResponse()
                                .withHeader("Access-Control-Allow-Origin", "*")
                                .withHeader("Access-Control-Allow-Credentials", "true")
                                .withHeader("Access-Control-Allow-Headers", "x-requested -with, Content-Type, Accept,Authorization, cid")
                                .withHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE")
                                .withStatus(200)

                ));

    }


    @Test
    public void outbound() {

//
        stubFor(get(urlMatching("/api/mob/uk-en/booking/proposals/return/outbound/.*"))
                // .withHeader("Access-Control-Allow-Origin", equalTo("*"))
//                .withRequestBody(containing("stub_epp_user@test.com"))
                .withHeader("Accept", equalTo("application/json"))
//                .withQueryParam("lang", equalTo("uk-en"))
                .willReturn(aResponse()
                                .withHeader("Access-Control-Allow-Origin", "*")
                                .withHeader("Access-Control-Allow-Credentials", "true")
                                .withHeader("Access-Control-Allow-Headers", "x-requested -with, Content-Type, Accept,Authorization, cid")
                                .withHeader("Access - Control - Allow - Methods", "POST, GET, OPTIONS, PUT, DELETE")
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                .withBody(responseData.outbound)
                ));
    }

    @Test
    public void inbound() {
        stubFor(post(urlMatching("/api/mob/uk-en/booking/proposals/inbound"))
//                .withRequestBody(containing("stub_epp_user@test.com"))
                .withHeader("Accept", equalTo("application/json"))
                .withHeader("Access-Control-Allow-Origin", equalTo("*"))
                .withRequestBody(containing("dep"))
//                .withQueryParam("lang", equalTo("uk-en"))
                .willReturn(aResponse()
                                .withHeader("Access-Control-Allow-Origin", "*")
                                .withHeader("Access-Control-Allow-Credentials", "true")
                                .withHeader("Access-Control-Allow-Headers", "x-requested -with, Content-Type, Accept,Authorization, cid")
                                .withHeader("Access - Control - Allow - Methods", "POST, GET, OPTIONS, PUT, DELETE")
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                .withBody(responseData.inbound)
                ));
    }


    @Test
    public void reserve() {
        stubFor(post(urlMatching("/api/mob/uk-en/booking/reserve"))
//                .withRequestBody(containing("stub_epp_user@test.com"))
                .withHeader("Accept", equalTo("application/json"))
                .withRequestBody(containing("dep"))
//                .withQueryParam("lang", equalTo("uk-en"))
                .willReturn(aResponse()
                        .withHeader("Access-Control-Allow-Origin", "*")
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(responseData.paymentResponse)));
    }


    @Test
    public void payment() {
        stubFor(post(urlMatching("/api/mob/uk-en/booking/checkout"))
//                .withRequestBody(containing("stub_epp_user@test.com"))
                .withHeader("Content-Type", equalTo("application/json"))
                .withRequestBody(containing("payment"))
//                .withQueryParam("lang", equalTo("uk-en"))
                .willReturn(aResponse()
                        .withHeader("Access-Control-Allow-Origin", "*")
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(responseData.checkout)));
    }


}
