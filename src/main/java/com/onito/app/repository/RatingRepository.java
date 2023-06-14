package com.onito.app.repository;

import java.util.List;

import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onito.app.module.Movies;
import com.onito.app.module.Ratings;

@Repository
public interface RatingRepository extends JpaRepository<Ratings, String> {
	@Query(value = "SELECT"
			+ "    m.genres,"
			+ "    m.primaryTitle,"
			+ "    COALESCE(SUM(r.numVotes), 0) AS numVotes"
			+ "FROM "
			+ "    movies "
			+ "LEFT JOIN "
			+ "    ratings r ON m.tconst = r.tconst"
			+ "GROUP BY "
			+ "    m.genres, m.primaryTitle"
			+ "WITH ROLLUP"
			+ "ORDER BY "
			+ "    m.genres ASC, m.primaryTitle ASC;", nativeQuery = true)
	public List<Ratings> getsubtotalofeachgener();

	 @Modifying
	    @Query(value = "UPDATE Movies m " +
	            "SET m.runtimeMinutes = CASE " +
	            "WHEN m.genres = 'Documentary' THEN m.runtimeMinutes + 15 " +
	            "WHEN m.genres= 'Animation' THEN m.runtimeMinutes + 30 " +
	            "ELSE m.runtimeMinutes + 45 " +
	            "END")
	    void updateRuntimeMinutes();

}
