package cat.handballstats.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cat.handballstats.model.Result;

public interface ResultRepository extends JpaRepository<Result, Long> {

}
