package com.tomspencerlondon;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class ToJson {
  private final ClassLoader classloader = Thread.currentThread().getContextClassLoader();
  private File file = new File(classloader.getResource("data.json").getFile());

  public void convert() throws IOException {
    InputStream is = classloader.getResourceAsStream("data.csv");
    Pattern pattern = Pattern.compile(",");
    try (BufferedReader in = new BufferedReader(new InputStreamReader(is))) {
      List<Player> players = in.lines().skip(1).map(line -> {
        String[] x = pattern.split(line);
        return new Player(Integer.parseInt(x[0]), x[1], x[2], x[3], Integer.parseInt(x[4]));
      }).toList();

      ObjectMapper mapper = new ObjectMapper();
      mapper.enable(SerializationFeature.INDENT_OUTPUT);
      mapper.writeValue(file, players);
    }
  }

  public File jsonFile() {
    return file;
  }
}
