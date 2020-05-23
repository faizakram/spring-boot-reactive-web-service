package spring.boot.reactive.web.controller;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import spring.boot.reactive.web.model.Role;
import spring.boot.reactive.web.model.User;
import spring.boot.reactive.web.repository.SaRoleRepository;
import spring.boot.reactive.web.repository.SaUserRepository;

@RestController
@RequestMapping("flux")
public class ReactiveController {

	@Autowired
	private SaRoleRepository saRoleRepository;
	
	@Autowired
	private SaUserRepository saUserRepository;

	@GetMapping(value = "reactive-numbers",  produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Integer> reactiveNumbers() {
		return Flux.create(fluxSink -> {
			for (int i = 1; i <= 10; i++) {
				fluxSink.next(i);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {

				}
			}
			fluxSink.complete();
		});
	}

	@GetMapping("test")
	public String get() {
		return "text";

	}

	@PostMapping("create-role")
	public Mono<Role> addRole(@RequestBody Role role) {
		return saRoleRepository.save(role);
	}

	
	@GetMapping("get-user/{id}")
	public Mono<User> getUser(@PathVariable String id) {
		return saUserRepository.findById(id);
	}

	@GetMapping(value = "/reactive-paged", produces = { "application/json" })
	public Flux<User> getQuoteFlux(final @RequestParam(name = "page") int page,
			final @RequestParam(name = "size") int size) {
		return saUserRepository.retrieveAllQuotesPaged(PageRequest.of(page, size))
				.delayElements(Duration.ofMillis(3000));
	}

}
