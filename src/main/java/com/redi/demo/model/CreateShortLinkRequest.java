package com.redi.demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.net.URI;

public class CreateShortLinkRequest {
  public final URI originalURL;

  @JsonCreator
  public CreateShortLinkRequest(@JsonProperty("url") final URI originalURL) {
    this.originalURL = originalURL;
  }
}
