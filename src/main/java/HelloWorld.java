import io.harness.cf.client.api.CfClient;
import io.harness.cf.client.api.Config;
import io.harness.cf.client.dto.Target;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

/**
 * This is a sample program that demonstrates a simple integration of the
 * ff-java-server-sdk with Harness Feature Flags
 */
@Slf4j
public class HelloWorld {
  public static void main(String[] args) {
    try {
      /**
       * Put the API Key here from your environment
       */
      String apiKey = "4d3a7f11-a3ab-4c6c-a235-62a5bfd8a29e";
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
            cfClient.boolVariation("harnessappdemoenablecimodule", target, false);
        log.info("Boolean variation is " + result);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
