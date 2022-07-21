package com.harness;

import io.harness.cf.client.api.CfClient;
import io.harness.cf.client.api.Config;
import io.harness.cf.client.dto.Target;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

/**
 * This is a sample program that demonstrates a simple integration of the
 * ff-java-server-sdk with Harness Feature Flags
 */
public class HelloWorld {
    public static void main(String[] args) {
        /**
         * Initiate the logger.
         */
        org.slf4j.Logger log = LoggerFactory.getLogger(HelloWorld.class);

        try {
            /**
             * Put the API Key here from your environment
             */
            String apiKey = System.getenv().getOrDefault("","d54e2088-2811-4e14-a710-f746dfd87646");
            log.info("Using SDK_KEY" + apiKey);
            String identifier = "test_flag";
            CfClient cfClient = new CfClient(apiKey, Config.builder().build());
            cfClient.waitForInitialization();
            /**
             * Define you target on which you would like to evaluate the featureFlag
             */
            Target target = Target.builder()
                    .name("User1")
                    .attributes(new HashMap<String, Object>())
                    .identifier("user1@example.com")
                    .build();
            while (true) {
                /**
                 * Sleep for sometime before printing the value of the flag
                 */
                Thread.sleep(2000);
                /**
                 * This is a sample boolean flag. You can replace the flag value with
                 * the identifier of your feature flag
                 */
                boolean result =
                        cfClient.boolVariation(identifier, target, false);
                log.info("Boolean variation is " + result);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
