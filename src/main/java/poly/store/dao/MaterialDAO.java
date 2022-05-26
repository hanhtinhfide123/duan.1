package poly.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.store.entity.Material;

public interface MaterialDAO extends JpaRepository<Material, Integer>{

}
