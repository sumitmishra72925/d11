package com.project.d11.impl;

import com.project.d11.jpa.D11Repo;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.io.Serializable;

public class D11RepoImpl<T, ID extends Serializable> extends
    SimpleJpaRepository<T, ID> implements D11Repo<T, ID> {

  private final EntityManager entityManager;

  public D11RepoImpl(JpaEntityInformation entityInformation, EntityManager entityManager) {
    super(entityInformation, entityManager);
    this.entityManager = entityManager;
  }

  @Override
  @Transactional
  public void refresh(T t) {
    entityManager.refresh(entityManager.merge(t));
  }
}
