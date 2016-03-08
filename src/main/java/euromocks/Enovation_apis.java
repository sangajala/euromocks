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
public class Enovation_apis implements CommandLineRunner {


    public void ods() throws IOException {
        JSONParser parser = new JSONParser();

        FileReader fileReader = new FileReader("src/main/resources/euromocks/enovation/ods.json");
        try {
            JSONObject json = (JSONObject) parser.parse(fileReader);

            stubFor(get(urlPathMatching("/enov/ods"))
                            .willReturn(
                                    aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody(json.toJSONString()))

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

            stubFor(get(urlEqualTo("/enov/ods?pos=error"))
                            .willReturn(
                                    aResponse().withStatus(500).withHeader("Content-Type", "application/json").withBody(json.toJSONString()))

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

            stubFor(get(urlEqualTo("/enov/ods?pos=400"))
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
            stubFor(post(urlPathEqualTo("/enov/proposals"))
                            //   .withRequestBody(containing("\"noOfPassengers\":\"2\""))
                            .willReturn(
                                    aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody(json.toJSONString())
                                            .withHeader("Access-Control-Allow-Origin", "*")
                                            .withHeader("Access-Control-Allow-Credentials", "true")
                                            .withHeader("Access-Control-Allow-Headers", "accept, cid")
                                            .withHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE"))
                            .atPriority(43)

            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void proposals_more() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/main/resources/euromocks/enovation/proposals_more.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);
            //String response = IOUtils.toString(this.getClass().getResourceAsStream("/euromocks/ods1.json"), "UTF-8");
            stubFor(post(urlPathEqualTo("/enov/proposals"))
                            .withRequestBody(containing("\"noOfPassengers\":\"2\""))
                            .willReturn(
                                    aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody(json.toJSONString())
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

    public void proposals_euro() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/main/resources/euromocks/enovation/proposals_euro.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);
            //String response = IOUtils.toString(this.getClass().getResourceAsStream("/euromocks/ods1.json"), "UTF-8");
            stubFor(post(urlPathEqualTo("/enov/proposals"))
                            .withRequestBody(containing("\"noOfPassengers\":\"3\""))
                            .willReturn(
                                    aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody(json.toJSONString())
                                            .withHeader("Access-Control-Allow-Origin", "*")
                                            .withHeader("Access-Control-Allow-Credentials", "true")
                                            .withHeader("Access-Control-Allow-Headers", "accept, cid")
                                            .withHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE"))
                            .atPriority(41)

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
            stubFor(post(urlPathEqualTo("/enov/proposals?pos=error"))

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

    public void login() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/main/resources/euromocks/enovation/login.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);
            stubFor(post(urlPathEqualTo("/enov/players/signin"))
//                            .withRequestBody(containing("valid"))
                            .willReturn(
                                    aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody(json.toJSONString())
                                            .withHeader("Access-Control-Allow-Origin", "*")
                                            .withHeader("Access-Control-Allow-Credentials", "true")
                                            .withHeader("Access-Control-Allow-Headers", "accept, cid")
                                            .withHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE"))

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
                    .withRequestBody(containing("invalid"))
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

    public void gameConfig() throws IOException {
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("src/main/resources/euromocks/enovation/gameConfig.json");
            JSONObject json = (JSONObject) parser.parse(fileReader);
            stubFor(get(urlPathEqualTo("/enov/games/GAME1?sessionId=snapsession1"))
                //    .withQueryParam("sessionId", containing(".*"))
                    .willReturn(
                            aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody(json.toJSONString())
                                    .withHeader("Access-Control-Allow-Origin", "*")
                                    .withHeader("Access-Control-Allow-Credentials", "true")
                                    .withHeader("Access-Control-Allow-Headers", "accept, cid")
                                    .withHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE"))

                    .atPriority(61));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getGames() throws IOException {
   //     JSONParser parser = new JSONParser();
        try {
          //  FileReader fileReader = new FileReader("src/main/resources/euromocks/enovation/listOfGames.json");
            //JSONObject json = (JSONObject) parser.parse(fileReader);
            stubFor(get(urlPathEqualTo("/enov/games?sessionid=snapsession1"))
                    //    .withQueryParam("sessionId", containing(".*"))
                    .willReturn(
                            aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody("[\n" +
                                    "  {\n" +
                                    "    \"code\": \"GAME1\",\n" +
                                    "    \"startDate\": \"2016-01-01\",\n" +
                                    "    \"endDate\": \"2016-05-20\",\n" +
                                    "    \"refCodeExpiry\": 7,\n" +
                                    "    \"maxPassengers\": 4,\n" +
                                    "    \"minPassengers\": 1,\n" +
                                    "    \"classOfService\": \"STANDARD\",\n" +
                                    "    \"lastUpdated\": \"2016-05-30T22:05:01\"\n" +
                                    "  }\n" +
                                    "]")
                                    .withHeader("Access-Control-Allow-Origin", "*")
                                    .withHeader("Access-Control-Allow-Credentials", "true")
                                    .withHeader("Access-Control-Allow-Headers", "accept, cid")
                                    .withHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE"))

                    .atPriority(61));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void reference() throws IOException {
        stubFor(get(urlPathMatching("/enov/play/.*"))
                        .willReturn(
                                aResponse().withStatus(200).withHeader("Content-Type", "application/json").withBody(responseData.getReference()))

        );
    }


    public void run(String... strings) throws Exception {

    }
}


