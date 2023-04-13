package com.project.d11.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface D11Repo<T, ID extends Serializable> extends JpaRepository<T, ID> {
  void refresh(T t);
}
