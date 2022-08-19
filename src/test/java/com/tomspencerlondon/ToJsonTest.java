package com.tomspencerlondon;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.net.URISyntaxException;
import org.junit.jupiter.api.Test;

public class ToJsonTest {


  @Test
  void givenCSVInputOutputsJson() throws IOException, URISyntaxException {
    ToJson toJson = new ToJson();

    toJson.convert();

    assertThat(toJson.jsonFile())
        .isNotEmpty();
  }
}
