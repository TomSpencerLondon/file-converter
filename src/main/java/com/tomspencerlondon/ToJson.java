package com.tomspencerlondon;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Pattern;

public class ToJson {

  public void convert() throws IOException {
    ClassLoader classloader = Thread.currentThread().getContextClassLoader();
    InputStream is = classloader.getResourceAsStream("data.csv");
    Pattern pattern = Pattern.compile(",");
    try (BufferedReader in = new BufferedReader(new InputStreamReader(is))) {
      List<Player> players = in.lines().skip(1).map(line -> {
        String[] x = pattern.split(line);
        return new Player(Integer.parseInt(x[0]), x[1], x[2], x[3], Integer.parseInt(x[4]));
      }).toList();

      ObjectMapper mapper = new ObjectMapper();

      mapper.enable(SerializationFeature.INDENT_OUTPUT);
      mapper.writeValue(System.out, players);
    }
  }
}
