package com.redi.demo.repository.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "short_links")
public class ShortLinkEntiry {

  @Id
  private String key;
  private String originalUrl;

  protected ShortLinkEntiry() {}

  public ShortLinkEntiry(final String key, final String originalUrl) {
    this.key = key;
    this.originalUrl = originalUrl;
  }

  public String getKey() {
    return key;
  }

  public String getOriginalUrl() {
    return originalUrl;
  }
}
