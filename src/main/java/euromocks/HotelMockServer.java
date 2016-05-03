package euromocks;

import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class HotelMockServer
{

    @Test
    public void postcode() {
        stubFor(get(urlMatching("/services/getAddress.php?.*"))
                .willReturn(aResponse()
                                .withHeader("Access-Control-Allow-Origin", "*")
                                .withHeader("Access-Control-Allow-Credentials", "true")
                                .withHeader("Access-Control-Allow-Headers", "x-requested -with, Content-Type, Accept,Authorization, cid")
                                .withHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE")
                                .withStatus(200)
                                .withBody("[{\n" +
                                        "  \"address\": \"10 Downing Street, London\"\n" +
                                        "}, {\n" +
                                        "  \"address\": \"1 Buckingham Palace, London\"\n" +
                                        "}]")

                ));

    }

    @Test
    public void register() throws Exception{

       // String response = IOUtils.toString(this.getClass().getResourceAsStream("/euromocks/reg.json"), "UTF-8");

        stubFor(post(urlEqualTo("/services/userActions.php"))
                .withRequestBody(containing("submissionType=create"))
                        .withRequestBody(containing("mailinator.com"))
                .willReturn(aResponse()
                        .withStatus(200).withHeader("Content-Type", "application/json").withBody("{  \n" +
                                "   \"status\":\"success\",\n" +
                                "   \"action_type\":\"user_login\",\n" +
                                "   \"user_id\":\"149941\",\n" +
                                "   \"details\":{  \n" +
                                "      \"user_id\":\"149941\",\n" +
                                "      \"app_code\":\"hyderbad\",\n" +
                                "      \"user_username\":\"test13@mailinator.com\",\n" +
                                "      \"user_password\":\"password\",\n" +
                                "      \"user_device_id\":\"097bfdbe68dd5ba5dfd316d21dd266529bf193ef2d985480c13be1c3e6bbcd13\",\n" +
                                "      \"user_device_uuid\":\"1548A942-E3A3-482C-8818-82DAC336E2E2\",\n" +
                                "      \"user_isiphone\":\"1\",\n" +
                                "      \"user_push_active\":\"1\",\n" +
                                "      \"user_fullname\":\"test\",\n" +
                                "      \"user_firstname\":null,\n" +
                                "      \"user_email\":\"test13@mailinator.com\",\n" +
                                "      \"user_phone\":\"07453289655\",\n" +
                                "      \"user_postcode\":\"E62ea\",\n" +
                                "      \"user_address\":\"123 Lathom Road, London\",\n" +
                                "      \"user_added\":\"2016-01-20 17:53:07\",\n" +
                                "      \"user_action_notifications\":\"false\",\n" +
                                "      \"user_total_spend\":\"17.45\",\n" +
                                "      \"user_loyalty_earned\":\"0.00\",\n" +
                                "      \"user_loyalty_claimed\":\"0.00\",\n" +
                                "      \"user_loyalty_available\":\"0.00\",\n" +
                                "      \"user_lat\":\"51.53114239514528\",\n" +
                                "      \"user_lng\":\"-0.1219382584781515\",\n" +
                                "      \"push_notification_optout\":\"0\",\n" +
                                "      \"user_last_login\":null,\n" +
                                "      \"user_modified\":\"2016-01-20 18:14:49\",\n" +
                                "      \"user_deleted\":\"0\"\n" +
                                "   }\n" +
                                "}"))

                );

    }


    @Test
    public void login() throws Exception{

        // String response = IOUtils.toString(this.getClass().getResourceAsStream("/euromocks/reg.json"), "UTF-8");

        stubFor(post(urlEqualTo("/services/userActions.php"))
                        .withRequestBody(containing("submissionType=login"))
                        .withRequestBody(containing("test13%40mailinator.com"))
                        .willReturn(aResponse()
                                .withStatus(200).withHeader("Content-Type", "application/json").withBody("{\n" +
                                        "\t\"status\": \"success\",\n" +
                                        "\t\"action_type\": \"user_login\",\n" +
                                        "\t\"user_id\": \"149941\",\n" +
                                        "\t\"details\": {\n" +
                                        "\t\t\"user_id\": \"149941\",\n" +
                                        "\t\t\"app_code\": \"hyderbad\",\n" +
                                        "\t\t\"user_username\": \"test13@mailinator.com\",\n" +
                                        "\t\t\"user_password\": \"password\",\n" +
                                        "\t\t\"user_device_id\": \"097bfdbe68dd5ba5dfd316d21dd266529bf193ef2d985480c13be1c3e6bbcd13\",\n" +
                                        "\t\t\"user_device_uuid\": \"1548A942-E3A3-482C-8818-82DAC336E2E2\",\n" +
                                        "\t\t\"user_isiphone\": \"1\",\n" +
                                        "\t\t\"user_push_active\": \"1\",\n" +
                                        "\t\t\"user_fullname\": \"test\",\n" +
                                        "\t\t\"user_firstname\": null,\n" +
                                        "\t\t\"user_email\": \"test13@mailinator.com\",\n" +
                                        "\t\t\"user_phone\": \"07453289655\",\n" +
                                        "\t\t\"user_postcode\": \"E62ea\",\n" +
                                        "\t\t\"user_address\": \"123 Lathom Road, London\",\n" +
                                        "\t\t\"user_added\": \"2016-01-20 17:53:07\",\n" +
                                        "\t\t\"user_action_notifications\": \"false\",\n" +
                                        "\t\t\"user_total_spend\": \"31.45\",\n" +
                                        "\t\t\"user_loyalty_earned\": \"0.00\",\n" +
                                        "\t\t\"user_loyalty_claimed\": \"0.00\",\n" +
                                        "\t\t\"user_loyalty_available\": \"0.00\",\n" +
                                        "\t\t\"user_lat\": \"51.53114263432779\",\n" +
                                        "\t\t\"user_lng\": \"-0.1219403316542824\",\n" +
                                        "\t\t\"push_notification_optout\": \"0\",\n" +
                                        "\t\t\"user_last_login\": null,\n" +
                                        "\t\t\"user_modified\": \"2016-01-21 11:56:19\",\n" +
                                        "\t\t\"user_deleted\": \"0\"\n" +
                                        "\t}\n" +
                                        "}"))

        );

        stubFor(post(urlEqualTo("/services/userActions.php"))
                        .withRequestBody(containing("submissionType=login"))
                        .withRequestBody(containing("test12%40mailinator.com"))
                        .willReturn(aResponse()
                                .withStatus(200).withHeader("Content-Type", "application/json").withBody("{\n" +
                                        "\t\"status\": \"success\",\n" +
                                        "\t\"action_type\": \"user_login\",\n" +
                                        "\t\"user_id\": \"148755\",\n" +
                                        "\t\"details\": {\n" +
                                        "\t\t\"user_id\": \"148755\",\n" +
                                        "\t\t\"app_code\": \"hyderbad\",\n" +
                                        "\t\t\"user_username\": \"test12@mailinator.com\",\n" +
                                        "\t\t\"user_password\": \"password\",\n" +
                                        "\t\t\"user_device_id\": \"097bfdbe68dd5ba5dfd316d21dd266529bf193ef2d985480c13be1c3e6bbcd13\",\n" +
                                        "\t\t\"user_device_uuid\": \"1548A942-E3A3-482C-8818-82DAC336E2E2\",\n" +
                                        "\t\t\"user_isiphone\": \"1\",\n" +
                                        "\t\t\"user_push_active\": \"1\",\n" +
                                        "\t\t\"user_fullname\": \"new\",\n" +
                                        "\t\t\"user_firstname\": null,\n" +
                                        "\t\t\"user_email\": \"test12@mailinator.com\",\n" +
                                        "\t\t\"user_phone\": \"07453289655\",\n" +
                                        "\t\t\"user_postcode\": \"E62ea\",\n" +
                                        "\t\t\"user_address\": \"125 Lathom Road, London\",\n" +
                                        "\t\t\"user_added\": \"2016-01-19 17:01:23\",\n" +
                                        "\t\t\"user_action_notifications\": \"false\",\n" +
                                        "\t\t\"user_total_spend\": \"55.88\",\n" +
                                        "\t\t\"user_loyalty_earned\": \"0.00\",\n" +
                                        "\t\t\"user_loyalty_claimed\": \"0.00\",\n" +
                                        "\t\t\"user_loyalty_available\": \"0.00\",\n" +
                                        "\t\t\"user_lat\": \"51.53114263432779\",\n" +
                                        "\t\t\"user_lng\": \"-0.1219403316542824\",\n" +
                                        "\t\t\"push_notification_optout\": \"0\",\n" +
                                        "\t\t\"user_last_login\": null,\n" +
                                        "\t\t\"user_modified\": \"2016-01-20 18:24:00\",\n" +
                                        "\t\t\"user_deleted\": \"0\"\n" +
                                        "\t}\n" +
                                        "}"))

        );

    }


    @Test
    public void getHistory() throws Exception{

        // String response = IOUtils.toString(this.getClass().getResourceAsStream("/euromocks/reg.json"), "UTF-8");

        stubFor(post(urlEqualTo("/services/userActions.php"))
                        .withRequestBody(containing("action=get_user_actions"))
                        .withRequestBody(containing("user_id=149941"))
                        .willReturn(aResponse()
                                .withStatus(200).withHeader("Content-Type", "application/json").withBody("[{\n" +
                                        "\t\"app_code\": \"hyderbad\",\n" +
                                        "\t\"fetched\": false,\n" +
                                        "\t\"action_id\": \"894251\",\n" +
                                        "\t\"action_parent_id\": \"0\",\n" +
                                        "\t\"tab_id\": 0,\n" +
                                        "\t\"user_id\": \"149941\",\n" +
                                        "\t\"action_type\": \"takeaway\",\n" +
                                        "\t\"action_subtype\": null,\n" +
                                        "\t\"action_blob\": \"{\\\"items\\\":[{\\\"id\\\":\\\"143482\\\",\\\"category\\\":\\\"Special Offer\\\",\\\"name\\\":\\\"Dum Chicken Biryani Family pack\\\",\\\"note\\\":\\\"\\\",\\\"ordered_price\\\":\\\"14.00\\\"}],\\\"client_info\\\":{\\\"name\\\":\\\"test\\\",\\\"phone\\\":\\\"07453289655\\\",\\\"device_uuid\\\":\\\"1548A942-E3A3-482C-8818-82DAC336E2E2\\\",\\\"device_id\\\":\\\"097bfdbe68dd5ba5dfd316d21dd266529bf193ef2d985480c13be1c3e6bbcd13\\\",\\\"payment_method\\\":\\\"Cash\\\",\\\"email\\\":\\\"test13@mailinator.com\\\",\\\"postcode\\\":\\\"E62ea\\\",\\\"address\\\":\\\"123 Lathom Road, London\\\"},\\\"internal_info\\\":{},\\\"delivery_type\\\":\\\"Collection\\\",\\\"delivery_time\\\":\\\"asap\\\",\\\"appcode\\\":\\\"hyderbad\\\",\\\"total_price\\\":14}\",\n" +
                                        "\t\"encrypted_blob\": \"0\",\n" +
                                        "\t\"action_url\": null,\n" +
                                        "\t\"action_datetime\": \"2016-01-21 11:56:19\",\n" +
                                        "\t\"action_lat\": null,\n" +
                                        "\t\"action_lon\": null,\n" +
                                        "\t\"backup_action_blob\": null,\n" +
                                        "\t\"action_deleted\": \"0\",\n" +
                                        "\t\"user_fullname\": \"test\",\n" +
                                        "\t\"user_username\": \"test13@mailinator.com\",\n" +
                                        "\t\"user_email\": \"test13@mailinator.com\",\n" +
                                        "\t\"user_phone\": \"07453289655\",\n" +
                                        "\t\"user_postcode\": \"E62ea\",\n" +
                                        "\t\"user_address\": \"123 Lathom Road, London\"\n" +
                                        "}, {\n" +
                                        "\t\"app_code\": \"hyderbad\",\n" +
                                        "\t\"fetched\": false,\n" +
                                        "\t\"action_id\": \"893669\",\n" +
                                        "\t\"action_parent_id\": \"0\",\n" +
                                        "\t\"tab_id\": 0,\n" +
                                        "\t\"user_id\": \"149941\",\n" +
                                        "\t\"action_type\": \"takeaway\",\n" +
                                        "\t\"action_subtype\": null,\n" +
                                        "\t\"action_blob\": \"{\\\"items\\\":[{\\\"id\\\":\\\"142963\\\",\\\"category\\\":\\\"Vegetarian Curries\\\",\\\"name\\\":\\\"Bendi Masala\\\",\\\"note\\\":\\\"\\\",\\\"ordered_price\\\":\\\"3.49\\\"},{\\\"id\\\":\\\"142963\\\",\\\"category\\\":\\\"Vegetarian Curries\\\",\\\"name\\\":\\\"Bendi Masala\\\",\\\"note\\\":\\\"\\\",\\\"ordered_price\\\":\\\"3.49\\\"},{\\\"id\\\":\\\"142963\\\",\\\"category\\\":\\\"Vegetarian Curries\\\",\\\"name\\\":\\\"Bendi Masala\\\",\\\"note\\\":\\\"\\\",\\\"ordered_price\\\":\\\"3.49\\\"},{\\\"id\\\":\\\"142963\\\",\\\"category\\\":\\\"Vegetarian Curries\\\",\\\"name\\\":\\\"Bendi Masala\\\",\\\"note\\\":\\\"\\\",\\\"ordered_price\\\":\\\"3.49\\\"},{\\\"id\\\":\\\"142963\\\",\\\"category\\\":\\\"Vegetarian Curries\\\",\\\"name\\\":\\\"Bendi Masala\\\",\\\"note\\\":\\\"\\\",\\\"ordered_price\\\":\\\"3.49\\\"}],\\\"client_info\\\":{\\\"name\\\":\\\"test user\\\",\\\"phone\\\":\\\"07453289655\\\",\\\"device_uuid\\\":\\\"1548A942-E3A3-482C-8818-82DAC336E2E2\\\",\\\"device_id\\\":\\\"097bfdbe68dd5ba5dfd316d21dd266529bf193ef2d985480c13be1c3e6bbcd13\\\",\\\"payment_method\\\":\\\"Cash\\\",\\\"email\\\":\\\"test13@mailinator.com\\\",\\\"postcode\\\":\\\"E62EA\\\",\\\"address\\\":\\\"127 Lathom Road, London\\\"},\\\"internal_info\\\":{},\\\"delivery_type\\\":\\\"Collection\\\",\\\"delivery_time\\\":\\\"asap\\\",\\\"appcode\\\":\\\"hyderbad\\\",\\\"total_price\\\":17.45}\",\n" +
                                        "\t\"encrypted_blob\": \"0\",\n" +
                                        "\t\"action_url\": null,\n" +
                                        "\t\"action_datetime\": \"2016-01-20 17:55:30\",\n" +
                                        "\t\"action_lat\": null,\n" +
                                        "\t\"action_lon\": null,\n" +
                                        "\t\"backup_action_blob\": null,\n" +
                                        "\t\"action_deleted\": \"0\",\n" +
                                        "\t\"user_fullname\": \"test\",\n" +
                                        "\t\"user_username\": \"test13@mailinator.com\",\n" +
                                        "\t\"user_email\": \"test13@mailinator.com\",\n" +
                                        "\t\"user_phone\": \"07453289655\",\n" +
                                        "\t\"user_postcode\": \"E62ea\",\n" +
                                        "\t\"user_address\": \"123 Lathom Road, London\"\n" +
                                        "}]"))

        );

        stubFor(post(urlEqualTo("/services/userActions.php"))
                        .withRequestBody(containing("action=get_user_actions"))
                        .withRequestBody(containing("user_id=148755"))
                        .willReturn(aResponse()
                                .withStatus(200).withHeader("Content-Type", "application/json").withBody("[{\n" +
                                        "\t\"app_code\": \"hyderbad\",\n" +
                                        "\t\"fetched\": false,\n" +
                                        "\t\"action_id\": \"894251\",\n" +
                                        "\t\"action_parent_id\": \"0\",\n" +
                                        "\t\"tab_id\": 0,\n" +
                                        "\t\"user_id\": \"149941\",\n" +
                                        "\t\"action_type\": \"takeaway\",\n" +
                                        "\t\"action_subtype\": null,\n" +
                                        "\t\"action_blob\": \"{\\\"items\\\":[{\\\"id\\\":\\\"143482\\\",\\\"category\\\":\\\"Special Offer\\\",\\\"name\\\":\\\"Dum Chicken Biryani Family pack\\\",\\\"note\\\":\\\"\\\",\\\"ordered_price\\\":\\\"14.00\\\"}],\\\"client_info\\\":{\\\"name\\\":\\\"test\\\",\\\"phone\\\":\\\"07453289655\\\",\\\"device_uuid\\\":\\\"1548A942-E3A3-482C-8818-82DAC336E2E2\\\",\\\"device_id\\\":\\\"097bfdbe68dd5ba5dfd316d21dd266529bf193ef2d985480c13be1c3e6bbcd13\\\",\\\"payment_method\\\":\\\"Cash\\\",\\\"email\\\":\\\"test13@mailinator.com\\\",\\\"postcode\\\":\\\"E62ea\\\",\\\"address\\\":\\\"123 Lathom Road, London\\\"},\\\"internal_info\\\":{},\\\"delivery_type\\\":\\\"Collection\\\",\\\"delivery_time\\\":\\\"asap\\\",\\\"appcode\\\":\\\"hyderbad\\\",\\\"total_price\\\":14}\",\n" +
                                        "\t\"encrypted_blob\": \"0\",\n" +
                                        "\t\"action_url\": null,\n" +
                                        "\t\"action_datetime\": \"2016-01-21 11:56:19\",\n" +
                                        "\t\"action_lat\": null,\n" +
                                        "\t\"action_lon\": null,\n" +
                                        "\t\"backup_action_blob\": null,\n" +
                                        "\t\"action_deleted\": \"0\",\n" +
                                        "\t\"user_fullname\": \"test\",\n" +
                                        "\t\"user_username\": \"test13@mailinator.com\",\n" +
                                        "\t\"user_email\": \"test13@mailinator.com\",\n" +
                                        "\t\"user_phone\": \"07453289655\",\n" +
                                        "\t\"user_postcode\": \"E62ea\",\n" +
                                        "\t\"user_address\": \"123 Lathom Road, London\"\n" +
                                        "},{\n" +
                                        "\t\"app_code\": \"hyderbad\",\n" +
                                        "\t\"fetched\": false,\n" +
                                        "\t\"action_id\": \"894251\",\n" +
                                        "\t\"action_parent_id\": \"0\",\n" +
                                        "\t\"tab_id\": 0,\n" +
                                        "\t\"user_id\": \"149941\",\n" +
                                        "\t\"action_type\": \"takeaway\",\n" +
                                        "\t\"action_subtype\": null,\n" +
                                        "\t\"action_blob\": \"{\\\"items\\\":[{\\\"id\\\":\\\"143482\\\",\\\"category\\\":\\\"Special Offer\\\",\\\"name\\\":\\\"Dum Chicken Biryani Family pack\\\",\\\"note\\\":\\\"\\\",\\\"ordered_price\\\":\\\"14.00\\\"}],\\\"client_info\\\":{\\\"name\\\":\\\"test\\\",\\\"phone\\\":\\\"07453289655\\\",\\\"device_uuid\\\":\\\"1548A942-E3A3-482C-8818-82DAC336E2E2\\\",\\\"device_id\\\":\\\"097bfdbe68dd5ba5dfd316d21dd266529bf193ef2d985480c13be1c3e6bbcd13\\\",\\\"payment_method\\\":\\\"Cash\\\",\\\"email\\\":\\\"test13@mailinator.com\\\",\\\"postcode\\\":\\\"E62ea\\\",\\\"address\\\":\\\"123 Lathom Road, London\\\"},\\\"internal_info\\\":{},\\\"delivery_type\\\":\\\"Collection\\\",\\\"delivery_time\\\":\\\"asap\\\",\\\"appcode\\\":\\\"hyderbad\\\",\\\"total_price\\\":14}\",\n" +
                                        "\t\"encrypted_blob\": \"0\",\n" +
                                        "\t\"action_url\": null,\n" +
                                        "\t\"action_datetime\": \"2016-01-21 11:56:19\",\n" +
                                        "\t\"action_lat\": null,\n" +
                                        "\t\"action_lon\": null,\n" +
                                        "\t\"backup_action_blob\": null,\n" +
                                        "\t\"action_deleted\": \"0\",\n" +
                                        "\t\"user_fullname\": \"test\",\n" +
                                        "\t\"user_username\": \"test13@mailinator.com\",\n" +
                                        "\t\"user_email\": \"test13@mailinator.com\",\n" +
                                        "\t\"user_phone\": \"07453289655\",\n" +
                                        "\t\"user_postcode\": \"E62ea\",\n" +
                                        "\t\"user_address\": \"123 Lathom Road, London\"\n" +
                                        "},{\n" +
                                        "\t\"app_code\": \"hyderbad\",\n" +
                                        "\t\"fetched\": false,\n" +
                                        "\t\"action_id\": \"894251\",\n" +
                                        "\t\"action_parent_id\": \"0\",\n" +
                                        "\t\"tab_id\": 0,\n" +
                                        "\t\"user_id\": \"149941\",\n" +
                                        "\t\"action_type\": \"takeaway\",\n" +
                                        "\t\"action_subtype\": null,\n" +
                                        "\t\"action_blob\": \"{\\\"items\\\":[{\\\"id\\\":\\\"143482\\\",\\\"category\\\":\\\"Special Offer\\\",\\\"name\\\":\\\"Dum Chicken Biryani Family pack\\\",\\\"note\\\":\\\"\\\",\\\"ordered_price\\\":\\\"14.00\\\"}],\\\"client_info\\\":{\\\"name\\\":\\\"test\\\",\\\"phone\\\":\\\"07453289655\\\",\\\"device_uuid\\\":\\\"1548A942-E3A3-482C-8818-82DAC336E2E2\\\",\\\"device_id\\\":\\\"097bfdbe68dd5ba5dfd316d21dd266529bf193ef2d985480c13be1c3e6bbcd13\\\",\\\"payment_method\\\":\\\"Cash\\\",\\\"email\\\":\\\"test13@mailinator.com\\\",\\\"postcode\\\":\\\"E62ea\\\",\\\"address\\\":\\\"123 Lathom Road, London\\\"},\\\"internal_info\\\":{},\\\"delivery_type\\\":\\\"Collection\\\",\\\"delivery_time\\\":\\\"asap\\\",\\\"appcode\\\":\\\"hyderbad\\\",\\\"total_price\\\":14}\",\n" +
                                        "\t\"encrypted_blob\": \"0\",\n" +
                                        "\t\"action_url\": null,\n" +
                                        "\t\"action_datetime\": \"2016-01-21 11:56:19\",\n" +
                                        "\t\"action_lat\": null,\n" +
                                        "\t\"action_lon\": null,\n" +
                                        "\t\"backup_action_blob\": null,\n" +
                                        "\t\"action_deleted\": \"0\",\n" +
                                        "\t\"user_fullname\": \"test\",\n" +
                                        "\t\"user_username\": \"test13@mailinator.com\",\n" +
                                        "\t\"user_email\": \"test13@mailinator.com\",\n" +
                                        "\t\"user_phone\": \"07453289655\",\n" +
                                        "\t\"user_postcode\": \"E62ea\",\n" +
                                        "\t\"user_address\": \"123 Lathom Road, London\"\n" +
                                        "},{\n" +
                                        "\t\"app_code\": \"hyderbad\",\n" +
                                        "\t\"fetched\": false,\n" +
                                        "\t\"action_id\": \"894251\",\n" +
                                        "\t\"action_parent_id\": \"0\",\n" +
                                        "\t\"tab_id\": 0,\n" +
                                        "\t\"user_id\": \"149941\",\n" +
                                        "\t\"action_type\": \"takeaway\",\n" +
                                        "\t\"action_subtype\": null,\n" +
                                        "\t\"action_blob\": \"{\\\"items\\\":[{\\\"id\\\":\\\"143482\\\",\\\"category\\\":\\\"Special Offer\\\",\\\"name\\\":\\\"Dum Chicken Biryani Family pack\\\",\\\"note\\\":\\\"\\\",\\\"ordered_price\\\":\\\"14.00\\\"}],\\\"client_info\\\":{\\\"name\\\":\\\"test\\\",\\\"phone\\\":\\\"07453289655\\\",\\\"device_uuid\\\":\\\"1548A942-E3A3-482C-8818-82DAC336E2E2\\\",\\\"device_id\\\":\\\"097bfdbe68dd5ba5dfd316d21dd266529bf193ef2d985480c13be1c3e6bbcd13\\\",\\\"payment_method\\\":\\\"Cash\\\",\\\"email\\\":\\\"test13@mailinator.com\\\",\\\"postcode\\\":\\\"E62ea\\\",\\\"address\\\":\\\"123 Lathom Road, London\\\"},\\\"internal_info\\\":{},\\\"delivery_type\\\":\\\"Collection\\\",\\\"delivery_time\\\":\\\"asap\\\",\\\"appcode\\\":\\\"hyderbad\\\",\\\"total_price\\\":14}\",\n" +
                                        "\t\"encrypted_blob\": \"0\",\n" +
                                        "\t\"action_url\": null,\n" +
                                        "\t\"action_datetime\": \"2016-01-21 11:56:19\",\n" +
                                        "\t\"action_lat\": null,\n" +
                                        "\t\"action_lon\": null,\n" +
                                        "\t\"backup_action_blob\": null,\n" +
                                        "\t\"action_deleted\": \"0\",\n" +
                                        "\t\"user_fullname\": \"test\",\n" +
                                        "\t\"user_username\": \"test13@mailinator.com\",\n" +
                                        "\t\"user_email\": \"test13@mailinator.com\",\n" +
                                        "\t\"user_phone\": \"07453289655\",\n" +
                                        "\t\"user_postcode\": \"E62ea\",\n" +
                                        "\t\"user_address\": \"123 Lathom Road, London\"\n" +
                                        "},{\n" +
                                        "\t\"app_code\": \"hyderbad\",\n" +
                                        "\t\"fetched\": false,\n" +
                                        "\t\"action_id\": \"894251\",\n" +
                                        "\t\"action_parent_id\": \"0\",\n" +
                                        "\t\"tab_id\": 0,\n" +
                                        "\t\"user_id\": \"149941\",\n" +
                                        "\t\"action_type\": \"takeaway\",\n" +
                                        "\t\"action_subtype\": null,\n" +
                                        "\t\"action_blob\": \"{\\\"items\\\":[{\\\"id\\\":\\\"143482\\\",\\\"category\\\":\\\"Special Offer\\\",\\\"name\\\":\\\"Dum Chicken Biryani Family pack\\\",\\\"note\\\":\\\"\\\",\\\"ordered_price\\\":\\\"14.00\\\"}],\\\"client_info\\\":{\\\"name\\\":\\\"test\\\",\\\"phone\\\":\\\"07453289655\\\",\\\"device_uuid\\\":\\\"1548A942-E3A3-482C-8818-82DAC336E2E2\\\",\\\"device_id\\\":\\\"097bfdbe68dd5ba5dfd316d21dd266529bf193ef2d985480c13be1c3e6bbcd13\\\",\\\"payment_method\\\":\\\"Cash\\\",\\\"email\\\":\\\"test13@mailinator.com\\\",\\\"postcode\\\":\\\"E62ea\\\",\\\"address\\\":\\\"123 Lathom Road, London\\\"},\\\"internal_info\\\":{},\\\"delivery_type\\\":\\\"Collection\\\",\\\"delivery_time\\\":\\\"asap\\\",\\\"appcode\\\":\\\"hyderbad\\\",\\\"total_price\\\":14}\",\n" +
                                        "\t\"encrypted_blob\": \"0\",\n" +
                                        "\t\"action_url\": null,\n" +
                                        "\t\"action_datetime\": \"2016-01-21 11:56:19\",\n" +
                                        "\t\"action_lat\": null,\n" +
                                        "\t\"action_lon\": null,\n" +
                                        "\t\"backup_action_blob\": null,\n" +
                                        "\t\"action_deleted\": \"0\",\n" +
                                        "\t\"user_fullname\": \"test\",\n" +
                                        "\t\"user_username\": \"test13@mailinator.com\",\n" +
                                        "\t\"user_email\": \"test13@mailinator.com\",\n" +
                                        "\t\"user_phone\": \"07453289655\",\n" +
                                        "\t\"user_postcode\": \"E62ea\",\n" +
                                        "\t\"user_address\": \"123 Lathom Road, London\"\n" +
                                        "},{\n" +
                                        "\t\"app_code\": \"hyderbad\",\n" +
                                        "\t\"fetched\": false,\n" +
                                        "\t\"action_id\": \"894251\",\n" +
                                        "\t\"action_parent_id\": \"0\",\n" +
                                        "\t\"tab_id\": 0,\n" +
                                        "\t\"user_id\": \"149941\",\n" +
                                        "\t\"action_type\": \"takeaway\",\n" +
                                        "\t\"action_subtype\": null,\n" +
                                        "\t\"action_blob\": \"{\\\"items\\\":[{\\\"id\\\":\\\"143482\\\",\\\"category\\\":\\\"Special Offer\\\",\\\"name\\\":\\\"Dum Chicken Biryani Family pack\\\",\\\"note\\\":\\\"\\\",\\\"ordered_price\\\":\\\"14.00\\\"}],\\\"client_info\\\":{\\\"name\\\":\\\"test\\\",\\\"phone\\\":\\\"07453289655\\\",\\\"device_uuid\\\":\\\"1548A942-E3A3-482C-8818-82DAC336E2E2\\\",\\\"device_id\\\":\\\"097bfdbe68dd5ba5dfd316d21dd266529bf193ef2d985480c13be1c3e6bbcd13\\\",\\\"payment_method\\\":\\\"Cash\\\",\\\"email\\\":\\\"test13@mailinator.com\\\",\\\"postcode\\\":\\\"E62ea\\\",\\\"address\\\":\\\"123 Lathom Road, London\\\"},\\\"internal_info\\\":{},\\\"delivery_type\\\":\\\"Collection\\\",\\\"delivery_time\\\":\\\"asap\\\",\\\"appcode\\\":\\\"hyderbad\\\",\\\"total_price\\\":14}\",\n" +
                                        "\t\"encrypted_blob\": \"0\",\n" +
                                        "\t\"action_url\": null,\n" +
                                        "\t\"action_datetime\": \"2016-01-21 11:56:19\",\n" +
                                        "\t\"action_lat\": null,\n" +
                                        "\t\"action_lon\": null,\n" +
                                        "\t\"backup_action_blob\": null,\n" +
                                        "\t\"action_deleted\": \"0\",\n" +
                                        "\t\"user_fullname\": \"test\",\n" +
                                        "\t\"user_username\": \"test13@mailinator.com\",\n" +
                                        "\t\"user_email\": \"test13@mailinator.com\",\n" +
                                        "\t\"user_phone\": \"07453289655\",\n" +
                                        "\t\"user_postcode\": \"E62ea\",\n" +
                                        "\t\"user_address\": \"123 Lathom Road, London\"\n" +
                                        "},{\n" +
                                        "\t\"app_code\": \"hyderbad\",\n" +
                                        "\t\"fetched\": false,\n" +
                                        "\t\"action_id\": \"894251\",\n" +
                                        "\t\"action_parent_id\": \"0\",\n" +
                                        "\t\"tab_id\": 0,\n" +
                                        "\t\"user_id\": \"149941\",\n" +
                                        "\t\"action_type\": \"takeaway\",\n" +
                                        "\t\"action_subtype\": null,\n" +
                                        "\t\"action_blob\": \"{\\\"items\\\":[{\\\"id\\\":\\\"143482\\\",\\\"category\\\":\\\"Special Offer\\\",\\\"name\\\":\\\"Dum Chicken Biryani Family pack\\\",\\\"note\\\":\\\"\\\",\\\"ordered_price\\\":\\\"14.00\\\"}],\\\"client_info\\\":{\\\"name\\\":\\\"test\\\",\\\"phone\\\":\\\"07453289655\\\",\\\"device_uuid\\\":\\\"1548A942-E3A3-482C-8818-82DAC336E2E2\\\",\\\"device_id\\\":\\\"097bfdbe68dd5ba5dfd316d21dd266529bf193ef2d985480c13be1c3e6bbcd13\\\",\\\"payment_method\\\":\\\"Cash\\\",\\\"email\\\":\\\"test13@mailinator.com\\\",\\\"postcode\\\":\\\"E62ea\\\",\\\"address\\\":\\\"123 Lathom Road, London\\\"},\\\"internal_info\\\":{},\\\"delivery_type\\\":\\\"Collection\\\",\\\"delivery_time\\\":\\\"asap\\\",\\\"appcode\\\":\\\"hyderbad\\\",\\\"total_price\\\":14}\",\n" +
                                        "\t\"encrypted_blob\": \"0\",\n" +
                                        "\t\"action_url\": null,\n" +
                                        "\t\"action_datetime\": \"2016-01-21 11:56:19\",\n" +
                                        "\t\"action_lat\": null,\n" +
                                        "\t\"action_lon\": null,\n" +
                                        "\t\"backup_action_blob\": null,\n" +
                                        "\t\"action_deleted\": \"0\",\n" +
                                        "\t\"user_fullname\": \"test\",\n" +
                                        "\t\"user_username\": \"test13@mailinator.com\",\n" +
                                        "\t\"user_email\": \"test13@mailinator.com\",\n" +
                                        "\t\"user_phone\": \"07453289655\",\n" +
                                        "\t\"user_postcode\": \"E62ea\",\n" +
                                        "\t\"user_address\": \"123 Lathom Road, London\"\n" +
                                        "},{\n" +
                                        "\t\"app_code\": \"hyderbad\",\n" +
                                        "\t\"fetched\": false,\n" +
                                        "\t\"action_id\": \"894251\",\n" +
                                        "\t\"action_parent_id\": \"0\",\n" +
                                        "\t\"tab_id\": 0,\n" +
                                        "\t\"user_id\": \"149941\",\n" +
                                        "\t\"action_type\": \"takeaway\",\n" +
                                        "\t\"action_subtype\": null,\n" +
                                        "\t\"action_blob\": \"{\\\"items\\\":[{\\\"id\\\":\\\"143482\\\",\\\"category\\\":\\\"Special Offer\\\",\\\"name\\\":\\\"Dum Chicken Biryani Family pack\\\",\\\"note\\\":\\\"\\\",\\\"ordered_price\\\":\\\"14.00\\\"}],\\\"client_info\\\":{\\\"name\\\":\\\"test\\\",\\\"phone\\\":\\\"07453289655\\\",\\\"device_uuid\\\":\\\"1548A942-E3A3-482C-8818-82DAC336E2E2\\\",\\\"device_id\\\":\\\"097bfdbe68dd5ba5dfd316d21dd266529bf193ef2d985480c13be1c3e6bbcd13\\\",\\\"payment_method\\\":\\\"Cash\\\",\\\"email\\\":\\\"test13@mailinator.com\\\",\\\"postcode\\\":\\\"E62ea\\\",\\\"address\\\":\\\"123 Lathom Road, London\\\"},\\\"internal_info\\\":{},\\\"delivery_type\\\":\\\"Collection\\\",\\\"delivery_time\\\":\\\"asap\\\",\\\"appcode\\\":\\\"hyderbad\\\",\\\"total_price\\\":14}\",\n" +
                                        "\t\"encrypted_blob\": \"0\",\n" +
                                        "\t\"action_url\": null,\n" +
                                        "\t\"action_datetime\": \"2016-01-21 11:56:19\",\n" +
                                        "\t\"action_lat\": null,\n" +
                                        "\t\"action_lon\": null,\n" +
                                        "\t\"backup_action_blob\": null,\n" +
                                        "\t\"action_deleted\": \"0\",\n" +
                                        "\t\"user_fullname\": \"test\",\n" +
                                        "\t\"user_username\": \"test13@mailinator.com\",\n" +
                                        "\t\"user_email\": \"test13@mailinator.com\",\n" +
                                        "\t\"user_phone\": \"07453289655\",\n" +
                                        "\t\"user_postcode\": \"E62ea\",\n" +
                                        "\t\"user_address\": \"123 Lathom Road, London\"\n" +
                                        "},{\n" +
                                        "\t\"app_code\": \"hyderbad\",\n" +
                                        "\t\"fetched\": false,\n" +
                                        "\t\"action_id\": \"894251\",\n" +
                                        "\t\"action_parent_id\": \"0\",\n" +
                                        "\t\"tab_id\": 0,\n" +
                                        "\t\"user_id\": \"149941\",\n" +
                                        "\t\"action_type\": \"takeaway\",\n" +
                                        "\t\"action_subtype\": null,\n" +
                                        "\t\"action_blob\": \"{\\\"items\\\":[{\\\"id\\\":\\\"143482\\\",\\\"category\\\":\\\"Special Offer\\\",\\\"name\\\":\\\"Dum Chicken Biryani Family pack\\\",\\\"note\\\":\\\"\\\",\\\"ordered_price\\\":\\\"14.00\\\"}],\\\"client_info\\\":{\\\"name\\\":\\\"test\\\",\\\"phone\\\":\\\"07453289655\\\",\\\"device_uuid\\\":\\\"1548A942-E3A3-482C-8818-82DAC336E2E2\\\",\\\"device_id\\\":\\\"097bfdbe68dd5ba5dfd316d21dd266529bf193ef2d985480c13be1c3e6bbcd13\\\",\\\"payment_method\\\":\\\"Cash\\\",\\\"email\\\":\\\"test13@mailinator.com\\\",\\\"postcode\\\":\\\"E62ea\\\",\\\"address\\\":\\\"123 Lathom Road, London\\\"},\\\"internal_info\\\":{},\\\"delivery_type\\\":\\\"Collection\\\",\\\"delivery_time\\\":\\\"asap\\\",\\\"appcode\\\":\\\"hyderbad\\\",\\\"total_price\\\":14}\",\n" +
                                        "\t\"encrypted_blob\": \"0\",\n" +
                                        "\t\"action_url\": null,\n" +
                                        "\t\"action_datetime\": \"2016-01-21 11:56:19\",\n" +
                                        "\t\"action_lat\": null,\n" +
                                        "\t\"action_lon\": null,\n" +
                                        "\t\"backup_action_blob\": null,\n" +
                                        "\t\"action_deleted\": \"0\",\n" +
                                        "\t\"user_fullname\": \"test\",\n" +
                                        "\t\"user_username\": \"test13@mailinator.com\",\n" +
                                        "\t\"user_email\": \"test13@mailinator.com\",\n" +
                                        "\t\"user_phone\": \"07453289655\",\n" +
                                        "\t\"user_postcode\": \"E62ea\",\n" +
                                        "\t\"user_address\": \"123 Lathom Road, London\"\n" +
                                        "}," +
                                        " {\n" +
                                        "\t\"app_code\": \"hyderbad\",\n" +
                                        "\t\"fetched\": false,\n" +
                                        "\t\"action_id\": \"893669\",\n" +
                                        "\t\"action_parent_id\": \"0\",\n" +
                                        "\t\"tab_id\": 0,\n" +
                                        "\t\"user_id\": \"149941\",\n" +
                                        "\t\"action_type\": \"takeaway\",\n" +
                                        "\t\"action_subtype\": null,\n" +
                                        "\t\"action_blob\": \"{\\\"items\\\":[{\\\"id\\\":\\\"142963\\\",\\\"category\\\":\\\"Vegetarian Curries\\\",\\\"name\\\":\\\"Bendi Masala\\\",\\\"note\\\":\\\"\\\",\\\"ordered_price\\\":\\\"3.49\\\"},{\\\"id\\\":\\\"142963\\\",\\\"category\\\":\\\"Vegetarian Curries\\\",\\\"name\\\":\\\"Bendi Masala\\\",\\\"note\\\":\\\"\\\",\\\"ordered_price\\\":\\\"3.49\\\"},{\\\"id\\\":\\\"142963\\\",\\\"category\\\":\\\"Vegetarian Curries\\\",\\\"name\\\":\\\"Bendi Masala\\\",\\\"note\\\":\\\"\\\",\\\"ordered_price\\\":\\\"3.49\\\"},{\\\"id\\\":\\\"142963\\\",\\\"category\\\":\\\"Vegetarian Curries\\\",\\\"name\\\":\\\"Bendi Masala\\\",\\\"note\\\":\\\"\\\",\\\"ordered_price\\\":\\\"3.49\\\"},{\\\"id\\\":\\\"142963\\\",\\\"category\\\":\\\"Vegetarian Curries\\\",\\\"name\\\":\\\"Bendi Masala\\\",\\\"note\\\":\\\"\\\",\\\"ordered_price\\\":\\\"3.49\\\"}],\\\"client_info\\\":{\\\"name\\\":\\\"test user\\\",\\\"phone\\\":\\\"07453289655\\\",\\\"device_uuid\\\":\\\"1548A942-E3A3-482C-8818-82DAC336E2E2\\\",\\\"device_id\\\":\\\"097bfdbe68dd5ba5dfd316d21dd266529bf193ef2d985480c13be1c3e6bbcd13\\\",\\\"payment_method\\\":\\\"Cash\\\",\\\"email\\\":\\\"test13@mailinator.com\\\",\\\"postcode\\\":\\\"E62EA\\\",\\\"address\\\":\\\"127 Lathom Road, London\\\"},\\\"internal_info\\\":{},\\\"delivery_type\\\":\\\"Collection\\\",\\\"delivery_time\\\":\\\"asap\\\",\\\"appcode\\\":\\\"hyderbad\\\",\\\"total_price\\\":17.45}\",\n" +
                                        "\t\"encrypted_blob\": \"0\",\n" +
                                        "\t\"action_url\": null,\n" +
                                        "\t\"action_datetime\": \"2016-01-20 17:55:30\",\n" +
                                        "\t\"action_lat\": null,\n" +
                                        "\t\"action_lon\": null,\n" +
                                        "\t\"backup_action_blob\": null,\n" +
                                        "\t\"action_deleted\": \"0\",\n" +
                                        "\t\"user_fullname\": \"test\",\n" +
                                        "\t\"user_username\": \"test13@mailinator.com\",\n" +
                                        "\t\"user_email\": \"test13@mailinator.com\",\n" +
                                        "\t\"user_phone\": \"07453289655\",\n" +
                                        "\t\"user_postcode\": \"E62ea\",\n" +
                                        "\t\"user_address\": \"123 Lathom Road, London\"\n" +
                                        "}]"))

        );

    }


    @Test
    public void getContext() throws Exception {

        // String response = IOUtils.toString(this.getClass().getResourceAsStream("/euromocks/reg.json"), "UTF-8");

        stubFor(post(urlEqualTo("/contest/list"))
//                        .withRequestBody(containing("action=get_user_actions"))
//                        .withRequestBody(containing("user_id=149941"))
                        .willReturn(aResponse()
                                .withStatus(200).withHeader("Content-Type", "application/json").withBody("{\n" +
                                        "  \"status\": true,\n" +
                                        "  \"msg\": null,\n" +
                                        "  \"data\": {\n" +
                                        "    \"totalPage\": 12,\n" +
                                        "    \"data\": [\n" +
                                        "      {\n" +
                                        "        \"id\": 122,\n" +
                                        "        \"contestName\": \"East London Testers\",\n" +
                                        "        \"contestBanner\": \"http://img.fotor.mobi/public/contest/974990b53f194b43a9fa0892d5aafb15.jpg\",\n" +
//                                        "        \"contestBanner\": \"https://upload.wikimedia.org/wikipedia/commons/7/73/Meetup_Logo_2015.png\",\n" +
                                        "        \"startTime\": 1453401000,\n" +
                                        "        \"endTime\": 1453406400,\n" +
                                        "        \"totalPhotoCount\": 0,\n" +
                                        "        \"state\": 4,\n" +
                                        "        \"color\": \"#195b8a\",\n" +
                                        "        \"detailBanner\": \"http://img.fotor.mobi/public/contest/123e005f86b7495d94e6498da3f2f2e3.jpg\",\n" +
                                        "        \"maxPhotoCount\": 10000,\n" +
                                        "        \"maxPhotoWidth\": 10000,\n" +
                                        "        \"maxPhotoHeight\": 10000,\n" +
                                        "        \"maxPhotoSize\": 51200,\n" +
                                        "        \"reward\": \"MEETUP: $00\",\n" +
                                        "        \"outReward\": \"MEETUP: $80\",\n" +
                                        "        \"unit\": \"Fotor\",\n" +
                                        "        \"ext\": [\n" +
                                        "          {\n" +
                                        "            \"val\": \"THANKS FOR COMING:\",\n" +
                                        "            \"title\": \"SRIRAM ANGAJALA\",\n" +
                                        "            \"vcolor\": \"#787878\",\n" +
                                        "            \"tcolor\": \"#5a5a5a\"\n" +
                                        "          },\n" +
                                        "          {\n" +
                                        "            \"val\": \"CONTACT:\",\n" +
                                        "            \"title\": \"SRIRAM.ANGAJALA@GMAIL.COM\",\n" +
                                        "            \"vcolor\": \"#787878\",\n" +
                                        "            \"tcolor\": \"#5a5a5a\"\n" +
                                        "          },\n" +
                                        "          {\n" +
                                        "            \"val\": \"SEE YOU ALL IN FIRST WEEK OF MARCH\",\n" +
                                        "            \"title\": \"NEXT MEET UP\",\n" +
                                        "            \"vcolor\": \"#787878\",\n" +
                                        "            \"tcolor\": \"#5a5a5a\"\n" +
                                        "          }\n" +
                                        "        ],\n" +
                                        "        \"tags\": [\n" +
                                        "          \"rain\",\n" +
                                        "          \"sunshine\",\n" +
                                        "          \"snow\",\n" +
                                        "          \"cloud\",\n" +
                                        "          \"lightning\"\n" +
                                        "        ],\n" +
                                        "        \"shareDesc\": null,\n" +
                                        "        \"contestType\": 0,\n" +
                                        "        \"contestSectionDesc\": null,\n" +
                                        "        \"unlock\": true,\n" +
                                        "        \"customStatus\": 0\n" +
                                        "      }\n" +
                                        "    ],\n" +
                                        "    \"currentPage\": 1,\n" +
                                        "    \"tag\": 1453259311\n" +
                                        "  },\n" +
                                        "  \"code\": \"000\"\n" +
                                        "}"))

        );

    }

    @BeforeClass
    public static void run() throws Exception {
//        try {
//            resetAllRequests();
//            resetToDefault();
//        }
//        catch (Exception e)
//        {
//
//        }

		WireMock.configureFor("http://ec2-52-18-179-94.eu-west-1.compute.amazonaws.com/",8080);

    }

}
