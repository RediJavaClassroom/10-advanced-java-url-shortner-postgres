package com.redi.demo.services;

import com.redi.demo.model.CreateShortLinkRequest;
import com.redi.demo.repository.ShortLinkRepository;
import com.redi.demo.repository.model.ShortLink;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShortLinksService {

  final private KeyGenerationService keyGenerationService;

  private final String BASE_URL = "http://localhost:8080";
  private final ShortLinkRepository repository;
  

  @Autowired
  public ShortLinksService(final KeyGenerationService keyGenerationService, final ShortLinkRepository repository) {
    this.keyGenerationService = keyGenerationService;
    this.repository = repository;
  }

  public com.redi.demo.model.ShortLink createShortLink(final CreateShortLinkRequest request) {
    final var key = keyGenerationService.generateKey();
    final var entity = new ShortLink(key, request.originalURL.toString());
    repository.save(entity);
    final var uri = URI.create(String.format("%s/%s", BASE_URL, key));
    return new com.redi.demo.model.ShortLink(uri);
  }

  public URI expandShortLink(final String key) {
    final ShortLink entity = repository.findByKey(key);
    return URI.create(entity.getOriginalUrl());
  }
}
