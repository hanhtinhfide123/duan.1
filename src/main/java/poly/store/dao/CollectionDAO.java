package poly.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.store.entity.Collection;

public interface CollectionDAO extends JpaRepository<Collection, Integer>{

}
