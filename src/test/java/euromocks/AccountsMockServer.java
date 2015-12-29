package euromocks;

import com.github.tomakehurst.wiremock.client.WireMock;
import org.apache.commons.io.IOUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;


import static com.github.tomakehurst.wiremock.client.WireMock.*;


@SpringBootApplication
public class AccountsMockServer implements CommandLineRunner {




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

    public void epp_user() throws Exception{

        String response = IOUtils.toString(this.getClass().getResourceAsStream("/euromocks/eppUserResponse.json"), "UTF-8");
        stubFor(post(urlEqualTo("/auth/authenticate?lang=uk-en"))
                .atPriority(1)
                .withRequestBody(containing("auto_test_epp_user@mailinator.com"))
                        //  .withHeader("Content-Type", containing("application/json"))
//                .withQueryParam("lang", equalTo("uk-en"))
                .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                        // .withBodyFile("/Users/sriramangajala/Downloads/euromocks/src/accounts.json")
                                .withBody(response)
                ));

    }

    public void engaged_user() {

        stubFor(post(urlEqualTo("/auth/authenticate?lang=uk-en"))
                .atPriority(1)
                .withRequestBody(containing("stub_engaged_user@mailinator.com"))
                        //  .withHeader("Content-Type", containing("application/json"))
//                .withQueryParam("lang", equalTo("uk-en"))
                .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                        // .withBodyFile("/Users/sriramangajala/Downloads/euromocks/src/accounts.json")
                                .withBody(responseData.engaged_login_response)
                ));

    }

    public void accountsJson() throws Exception
    {
        String response = IOUtils.toString(this.getClass().getResourceAsStream("/euromocks/accounts.json"), "UTF-8");

        stubFor(get(urlEqualTo("/refdata/accounts.json?lang=uk-en"))
                .willReturn(aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody(response)));
    }
    private void getEPPCustomerDetails() throws IOException {
        String response = IOUtils.toString(this.getClass().getResourceAsStream("/euromocks/eppUserDetailsResponse.json"), "UTF-8");
        stubFor(get(urlEqualTo("/customers/3857?lang=uk-en"))
                        .atPriority(1)
                                //.withHeader("Content-Type", equalTo("application/json"))
                        .willReturn(
                                aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody(response))

        );
    }


    private void getEngagedCustomerDetails() throws IOException {
        String response = IOUtils.toString(this.getClass().getResourceAsStream("/euromocks/customerDetails.json"), "UTF-8");
        stubFor(get(urlPathMatching("/customers/.*?lang=uk-en"))
                        //.withHeader("Content-Type", equalTo("application/json"))
                        .willReturn(
                                aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody(response))

        );
    }

    private void logOut() throws  IOException {
        stubFor(delete(urlEqualTo("/auth/revoke?lang=uk-en"))
                .willReturn(aResponse().withStatus(200)));
    }




    public static void main(String[] args) throws IOException {
        SpringApplication.run(AccountsMockServer.class, args);
    }
    public void run(String... args) throws Exception {
//		WireMock.configureFor("localhost", 9099);
        WireMock.configureFor("52.18.159.167", 8080);
//                resetAllRequests();
//        resetToDefault();
//		WireMockServer wireMockServer = new WireMockServer(WireMockConfiguration.wireMockConfig().port(9090));
//		WireMock.configureFor(9090);
//		wireMockServer.start();
        accountsJson();
        optionstest();
        register();
        epp_user();
        engaged_user();
        getEPPCustomerDetails();
        getEngagedCustomerDetails();
        logOut();
    }

}
