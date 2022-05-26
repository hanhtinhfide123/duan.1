package poly.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.store.entity.Brand;

public interface BrandDAO extends JpaRepository<Brand, Integer>{

}
