package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${key}.properties"
})
public interface StartConfig extends Config {

    @Key("remote_url")
    String remote_url();

    @Key("browser")
    String browser();

    @Key("browser.version")
    String browserVersion();

    @Key("key.url")
    String keyUrl();

    @Key("video.storage")
    String videoStorage();

    @Key("repository")
    String repository();

    @Key("issues")
    String issues();

    @Key("issue.number")
    String issueNumber();
}
