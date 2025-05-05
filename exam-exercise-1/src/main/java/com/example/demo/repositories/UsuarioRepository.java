package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Usuario findByUsername(String username);
	
	@Modifying
    @Transactional
    @Query(
      value = "DELETE FROM favorito "
            + "WHERE usuario_id = (SELECT id FROM usuario WHERE username = :username) "
            + "  AND manga_id   = :mangaId",
      nativeQuery = true
    )
    void deleteFavoritoByUsernameAndMangaId(
      @Param("username") String username,
      @Param("mangaId")  Integer mangaId
    );
	
	@Modifying
    @Transactional
    @Query(
      value = "INSERT INTO favorito(usuario_id, manga_id) " +
              "VALUES (" +
              "  (SELECT id FROM usuario WHERE username = :username)," +
              "  :mangaId" +
              ")",
      nativeQuery = true
    )
    void insertFavoritoByUsernameAndMangaId(
      @Param("username") String username,
      @Param("mangaId")  Integer mangaId
    );
}
