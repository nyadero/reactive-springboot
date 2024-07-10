package com.bronyst.spring_reactive;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.List;
import java.util.Locale;

public class ReactiveProgramming {
    private Mono<String> testMono(){
        return Mono.just("Java");
    }

    private Flux<String> favoriteProgrammingLanguages(){
        Flux<String> flux = Flux.just("Java", "Kotlin", "Cpp", "Swift", "Python");
        return flux.map(s -> s.toUpperCase(Locale.ROOT)).delayElements(Duration.ofSeconds(1));
    }

    private Flux<Integer> numbers(){
        Flux<Integer> flux1 = Flux.range(1, 25).delayElements(Duration.ofMillis(100));
        Flux<Integer> flux2 = Flux.range(26, 100).delayElements(Duration.ofMillis(100));
        return Flux.merge(flux1, flux2);
    }

    private Flux<Tuple2<Integer, Integer>> fluxZip(){
        Flux<Integer> flux1 = Flux.range(1, 25).delayElements(Duration.ofMillis(100));
        Flux<Integer> flux2 = Flux.range(26, 50).delayElements(Duration.ofMillis(100));
        flux2.doOnSubscribe(s -> System.out.println("subscribed"));
        return Flux.zip(flux1, flux2).log();
    }

    private Mono<List<Integer>> collection(){
        return Flux.range(1, 10).collectList();
    }
    public static void main(String[] args) throws InterruptedException {
       ReactiveProgramming reactiveProgramming = new ReactiveProgramming();
       reactiveProgramming.testMono().subscribe(data -> System.out.println(data));
       reactiveProgramming.favoriteProgrammingLanguages().subscribe(data -> System.out.println(data));
//       reactiveProgramming.numbers().subscribe(data -> System.out.println(data));
        reactiveProgramming.fluxZip().subscribe(data -> System.out.println(data));
        reactiveProgramming.collection().subscribe(data -> System.out.println(data));
        
       Thread.sleep(10_000);

    }
}
