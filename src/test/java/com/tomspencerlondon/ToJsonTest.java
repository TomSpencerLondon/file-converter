package com.tomspencerlondon;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class ToJsonTest {


  @Test
  void givenCSVInputOutputsJson() throws IOException {
    ToJson toJson = new ToJson();

    toJson.convert();
  }
}
