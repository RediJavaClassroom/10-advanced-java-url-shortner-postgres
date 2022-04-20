package com.redi.demo.repository;

import com.redi.demo.repository.model.ShortLink;
import org.springframework.data.repository.CrudRepository;

public interface ShortLinkRepository extends CrudRepository<ShortLink, String> {
  ShortLink findByKey(final String key);
}
