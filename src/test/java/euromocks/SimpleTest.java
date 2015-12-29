package euromocks;

import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

/**
 * Unit test for simple App.
 */
public class SimpleTest //extends AcceptanceTestBase
{

    @BeforeClass
    public static void start()
    {
//        WireMock.shutdownServer();
        WireMock.configureFor("52.18.159.167", 8080);
//        WireMock.configureFor("localhost", 9099);
        resetAllRequests();
        resetToDefault();
    }

//
//    @Test
//    public void exampleTest() {
////        resetAllRequests();
////        resetToDefault();
//
//        stubFor(get(urlEqualTo("/my/resource"))
//                .withHeader("Accept", equalTo("text/json"))
//                .willReturn(aResponse()
//                        .withStatus(200)
//                        .withHeader("Content-Type", "application/json")
//                        .withBody("{\"Some content\"}")));
//
////
////        Result result = myHttpServiceCallingObject.doSomething();
////
////        assertTrue(result.wasSuccessFul());
////
////        verify(getRequestedFor(urlMatching("/my/resource/"))
//////                .withRequestBody(matching(".*<message>1234</message>.*"))
////                .withHeader("Content-Type", matching("application/json")));
//    }



    @Test
    public void invalidLogin() {
//        resetAllRequests();
//        resetToDefault();
        stubFor(post(urlEqualTo("/auth/authenticate?lang=uk-en"))
//                .withRequestBody(containing("stub_epp_user@test.com"))
                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                                .withHeader("Access-Control-Allow-Origin", "*")
                                .withStatus(401)
                                .withHeader("Content-Type", "application/json")
//                                .withBodyFile("/Users/sriramangajala/Downloads/euromocks/src/accounts.json")
                                .withBody("{\n" +
                                        "        \"errors\" : [ {\n" +
                                        "        \"code\" : \"ACC_200\",\n" +
                                        "                \"message\" : \"Sorry it seems we are having problems finding this account. We'd suggest that you give your dedicated service centre a call on 08448 117 117. (CRM_358)\"\n" +
                                        "    } ]\n" +
                                        "    }")
                ));

    }


    @Test
    public void register() {
        stubFor(post(urlPathMatching("/app/register"))
                .withQueryParam("lang", equalTo("uk-en"))
                        .withRequestBody(containing("default-api-key"))

                .withHeader("Accept", equalTo("application/json"))
                .willReturn(aResponse()
                      //  .withHeader("Access-Control-Allow-Origin", "*")
                        .withStatus(200)
                      //  .withHeader("Content-Type", "application/json")
                        .withBody("{\n" +
                                "  \"client_id\" : \"9d396d4b-c5e3-476c-abe6-12d3683e6d03\"\n" +
                                "}")));

    }

    @Test
    public void engagedUser() {
        stubFor(post(urlEqualTo("/auth/authenticate?lang=uk-en")).withRequestBody((containing("stub_engaged_user@mailinator.com")))
                        .withHeader("Accept", equalTo("application/json"))
                        .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Access-Control-Allow-Origin","*")
                                .withHeader("Content-Type", "application/json")
                                .withBody("{\n" +
                                        "  \"membership\" : { },\n" +
                                        "  \"profile\" : {\n" +
                                        "    \"title\" : \"MR.\",\n" +
                                        "    \"givenName\" : \"engaged\",\n" +
                                        "    \"familyName\" : \"user1\",\n" +
                                        "    \"displayName\" : \"MR. userengaged\"\n" +
                                        "  },\n" +
                                        "  \"access_token\" : \"110f94d21aeef6474a5e35e1c48f482d\",\n" +
                                        "  \"refresh_token\" : \"a34a3878b017d0f86049f5b07d11ec33\",\n" +
                                        "  \"token_type\" : \"bearer\",\n" +
                                        "  \"expires_in\" : 3600,\n" +
                                        "  \"customer_id\" : 27619,\n" +
                                        "  \"customer_version\" : \"1443108073000\"\n" +
                                        "}"))
        );
    }

}
