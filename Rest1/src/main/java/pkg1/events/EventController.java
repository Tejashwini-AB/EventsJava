package pkg1.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class EventController {
	@Autowired
	EventRepo er;
	
	@PostMapping("/meetings/cs/add")
	public String addEvent(@RequestBody EventEntity ee) {
		er.save(ee);
		
		return "Success";
	}
	
	@GetMapping("/meetings/cs/2024")
	public List<EventEntity> getEvents2024(){
		return er.findAll();
		
	}
	
	@GetMapping("/meetings/cs/2024/{month}")
	public List<EventEntity> getEventsByMonth(@PathVariable int month){
		return er.getEventsByMonth(month);
		
	}

}
