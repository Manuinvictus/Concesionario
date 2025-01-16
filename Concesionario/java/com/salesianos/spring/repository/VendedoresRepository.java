package com.salesianos.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.salesianos.spring.model.Vendedores;

@Repository
public interface VendedoresRepository extends JpaRepository<Vendedores, Long>{

	@Query(value = "SELECT * "
				 + " FROM spells sp "
				 + " WHERE sp.idspell = :id "
				 + " ORDER BY sp.spellname ASC "
		 , nativeQuery = true)
	List<Vendedores> findByID(@Param("id") long id);

	@Query("SELECT sp "
		 + " FROM Spell sp "
		 + " WHERE sp.damage > :dmg "
		 + " ORDER BY sp.spellname ASC ")
	List<Vendedores> findByDmg(@Param("dmg") int dmg);
	
	@Query(value = "SELECT * "
			 	 + " FROM spells sp "
			 	 + " WHERE sp.level >= ?1 "
			 	 + " ORDER BY sp.spellname ASC "
		 , nativeQuery = true)
	List<Vendedores> findByLevel(int lvl);
}