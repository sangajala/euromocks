package euromocks;

import com.github.tomakehurst.wiremock.client.VerificationException;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

/**
 * Created by sriramangajala on 22/01/16.
 */
public class Snap implements CommandLineRunner {

    public void setupCORSHeaders() {
        stubFor(options(urlMatching("/.*"))
                .willReturn(aResponse()
                                .withHeader("Access-Control-Allow-Origin", "*")
                                .withHeader("Access-Control-Allow-Credentials", "true")
                                .withHeader("Access-Control-Allow-Headers", "accept, cid")
                                .withHeader("Access-Control-Request-Headers", "accept, cid")
                                .withHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE")

                                .withHeader("Content-Type", "application/json")
                                .withStatus(200)

                ));

    }

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Snap.class, args);
    }

    public void run(String... args) throws Exception {

//        WireMock.configureFor("stubs-services.trainz.io",8080);
        if(System.getProperty("URL")==null||System.getProperty("PORT")==null)
            WireMock.configureFor(Constants.URL, Constants.PORT);
        else
            WireMock.configureFor(System.getProperty("URL"), Integer.parseInt(System.getProperty("PORT")));

//        try
//        {
//
//            resetAllRequests();
//            resetToDefault();
////            WireMock.reset();
//
//        }
//        catch (VerificationException e)
        {
            setupCORSHeaders();

            Snap_Bookings bookings = new Snap_Bookings();

            bookings.pnr_blank();
            bookings.error_500();
            bookings.pos_invalid();
            bookings.old_pnr();
            bookings.no_access();
            bookings.no_access_key_field();
            bookings.booking_already_created();
            bookings.booking_success_happy_path();
            bookings.pnr_not_found_in_SBE();
            bookings.get_refresh_booking_fail();
            bookings.get_refresh_booking_success();
            bookings.booking_RuntimeException();
            bookings.no_access_key();
            bookings.no_access_key_field_infant_post();


            Infant infant = new Infant();

            infant.post_infant_booking_already_created();
            infant.post_infant_booking_pnr_access_not_found();
            infant.post_infant_passenger_id_unknown();
            infant.infant_get_success();
            infant.infant_post_success();



            Enovation_apis satishStuff = new Enovation_apis();

            satishStuff.reference();
            satishStuff.proposals();
//            satishStuff.proposals_inbound();
            satishStuff.ods();
//            satishStuff.proposals_more();
//            satishStuff.ods_500();
//            satishStuff.ods_400();
//            satishStuff.proposals_500();
//            satishStuff.proposals_300();
            satishStuff.proposals_euro();
            satishStuff.login();
//            satishStuff.invalid_login();
//            satishStuff.invalid_login_401();
            satishStuff.gameConfig();
            satishStuff.getGames();


            AccountsMockServer accountsMockServer = new AccountsMockServer();

            accountsMockServer.accountsJson();
            accountsMockServer.optionstest();
            accountsMockServer.postcode();
            accountsMockServer.register();
            accountsMockServer.epp_user();
            accountsMockServer.engaged_user();
            accountsMockServer.getEPPCustomerDetails();
//            accountsMockServer.getEngagedCustomerDetails();
//            accountsMockServer.getOutboundData();
//            accountsMockServer.getInboundData();
//            accountsMockServer.logOut();


            Enovation_payment enovationPayment = new Enovation_payment();
            enovationPayment.setuppayment_200();
//            enovationPayment.setuppayment_500();
            enovationPayment.querypayment_200();
            enovationPayment.querypayment_400();
            enovationPayment.creditcard_200();
            enovationPayment.checkout_200();


//            Enov_Stubs enov_stubs = new Enov_Stubs();
            satishStuff.booking();

            saveAllMappings();
//
        }



    }
}
