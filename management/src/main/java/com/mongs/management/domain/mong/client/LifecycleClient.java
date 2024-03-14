package com.mongs.management.domain.mong.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "LIFECYCLE", configuration = FeignClientInterceptor.class)
public interface LifecycleClient {
    @PostMapping("/lifecycle/admin/egg/{mongId}")
    ResponseEntity<Object> eggMongEvent(@PathVariable("mongId") Long mongId);
    @PutMapping("/lifecycle/admin/sleep/{mongId}")
    ResponseEntity<Object> sleepMongEvent(@PathVariable("mongId") Long mongId);
    @PutMapping("/lifecycle/admin/wakeup/{mongId}")
    ResponseEntity<Object> wakeupMongEvent(@PathVariable("mongId") Long mongId);
    @DeleteMapping("/lifecycle/admin/evolution/{mongId}")
    ResponseEntity<Object> evolutionReadyMongEvent(@PathVariable("mongId") Long mongId);
    @PutMapping("/lifecycle/admin/evolution/{mongId}")
    ResponseEntity<Object> evolutionMongEvent(@PathVariable("mongId") Long mongId);
    @DeleteMapping("/lifecycle/admin/graduation/{mongId}")
    ResponseEntity<Object> graduationMongEvent(@PathVariable("mongId") Long mongId);
}
