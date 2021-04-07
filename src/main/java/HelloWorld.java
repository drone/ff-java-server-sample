import io.harness.cf.client.api.CfClient;
import io.harness.cf.client.api.Config;
import io.harness.cf.client.dto.Target;
import java.util.HashMap;
import lombok.extern.slf4j.Slf4j;

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
      String apiKey = "27704199-d73c-49eb-92ac-6896ffd7558e";
      CfClient cfClient =
          new CfClient(apiKey, Config.builder()
                                   .configUrl("http://35.199.167.179/api/1.0")
                                   .eventUrl("http://34.83.236.94/api/1.0")
                                   .build());
      /**
       * Define you target on which you would like to evaluate the featureFlag
       */
      Target target = Target.builder()
                          .name("User1")
                          .attributes(new HashMap<String, Object>())
                          .identifier("user1@example.com")
                          .build();
      Target target2 = Target.builder()
          .name("User2")
          .attributes(new HashMap<String, Object>())
          .identifier("user2@example.com")
          .build();

      Target target3 = Target.builder()
          .name("User3")
          .attributes(new HashMap<String, Object>())
          .identifier("user3@example.com")
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
        boolean result = cfClient.boolVariation("myboolean1", target, false);
        log.info("Boolean variation for user1 is " + result);

        result = cfClient.boolVariation("myboolean1", target2, false);
        log.info("Boolean variation for user2 is " + result);

        result = cfClient.boolVariation("myboolean1", target3, false);
        log.info("Boolean variation for user3 is " + result);

      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
