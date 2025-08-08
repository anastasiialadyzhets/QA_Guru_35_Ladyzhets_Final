package web.config;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;
import java.util.UUID;

public class BaseConfig {
    private final WebConfig webConfig;

    public BaseConfig(WebConfig webConfig) {
        this.webConfig = webConfig;
    }

    public void setConfig() {
        Configuration.baseUrl = webConfig.getBaseUrl();
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = webConfig.getBrowser().toString();
        Configuration.browserVersion = webConfig.getBrowserVersion();
        Configuration.browserSize = webConfig.getBrowserSize();
        Configuration.remote ="https://user1:1234@selenoid.autotests.cloud/wd/hub";


        if (webConfig.isRemote()) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true,
                    "name", "Test: " + UUID.randomUUID()
            ));
            Configuration.remote = webConfig.getRemoteUrl();
            Configuration.browserCapabilities = capabilities;
        }
    }
}
