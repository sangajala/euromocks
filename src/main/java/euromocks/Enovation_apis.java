package euromocks;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.CommandLineRunner;

import java.io.FileReader;
import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

/**
 * Created by sriramangajala on 22/01/16.
 */
public class Enovation_apis {


    public void ods() throws IOException {
        JSONParser parser = new JSONParser();

        FileReader fileReader = new FileReader("src/main/resources/euromocks/enovation/ods.json");
        try {
            JSONObject json = (JSONObject) parser.parse(fileReader);
            stubFor(get(urlPathMatching("/enov/availabilities/ods"))
                            .willReturn(
                                    aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody(json.toJSONString())
                                             .withHeader("Content-Type", "application/json")
                                            .withHeader("Access-Control-Allow-Origin", "*")
                                            .withHeader("Access-Control-Allow-Credentials", "true")
                                            .withHeader("Access-Control-Allow-Headers", "accept, cid")
                                            .withHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE")
                                            .withHeader("Content-Type", "application/json"))


                            .atPriority(1)
            );

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void ods_500() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/main/resources/euromocks/enovation/ods_500.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);

            stubFor(get(urlEqualTo("/enov/availabilities/ods?pos=error"))
                            .willReturn(
                                    aResponse().withStatus(500).withHeader("Content-Type", "application/json").withBody(json.toJSONString())
                                            .withHeader("Access-Control-Allow-Origin", "*")
                                            .withHeader("Access-Control-Allow-Credentials", "true")
                                            .withHeader("Access-Control-Allow-Headers", "accept, cid")
                                            .withHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE")
                                            .withHeader("Content-Type", "application/json"))

            );

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public void ods_400() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/main/resources/euromocks/enovation/ods_500.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);

