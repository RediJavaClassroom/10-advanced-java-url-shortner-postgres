package com.redi.demo.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;

import com.redi.demo.model.CreateShortLinkRequest;
import com.redi.demo.repository.ShortLinkRepository;
import java.net.URI;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ShortLinksServiceTest {

  @Mock KeyGenerationService keyGenerationService;
  @Mock ShortLinkRepository shortLinkRepository;

  @Test
  void createShortLinks() {
    final ShortLinksService shortLinksService = new ShortLinksService(keyGenerationService, shortLinkRepository);
    when(keyGenerationService.generateKey()).thenReturn("xxx");
    final var request = new CreateShortLinkRequest(URI.create("http://example.com"));

    final var shortLink = shortLinksService.createShortLink(request);

    assertThat(shortLink.url.toString(), equalTo("http://localhost:8080/xxx"));
  }
}
