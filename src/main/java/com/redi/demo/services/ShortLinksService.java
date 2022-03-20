package com.redi.demo.services;

import com.redi.demo.model.CreateShortLinkRequest;
import com.redi.demo.model.ShortLink;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShortLinksService {

  final private KeyGenerationService keyGenerationService;

  private final String BASE_URL = "http://localhost:8080";
  private final Map<String, URI> shortLinks = new ConcurrentHashMap<>();

  @Autowired
  public ShortLinksService(final KeyGenerationService keyGenerationService) {
    this.keyGenerationService = keyGenerationService;
  }

  public ShortLink createShortLink(final CreateShortLinkRequest request) {
    final var key = keyGenerationService.generateKey();
    shortLinks.put(key, request.originalURL);
    final var uri = URI.create(String.format("%s/%s", BASE_URL, key));
    return new ShortLink(uri);
  }

  public URI expandShortLink(final String key) {
    return shortLinks.get(key);
  }
}
