package org.shtroh.shortlnkservice.controller;


import lombok.RequiredArgsConstructor;
import org.shtroh.shortlnkservice.model.GenerateRequest;
import org.shtroh.shortlnkservice.service.LinkManageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/sls")
@RequiredArgsConstructor
public class UrlController {

    private final LinkManageService linkManageService;

    @PostMapping("/generate")
    public ResponseEntity<String> generate(@Valid @RequestBody GenerateRequest request) {
        String shortUrl = linkManageService.generateShortLink(request.getUrl());
        return ResponseEntity.ok(shortUrl);
    }

    @GetMapping("/getOriginal")
    public ResponseEntity<String> get(@RequestParam String request) {
        String url = linkManageService.getUrl(request);
        return ResponseEntity.ok(url);
    }
}
