package poly.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.store.entity.Movement;

public interface MovementDAO extends JpaRepository<Movement, Integer>{

}
