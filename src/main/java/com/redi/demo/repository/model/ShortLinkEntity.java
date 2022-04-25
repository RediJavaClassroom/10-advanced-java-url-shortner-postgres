package com.redi.demo.repository.model;

import java.time.Instant;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "short_links")
public class ShortLinkEntity {

  @Id
  private String key;
  private String originalUrl;
  private Instant expiresAt;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  private User user;

  protected ShortLinkEntity() {}

  public ShortLinkEntity(final String key, final String originalUrl, final Instant expiresAt) {
    this.key = key;
    this.originalUrl = originalUrl;
    this.expiresAt = expiresAt;
  }

  public String getKey() {
    return key;
  }

  public String getOriginalUrl() {
    return originalUrl;
  }
}
