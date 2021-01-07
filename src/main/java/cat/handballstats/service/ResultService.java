package cat.handballstats.service;

import org.springframework.stereotype.Service;

import cat.handballstats.model.Result;
import cat.handballstats.repository.ResultRepository;

@Service
public class ResultService {
    
	private final ResultRepository repository;
	
	public ResultService(ResultRepository repository) {
		this.repository = repository;
	}
	
	// Get result
	public Result getResult(Long matchId) {
		return repository.findById(matchId).orElse(null);
	}
}
