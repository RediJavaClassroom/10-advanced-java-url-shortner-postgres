package com.redi.demo.repository;

import com.redi.demo.repository.model.ShortLinkEntiry;
import org.springframework.data.repository.CrudRepository;

public interface ShortLinkRepository extends CrudRepository<ShortLinkEntiry, String> {
  ShortLinkEntiry findByKey(final String key);
}
