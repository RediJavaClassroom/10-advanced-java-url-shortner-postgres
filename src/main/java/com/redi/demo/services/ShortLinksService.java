package com.redi.demo.services;

import com.redi.demo.model.CreateShortLinkRequest;
import com.redi.demo.model.ShortLink;
import com.redi.demo.repository.ShortLinkRepository;
import com.redi.demo.repository.model.ShortLinkEntiry;
import java.net.URI;
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

  public ShortLink createShortLink(final CreateShortLinkRequest request) {
    final var key = keyGenerationService.generateKey();
    final var entity = new ShortLinkEntiry(key, request.originalURL.toString());
    repository.save(entity);
    final var uri = URI.create(String.format("%s/%s", BASE_URL, key));
    return new ShortLink(uri);
  }

  public URI expandShortLink(final String key) {
    final ShortLinkEntiry entity = repository.findByKey(key);
    return URI.create(entity.getOriginalUrl());
  }
}
