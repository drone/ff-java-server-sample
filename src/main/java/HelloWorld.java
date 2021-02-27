import io.harness.cf.client.api.CfClient;
import io.harness.cf.client.api.Config;
import io.harness.cf.client.dto.Target;

import java.util.HashMap;

public class HelloWorld {
  public static void main(String[] args) throws Exception {
    try {
      String apiKey = "17e7c975-06c1-4f09-98f4-2c33d6c82974";
      CfClient cfClient =
          new CfClient(apiKey, Config.builder().baseUrl("https://config.feature-flags.uat.harness.io/api/1.0").build());
      Target target =
          Target.builder().name("User1").custom(new HashMap<String, Object>()).identifier("user1@example.com").build();
      while (true) {
        Thread.sleep(2000);
        boolean result = cfClient.boolVariation("flag", target, false);
        System.out.println("Boolean variation is " + result);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
