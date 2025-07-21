package org.akazukin.template;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.ZonedDateTime;
import java.util.Properties;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE)
public final class BuildData {
    String vendor;
    String version;
    String commit;
    String commitHash;
    ZonedDateTime buildDate;

    String modId;
    String modName;

    public static BuildData getInstance() {
        final BuildData data = new BuildData();
        data.load();
        return data;
    }

    public void load() {
        try (final InputStream is = this.getClass().getResourceAsStream("/build-data.properties")) {
            try (final InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8)) {
                final Properties props = new Properties();
                props.load(isr);

                this.vendor = String.valueOf(props.get("vendor"));
                this.version = String.valueOf(props.get("version"));
                this.commit = String.valueOf(props.get("commit"));
                this.commitHash = String.valueOf(props.get("commit-hash"));
                this.buildDate = ZonedDateTime.parse(String.valueOf(props.get("build-date")));

                this.modId = String.valueOf(props.get("mod-id"));
                this.modName = String.valueOf(props.get("mod-name"));
            }
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }
}