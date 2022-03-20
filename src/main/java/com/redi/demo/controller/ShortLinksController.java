package com.redi.demo.controller;

import com.redi.demo.model.CreateShortLinkRequest;
import com.redi.demo.model.ShortLink;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShortLinksController {
  private final String BASE_URL = "http://localhost:8080";
  private Map<String, URI> shortLinks = new ConcurrentHashMap<>();

  @PostMapping("links")
  public ShortLink createLink(final @RequestBody CreateShortLinkRequest request) {
    final var key = generateKey();
    shortLinks.put(key, request.originalURL);
    final var uri = URI.create(String.format("%s/%s", BASE_URL, key));
    return new ShortLink(uri);
  }

  @GetMapping("/{key}")
  public void expandLink(
      final @PathVariable(value = "key") String key,
      final HttpServletResponse httpServletResponse) {
    httpServletResponse.setStatus(HttpStatus.MOVED_PERMANENTLY.value());
    httpServletResponse.setHeader(HttpHeaders.LOCATION, shortLinks.get(key).toString());
  }

  private String generateKey() {
    return "TODO";
  }
}
