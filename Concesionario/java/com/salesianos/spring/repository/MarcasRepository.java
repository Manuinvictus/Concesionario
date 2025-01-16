package com.salesianos.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.salesianos.spring.model.CochePorMarca;
import com.salesianos.spring.model.Marcas;

@Repository
public interface MarcasRepository extends JpaRepository<Marcas, Long>{
	
	// Esta query no debe solo mostrar los datos, también debe cargarlos en nuestro objeto AlumConHech,
	// mediante el builder de este.
	@Query("SELECT new AlumConHech(st.idstudent, st.fullname, st.email, st.matriculationdate,"
		 + " st.gender, sp.spellname, sp.type, sp.level, sp.islethal) "
		 + " FROM Student st, Spell sp "
		 + " WHERE st.spellknown=sp.idspell "
		 + " AND UPPER(sp.spellname) LIKE ?1% "
		 + " ORDER BY sp.spellname, st.fullname ASC ")
	List<CochePorMarca> alumnosPorHechizo(String nomHechizo);

	@Query(value = "SELECT * "
				 + " FROM spells sp "
				 + " WHERE sp.idspell = :id "
				 + " ORDER BY sp.spellname ASC "
		 , nativeQuery = true)
	List<Marcas> findByID(@Param("id") long id);

	@Query("SELECT sp "
		 + " FROM Spell sp "
		 + " WHERE sp.damage > :dmg "
		 + " ORDER BY sp.spellname ASC ")
	List<Marcas> findByDmg(@Param("dmg") int dmg);
	
	@Query(value = "SELECT * "
			 	 + " FROM spells sp "
			 	 + " WHERE sp.level >= ?1 "
			 	 + " ORDER BY sp.spellname ASC "
		 , nativeQuery = true)
	List<Marcas> findByLevel(int lvl);
}