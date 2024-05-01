package pkg1.events;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface EventRepo extends JpaRepository<EventEntity,Integer>{
	@Query(value="SELECT * from events where month(date) =:month",nativeQuery = true)
	public List<EventEntity> getEventsByMonth(@Param(value = "month") int month);
	

}
