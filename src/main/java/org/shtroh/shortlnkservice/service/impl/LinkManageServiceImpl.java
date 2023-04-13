package org.shtroh.shortlnkservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.shtroh.shortlnkservice.db.model.Url;
import org.shtroh.shortlnkservice.db.repository.UrlRepository;
import org.shtroh.shortlnkservice.service.LinkManageService;
import org.shtroh.shortlnkservice.util.Base62;
import org.shtroh.shortlnkservice.util.Constants;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
@RequiredArgsConstructor
public class LinkManageServiceImpl implements LinkManageService {
    private final UrlRepository urlRepository;

    @Override
    public String getUrl(String request) {
        log.info("get original url from '{}'", request);
        Integer urlId = Base62.decode(request);
        log.info("urlId: {}", urlId);
        String url = urlRepository.findById(urlId).map(Url::getOriginal).orElse(null);
        log.info("original url from '{}' is '{}'", request, url);
        return url;
    }

    @Override
    public String generateShortLink(String originalUrl) {
        Url url = Url.builder().original(originalUrl).build();
        urlRepository.save(url);
        return String.format("%s%s", Constants.PREFIX, Base62.encode(url.getId()));
    }

    @PostConstruct
    private void init() {
        urlRepository.findAll().forEach(u -> log.info("test url {}{}", Constants.PREFIX, Base62.encode(u.getId())));
    }
}
