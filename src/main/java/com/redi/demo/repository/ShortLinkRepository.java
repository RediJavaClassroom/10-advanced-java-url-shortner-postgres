package com.redi.demo.repository;

import com.redi.demo.repository.model.ShortLinkEntity;
import java.time.Instant;
import org.springframework.data.repository.CrudRepository;

public interface ShortLinkRepository extends CrudRepository<ShortLinkEntity, String> {
  ShortLinkEntity findByKeyAndExpiresAtAfter(final String key, final Instant instant);
}
