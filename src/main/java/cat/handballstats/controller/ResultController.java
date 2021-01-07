package cat.handballstats.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import cat.handballstats.model.Result;
import cat.handballstats.service.ResultService;

@RestController
public class ResultController {
	
    private final ResultService service;
    
    public ResultController(ResultService service) {
    	this.service = service;
    }
    
    // Get result
    @GetMapping("/results/{matchId}")
    public Result getResult(@PathVariable Long matchId) {
    	return service.getResult(matchId);
    }
}
