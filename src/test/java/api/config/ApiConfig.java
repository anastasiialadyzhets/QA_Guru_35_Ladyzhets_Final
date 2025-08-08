package api.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:apiConfig.properties")
public interface ApiConfig extends Config{
    @Config.Key("baseUri")
    String baseUri();
}
