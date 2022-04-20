package com.redi.demo.repository.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "short_links")
public class ShortLinkEntiry {

  @Id
  private String key;
  private String originalUrl;
  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
  private User user;

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