            stubFor(get(urlEqualTo("/enov/availabilities/ods?pos=400"))
                            .willReturn(
                                    aResponse().withStatus(500).withHeader("Content-Type", "application/json").withBody(json.toJSONString()))

            );

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void proposals() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/main/resources/euromocks/enovation/proposals.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);
            //String response = IOUtils.toString(this.getClass().getResourceAsStream("/euromocks/ods1.json"), "UTF-8");
            stubFor(post(urlPathMatching("/enov/availabilities/proposals"))
                            //   .withRequestBody(containing("\"noOfPassengers\":\"2\""))
                            .willReturn(
                                    aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody(json.toJSONString())
                                            .withHeader("Access-Control-Allow-Origin", "*")
                                            .withHeader("Access-Control-Allow-Credentials", "true")
                                            .withHeader("Access-Control-Allow-Headers", "accept, cid,Content-Type")
                                            .withHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE")
                                      .withHeader("Content-Type", "application/json")
                            )
                            .atPriority(49)

            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void proposals_more() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/main/resources/euromocks/enovation/proposals_300.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);
            //String response = IOUtils.toString(this.getClass().getResourceAsStream("/euromocks/ods1.json"), "UTF-8");
            stubFor(post(urlPathMatching("/enov/availabilities/proposals"))
//                            .withRequestBody(containing("\"noOfPassengers\":\"2\""))
                            .willReturn(
                                    aResponse().withStatus(412).withHeader("Content-Type", "application/json").withBody(json.toJSONString())
                                            .withHeader("Access-Control-Allow-Origin", "*")
                                            .withHeader("Access-Control-Allow-Credentials", "true")
                                            .withHeader("Access-Control-Allow-Headers", "accept, cid")
                                            .withHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE"))
                            .atPriority(42)

            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void proposals_inbound() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/main/resources/euromocks/enovation/proposals_inbound.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);
            //String response = IOUtils.toString(this.getClass().getResourceAsStream("/euromocks/ods1.json"), "UTF-8");
            stubFor(post(urlPathMatching("/enov/availabilities/proposals"))
//                            .withRequestBody(containing("\"noOfPassengers\":\"3\""))
                            .withRequestBody(containing("\"journeyType\":\"ONEWAY\""))
                            .willReturn(
                                    aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody(json.toJSONString())
                                            .withHeader("Access-Control-Allow-Origin", "*")
                                            .withHeader("Access-Control-Allow-Credentials", "true")
                                            .withHeader("Access-Control-Allow-Headers", "accept, cid")
                                            .withHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE"))
                            .atPriority(45)

            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void proposals_euro() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/main/resources/euromocks/enovation/proposals_euro.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);
            //String response = IOUtils.toString(this.getClass().getResourceAsStream("/euromocks/ods1.json"), "UTF-8");
            stubFor(post(urlPathEqualTo("/enov/availabilities/proposals"))
                            .withRequestBody(containing("\"noOfPassengers\":\"3\""))
                            .willReturn(
                                    aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody(json.toJSONString())
                                            .withHeader("Access-Control-Allow-Origin", "*")
                                            .withHeader("Access-Control-Allow-Credentials", "true")
                                            .withHeader("Access-Control-Allow-Headers", "accept, cid")
                                            .withHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE"))
                            .atPriority(46)

            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void proposals_500() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/main/resources/euromocks/enovation/proposals_500.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);
            stubFor(post(urlPathEqualTo("/enov/availabilities/proposals?pos=error"))

                            .willReturn(
                                    aResponse().withStatus(500).withHeader("Content-Type", "application/json").withBody(json.toJSONString())
                                            .withHeader("Access-Control-Allow-Origin", "*")
                                            .withHeader("Access-Control-Allow-Credentials", "true")
                                            .withHeader("Access-Control-Allow-Headers", "accept, cid")
                                            .withHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE"))

            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void proposals_300() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/main/resources/euromocks/enovation/proposals_300.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);
            stubFor(post(urlPathMatching("/enov/availabilities/proposals"))
                            .withRequestBody(containing("\"noOfPassengers\":\"4\""))

                            .willReturn(
                                    aResponse().withStatus(412).withHeader("Content-Type", "application/json").withBody(json.toJSONString())
                                            .withHeader("Access-Control-Allow-Origin", "*")
                                            .withHeader("Access-Control-Allow-Credentials", "true")
                                            .withHeader("Access-Control-Allow-Headers", "accept, cid")
                                            .withHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE"))

            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void login() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/main/resources/euromocks/enovation/login.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);
            stubFor(post(urlPathMatching("/enov/players/signin"))
//                            .withRequestBody(containing("valid"))
                            .willReturn(
                                    aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody(json.toJSONString())
                                            .withHeader("Access-Control-Allow-Origin", "*")
                                            .withHeader("Access-Control-Allow-Credentials", "true")
                                            .withHeader("Access-Control-Allow-Headers", "accept, cid")
                                            .withHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE")
                                            .withHeader("Content-Type", "application/json"))

                            .atPriority(52));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void invalid_login() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/main/resources/euromocks/enovation/login_500.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);
            stubFor(post(urlPathEqualTo("/enov/players/signin"))
                    .withRequestBody(containing("mobile"))
                    .willReturn(
                            aResponse().withStatus(500).withHeader("Content-Type", "application/json").withBody(json.toJSONString())
                                    .withHeader("Access-Control-Allow-Origin", "*")
                                    .withHeader("Access-Control-Allow-Credentials", "true")
                                    .withHeader("Access-Control-Allow-Headers", "accept, cid")
                                    .withHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE"))

                    .atPriority(51));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void invalid_login_401() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/main/resources/euromocks/enovation/login_401.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);
            stubFor(post(urlPathEqualTo("/enov/players/signin"))
                    .withRequestBody(containing("sriram"))
                    .willReturn(
                            aResponse().withStatus(412).withHeader("Content-Type", "application/json").withBody(json.toJSONString())
                                    .withHeader("Access-Control-Allow-Origin", "*")
                                    .withHeader("Access-Control-Allow-Credentials", "true")
                                    .withHeader("Access-Control-Allow-Headers", "accept, cid")
                                    .withHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE"))

                    .atPriority(51));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void gameConfig() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/main/resources/euromocks/enovation/games_eno100.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);
            stubFor(get(urlPathMatching("/enov/games/GAME1"))
                    //    .withQueryParam("sessionId", containing(".*"))
                    .willReturn(
//                            aResponse().withStatus(412).withHeader("Content-Type", "application/json").withBody(json.toJSONString())

                            aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody("{\n" +
                                    "  \"code\" : \"GAME1\",\n" +
                                    "  \"saleStartDate\" : \"2016-04-01\",\n" +
                                    "  \"saleEndDate\" : \"2016-05-20\",\n" +
                                    "  \"travelStartDate\" : \"2016-04-01\",\n" +
                                    "  \"travelEndDate\" : \"2016-05-29\",\n" +
                                    "  \"refCodeExpiry\" : 7,\n" +
                                    "  \"maxPassengers\" : 4,\n" +
                                    "  \"minPassengers\" : 2,\n" +
                                    "  \"minAge\" : 16,\n" +
                                    "  \"classOfService\" : \"STANDARD\",\n" +
                                    "  \"tripType\" : \"FLEXIBLE\",\n" +
                                    "  \"lastUpdated\" : \"2016-04-13T16:23:11\",\n" +
                                    "  \"reminderBeforeTravel\" : 2,\n" +
                                    "  \"displayPrice\" : true\n" +
                                    "}")
//                                    .withBody(""))
                                    .withHeader("Access-Control-Allow-Origin", "*")
                                    .withHeader("Access-Control-Allow-Credentials", "true")
                                    .withHeader("Access-Control-Allow-Headers", "accept, cid")
                                    .withHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE")
                    .withHeader("Content-Type", "application/json"))

                    .atPriority(60));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getGames() throws IOException {
        JSONParser parser = new JSONParser();
        try {
//            FileReader fileReader = new FileReader("src/main/resources/euromocks/enovation/listOfGames.json");
//            JSONObject json = (JSONObject) parser.parse(fileReader);
            stubFor(get(urlPathEqualTo("/enov/games"))
                    //    .withQueryParam("sessionId", containing(".*"))
                    .willReturn(
//                            aResponse().withFixedDelay(10000).withStatus(422).withHeader("Content-Type", "application/json").withBody("{\n" +
//                                                    " \"errors\" : [ {\n" +
//                                                    "   \"code\" : \"ENO_102\",\n" +
//                                                    "   \"message\" : \"Game in the request pastGame is expired\"\n" +
//                                                    " } ]\n" +
//                                                    "}"

//                            aResponse().withFixedDelay(120000).withStatus(200).withHeader("Content-Type", "application/json").withBody(json.toJSONString()
                            aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody(
                                    "[ {\n" +
                                            "  \"code\" : \"GAME1\",\n" +
                                            "  \"saleStartDate\" : \"2016-03-01\",\n" +
                                            "  \"saleEndDate\" : \"2016-03-20\",\n" +
                                            "  \"travelStartDate\" : \"2016-04-01\",\n" +
                                            "  \"travelEndDate\" : \"2016-05-29\",\n" +
                                            "  \"refCodeExpiry\" : 7,\n" +
                                            "  \"maxPassengers\" : 10,\n" +
                                            "  \"minPassengers\" : 1,\n" +
                                            "  \"minAge\" : 9,\n" +
                                            "  \"classOfService\" : \"STANDARD\",\n" +
                                            "  \"tripType\" : \"SINGLE_ONLY\",\n" +
                                            "  \"lastUpdated\" : \"2016-04-13T16:23:11\",\n" +
                                            "  \"reminderBeforeTravel\" : 2,\n" +
                                            "  \"displayPrice\" : true\n" +
                                            "} ]"
//                                    "  {\n" +
//                                    "    \"code\": \"GAME2\",\n" +
//                                    "    \"startDate\": \"2016-06-01\",\n" +
//                                    "    \"endDate\": \"2016-05-20\",\n" +
//                                    "    \"refCodeExpiry\": 7,\n" +
//                                    "    \"maxPassengers\": 4,\n" +
//                                    "    \"minPassengers\": 1,\n" +
//                                    "    \"classOfService\": \"STANDARD\",\n" +
//                                    "    \"lastUpdated\": \"2016-08-30T22:05:01\",\n" +
//                                    "    \"reminderBeforeTravel\": 2\n" +
//                                    "  },\n" +
//                                    "  {\n" +
//                                    "    \"code\": \"GAME3\",\n" +
//                                    "    \"startDate\": \"2016-09-01\",\n" +
//                                    "    \"endDate\": \"2016-05-20\",\n" +
//                                    "    \"refCodeExpiry\": 7,\n" +
//                                    "    \"maxPassengers\": 4,\n" +
//                                    "    \"minPassengers\": 1,\n" +
//                                    "    \"classOfService\": \"STANDARD\",\n" +
//                                    "    \"lastUpdated\": \"2016-10-23T22:05:01\",\n" +
//                                    "    \"reminderBeforeTravel\": 2\n" +
//                                    "  },\n" +
//                                    "  {\n" +
//                                    "    \"code\": \"testGame1\",\n" +
//                                    "    \"startDate\": \"2016-04-20\",\n" +
//                                    "    \"endDate\": \"2016-05-20\",\n" +
//                                    "    \"refCodeExpiry\": 7,\n" +
//                                    "    \"maxPassengers\": 4,\n" +
//                                    "    \"minPassengers\": 2,\n" +
//                                    "    \"maxAge\": 25,\n" +
//                                    "    \"minAge\": 16,\n" +
//                                    "    \"classOfService\": \"STANDARD\",\n" +
//                                    "    \"lastUpdated\": \"2016-03-08T15:43:02\",\n" +
//                                    "    \"reminderBeforeTravel\": 2\n" +
//                                    "  },\n" +
//                                    "  {\n" +
//                                    "    \"code\": \"testGame2\",\n" +
//                                    "    \"startDate\": \"2016-04-20\",\n" +
//                                    "    \"endDate\": \"2016-05-20\",\n" +
//                                    "    \"refCodeExpiry\": 7,\n" +
//                                    "    \"maxPassengers\": 4,\n" +
//                                    "    \"minPassengers\": 2,\n" +
//                                    "    \"maxAge\": 25,\n" +
//                                    "    \"minAge\": 16,\n" +
//                                    "    \"classOfService\": \"STANDARD\",\n" +
//                                    "    \"lastUpdated\": \"2016-03-08T15:45:28\",\n" +
//                                    "    \"reminderBeforeTravel\": 2\n" +
//                                    "  },\n" +
//                                    "  {\n" +
//                                    "    \"code\": \"testGame3\",\n" +
//                                    "    \"startDate\": \"2016-04-25\",\n" +
//                                    "    \"endDate\": \"2016-05-25\",\n" +
//                                    "    \"refCodeExpiry\": 7,\n" +
//                                    "    \"maxPassengers\": 4,\n" +
//                                    "    \"minPassengers\": 2,\n" +
//                                    "    \"maxAge\": 25,\n" +
//                                    "    \"minAge\": 16,\n" +
//                                    "    \"classOfService\": \"STANDARD\",\n" +
//                                    "    \"lastUpdated\": \"2016-03-08T15:45:34\",\n" +
//                                    "    \"reminderBeforeTravel\": 2\n" +
//                                    "  }\n" +
                            )
                                    .withHeader("Access-Control-Allow-Origin", "*")
                                    .withHeader("Access-Control-Allow-Credentials", "true")
                                    .withHeader("Access-Control-Allow-Headers", "accept, cid")
                                    .withHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE")
                    )

                    .atPriority(61));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void booking() throws IOException {
        JSONParser parser = new JSONParser();

        FileReader fileReader = new FileReader("src/main/resources/euromocks/enovation/booking.json");
        try {
            JSONObject json = (JSONObject) parser.parse(fileReader);
            stubFor(get(urlPathMatching("/enov/players/bookings"))
                            .willReturn(
                                    aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody(json.toJSONString())
                                            .withHeader("Content-Type", "application/json")
                                            .withHeader("Access-Control-Allow-Origin", "*")
                                            .withHeader("Access-Control-Allow-Credentials", "true")
                                            .withHeader("Access-Control-Allow-Headers", "accept, cid")
                                            .withHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE")
                                            .withHeader("Content-Type", "application/json"))


                            .atPriority(1)
            );

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    public void reference() throws IOException {
        stubFor(get(urlPathMatching("/enov/play/.*"))
                        .willReturn(
                                aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody(responseData.getReference()))

        );
    }
//
//
//    public void run(String... strings) throws Exception {
//
//    }
}


